package com.example.nero.clones;

import com.example.nero.clones.validador.Validador;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ClonesUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validarNomeInvalidoTest() throws  Exception{
        String nome = "Ulisses";

        boolean atual = Validador.validarNome(nome);
        boolean esperado = false;

        assertEquals(esperado, atual);
    }

    @Test
    public void validarNomeValidoTest() throws  Exception{
        String nome = "ULI1996";

        boolean atual = Validador.validarNome(nome);
        boolean esperado = true;

        assertEquals(esperado, atual);
    }

    @Test
    public void validarIdadeValidoTest() throws  Exception{
        int idade = 19;

        boolean atual = Validador.validarIdade(idade);
        boolean esperado = true;

        assertEquals(esperado, atual);
    }

    @Test
    public void validarIdadeInvalidoTest() throws  Exception{
        int idade = 21;

        boolean atual = Validador.validarIdade(idade);
        boolean esperado = false;

        assertEquals(esperado, atual);
    }
}