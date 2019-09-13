package xxxxxx.yyyyyy.zzzzzz;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.is;

public class MessageHandlerTest {
	private WebTestClient testClient;

	@BeforeAll
	void setUp() throws Exception {
		this.testClient = WebTestClient
				.bindToRouterFunction(new MessageHandler().routes()).build();
	}

	@Test
	void testInvalidMessage() throws Exception {
		this.testClient.post().uri("/messages") //
				.bodyValue(new Message("HelloHello")).exchange() //
				.expectStatus().isBadRequest() //
				.expectBody(JsonNode.class)
				.value(n -> n.get("details").get(0).get("defaultMessage").asText(), is(
						"The size of \"text\" must be less than or equal to 8. The given size is 10"));
	}

	@Test
	void testMessage() throws Exception {
		this.testClient.post().uri("/messages") //
				.bodyValue(new Message("Hello")).exchange() //
				.expectStatus().isOk() //
				.expectBody(String.class).isEqualTo("{\"text\":\"Hello\"}");

		this.testClient.get().uri("/messages") //
				.exchange() //
				.expectStatus().isOk() //
				.expectBody(String.class).isEqualTo("[{\"text\":\"Hello\"}]");
	}
}
