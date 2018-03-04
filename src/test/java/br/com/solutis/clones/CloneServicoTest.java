package br.com.solutis.clones;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CloneServicoTest {

	private String nomeBob;
	private String nomeAna;
	private String nomeErro;

	private int idadeErro;
	private int idadeBob;
	private int idadeAna;

	private Clone cloneBob;
	private Clone cloneAna;

    CloneServico cloneServico;

	@Before
	public void init() {
		this.nomeBob = "BOB1234";
		this.idadeBob = 15;

		this.nomeAna = "ANA9876";
		this.idadeAna = 16;

		this.nomeErro = "Bob Erro";
		this.idadeErro = 25;

		this.cloneBob = new Clone(this.nomeBob, this.idadeBob, new Date());
		this.cloneAna = new Clone(this.nomeAna, this.idadeAna, new Date());

        this.cloneServico = CloneServico.getInstance();
        
        criarClonesBobEAna();
	}

	@Test
	public void testaCloneCriadoComSucesso() {
		
        List<Clone> clones = this.cloneServico.getClones();
		Assert.assertEquals(2, clones.size());
		Assert.assertEquals(this.cloneBob, clones.get(0));
		Assert.assertEquals(this.cloneAna, clones.get(1));
	}

    @Test
    public void testarRemocaoClone() {
        criarClonesBobEAna();
        
        this.cloneServico.removerClone(this.nomeBob);

        List<Clone> clones = this.cloneServico.getClones();

        Assert.assertEquals(1, clones.size());
        Assert.assertEquals(this.cloneAna, clones.get(0));
        Assert.assertEquals(-1, clones.indexOf(this.cloneBob));

    }

    @Test
    public void testarAtualizacaoCloneComSucesso() {
        criarClonesBobEAna();

        List<Clone> clones = this.cloneServico.getClones();

        Assert.assertEquals(15, clones.get(0).getIdade());

        this.cloneServico.atualizarClone(this.nomeBob, 19);

        clones = this.cloneServico.getClones();

        Assert.assertEquals(2, clones.size());
        Assert.assertEquals(this.cloneBob, clones.get(0));
        Assert.assertEquals(19, clones.get(0).getIdade());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoCloneComNomeRepetido() {
		criarClonesBobEAna();
        this.cloneServico.criarClone(this.nomeAna, this.idadeAna);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoCloneComNomeForaPadrao() {
        this.cloneServico.criarClone(this.nomeErro, this.idadeAna);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoCloneComIdadeInvalida() {
        this.cloneServico.criarClone(this.nomeBob, this.idadeErro);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testarAtualizacaoCloneNomeNaoExiste() {
		criarClonesBobEAna();
		String nomeInexistente = "AAA1234";
        this.cloneServico.atualizarClone(nomeInexistente, 19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testarAtualizacaoCloneIdadeInvalida() {
		criarClonesBobEAna();

        this.cloneServico.atualizarClone(this.nomeBob, this.idadeErro);
	}

	private void criarClonesBobEAna() {
        this.cloneServico.limparClones();
        this.cloneServico.criarClone(this.nomeBob, this.idadeBob);
        this.cloneServico.criarClone(this.nomeAna, this.idadeAna);
	}

}