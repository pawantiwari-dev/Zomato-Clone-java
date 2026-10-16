package com.zmo.controller;

import com.zmo.dao.RestaurantDao;
import com.zmo.entity.Restaurant;
import com.zmo.helper.FactoryProduct;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/RestaurantController")
public class RestaurantController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // HTML form se data receive karna
            String name = request.getParameter("name");
            String cuisine = request.getParameter("cuisine");
            String deliveryTime = request.getParameter("deliveryTime");
            
            if (name != null && !name.trim().isEmpty()) {
                // Restaurant object banana
                Restaurant restaurant = new Restaurant(name, cuisine, deliveryTime);
                
                // DAO ke through database me save karna
                RestaurantDao dao = new RestaurantDao(FactoryProduct.getSessionFactory());
                boolean success = dao.saveRestaurant(restaurant);
                
                
                   if (success) {
                out.println("<h2 style='color: green;'>Restaurant Added Successfully to Zomato Demo!</h2>");
                out.println("<h3>Added Restaurant Details:</h3>");
                out.println("<p><b>Restaurant Name:</b> " + name + "</p>");
                out.println("<p><b>Cuisine Type:</b> " + cuisine + "</p>");
                out.println("<p><b>Delivery Time:</b> " + deliveryTime + " mins</p>");
                out.println("<br><a href='index.jsp'>Go Back</a>");
            
                   
                } else {
                    out.println("<h2 style='color: red;'>Error! Something went wrong.</h2>");
                }
            } else {
                out.println("<h3>Please fill all details!</h3>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}