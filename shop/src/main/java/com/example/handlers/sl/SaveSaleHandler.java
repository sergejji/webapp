package com.example.handlers.sl;

import com.example.hibernate.dao.BuyerDAO;
import com.example.hibernate.dao.ProductDAO;
import com.example.hibernate.dao.SaleDAO;
import com.example.hibernate.models.Buyer;
import com.example.hibernate.models.Product;
import com.example.hibernate.models.Sale;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class SaveSaleHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int buyerId = Integer.parseInt(context.formParam("buyer_id"));
        int productId = Integer.parseInt(context.formParam("product_id"));

        Buyer buyer = BuyerDAO.one(buyerId);
        Product product = ProductDAO.one(productId);

        if (buyer == null || product == null) {
            context.html("<h1>Invalid buyer ID or product ID</h1>");
            return;
        }

        Sale sale = new Sale();
        sale.setBuyer(buyer);
        sale.setProduct(product);

        SaleDAO.save(sale);
        context.redirect("/sales");
    }
}
