
import java.util.ArrayList;

public class UserList {
    private static UserList userList = null;
    private ArrayList<User> users;

    private UserList(){
        users = FileLoader.getUsers();
    }

    /**
     * gets an instance of the UserList private constructor
     * @return returns an instance of the UserList constructor
     * @author Andrew Erdmann
     */
    public static UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
    }

    /**
     * gets the array list of users
     * @return returns users 
     * @author Andrew Erdmann
     */
    public ArrayList<User> getUsers() {
        return users;
    }


    /**
     * gets a singular specific user
     * @param username username of the person you want
     * @return returns that user
     * @author Alex Dupree
     */
    public User getUser(String username){
        for(User user : users){
            if(user.getUserName().equals(username))
                return user;
        }
        return null;
    }
}
