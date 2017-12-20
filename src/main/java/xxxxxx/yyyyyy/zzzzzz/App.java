package xxxxxx.yyyyyy.zzzzzz;

import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.ipc.netty.http.server.HttpServer;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class App {

    static RouterFunction<ServerResponse> routes() {
        return route(GET("/"), req -> ok().body(Flux.just("Hello", " ", "World!"), String.class));
    }

    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        int port = Optional.ofNullable(System.getenv("PORT")) //
                .map(Integer::parseInt) //
                .orElse(8080);
        HttpServer httpServer = HttpServer.create("0.0.0.0", port);
        httpServer.startRouterAndAwait(routes -> routes.route(x -> true,
                new ReactorHttpHandlerAdapter(toHttpHandler(App.routes()))), x -> {
            long elapsed = System.currentTimeMillis() - begin;
            LoggerFactory.getLogger(App.class).info("Started in {} seconds", elapsed / 1000.0);
        });
    }
}
