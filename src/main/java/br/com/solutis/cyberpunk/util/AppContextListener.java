package br.com.solutis.cyberpunk.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.validate.bean.BeanValidationMetadataMapper;

import br.com.solutis.cyberpunk.validation.NotBlankClientValidationConstraint;

@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// evita que ao processar pagina converta campos numerais em zero
		System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");

		// Registra anotações de terceiro
		BeanValidationMetadataMapper.registerConstraintMapping(NotBlank.class, 
				new NotBlankClientValidationConstraint());
	}
}