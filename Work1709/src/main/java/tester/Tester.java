/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Customer;

/**
 *
 * @author ahmed
 */
public class Tester {
    public static void main(String[] args) {
        
        Customer custum = new Customer("bob");
        custum.addHobby("Dabbing");
        custum.addHobby("Crak");
        custum.addHobby("Eat mcd");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
        em.persist(custum);
        em.getTransaction().commit();
        }finally{
        em.close();
        }
        
         em = emf.createEntityManager();
        Customer found = em.find(Customer.class,custum.getId());
        System.out.println("Hobbies : " + found.getHobby());
    }
    
}
