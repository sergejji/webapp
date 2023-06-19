package com.example.handlers.bu;

import com.example.hibernate.dao.BuyerDAO;
import com.example.hibernate.dao.ProductDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class BuyerHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {

            HashMap<String,Object> modelData = new HashMap<>();
            modelData.put("main_menu", MainMenu.get());
            modelData.put("buyers", BuyerDAO.all());
            String html_content = Renderer.render("buyers.ftl",modelData);
            context.html(html_content);
        }
    }

