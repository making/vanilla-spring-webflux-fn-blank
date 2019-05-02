package xxxxxx.yyyyyy.zzzzzz;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class HelloHandler {
	public RouterFunction<ServerResponse> routes() {
		return route() //
				.GET("/", this::hello) //
				.build();
	}

	Mono<ServerResponse> hello(ServerRequest req) {
		return ok().body(Flux.just("Hello", " ", "World!"), String.class);
	}
}
