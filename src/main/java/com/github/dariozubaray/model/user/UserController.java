package com.github.dariozubaray.model.user;

import java.util.Objects;
import io.javalin.http.Handler;

public class UserController {
    public static Handler fetchAllUsernames = ctx -> {
        UserDao dao = UserDao.instance();
        Iterable<String> allUsers = dao.getAllUsernames();
        ctx.json(allUsers);
    };

    public static Handler fetchById = ctx -> {
        int id = Integer.parseInt(Objects.requireNonNull(ctx.formParam("id")));
        UserDao dao = UserDao.instance();
        User user = dao.getUserById(id).get();
        if (user == null) {
            ctx.html("Not Found");
        } else {
            ctx.json(user);
        }
    };
}
