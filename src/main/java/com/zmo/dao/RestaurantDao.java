package com.zmo.dao;

import com.zmo.entity.Restaurant;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RestaurantDao {

    private SessionFactory factory;

    public RestaurantDao(SessionFactory factory) {
        this.factory = factory;
    }

    // Save Restaurant to Database
    public boolean saveRestaurant(Restaurant restaurant) {
        boolean f = false;
        try {
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            
            session.save(restaurant);
            
            tx.commit();
            session.close();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    // Get All Restaurants List
    public List<Restaurant> getAllRestaurants() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from Restaurant");
        List<Restaurant> list = query.list();
        session.close();
        return list;
    }
}