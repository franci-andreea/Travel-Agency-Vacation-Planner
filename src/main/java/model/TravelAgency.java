package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "travel_agency")
public class TravelAgency
{
    @Id
    private int id;

    @Column
    private final String usernameAdmin = "admin";

    @Column
    private final String passwordAdmin = "adminpass";

    public TravelAgency()
    {

    }

    public int getId()
    {
        return id;
    }

    public String getUsernameAdmin()
    {
        return usernameAdmin;
    }

    public String getPasswordAdmin()
    {
        return passwordAdmin;
    }
}
