package controller;

import business.UserService;
import model.User;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;

public class UserController
{
    private final UserService userService;

    public UserController()
    {
        userService = new UserService();
    }

    public void addUser(String username, String password) throws NoSuchAlgorithmException
    {
        User user = new User(username, password);
        userService.addUser(user); //the new user is added after validation and it also executes in the database
    }

    public int checkLogIn(String username, String password) throws NoSuchAlgorithmException
    {
        User searchedUser = userService.getUserByUsername(username);

        if(searchedUser == null)
        {
            JOptionPane.showMessageDialog(null, "No user found with this username");

            return 1;
        }
        else
        {
            //check if password is correct
            if(userService.encodePassword(password).compareTo(searchedUser.getPassword()) != 0)
            {
                JOptionPane.showMessageDialog(null, "Incorrect password");

                return 1;
            }
        }

        //everything all good
        return 0;
    }
}
