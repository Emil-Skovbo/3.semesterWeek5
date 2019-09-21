/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import javax.persistence.EntityManager;
import entity.Semester;
import entity.Student;
import entity.Teacher;
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

    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        try {

            List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
            return students;
        } finally {
            em.close();
        }
    }

    public List<Student> FindStudentByName(String fistname) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Student.findByFirstname").setParameter("firstname", fistname).getResultList();
        } finally {
            em.close();
        }
    }

    public Student addStudent(Student stud) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(stud);
            em.getTransaction().commit();
            return stud;
        } finally {
            em.close();
        }
    }

    public Semester addStudentToSemester(long studId, long semId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Semester semsters = (Semester) em.createNamedQuery("Semester.findById").setParameter("Id", semId).getSingleResult();
            Student stud = (Student) em.createNamedQuery("Student.findById").setParameter("Id", studId).getSingleResult();
            semsters.addStudent(stud);
            em.persist(semsters);
            em.getTransaction().commit();
            return semsters;
        } finally {
            em.close();
        }
    }

    public List<Student> findAllStudentswithLastName(String lastname) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery query = em.createQuery("SELECT s FROM Student s WHERE s.lastname = :lastname", Student.class);
            query.setParameter("lastname", lastname);
            em.getTransaction().commit();
            return query.getResultList();

        } finally {
            em.close();
        }
    }

    public int amountStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            return (int) em.createQuery("SELECT COUNT(e)  FROM Student e").getSingleResult();
        } finally {
            em.close();
        }
    }

    public int findNumberStudentsOnSemester(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            int semid = (int) em.createQuery("SELECT s.id FROM Semester s WHERE s.name = :name").setParameter("name", name).getSingleResult();
            return (int) em.createQuery("SELECT COUNT(s) FROM Student s, Semester a WHERE s.semester = :a." + semid).getSingleResult();
        } finally {
            em.close();
        }
    }

//    public int findNumberStudentsOnAllSemesters() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            return (int) em.createQuery("SELECT COUNT(s) FROM Student s JOIN s.Student Semester a WHERE s.semester = :a." + semid).getSingleResult();
//        } finally {
//            em.close();
//        }
//    }

}
