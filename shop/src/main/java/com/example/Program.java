package com.example;


import com.example.handlers.bu.BuyerHandler;
import com.example.handlers.bu.DeleteBuyerHandler;
import com.example.handlers.bu.SaveBuyerHandler;
import com.example.handlers.bu.UpdateBuyerHandler;
import com.example.handlers.pr.DeleteProductHandler;
import com.example.handlers.pr.ProductHandler;
import com.example.handlers.pr.SaveProductHandler;
import com.example.handlers.pr.UpdateProductHandler;
import com.example.handlers.sl.DeleteSaleHandler;
import com.example.handlers.sl.SaleHandler;
import com.example.handlers.sl.SaveSaleHandler;
import com.example.handlers.sl.UpdateSaleHandler;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;



public class Program {
    public static void main(String[] args) {
        Javalin app = Javalin.create(confi->{
            confi.staticFiles.add("/templates", Location.CLASSPATH);

        });

        app.get("/products",new ProductHandler());
        app.post("/sacuvaj", new SaveProductHandler());
        app.post("/uredi/{id}", new UpdateProductHandler());
        app.post("/obrisi/{id}",new DeleteProductHandler());
        app.get("/buyers",new BuyerHandler());
        app.post("/sacuvajj",new SaveBuyerHandler());
        app.post("/uredii/{id}", new UpdateBuyerHandler());
        app.post("/obrisii/{id}",new DeleteBuyerHandler());
        app.get("/sales",new SaleHandler());
        app.post("/sacuvajjj",new SaveSaleHandler());
        app.post("/urediii/{id}",new UpdateSaleHandler());
        app.post("/obrisiii/{id}",new DeleteSaleHandler());

        app.start(7000);

    }
}
