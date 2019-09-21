/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import javax.persistence.EntityManager;
import Entities.Customer;
import Entities.ItemType;
import Entities.Order;
import Entities.OrderLine;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author emils
 */
public class AllFacade {

    private static AllFacade instance;
    private static EntityManagerFactory emf;

    public Customer addCustomer(String name, String color) {
        Customer cust = new Customer();
        cust = new Customer(name, color);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public Customer getCustomerByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer cust = em.find(Customer.class, id);
            return cust;
        } finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Customer> id = em.createQuery("select b from Customer b").getResultList();
            return id;
        } finally {
            em.close();
        }
    }

    public ItemType addItemType(String name, String desription, int price) {
        ItemType item = new ItemType();
        item = new ItemType(name, desription, price);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            return item;
        } finally {
            em.close();
        }
    }

    public ItemType getItemTypeByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            ItemType item = em.find(ItemType.class, id);
            return item;
        } finally {
            em.close();
        }
    }

    public Customer addOrderToCustomer(String name, String color, long orderId) {
        Customer cust = new Customer(name, color);
        Order ord = new Order(orderId);
        cust.addOrder(ord);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public Order addOrderLineToOrder(String name, String description, int price, Long orderId, int quant) {
        Order ord = new Order(orderId);
        ItemType item = new ItemType(name, description, price);
        OrderLine ol = new OrderLine(quant, item);
        ord.addOrderLine(ol);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ord);
            em.getTransaction().commit();
            return ord;
        } finally {
            em.close();
        }
    }

    
    public List<Order> findAllOrders(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery query = em.createQuery("Select m from Order m, Customer a WHERE m.id = :a.id", Order.class);
            query.setParameter("id", id);
            em.getTransaction().commit();
            return query.getResultList();

        } finally {
            em.close();
        }
    }

}
