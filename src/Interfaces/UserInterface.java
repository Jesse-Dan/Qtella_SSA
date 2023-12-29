package src.Interfaces;

import java.util.ArrayList;

import src.Interfaces.UserInterface;
import src.Models.User;


public interface UserInterface {

    public void getUser();

    public void saveUser();

    public void editUserr();

    public void deleteUser();


    public ArrayList<User> getAllUsers();

}
