package com.example.handlers.sl;

import com.example.hibernate.dao.BuyerDAO;
import com.example.hibernate.dao.SaleDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeleteSaleHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        int id = Integer.parseInt(context.pathParam("id"));
        SaleDAO.delete(id);
        context.redirect("/sales");
    }
}
