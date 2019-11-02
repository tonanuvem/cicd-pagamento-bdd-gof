package bddgof;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Entao;

import bddgof.PagamentoTeste;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class Stepdefs {

    private static String tipo;
    private static Integer valor;
    private static String url_port = "http://localhost:8080/";

    @Before
    public void url_port(){
        String system_arg_url = String.valueOf(System.getProperty("url"));
        System.out.println("system_arg_url = " + system_arg_url);
        String system_arg_port = String.valueOf(System.getProperty("port"));
        System.out.println("system_arg_port = " + system_arg_port);
        if (system_arg_url != "null") {
            System.out.println("entrou no if / system_arg_url = " + system_arg_url);
            Stepdefs.url_port = "http://";
            Stepdefs.url_port += system_arg_url;
            if (system_arg_port != "null") {
                System.out.println("entrou no 2o if / system_arg_port = " + system_arg_port);
                Stepdefs.url_port += ":";
                Stepdefs.url_port += system_arg_port;
            }
        }
    }

    @Dado("Que cliente finalizou a compra do seu Carrinho de Compras")
    public void que_cliente_finalizou_a_compra_do_seu_Carrinho_de_Compras() {
        System.out.println("url = " + url_port);
        // HttpRequestTest
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url_port, String.class);
        assertTrue(s.contains("Pagamento"));
    }

    @Quando("Escolhe a opcao de pagamento: {string}")
    public void escolhe_a_opcao_de_pagamento(String string) {
        Stepdefs.tipo = string;
    }

    @Quando("clica em finalizar Pagamento: {int}")
    public void clica_em_finalizar_Pagamento(Integer int1) {
        Stepdefs.valor = int1;
    }

    @Entao("O pagamento tem que ser concluido com sucesso: {string}")
    public void o_pagamento_tem_que_ser_concluido_com_sucesso(String string) {
        RestTemplate restTemplate = new RestTemplate();
        String url = url_port+"/pagamento?tipo_pagamento="+tipo+"&valor_pagamento="+valor;
        PagamentoTeste pagamentoTeste = restTemplate.getForObject(url, PagamentoTeste.class);
        assertEquals(pagamentoTeste.getStatusPagamento(), string);
    }

}
