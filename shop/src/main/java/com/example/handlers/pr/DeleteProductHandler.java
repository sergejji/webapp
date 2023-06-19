package com.example.handlers.pr;

import com.example.hibernate.dao.ProductDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class DeleteProductHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        int id = Integer.parseInt(context.pathParam("id"));
        ProductDAO.delete(id);
        context.redirect("/products");
    }
}
