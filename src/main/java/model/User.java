package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable (name = "users_packages", joinColumns = {@JoinColumn (name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn (name = "package_id", referencedColumnName = "id")})
    Set<VacationDestinationPackage> packages = new HashSet<>();

    public User()
    {

    }

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public User(int id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
