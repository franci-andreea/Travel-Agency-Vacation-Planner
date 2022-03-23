package repository;

import model.VacationDestination;
import model.VacationDestinationPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class VacationDestinationPackageRepository
{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vacation.planner.a1");
    private VacationDestinationRepository vacationDestinationRepository = new VacationDestinationRepository();

    public void insertVacationDestinationPackage(VacationDestinationPackage vacationDestinationPackageToInsert, String locationName)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        VacationDestination vacationDestination = vacationDestinationRepository.findByName(locationName);
        vacationDestination.getPackages().add(vacationDestinationPackageToInsert);
        em.getTransaction().begin();
        em.persist(vacationDestinationPackageToInsert);
        em.merge(vacationDestination);
        em.getTransaction().commit();
        em.close();
    }

    public void editVacationPackage(VacationDestinationPackage vacationDestinationPackage)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(vacationDestinationPackage);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteVacationPackage(int id)
    {
        EntityManager em = entityManagerFactory.createEntityManager();

        VacationDestinationPackage vacationDestinationPackage = em.find(VacationDestinationPackage.class, id);

        em.getTransaction().begin();
        em.remove(vacationDestinationPackage);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public VacationDestinationPackage getPackageByName(String packageName)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try
        {
            return em.createQuery("SELECT p FROM VacationDestinationPackage p WHERE p.packageName = :packageName", VacationDestinationPackage.class).setParameter("packageName", packageName).getSingleResult();
        }
        catch (NoResultException e)
        {
            System.out.println("There is no package with the provided name");
        }
        em.getTransaction().commit();
        em.close();

        return null;
    }
}
