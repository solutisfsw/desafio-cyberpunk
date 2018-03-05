package br.com.solutis.cyberpunk.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.solutis.cyberpunk.model.Adicional;

public class AdicionalTest{

	@Test
	public void adicionalTest(){
		String adicional = Adicional.BRACO_MECANICO.getNome();
		assertEquals("Braço Mecânico", adicional);		
	}
	
}
