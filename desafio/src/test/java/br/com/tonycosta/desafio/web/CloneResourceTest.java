package br.com.tonycosta.desafio.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.tonycosta.desafio.domain.Clone;
import br.com.tonycosta.desafio.domain.CloneRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloneResourceTest {

	private static final String URI = "/api/clones";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@Autowired
	private CloneRepository repository;
	@Autowired
	private WebApplicationContext context;
	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	private MockMvc mvc;
	
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void deveListarTodosOsClones() throws Exception {
		this.mvc.perform(get(URI))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deveCadastrarUmNovoClone() throws Exception {
		String cloneJson = json(new Clone("ASW8524", 13));
		
		ResultActions resultActions = this.mvc.perform(post(URI)
				.contentType(contentType)
				.content(cloneJson));
		
		resultActions
			.andDo(print())
			.andExpect(status().isCreated());
	}
	
	@Test
	public void deveBuscarUmClonePeloId() throws Exception {
		Clone clone = repository.findAll().get(0);
		
		this.mvc.perform(get(URI+"/"+clone.getId()))
			.andExpect(jsonPath("id", is(clone.getId().intValue())))
			.andExpect(jsonPath("nome", is(clone.getNome())))
			.andExpect(jsonPath("idade", is(clone.getIdade())))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deveBuscarUmClonePorNome() throws Exception {
		Clone clone = repository.findAll().get(0);
		
		this.mvc.perform(get(URI+"/nome/"+clone.getNome()))
			.andExpect(jsonPath("id", is(clone.getId().intValue())))
			.andExpect(jsonPath("nome", is(clone.getNome())))
			.andExpect(jsonPath("idade", is(clone.getIdade())))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deveRetornarStatus404AoBuscarCloneComIdQueNaoExiste() throws Exception {
		this.mvc.perform(get(URI+"/0"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void deveRetornarStatus400AoTentarCadastrarCloneComMesmoNome() throws Exception {
		Clone clone = repository.findAll().get(0);
		String cloneJson = json(new Clone(clone.getNome(), 15));
		
		ResultActions resultActions = this.mvc.perform(post(URI)
				.contentType(contentType)
				.content(cloneJson));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void deveAtualizarUmClone() throws Exception {
		Clone clone = repository.findAll().get(0);
		String cloneJson = json(new Clone("AOL8524", 14));
		
		ResultActions resultActions = this.mvc.perform(put(URI+"/"+clone.getId())
				.contentType(contentType)
				.content(cloneJson));
		
		resultActions
			.andDo(print())
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deveDeletarUmClone() throws Exception {
		Clone clone = repository.findAll().get(0);
		
		this.mvc.perform(delete(URI+"/"+clone.getId()))
			.andExpect(status().isNoContent());
	}
	
	@Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
	
	@SuppressWarnings("unchecked")
	protected String json(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
