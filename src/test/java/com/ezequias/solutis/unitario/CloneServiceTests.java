package com.ezequias.solutis.unitario;

import com.ezequias.solutis.exception.CloneNaoEncontradoException;
import com.ezequias.solutis.exception.UnicidadeNomeExeption;
import com.ezequias.solutis.model.Adicionais;
import com.ezequias.solutis.model.Clone;
import com.ezequias.solutis.persistence.CloneRepository;
import com.ezequias.solutis.service.CloneService;
import com.ezequias.solutis.service.CloneServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CloneServiceTests {

    private static final String NOME = "ABS1234";
    private static final Integer IDADE = 18;
    private static final Date DATE = Calendar.getInstance().getTime();

    @MockBean
    private CloneRepository cloneRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CloneService service;
    private Clone clone;
    private Adicionais adicionais;

    @Before
    public void setUp() {
        service = new CloneServiceImpl(cloneRepository);

        clone = new Clone();
        clone.setNome(NOME);
        clone.setIdade(IDADE);
        clone.setDataCriacao(DATE);

        adicionais = new Adicionais();
        adicionais.setPeleAdaptativa(true);
        adicionais.setRaioLaser(true);
        adicionais.setBracoMecanico(true);
        adicionais.setEsqueletoReforcado(true);

        clone.setAdicionais(adicionais);

        when(cloneRepository.findByNome(NOME)).thenReturn(Optional.empty());
    }


    @Test
    public void findAllClones() {
        service.findAll();
        verify(cloneRepository).findAll();
    }

    @Test
    public void returnCloneByNome() throws Exception {
        when(cloneRepository.findByNome(NOME)).thenReturn(Optional.of(clone));

        Clone cloneTest = service.findByNome(NOME);

        verify(cloneRepository).findByNome(NOME);

        assertThat(cloneTest).isNotNull();
        assertThat(cloneTest.getNome()).isEqualTo(NOME);
        assertThat(cloneTest.getAdicionais()).isNotNull();
        assertThat(cloneTest.getIdade()).isEqualTo(IDADE);
    }

    @Test
    public void returnNaoEncontradoCloneByNome() throws Exception {
        expectedException.expect(CloneNaoEncontradoException.class);
        expectedException.expectMessage("Não existe clone com o nome '" + NOME + "'");
        service.findByNome(NOME);
    }

    @Test
    public void notCreateCloneByNome() throws Exception {
        when(cloneRepository.findByNome(NOME)).thenReturn(Optional.of(clone));
        expectedException.expect(UnicidadeNomeExeption.class);
        expectedException.expectMessage("Já existe um clone cadastrado com o nome '" + NOME + "'");
        service.create(clone);

    }

    @Test
    public void salveClone() throws Exception {
        service.create(clone);
        verify(cloneRepository).save(clone);
    }

    @Test
    public void updateClone() throws Exception {
        when(cloneRepository.findByNome(NOME)).thenReturn(Optional.of(clone));
        clone.setIdade(20);

        service.update(NOME, clone);
        verify(cloneRepository).save(clone);
        assertThat(clone.getIdade()).isEqualTo(20);
    }

    @Test
    public void returnNotUpdateByNomeInUse() throws Exception {
        when(cloneRepository.findByNome(NOME)).thenReturn(Optional.of(clone));
        clone.setIdade(20);
        when(cloneRepository.save(clone)).thenThrow(DataIntegrityViolationException.class);

        expectedException.expect(UnicidadeNomeExeption.class);
        expectedException.expectMessage("Este nome '" + NOME + "' já está em uso");
        service.update(NOME, clone);
    }

    @Test
    public void returnNaoEncontradoUpdateClone() throws Exception {
        expectedException.expect(CloneNaoEncontradoException.class);
        expectedException.expectMessage("Não existe clone com o nome '" + NOME + "'");
        service.update(NOME, clone);
    }

    @Test
    public void removeClone() throws Exception {
        when(cloneRepository.findByNome(NOME)).thenReturn(Optional.of(clone));

        service.remove(NOME);
        verify(cloneRepository).delete(clone);
    }

    @Test
    public void returnNaoEncontradoRemoveClone() throws Exception {
        expectedException.expect(CloneNaoEncontradoException.class);
        expectedException.expectMessage("Não existe clone com o nome '" + NOME + "'");
        service.remove(NOME);
    }
}
