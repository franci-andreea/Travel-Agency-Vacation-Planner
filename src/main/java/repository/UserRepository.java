package repository;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class UserRepository
{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vacation.planner.a1");

    public void insertUser(User userToInsert)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(userToInsert);
        em.getTransaction().commit();
        em.close();
    }

    //find by username to implement validation on user's username (to check for uniqueness)
    public User findByUsername(String username)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try
        {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class).setParameter("username", username).getSingleResult();
        }
        catch (NoResultException e)
        {
            System.out.println("There is no such user with the provided username");
        }
        em.getTransaction().commit();
        em.close();

        return null;
    }
}
