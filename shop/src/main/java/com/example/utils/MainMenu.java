package com.example.utils;

import java.util.ArrayList;

public class MainMenu {
    public static ArrayList<MenuItems> get(){
        ArrayList<MenuItems> items = new ArrayList<>();
        items.add(new MenuItems("Products","/products"));
        items.add(new MenuItems("Sales","/sales"));
        items.add(new MenuItems("Buyers","/buyers"));
        return items;
    }
}
