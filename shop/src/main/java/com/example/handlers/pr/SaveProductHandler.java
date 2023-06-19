package com.example.handlers.pr;

import com.example.hibernate.dao.ProductDAO;
import com.example.hibernate.models.Product;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class SaveProductHandler implements Handler {

    @Override
    public void handle(Context context)  {
        Product product = new Product();
        String ime = context.formParam("name");
        double cena = Double.parseDouble(context.formParam("price"));
        if (!ime.equals("") && cena != 0) {
            product.setProduct_name(ime);
            product.setProduct_price(cena);
            ProductDAO.save(product);
            context.redirect("/products");
        }
    }
}
