package com.github.dariozubaray;

import io.javalin.Javalin;

public class JavalinApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/hola", ctx -> ctx.html("Hello from Javalin!"));
    }

}
