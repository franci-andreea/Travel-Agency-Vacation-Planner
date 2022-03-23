package controller;

import business.VacationDestinationService;
import model.User;
import model.VacationDestination;

import java.util.ArrayList;
import java.util.List;

public class VacationDestinationController
{
    private final VacationDestinationService vacationDestinationService;

    public VacationDestinationController()
    {
        vacationDestinationService = new VacationDestinationService();
    }

    public void addVacationDestination(String locationName, String description)
    {
        VacationDestination vacationDestination = new VacationDestination(locationName, description, new ArrayList<>());
        vacationDestinationService.addVacationDestination(vacationDestination);
    }

    public void deleteVacationDestination(int id)
    {
        vacationDestinationService.deleteVacationDestination(id);
    }

    public VacationDestination getDestinationByName(String locationName)
    {
        return vacationDestinationService.getDestinationByName(locationName);
    }

    public List<VacationDestination> getAllDestinations()
    {
        return vacationDestinationService.getAllDestinations();
    }

}
