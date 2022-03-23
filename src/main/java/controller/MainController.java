package controller;

import model.VacationDestination;
import model.VacationDestinationPackage;
import view.LogInWindow;
import view.TravelAgencyWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainController
{
    private final UserController userController;
    private final VacationDestinationController vacationDestinationController;
    private final VacationDestinationPackageController vacationDestinationPackageController;

    private LogInWindow logInWindow;
    private TravelAgencyWindow travelAgencyWindow;

    public MainController()
    {
        userController = new UserController();
        vacationDestinationController = new VacationDestinationController();
        vacationDestinationPackageController = new VacationDestinationPackageController();
    }

    public void start()
    {
        logInWindow = new LogInWindow();

        logInWindowInitializeButtons();
    }

    public void logInWindowInitializeButtons()
    {
        logInWindow.adminButtonActionListener(e -> {
            //set login window invisible
            logInWindow.setVisible(false);

            travelAgencyWindow = new TravelAgencyWindow();

            for(VacationDestination vd : vacationDestinationController.getAllDestinations())
            {
                travelAgencyWindow.getVacationDestinationsList().addItem(vd);
            }

            travelWindowInitializeButtons();
        });

        logInWindow.logInButtonActionListener(e -> {
            String usernameIntroduced = logInWindow.getUsernameField().getText();
            String passwordIntroduced = logInWindow.getPasswordField().getText();

            try
            {
                if(userController.checkLogIn(usernameIntroduced, passwordIntroduced) == 0)
                {
                    System.out.println("logged in successfully");
                }
            } catch (NoSuchAlgorithmException ex)
            {
                ex.printStackTrace();
            }

        });

        logInWindow.registerButtonActionListener(e -> {
            String usernameIntroduced = logInWindow.getUsernameField().getText();
            String passwordIntroduced = logInWindow.getPasswordField().getText();

            try
            {
                userController.addUser(usernameIntroduced, passwordIntroduced);

                System.out.println("registration completed!");
            } catch (NoSuchAlgorithmException ex)
            {
                ex.printStackTrace();
            }
        });
    }

    public void travelWindowInitializeButtons()
    {
        travelAgencyWindow.addItemListenerPackagesComboBox(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                VacationDestination destinationSelected = (VacationDestination) travelAgencyWindow.getVacationDestinationsList().getSelectedItem();
                travelAgencyWindow.getVacationPackagesList().removeAllItems();
                for(VacationDestinationPackage vdp : destinationSelected.getPackages())
                {
                    travelAgencyWindow.getVacationPackagesList().addItem(vdp);
                }
            }
        });

        travelAgencyWindow.addItemListenerPackagesDetails(e -> {
            travelAgencyWindow.getPackageDetailsArea().setText("");

            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                VacationDestinationPackage packageSelected = (VacationDestinationPackage) travelAgencyWindow.getVacationPackagesList().getSelectedItem();

                System.out.println("print details");

                travelAgencyWindow.getPackageDetailsArea().append("Name: " + packageSelected.getPackageName() + "\n");
                travelAgencyWindow.getPackageDetailsArea().append("Price: " + packageSelected.getPrice() + "\n");
                travelAgencyWindow.getPackageDetailsArea().append("Start date: " + packageSelected.getStartDate() + "\n");
                travelAgencyWindow.getPackageDetailsArea().append("End date: " + packageSelected.getEndDate() + "\n");
                travelAgencyWindow.getPackageDetailsArea().append("Number of persons: " + packageSelected.getNumberOfAvailablePersons() + "\n");
                travelAgencyWindow.getPackageDetailsArea().append("Extra details:\n" + packageSelected.getExtraDetails());
            }
        });

        travelAgencyWindow.addDestinationButtonActionListener(e -> {
            String destinationNameIntroduced = travelAgencyWindow.getDestinationNameField().getText();
            String descriptionIntroduced = travelAgencyWindow.getDestinationDescriptionField().getText();

            vacationDestinationController.addVacationDestination(destinationNameIntroduced, descriptionIntroduced);


            System.out.println("destination inserted successfully");

            VacationDestination lastAddedDestination = vacationDestinationController.getDestinationByName(destinationNameIntroduced);
            travelAgencyWindow.getVacationDestinationsList().addItem(lastAddedDestination);
        });

        travelAgencyWindow.deleteDestinationButtonActionListener(e -> {
            VacationDestination destinationSelected = (VacationDestination) travelAgencyWindow.getVacationDestinationsList().getSelectedItem();

            for(VacationDestinationPackage vdp : destinationSelected.getPackages())
            {
                vacationDestinationPackageController.deleteVacationPackage(vdp.getId());
            }

            System.out.println("deleted all packages successfully");

            travelAgencyWindow.getVacationDestinationsList().removeItem(destinationSelected);

            vacationDestinationController.deleteVacationDestination(destinationSelected.getId());

            System.out.println("deleted destination successfully");
        });

        travelAgencyWindow.addPackageButtonActionListener(e -> {
            try
            {
                String nameIntroduced = travelAgencyWindow.getPackageNameField().getText();
                float priceIntroduced = Float.parseFloat(travelAgencyWindow.getPackagePriceField().getText());
                Date startDateIntroduced = new SimpleDateFormat("dd/MM/yyyy").parse(travelAgencyWindow.getStartDateField().getText());
                Date endDateIntroduced = new SimpleDateFormat("dd/MM/yyyy").parse(travelAgencyWindow.getEndDateField().getText());
                String extraDetailsIntroduced = travelAgencyWindow.getExtraDetailsField().getText();
                int numberOfPeopleIntroduced = Integer.parseInt(travelAgencyWindow.getNumberOfPeopleField().getText());

                String locationNameSelected = String.valueOf(travelAgencyWindow.getVacationDestinationsList().getSelectedItem());

                vacationDestinationPackageController.addVacationDestinationPackage(nameIntroduced, priceIntroduced, startDateIntroduced, endDateIntroduced, extraDetailsIntroduced, numberOfPeopleIntroduced, locationNameSelected);

                System.out.println("package added successfully");

                VacationDestinationPackage lastAddedPackage = vacationDestinationPackageController.findPackageByName(nameIntroduced);
                travelAgencyWindow.getVacationPackagesList().addItem(lastAddedPackage);

            } catch (ParseException ex)
            {
                ex.printStackTrace();
            }

        });

        travelAgencyWindow.deletePackageButtonActionListener(e -> {
            VacationDestinationPackage selectedPackage = (VacationDestinationPackage) travelAgencyWindow.getVacationPackagesList().getSelectedItem();

            vacationDestinationPackageController.deleteVacationPackage(selectedPackage.getId());

            travelAgencyWindow.getVacationPackagesList().removeItem(selectedPackage);
        });

        travelAgencyWindow.editPackageButtonActionListener(e -> {
            try
            {
                String newName = travelAgencyWindow.getPackageNameField().getText();
                float newPrice = Float.parseFloat(travelAgencyWindow.getPackagePriceField().getText());
                Date newStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(travelAgencyWindow.getStartDateField().getText());
                Date newEndDate = new SimpleDateFormat("dd/MM/yyyy").parse(travelAgencyWindow.getEndDateField().getText());
                String newExtraDetails = travelAgencyWindow.getExtraDetailsField().getText();
                int newNumberOfPersons = Integer.parseInt(travelAgencyWindow.getNumberOfPeopleField().getText());

                VacationDestinationPackage oldSelectedPackage = (VacationDestinationPackage) travelAgencyWindow.getVacationPackagesList().getSelectedItem();
                VacationDestinationPackage newPackage = new VacationDestinationPackage(newName, newPrice, newStartDate, newEndDate, newExtraDetails, newNumberOfPersons);

                vacationDestinationPackageController.editVacationDestinationPackage(oldSelectedPackage, newPackage);

                System.out.println("package edited successfully");

            } catch (ParseException ex)
            {
                ex.printStackTrace();
            }

        });

        travelAgencyWindow.exitButtonActionListener(e -> {
            travelAgencyWindow.setVisible(false);
            logInWindow.setVisible(true);
        });
    }
}
