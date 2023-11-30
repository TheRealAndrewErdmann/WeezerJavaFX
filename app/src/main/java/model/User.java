
import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNum;
    /**
     * Constructs a new User object with the specified user information without an id.
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param userName The username chosen by the user
     * @param password The password chosen by the user
     * @param email The email address provided by the user
     * @param phoneNum The phone number provided by the user
     * @author Shiv Patel
     */
    public User(String firstName, String lastName, String userName, String password,
                String email, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;

    }

    /**
     * Constructs a new User object with the specified user information with an id.
     * @param id The id of the user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param userName The username chosen by the user
     * @param password The password chosen by the user
     * @param email The email address provided by the user
     * @param phoneNum The phone number provided by the user
     */
    public User(UUID id, String firstName, String lastName, String userName, String password,
                String email, String phoneNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;

    }
    
    /**
     * Gets the id from the UUID
     * @return the id
     * @author Shiv Patel
     */
    public UUID getID(){
        return id;
    }

    /**
     * Gets the first name of the user
     * @return the first name
     * @author Shiv Patel
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Gets the last name of the user
     * @return the last name
     * @author Shiv Patel
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Gets the user name of the user
     * @return the username
     * @author Shiv Patel
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Gets the password of the user
     * @return the password
     * @author Shiv Patel
     */
    public String getPassword(){
        return password;
    }

    /**
     * Gets the email of the user
     * @return the email
     * @author Shiv Patel
     */
    public String getEmail(){
        return email;
    }

    /**
     * Gets the phone number of the user
     * @return the phone number
     * @author Shiv Patel
     */
    public String getPhoneNum(){
        return phoneNum;
    }

    /**
     * Checks and verifies the user based on the login info
     * @param Password Checks if the password matches
     * @return True if the password matches, false otherwise
     * @author Shiv Patel
     */
    public boolean verifyLogin(String Password) {
        if (password == Password) {
            return true;
        }
        else {
            return false;
        }
    }

}