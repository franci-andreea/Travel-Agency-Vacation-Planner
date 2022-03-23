package business;

import model.VacationDestination;
import model.VacationDestinationPackage;
import repository.VacationDestinationPackageRepository;

public class VacationDestinationPackageService
{
    private final VacationDestinationPackageRepository vacationDestinationPackageRepository;

    public VacationDestinationPackageService()
    {
        vacationDestinationPackageRepository = new VacationDestinationPackageRepository();
    }

    public void addVacationPackage(VacationDestinationPackage newVacationPackage, String destinationName)
    {
        //validari, apoi insert in repository
        if ((newVacationPackage.getPackageName() != null && !newVacationPackage.getPackageName().isEmpty()) &&   //not-null and non-empty string
                (newVacationPackage.getEndDate().compareTo(newVacationPackage.getStartDate()) > 0) &&           //end date should be after start date
                (newVacationPackage.getPrice() > 0.0f) &&                                                       //price should be a positive value
                (newVacationPackage.getNumberOfAvailablePersons() > 0) &&                                       //number of people should be a positive value
                (newVacationPackage.getExtraDetails() != null))                                                 //extra details field not-null
        {
            vacationDestinationPackageRepository.insertVacationDestinationPackage(newVacationPackage, destinationName);
        } else
        {
            System.out.println("Can't insert package into the database");
        }
    }

    public void editVacationDestinationPackage(VacationDestinationPackage oldVacationPackage, VacationDestinationPackage newVacationPackage)
    {
        if ((newVacationPackage.getPackageName() != null && !newVacationPackage.getPackageName().isEmpty()) &&   //not-null and non-empty string
                (newVacationPackage.getEndDate().compareTo(newVacationPackage.getStartDate()) > 0) &&           //end date should be after start date
                (newVacationPackage.getPrice() > 0.0f) &&                                                       //price should be a positive value
                (newVacationPackage.getNumberOfAvailablePersons() > 0) &&                                       //number of people should be a positive value
                (newVacationPackage.getExtraDetails() != null))
        {

            oldVacationPackage.setPackageName(newVacationPackage.getPackageName());
            oldVacationPackage.setPrice(newVacationPackage.getPrice());
            oldVacationPackage.setStartDate(newVacationPackage.getStartDate());
            oldVacationPackage.setEndDate(newVacationPackage.getEndDate());
            oldVacationPackage.setExtraDetails(newVacationPackage.getExtraDetails());
            oldVacationPackage.setNumberOfAvailablePersons(newVacationPackage.getNumberOfAvailablePersons());

            vacationDestinationPackageRepository.editVacationPackage(oldVacationPackage);
        }
    }

    public void deleteVacationDestinationPackage(int id)
    {
        vacationDestinationPackageRepository.deleteVacationPackage(id);
    }

    public VacationDestinationPackage getPackageByName(String packageNameToFind)
    {
        if(packageNameToFind != null && !packageNameToFind.isEmpty())
        {
            return vacationDestinationPackageRepository.getPackageByName(packageNameToFind);
        }
        else
        {
            System.out.println("Can't find package by name");
            return null;
        }
    }



}
