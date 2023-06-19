package com.example.handlers.sl;

import com.example.hibernate.dao.SaleDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class SaleHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();
        modelData.put("main_menu", MainMenu.get());
        modelData.put("sales", SaleDAO.all());
        String htmlContent = Renderer.render("sales.ftl", modelData);
        context.html(htmlContent);
    }
}
