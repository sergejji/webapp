package com.example.hibernate.dao;

import com.example.hibernate.HibernateUtil;
import com.example.hibernate.models.Product;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;

public class ProductDAO {

    public static ArrayList<Product> all(){
        ArrayList<Product> products = new ArrayList<>();
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            products =(ArrayList<Product>) session.createQuery("From Product", Product.class).list();

            session.getTransaction().commit();
        }catch (Exception ex){ ex.printStackTrace(); }
        return products;
    }
    public static Product one(int product_id){
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            Product product = session.createQuery("From Product p WHERE p.product_id = :product_id", Product.class)
                    .setParameter("product_id",product_id).getSingleResult();

            session.getTransaction().commit();
            return product;
        }catch (Exception ex){ ex.printStackTrace(); }
        return null;
    }
    public static void save(Product product){
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            session.persist(product);

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void update(Product product){
        save(product);
    }
    public static void delete(int product_id) {
        Session session = HibernateUtil.openSession();
        session.getTransaction().begin();

        Query query = session.createNativeQuery("DELETE FROM products WHERE product_id = :product_id");
        query.setParameter("product_id", product_id);
        query.executeUpdate();

        session.getTransaction().commit();
    }
    public static void delete(Product product){
        delete(product.getProduct_id());
    }
}
