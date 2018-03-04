package br.com.solutis.cyberpunk.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.solutis.cyberpunk.repository.filter.CloneFilter;


public class CloneFilterTest {
	
	@Test
	public void cloneFilterTest() {
		
		CloneFilter cloneFilter = new CloneFilter();
		cloneFilter.setNome("ABCDE");	
		assertEquals(cloneFilter.getNome(), "abcde");		
	}
}
