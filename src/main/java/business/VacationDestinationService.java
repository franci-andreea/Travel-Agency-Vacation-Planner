package business;

import model.VacationDestination;
import repository.VacationDestinationRepository;

import java.util.List;

public class VacationDestinationService
{
    private final VacationDestinationRepository vacationDestinationRepository;

    public VacationDestinationService()
    {
        vacationDestinationRepository = new VacationDestinationRepository();
    }

    public void addVacationDestination(VacationDestination newVacationDestination)
    {
        //validari, apoi insert in repository
        if ((newVacationDestination.getLocationName() != null && !newVacationDestination.getLocationName().isEmpty()) &&
                (newVacationDestination.getDescription() != null))
        {
            vacationDestinationRepository.insertVacationDestination(newVacationDestination);
        } else
        {
            System.out.println("Can't insert vacation destination into the database");
        }
    }

    public void deleteVacationDestination(int id)
    {
        vacationDestinationRepository.deleteVacationDestination(id);
    }

    public VacationDestination getDestinationByName(String locationName)
    {
        return vacationDestinationRepository.findByName(locationName);
    }

    public List<VacationDestination> getAllDestinations()
    {
        return vacationDestinationRepository.getAllElements();
    }

}
