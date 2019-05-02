package xxxxxx.yyyyyy.zzzzzz;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.web.reactive.server.WebTestClient;

public class HelloHandlerTest {
	private WebTestClient testClient;

	@Before
	public void setUp() throws Exception {
		this.testClient = WebTestClient.bindToRouterFunction(new HelloHandler().routes())
				.build();
	}

	@Test
	public void testHello() throws Exception {
		this.testClient.get().uri("/") //
				.exchange() //
				.expectStatus().isOk() //
				.expectBody(String.class).isEqualTo("Hello World!");
	}
}
