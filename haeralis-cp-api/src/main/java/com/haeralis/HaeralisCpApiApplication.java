package com.haeralis;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@SpringBootApplication
public class HaeralisCpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaeralisCpApiApplication.class, args);
	}
	
	@Bean
	public Filter getCharacterEncodingFilter() {

	    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

	    encodingFilter.setEncoding("UTF-8");
	    encodingFilter.setForceEncoding(true);

	    return encodingFilter;

	}
}
