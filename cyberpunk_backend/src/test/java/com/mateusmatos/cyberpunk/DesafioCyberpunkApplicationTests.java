package com.mateusmatos.cyberpunk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mateusmatos.cyberpunk.DesafioCyberpunkApplication;
import com.mateusmatos.cyberpunk.models.Clone;
import com.mateusmatos.cyberpunk.models.CloneDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DesafioCyberpunkApplicationTests {

	@Autowired
    private DesafioCyberpunkApplication controller;
	
	@Autowired
    private MockMvc mockMvc;	

	 @Autowired
	 private CloneDAO cloneDAO;
	
	@Test
	public void contextLoads() {
		 assertThat(controller).isNotNull();
	}
	
	 @Test
    public void listaClientes() throws Exception {
		 
		 this.mockMvc.perform(get("/clones")).andExpect(status().isOk())
         .andExpect(content().string(containsString("teste")));
    }
	 
	 @Test
   public void buscaClonesPorId() throws Exception {
       Clone clone = new Clone();
       clone.setNome("ABC444");
       clone.setIdade(20);
       clone.setData_cadastro(new Date());
       cloneDAO.save(clone);
       
       System.out.println(clone.getId());

       this.mockMvc.perform(get("clones/"+clone.getId()))
	   			.andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("nome", is(clone.getNome())));
       
   }

}
