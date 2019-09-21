/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Address;
import jpa.Customer;
import jpa.CustomerAsg;

/**
 *
 * @author ahmed
 */
public class tester2 {
    public static void main(String[] args) {/*
        CustomerAsg cust1 = new CustomerAsg("joe", "jackson");
        Address add1 = new Address("new work", "dounutStreet");
        cust1.setAddress(add1);
        //add1.setCustomer(cust1); // one way
       
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
        em.persist(cust1);
        em.getTransaction().commit();
        }finally{
        em.close();
        }
         em = emf.createEntityManager();
        CustomerAsg found = em.find(CustomerAsg.class, cust1.getId());
        System.out.println("adress : " + found.getAddress().getCity());*/
        //Customer found = em.find(Customer.class,custum.getId());
        
        
    }
    
}
