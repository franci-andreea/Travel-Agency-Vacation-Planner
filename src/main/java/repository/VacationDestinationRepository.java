package repository;

import model.VacationDestination;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class VacationDestinationRepository
{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vacation.planner.a1");

    public void insertVacationDestination(VacationDestination vacationDestinationToInsert)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(vacationDestinationToInsert);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteVacationDestination(int id)
    {
        EntityManager em = entityManagerFactory.createEntityManager();

        VacationDestination vacationDestination = em.find(VacationDestination.class, id);

        em.getTransaction().begin();
        em.remove(vacationDestination);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public VacationDestination findByName(String locationName)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try
        {
            return em.createQuery("SELECT vd FROM VacationDestination vd WHERE vd.locationName = :locationName", VacationDestination.class).setParameter("locationName", locationName).getSingleResult();
        }
        catch (NoResultException e)
        {
            System.out.println("There is no destination with the provided name");
        }
        em.getTransaction().commit();
        em.close();

        return null;
    }

    public List<VacationDestination> getAllElements()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        String query = "SELECT vd FROM VacationDestination vd";
        return (List<VacationDestination>) em.createQuery(query).getResultList();
    }
}
