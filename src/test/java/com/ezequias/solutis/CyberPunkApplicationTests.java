package com.ezequias.solutis;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class CyberPunkApplicationTests {

    @Value("${local.server.port}")
    protected int porta;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = porta;
    }

//    private static Clone clone;
//    @Autowired
//    private CloneRepository provider;
//
//    @Autowired
//    private CloneController controller;
//
//    @Before
//    public void setupClass() {
//        clone = new Clone();
//        clone.setIdade(20);
//        clone.setNome("AGE3047");
//        clone.setDataCriacao(Calendar.getInstance().getTime());
//
//        List<Adicionais> adicionais = new ArrayList<>();
//        Adicionais a1 = new Adicionais();
//        a1.setBracoMecanico(true);
//        a1.setEsqueletoReforcado(true);
//        a1.setPeleAdaptativa(true);
//        adicionais.add(a1);
//
//        Adicionais a2 = new Adicionais();
//        a2.setBracoMecanico(true);
//        a2.setEsqueletoReforcado(true);
//        a2.setPeleAdaptativa(true);
//        a2.setRaioLaser(true);
//        a2.setSentidosAgucados(true);
//        adicionais.add(a2);
//
//        clone.setAdicionais(adicionais);
//    }
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test()
//    public void teste() {
//        this.provider.save(clone);
//        System.out.println("Lista !!!!"+provider.findAll());
//    }

//    @Test
//    public void test2() {
//        clone.setNome("ea");
//        ModelMap result = this.controller.create(clone);
//        System.out.println(result.get("menssagem"));
//        Assert.assertFalse((Boolean) result.get("success"));
//    }
}
