package facades;

import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {
    }

    /**
     *
     * @param _emf  
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getPersonCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long Count = (long) em.createQuery("SELECT COUNT(r) FROM Person r").getSingleResult();
            return Count;
        } finally {
            em.close();
        }
    }
    
        public List<Person> getAllPerson() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query
                    = em.createQuery("Select m from Person m", Person.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public Person getPersonByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Person person = em.find(Person.class, id);
            return person;
        } finally {
            em.close();
        }
    }

    public void deletePersonByID(int id) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        Person nPerson = p;
        try{
            em.getTransaction().begin();
                        TypedQuery query
                    = em.createQuery("UPDATE Person p SET p.firstName :firstName where p.id =:id", Person.class);
            em.setProperty("name", p.getFirstname());
            em.setProperty("name", p.getId());
            em.getTransaction().commit();
        } finally {
            em.close();
        }  
        return nPerson;
    }
    
        public Person addPerson(String firstName, String lastName) {
        Person p = new Person();
        p = new Person(firstName, lastName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

}
