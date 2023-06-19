package com.example.handlers.bu;

import com.example.hibernate.dao.BuyerDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeleteBuyerHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        int id = Integer.parseInt(context.pathParam("id"));
        BuyerDAO.delete(id);
        context.redirect("/buyers");
    }
}
