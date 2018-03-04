package com.ezequias.solutis.integrado;

import com.ezequias.solutis.CyberPunkApplicationTests;
import com.ezequias.solutis.model.Adicionais;
import com.ezequias.solutis.model.Clone;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class CloneControllerTests extends CyberPunkApplicationTests {


    @Test
    public void findAllClones() {
        when()
                .get("/cyberpunk/clones")
                .then()
                .log().body().and()
                .statusCode(HttpStatus.OK.value())
                .body(notNullValue());
    }

    @Test
    public void returnCloneByNome() {
        given()
                .pathParam("nome", "LKH3047")
                .when()
                .get("/cyberpunk/clones/{nome}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("id", equalTo(3),
                        "nome", equalToIgnoringCase("LKH3047"),
                        "adicionais", notNullValue());
    }

    @Test
    public void createClone() {
        given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(fabricyClone())
                .when()
                .post("/cyberpunk/clones")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", notNullValue());

    }

    @Test
    public void updateClone() {
        Clone clone = fabricyClone();
        clone.setNome("SKA5212");

        given()
                .accept(ContentType.ANY)
                .contentType(ContentType.JSON)
                .request().body(clone)
                .pathParam("nome", "LKH3047")
                .put("/cyberpunk/clones/{nome}")
                .then()
                .log().body().and()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", notNullValue(),
                        "nome", equalTo("SKA5212"),
                        "adicionais", notNullValue());
    }

    @Test
    public void removeClone() {
        given()
                .pathParam("nome", "KMJ3748")
                .delete("/cyberpunk/clones/{nome}")
                .then()
                .log().body().and()
                .statusCode(HttpStatus.OK.value())
                .body("id", notNullValue());
    }

    private Clone fabricyClone() {
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
