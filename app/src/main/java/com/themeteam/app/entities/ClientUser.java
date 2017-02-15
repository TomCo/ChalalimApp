package com.themeteam.app.entities;

/**
 * Created by huser on 14/02/2017.
 */

public class ClientUser {
    static com.themeteam.app.Server.User user;

    public static com.themeteam.app.Server.User getCurrentUser() {
        return ClientUser.user;
    }

    public static void connect(com.themeteam.app.Server.User toConnect) {
        ClientUser.user = toConnect;
    }

}
