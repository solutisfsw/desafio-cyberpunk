package com.mateusmatos.cyberpunk.repository;

import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mateusmatos.cyberpunk.models.Clone;
import com.mateusmatos.cyberpunk.models.CloneDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloneDAOTest {	

	 @Autowired
	 private CloneDAO cloneDAO;

	@Test
	@Transactional
	public void testSave() throws Exception {

		//Objeto de teste
	    Clone clone = new Clone();
	    clone.setNome("clone de teste");
        clone.setIdade(20);
        clone.setData_cadastro(new Date());
        clone.setBraco_mecanico(true);

	    // Objeto salvo
	    cloneDAO.save(clone);
	    
	    //Recebeu um Id?
	    assertTrue(clone.getNome()+" está salvo - Id "+clone.getId(),clone.getId() > 0);
	}
	
	@Test
	@Transactional
	public void testUpdate() throws Exception {

        Clone clone = cloneDAO.findOne(0L);

        assertTrue(clone != null);
        clone.setNome("ADE321");
        cloneDAO.save(clone);

        assertEquals("Nome alterado", cloneDAO.findOne(0L).getNome());
	}	
	
	@Test
	@Transactional
	public void testDelete() throws Exception {
		
		long testId = 0L;

		assertTrue(cloneDAO.exists(testId));
		//Existe
        assertTrue(cloneDAO.exists(testId));
        cloneDAO.delete(testId);
        //Mas não mais...
        assertFalse(cloneDAO.exists(testId));
	}
}
