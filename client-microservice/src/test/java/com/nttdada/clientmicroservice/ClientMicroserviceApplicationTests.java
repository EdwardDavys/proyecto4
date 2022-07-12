package com.nttdada.clientmicroservice;

import com.nttdada.clientmicroservice.dominio.servicios.ClientServiceImpl;
import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientMicroserviceApplicationTests {

	@Autowired
	private WebTestClient client;

	private ClientServiceImpl clientService;

	@Test
	void listar() {

		client.get()
				.uri("/clients")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBodyList(Client.class)
				.consumeWith(response -> {
					List<Client> clients = response.getResponseBody();
					clients.forEach(p -> {
						System.out.println(p.getNameClient());
					});

				});
	}

	@Test
	void detalle() {

		//Client cliente = clientService.findByNameClient("David").block();
		client.get()
				.uri("/clients/{idClient}", "62b36dd6f85d5938dd54e8ec")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody()
				.jsonPath("$.nameClient").isEqualTo("David");

	}

	@Test
	void create(){

		Client cliente = new Client("11","adrian","lima");

		client.post()
				.uri("/clients")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(cliente),Client.class)
				.exchange()
				.expectStatus().isOk();

	}
}