package controller;

import business.VacationDestinationPackageService;
import model.VacationDestinationPackage;

import java.util.Date;

public class VacationDestinationPackageController
{
    private final VacationDestinationPackageService vacationDestinationPackageService;

    public VacationDestinationPackageController()
    {
        vacationDestinationPackageService = new VacationDestinationPackageService();
    }

    public void addVacationDestinationPackage(String packageName, float price, Date startDate, Date endDate, String extraDetails, int numberOfAvailablePersons, String locationName)
    {
        VacationDestinationPackage vacationPackage = new VacationDestinationPackage(packageName, price, startDate, endDate, extraDetails, numberOfAvailablePersons);
        vacationDestinationPackageService.addVacationPackage(vacationPackage, locationName);
    }

    public void editVacationDestinationPackage(VacationDestinationPackage oldPackage, VacationDestinationPackage newPackage)
    {
        vacationDestinationPackageService.editVacationDestinationPackage(oldPackage, newPackage);
    }

    public void deleteVacationPackage(int id)
    {
        vacationDestinationPackageService.deleteVacationDestinationPackage(id);
    }

    public VacationDestinationPackage findPackageByName(String packageName)
    {
        return vacationDestinationPackageService.getPackageByName(packageName);
    }


}
