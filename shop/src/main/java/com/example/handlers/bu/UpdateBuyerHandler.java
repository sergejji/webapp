package com.example.handlers.bu;

import com.example.hibernate.dao.BuyerDAO;
import com.example.hibernate.models.Buyer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class UpdateBuyerHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int buyer_id = Integer.parseInt(context.pathParam("id"));
        String first_name = context.formParam("first_name");
        String last_name = context.formParam("last_name");
        String address = context.formParam("address");
        String email = context.formParam("email");
        Buyer buyer = BuyerDAO.one(buyer_id);
        buyer.setFirst_name(first_name);
        buyer.setLast_name(last_name);
        buyer.setAddress(address);
        buyer.setEmail(email);
        BuyerDAO.update(buyer);
        context.redirect("/buyers");
    }
}
