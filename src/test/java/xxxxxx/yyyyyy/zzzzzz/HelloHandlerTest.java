package xxxxxx.yyyyyy.zzzzzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.reactive.server.WebTestClient;

public class HelloHandlerTest {
	private WebTestClient testClient;

	@BeforeAll
	void setUp() throws Exception {
		this.testClient = WebTestClient.bindToRouterFunction(new HelloHandler().routes())
				.build();
	}

	@Test
	void testHello() throws Exception {
		this.testClient.get().uri("/") //
				.exchange() //
				.expectStatus().isOk() //
				.expectBody(String.class).isEqualTo("Hello World!");
	}
}
