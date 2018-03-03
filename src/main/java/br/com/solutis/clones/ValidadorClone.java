package br.com.solutis.clones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorClone {

	private static final String EXPRESSAO = "[A-Z]{3}[0-9]{4}";

	/**
	 * @param nome
	 * @param idade
	 * 
	 * @throws IllegalArgumentException - excecao lançada se os dados não atenderem os padraos
	 */
	public static void validarDados(String nome, int idade) {
		validarNome(nome);
		validarIdade(idade);
	}

	public static void validarNome(String nome) {
		Pattern pattern = Pattern.compile(EXPRESSAO);
		Matcher matcher = pattern.matcher(nome);
		
		if (!matcher.matches()) {
			throw new IllegalArgumentException("O nome [" + nome + "] é inválido! Padrão válido é [AAA1111]");
		}
	}

	public static void validarIdade(int idade) {
		if (idade <= 10 || idade >= 20) {
			throw new IllegalArgumentException("A idade [" + idade + "] é inválida! Informe uma idade entre 10 e 20");
		}
	}

}