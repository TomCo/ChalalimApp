package com.themeteam.app.entities;

import com.themeteam.app.Server.Chalal;

/**
 * Created by huser on 14/02/2017.
 */

public class ClientChalal {
    static Chalal chalal;

    public static com.themeteam.app.Server.Chalal getCurrentChalal() {
        return ClientChalal.chalal;
    }

    public static void addCurrentChalal(com.themeteam.app.Server.Chalal chalal) {
        ClientChalal.chalal = chalal;
    }

}
