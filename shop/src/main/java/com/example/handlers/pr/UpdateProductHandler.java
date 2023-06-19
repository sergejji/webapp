package com.example.handlers.pr;

import com.example.hibernate.dao.ProductDAO;
import com.example.hibernate.models.Product;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class UpdateProductHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int productId = Integer.parseInt(context.pathParam("id"));
        String newName = context.formParam("name");
        double newPrice = Double.parseDouble(context.formParam("price"));
        Product product = ProductDAO.one(productId);
        product.setProduct_name(newName);
        product.setProduct_price(newPrice);
        context.redirect("/products");
    }
}
