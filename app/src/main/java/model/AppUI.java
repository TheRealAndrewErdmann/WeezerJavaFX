

public class AppUI {
    private PMSoftware PMSoftware;

    /**
     * Constructs the UI for the project management app
     */
    AppUI() {
        PMSoftware = new PMSoftware();
    }

    /**
     * Method to run the project management app with a given scenario 
     */
    public void scenario() {

        System.out.println("Welcome to Code Mission Possible"); 
        System.out.println("-----------Logging in-----------");       
        System.out.println("Welcome Atticus Madden\n");

        System.out.println("Which project would you like to view?");
        PMSoftware.showAllProjects();
        Project found = PMSoftware.findProject("Electric Missiles");

        if (found == null) {
            System.out.println("That is not an existing project");
        }

        System.out.println("\n----Viewing Electric Missiles----");

        Column abandoned = new Column("Abandoned", "Incomplete");
        User Atticus = new User("Atticus", "Madden", "Amadden", "Madden", "amadden@gamil.com", "803-730-4872");
        User Jeff = new User("Jeff", "Goldblum", "Jgoldblum", "Password", "jgoldblum@gamil.com", "803-826-9943");
        User Finch = new User("Atticus", "Finch", "Afinch", "Circle", "afinch@gamil.com", "803-747-3250");
        
        found.addColumn(abandoned);
        found.addParticipant(Atticus, "Scrum Master");
        found.addParticipant(Jeff, "Developer");
        found.addParticipant(Finch, "Product Owner"); 

        Task cylinder = new Task(found, "Curve the metal to make a cylindrical shape",
                                 "description", Category.Feature, "High");
        Task initialize = new Task(found, "Initialize super algorithm to detonate at warp speed", 
                                    "description", Category.Feature, "Medium");
        Task burger = new Task(found, "Make impossible burger possible", "description", 
                                Category.Feature, "Low");  
        found.addTask(initialize, "Incomplete");

        Comment avoid = new Comment("Atticus Madden", "Avoid civllians Jeff!");
        initialize.addComment(avoid);
        Comment reply = new Comment("Atticus Madden", "How about you do it jeff."); 

        PMSoftware.findProject("Electrical Missiles").changeTaskStatus(initialize, "Incomplete", "To Do");
        PMSoftware.findProject("Electrical Missiles").changeTaskStatus(cylinder, "To Do", "Doing");
        PMSoftware.findProject("Electrical Missiles").changeTaskStatus(burger, "To Do", "Abandoned");
        
        Comment cylindrical = new Comment("Jeff Goldblum", "Not cyclindrical enough.");
        Comment question = new Comment("Atticus Finch", "What's a cylinder?");

        cylinder.addComment(cylindrical);
        cylinder.addComment(question);

        System.out.println("Moving task (" + cylinder.getTaskName() + ") to 'Doing' column.");
        System.out.println("Replying to Jeff Goldblum \"" + reply.getComment() + "\"");
        System.out.println("Moving task (" + burger.getTaskName() + ") to 'Abandoned' column.\n");
        found.print();
        System.out.println("Code Mission Possible scrum board can be found in scrum.txt.");
    }

    public static void main(String[] args) {
        AppUI app = new AppUI();
        app.scenario();
    }
}