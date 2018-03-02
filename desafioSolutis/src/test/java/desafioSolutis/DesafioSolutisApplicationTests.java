package desafioSolutis;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import model.Clone;
import repositories.CloneRepository;


@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@WebMvcTest()
public class DesafioSolutisApplicationTests {

	@LocalServerPort
    private int port;
	
	/*@Autowired
    private TestRestTemplate restTemplate;*/
	
	
	@Autowired
    private MockMvc mvc;
		
	@MockBean
    private CloneRepository cloneRepository;
	
	@MockBean
    private Clone clone;
	
	
	
	/*
	@Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/clones/10",
                Clone.class)).hasFieldOrProperty("nome");
    }
	*/
	
	@Test
    public void clonesTest () throws Exception {
		Clone clone = new Clone();
		mvc.perform(get("/clones")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
			      
    }
	
	

}
