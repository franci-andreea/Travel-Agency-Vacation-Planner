package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "vacation_destinations")
public class VacationDestination
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String locationName;

    @Column
    private String description;

    @OneToMany
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private List<VacationDestinationPackage> packages;

    public VacationDestination()
    {

    }

    public VacationDestination(String locationName, String description, List<VacationDestinationPackage> packages)
    {
        this.locationName = locationName;
        this.description = description;
        this.packages = packages;
    }

    public VacationDestination(int id, String locationName, String description, List<VacationDestinationPackage> packages)
    {
        this.id = id;
        this.locationName = locationName;
        this.description = description;
        this.packages = packages;
    }

    public int getId()
    {
        return id;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public String getDescription()
    {
        return description;
    }

    public List<VacationDestinationPackage> getPackages()
    {
        return packages;
    }

    @Override
    public String toString()
    {
        return locationName;
    }
}
