package com.example.handlers.sl;

import com.example.hibernate.dao.BuyerDAO;
import com.example.hibernate.dao.ProductDAO;
import com.example.hibernate.dao.SaleDAO;
import com.example.hibernate.models.Buyer;
import com.example.hibernate.models.Product;
import com.example.hibernate.models.Sale;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class UpdateSaleHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int saleId = Integer.parseInt(context.pathParam("id"));
        Sale sale = SaleDAO.one(saleId);

        if (sale == null) {
            context.html("<h1>Sale not found</h1>");
            return;
        }
        int updatedBuyerId = Integer.parseInt(context.formParam("buyer_id"));
        int updatedProductId = Integer.parseInt(context.formParam("product_id"));

        Buyer updatedBuyer = BuyerDAO.one(updatedBuyerId);
        Product updatedProduct = ProductDAO.one(updatedProductId);

        if (updatedBuyer == null || updatedProduct == null) {
            context.html("<h1>Invalid buyer ID or product ID</h1>");
            return;
        }
        sale.setBuyer(updatedBuyer);
        sale.setProduct(updatedProduct);

        SaleDAO.update(sale);
        context.redirect("/sales");
    }
    }

