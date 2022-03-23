package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "vacation_packages")
public class VacationDestinationPackage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String packageName;

    @Column
    private float price;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String extraDetails;

    @Column
    private int numberOfAvailablePersons;

    @ManyToMany(mappedBy = "packages")
    private Set<User> users = new HashSet<>();

    public VacationDestinationPackage(String packageName, float price, Date startDate, Date endDate, String extraDetails, int numberOfAvailablePersons)
    {
        this.packageName = packageName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extraDetails = extraDetails;
        this.numberOfAvailablePersons = numberOfAvailablePersons;
    }

    public VacationDestinationPackage(int id, String packageName, float price, Date startDate, Date endDate, String extraDetails, int numberOfAvailablePersons)
    {
        this.id = id;
        this.packageName = packageName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extraDetails = extraDetails;
        this.numberOfAvailablePersons = numberOfAvailablePersons;

    }

    public VacationDestinationPackage()
    {

    }

    public int getId()
    {
        return id;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public float getPrice()
    {
        return price;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public String getExtraDetails()
    {
        return extraDetails;
    }

    public int getNumberOfAvailablePersons()
    {
        return numberOfAvailablePersons;
    }

    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public void setExtraDetails(String extraDetails)
    {
        this.extraDetails = extraDetails;
    }

    public void setNumberOfAvailablePersons(int numberOfAvailablePersons)
    {
        this.numberOfAvailablePersons = numberOfAvailablePersons;
    }

    @Override
    public String toString()
    {
        return packageName;
    }
}
