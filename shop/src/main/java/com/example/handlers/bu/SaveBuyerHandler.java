package com.example.handlers.bu;

import com.example.hibernate.dao.BuyerDAO;
import com.example.hibernate.models.Buyer;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class SaveBuyerHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        Buyer buyer = new Buyer();
        String first_name = context.formParam("first_name");
        String last_name = context.formParam("last_name");
        String address = context.formParam("address");
        String email = context.formParam("email");
        buyer.setFirst_name(first_name);
        buyer.setLast_name(last_name);
        buyer.setAddress(address);
        buyer.setEmail(email);
        BuyerDAO.save(buyer);
        context.redirect("/buyers");
        }
    }

