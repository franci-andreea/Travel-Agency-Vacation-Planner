package business;

import model.User;
import repository.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService
{
    private final UserRepository userRepository;

    public UserService()
    {
        userRepository = new UserRepository();
    }

    public void addUser(User newUser) throws NoSuchAlgorithmException
    {
        //validari, apoi insert in repository
        if(newUser.getUsername() != null && !newUser.getUsername().isEmpty())
        {
            //check for uniqueness
            if(getUserByUsername(newUser.getUsername()) == null)
            {
                //no user with this username, it is safe to add in the database
                newUser.setPassword(encodePassword(newUser.getPassword()));
                userRepository.insertUser(newUser);
            }
        }
        else
        {
            System.out.println("Can't insert user into the database");
        }
    }

    public User getUserByUsername(String usernameToFind)
    {
        if(usernameToFind != null && !usernameToFind.isEmpty())
        {
            return userRepository.findByUsername(usernameToFind);
        }
        else
        {
            System.out.println("Can't find user by username");
            return null;
        }
    }

    public String encodePassword(String password) throws NoSuchAlgorithmException
    {
        //we will use MD5 encryption technique???
        String encryptedPassword = null;

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());

        byte[] bytes = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes)
        {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        encryptedPassword = sb.toString();

        return encryptedPassword;
    }
}
