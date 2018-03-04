package com.ezequias.solutis.integrado;

import com.ezequias.solutis.CyberPunkApplicationTests;
import com.ezequias.solutis.model.Adicionais;
import com.ezequias.solutis.model.Clone;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class CloneControllerExceptionsTests extends CyberPunkApplicationTests {

    @Test
    public void nomeNaoEncontrado() {
        given()
                .pathParam("nome", "VVV5554")
                .when()
                .get("/cyberpunk/clones/{nome}")
                .then()
                .log().body().and()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("errors[0].defaultMessage", equalTo("Não existe clone com o nome 'VVV5554'"));
    }

    @Test
    public void cloneValidateNome() {
        Clone clone = fabricyClone();
        clone.setNome("aZ81352");
        given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(clone)
                .when()
                .post("/cyberpunk/clones")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("errors", notNullValue(),
                        "errors[0].field", equalTo("nome"),
                        "errors[0].defaultMessage", equalTo("O nome deve conter 7 caracteres sendo que deve ter 3 letras de [A-Z] e 4 numeros de [0-9]. Ex.: ABC1234"),
                        "errors[0].rejectedValue", equalTo("aZ81352"));
    }

    @Test
    public void cloneValidateNomeNullo() {
        Clone clone = fabricyClone();
        clone.setNome(null);
        given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(clone)
                .pathParam("nome", "FYR3251")
                .put("/cyberpunk/clones/{nome}")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("errors[0].field", equalTo("nome"),
                        "errors[0].defaultMessage", equalTo("O nome é obrigatório"),
                        "errors[0].rejectedValue", nullValue());
    }

    @Test
    public void unicidadeNomeClone() {
       Clone clone =  fabricyClone();
       clone.setNome("FYR3251");

        given()
                .accept(ContentType.ANY)
                .contentType(ContentType.JSON)
                .request().body(clone)
                .pathParam("nome", "LKH3047")
                .put("/cyberpunk/clones/{nome}")
                .then()
                .log().body().and()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("errors[0].defaultMessage", equalTo("Este nome 'FYR3251' já está em uso"));
    }


    public Clone fabricyClone() {
        Clone clone = new Clone();
        clone.setNome("GSH8927");
        clone.setIdade(14);
        clone.setDataCriacao(new Date());

        Adicionais adicionais = new Adicionais();
        adicionais.setSentidosAgucados(true);
        adicionais.setBracoMecanico(true);
        adicionais.setRaioLaser(true);
        adicionais.setPeleAdaptativa(false);

        clone.setAdicionais(adicionais);
        return clone;
    }
}
