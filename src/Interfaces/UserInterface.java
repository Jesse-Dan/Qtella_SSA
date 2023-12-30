package src.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import src.Interfaces.UserInterface;
import src.Models.User;


public interface UserInterface {

    public void getUser(int id);

    public HashMap<String,String> saveUser() throws SQLException;

    public void editUserr();

    public void deleteUser(int id);


    public ArrayList<User> getAllUsers();

}
