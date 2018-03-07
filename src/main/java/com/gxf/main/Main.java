package com.gxf.main;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * Created by 58 on 2018/3/7.
 */
public class Main {
    public static void main(String[] args) {
        Undertow server = Undertow.builder().addHttpListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
                        httpServerExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        httpServerExchange.getResponseSender().send("Hello Undertow");
                    }
                }).build();
        server.start();
    }
}
