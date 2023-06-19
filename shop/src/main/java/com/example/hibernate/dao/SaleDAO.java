package com.example.hibernate.dao;

import com.example.hibernate.HibernateUtil;
import com.example.hibernate.models.Sale;
import org.hibernate.Session;

import java.util.ArrayList;

public class SaleDAO {

    public static ArrayList<Sale> all(){
        ArrayList<Sale> sales = new ArrayList<>();
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            sales =(ArrayList<Sale>) session.createQuery("From Sale", Sale.class).list();

            session.getTransaction().commit();
        }catch (Exception ex){ ex.printStackTrace(); }
        return sales;
    }
    public static Sale one(int sale_id){
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            Sale sale = session.createQuery("From Sale s WHERE s.sale_id = :sale_id", Sale.class)
                    .setParameter("sale_id",sale_id).getSingleResult();

            session.getTransaction().commit();
            return sale;
        }catch (Exception ex){ ex.printStackTrace(); }
        return null;
    }
    public static void save(Sale sale){
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            session.persist(sale);

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void update(Sale sale){
        save(sale);
    }
    public static void delete(int sale_id){
        Session session = HibernateUtil.openSession();
        session.getTransaction().begin();

        session.createNativeQuery("DELETE FROM sales WHERE sale_id = :sale_id")
                .setParameter("sale_id",sale_id).executeUpdate();

        session.getTransaction().commit();
    }
    public static void delete(Sale sale){
        delete(sale.getSale_id());
    }
}
