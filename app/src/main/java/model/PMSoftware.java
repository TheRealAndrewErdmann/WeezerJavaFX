package model;
import java.util.ArrayList;

public class PMSoftware {

    private User user;
    private UserList userList;
    private ProjectList projectList;
    private Project project1;
    private Project project2;
    private Project project3;
    private ArrayList<Project> projects;

    /**
     * Constructs the project management software
     */
    public PMSoftware() {
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();
        
        projects = new ArrayList<Project>();
        project1 = new Project("Electric Missles", "Make electric missles");
        project2 = new Project("Soap Free Washers", "Make washers soap free");
        project3 = new Project("Air Computers", "Make air computers");
        projects.add(project1);

        Column column1 = new Column("To Do", "Incomplete");
        Column column2 = new Column("Doing", "Incomplete");
        Column column3 = new Column("Complete", "Complete");

        Task cylinder = new Task(project1, "Curve the metal to make a cylindrical shape",
                                 "description", Category.Feature, "High");
        
        Comment cylindrical = new Comment("Jeff Goldblum", "Not cyclindrical enough");
        Comment question = new Comment("Atticus Finch", "What's a cylinder?");

        project1.addTask(cylinder, "Incomplete");
        project1.addColumn(column1);
        project1.addColumn(column2);
        project1.addColumn(column3);
        cylinder.addComment(cylindrical);
        cylinder.addComment(question);

        projects.add(project2);
        projects.add(project3);
        
    }

    /**
     * logs in a user using their username and password
     * @param username username of the user logging in
     * @param password password of the user logging in
     * @return the user that logged in with their credentials
     */
    public User login(String username, String password) {
        if (userList.getUser(username) == null) {
            return null;
        }
        else {
            user = userList.getUser(username);
            return user;
        }
    }

    /**
     * signs up a new user for the project management software
     * @param username username made by the user
     * @param password password made by the user
     * @param email email address provided by the user
     * @param phoneNumber phone number provided by the user
     * @return the user that signed up with the given information
     */
    public User signup(String firstName, String lastName, String username, String password,String email, String phoneNumber) {
        return new User(firstName, lastName, username, password, email, phoneNumber);
    }

    /**
     * Creates a new project
     * @param title title of the project
     * @param description description of the project
     * @return a newly created project
     */
    public Project createProject(String title, String description) {
        return new Project(title, description);
    }

    /**
     * Finds a project in an array list of projects
     * @param projectName name of the project the user is looking for
     * @return the project the user was looking for
     */
    public Project findProject(String projectName) {
        for (int i = 0; i < projects.size(); i++) {
                return projects.get(i);
        }
        return null;
    }

    /**
     * Shows all the projects the user is a part of
     */
    public void showAllProjects(){
        for (int i = 0; i < projects.size(); i++) {
            System.out.println(projects.get(i).getTitle());
        }
    }

}