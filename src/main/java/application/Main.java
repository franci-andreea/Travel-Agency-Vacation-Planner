package application;

import controller.MainController;
import controller.UserController;
import controller.VacationDestinationController;
import controller.VacationDestinationPackageController;
import model.VacationDestination;
import model.VacationDestinationPackage;
import repository.VacationDestinationRepository;
import view.LogInWindow;
import view.TravelAgencyWindow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vacation.planner.a1");

    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException
    {
//        VacationDestinationPackage p = new VacationDestinationPackage(1,
//                "Hai la bere",
//                69.0f,
//                new SimpleDateFormat("dd/MM/yyyy").parse("22/03/2022"),
//                new SimpleDateFormat("dd/MM/yyyy").parse("30/03/2022"),
//                "extra details text text text text",
//                200
//                );
//
//        VacationDestination vacationDestination = new VacationDestination(1, "Alaska", "lorem ipsum description", new ArrayList<>(List.of(p)));

//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(p);
//        em.persist(vacationDestination);
//        em.getTransaction().commit();
//        em.close();

//
//        //test insert vacation destination
//        VacationDestinationController controller1 = new VacationDestinationController();
//        controller1.addVacationDestination(2, "Alaska", "description Alaska");
//
//        //test insert vacation package
//        VacationDestinationPackageController controller2 = new VacationDestinationPackageController();
//        controller2.addVacationDestinationPackage(2, "Alaska package22", 123.99f, new SimpleDateFormat("dd/MM/yyyy").parse("22/03/2022"),
//                new SimpleDateFormat("dd/MM/yyyy").parse("30/03/2022"), "extra details text text text text", 200, "Alaska");
//        EntityManager em = entityManagerFactory.createEntityManager();
//        VacationDestinationRepository vacationDestinationRepository = new VacationDestinationRepository();
//        VacationDestination vacationDestination = vacationDestinationRepository.findByName("Alaska");
//
//
//
//        System.out.println(vacationDestination.toString());

        MainController mainController = new MainController();
        mainController.start();


    }
}
