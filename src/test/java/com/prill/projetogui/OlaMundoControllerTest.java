package com.prill.projetogui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prill.projetogui.entities.Pessoa;

@SpringBootTest
@AutoConfigureMockMvc
public class OlaMundoControllerTest {

	@Autowired
	private MockMvc mock;

	protected String transformaJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T reverteJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void deveRetornar200SeForMaiorDeIdade() throws Exception {

		Pessoa pessoa1 = new Pessoa(1, "Ana", 25, "Feminino");

		URI uri = new URI("/olamundo/pessoa");
		
		String json = transformaJson(pessoa1);
		
		MvcResult mvcResult = mock.perform(MockMvcRequestBuilders
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		
		assertEquals(200, status);
	}

}
