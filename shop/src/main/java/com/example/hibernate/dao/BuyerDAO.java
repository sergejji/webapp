package com.example.hibernate.dao;

import com.example.hibernate.HibernateUtil;
import com.example.hibernate.models.Buyer;
import org.hibernate.Session;

import java.util.ArrayList;

public class BuyerDAO {
    public static ArrayList<Buyer> all(){
        ArrayList<Buyer> buyers = new ArrayList<>();
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            buyers =(ArrayList<Buyer>) session.createQuery("From Buyer", Buyer.class).list();

            session.getTransaction().commit();
        }catch (Exception ex){ ex.printStackTrace(); }
        return buyers;
    }
    public static Buyer one(int buyer_id){
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            Buyer buyer = session.createQuery("From Buyer b WHERE b.buyer_id = :buyer_id", Buyer.class)
                    .setParameter("buyer_id",buyer_id).getSingleResult();

            session.getTransaction().commit();
            return buyer;
        }catch (Exception ex){ ex.printStackTrace(); }
        return null;
    }
    public static void save(Buyer buyer){
        try{
            Session session = HibernateUtil.openSession();
            session.getTransaction().begin();

            session.persist(buyer);

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void update(Buyer buyer){
        save(buyer);
    }
    public static void delete(int buyer_id){
        Session session = HibernateUtil.openSession();
        session.getTransaction().begin();

        session.createNativeQuery("DELETE FROM buyers WHERE buyer_id = :buyer_id")
                .setParameter("buyer_id",buyer_id).executeUpdate();

        session.getTransaction().commit();
    }
    public static void delete(Buyer buyer){
        delete(buyer.getBuyer_id());
    }
}
