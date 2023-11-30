import java.util.ArrayList;
import java.util.UUID;


public class Task {
    private UUID id;
    private Project project;
    private String taskName;
    private String taskDescription;
    private Category category;
    private String priority;
    private String status;
    private User taskOwner;
    private ArrayList<Comment> comments;
    private ArrayList<Change> changes;
    /**
     * Constructs a new Task with the specified attributes
     * @param project The project to which this task belongs
     * @param taskName The name of the task
     * @param taskDescription The description of the task
     * @param category The category to which the task is associated 
     * @param priority The priority level of the task
     * @author Shiv Patel
     */
    public Task(Project project, String taskName, String taskDescription, Category category, String priority){
        this.project = project;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.category = category;
        this.priority = priority;
        comments = new ArrayList<Comment>();
        changes = new ArrayList<Change>();
    }
    /**
     * Changes the staus of a task to a new status
     * This method allows you to update the status of a task to a new status if the status of the task is not null.
     * @param newStatus The new status for the task
     * @return True if the task is successfully changed, false otherwise
     * @author Shiv Patel
     */
    public boolean changeStatus(String newStatus){
        if(status == null)
            return false;
        changes.add(new Change("Changed status from "+status+" to "+newStatus, taskOwner));
        return project.changeTaskStatus(this, status, newStatus);
    }
    /**
     * Changes the description of a task
     * This method updates the task's description with the provided input 
     * @param description The new description for the task
     * @return True if the description was successfully changed; false otherwise.
     * @author Shiv Patel
     */
    public boolean changeDescription(String description){
        if(description == null)
            return false;
        taskDescription = description;
        changes.add(new Change("Changed description from "+taskDescription+" to "+description, taskOwner));
        return true;
    }
    /**
     * Changes the priority of the current object to the specified priority
     * @param priority The new priority to set. Must not be null
     * @return True if the priority was successfully changed; false otherwise
     * @author Shiv Patel
     */
    public boolean changePriority(String priority){
        if(priority == null)
            return false;
        changes.add(new Change("Changed priority from "+this.priority+" to "+priority, taskOwner));
        this.priority = priority;
        return true;
    }
    /**
     * This adds a comment to the list of comments
     * This method adds the specified comment to the list of comments 
     * @param comment The comment to add to the list 
     * @return True if the comment was added; false otherwise.
     * @author Shiv Patel
     */
    public boolean addComment(Comment comment){
        if(comment == null)
            return false;
        return comments.add(comment);
    }
    /**
     * Sets the status of an object to the specified value
     * @param status To set the new status
     * @return True if the status was set; false otherwise
     * @author Shiv Patel
     */
    public boolean setStatus(String status) {
        if(status == null)
            return false;
        changes.add(new Change("Set status to "+status, taskOwner));
        this.status = status;
        return true;
    }
    /**
     * This sets the task owner for the task a user decides to complete
     * @param taskOwner Sets the task owner
     * @return True if the task owner is successfully set up; false otherwise
     * @author Shiv Patel
     */
    public boolean setTaskOwner(User taskOwner) {
        if(taskOwner == null || this.taskOwner != null)
            return false;
        this.taskOwner = taskOwner;
        return true;
    }

    /**
     * Gets the changes that were made to task and stores it in an array list
     * @return the changes
     * @author Shiv Patel
     */
    public ArrayList<Change> getChanges() {
        return changes;
    }

    /**
     * Gets the comments and stores it in an array list
     * @return Comments added
     * @author Shiv Patel
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Gets the name of the task
     * @return the task name
     * @author Shiv Patel
     */
    public String getTaskName() {
        return taskName;
    }
	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPriority() {
		// TODO Auto-generated method stub
		return null;
	}

}
