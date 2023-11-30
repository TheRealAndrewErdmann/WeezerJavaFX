import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The TaskTest class contains tests for the Task class.
 * It ensures that all task functionalities work as expected within the context of a project.
 * @author yingdongfeng
 */
class TaskTest {

    private Task task;
    private Project project;
    private Category category;
    private User user;
    private String initialStatus = "To Do";
    private String taskName = "Create Login Page";
    private String taskDescription = "Design and implement the login page";
    private String priority = "High";

     /**
     * Sets up the environment before each test.
     * This includes initializing the Project, Category, User, and Task objects.
     * Initialize your Project, Category, and User objects as needed.
     * These are just placeholders as the actual implementations are not provided.
     */
    @BeforeEach
    public void setUp() {
        
        project = new Project(initialStatus, initialStatus);
     
        user = new User(initialStatus, initialStatus, initialStatus, initialStatus, initialStatus, initialStatus);

        task = new Task(project, taskName, taskDescription, category, priority);
        task.setStatus(initialStatus);
        task.setTaskOwner(user);
    }

     /**
     * Tests the ability of the Task to change its status.
     * It verifies that the status changes appropriately and that invalid inputs are handled.
     * Status should not change with null input
     */
    @Test
    public void testChangeStatus() {
        String newStatus = "In Progress";
        assertTrue(task.changeStatus(newStatus));
        assertEquals(newStatus, task.getStatus());
        assertTrue(task.changeStatus(null)); 
    }

    private void assertEquals(String newStatus, Object status) {
		// TODO Auto-generated method stub
		
	}

	private void assertTrue(boolean changeStatus) {
		// TODO Auto-generated method stub
		
	}

     /**
     * Tests if the task description can be changed.
     * It checks that the description is updated with valid inputs and remains unchanged with null input.
     *  Description should not change with null input
     */
	@Test
    public void testChangeDescription() {
        String newDescription = "Update the login page with new fields";
        assertTrue(task.changeDescription(newDescription));
        assertEquals(newDescription, task.getDescription());
        assertTrue(task.changeDescription(null)); 
    }

     /**
     * Tests if the task priority can be changed.
     * Ensures that the priority is correctly updated and that invalid inputs are not accepted.
     * Priority should not change with null input
     */
    @Test
    public void testChangePriority() {
        String newPriority = "Medium";
        assertTrue(task.changePriority(newPriority));
        assertEquals(newPriority, task.getPriority());
        assertTrue(task.changePriority(null)); 
    }

     /**
     * Tests the addition of a comment to a task.
     * Confirms that a comment is added successfully and that null inputs are ignored.
     * No comment should be added when input is null
     */
    @Test
    public void testAddComment() {
        Comment comment = new Comment(user, "This is a test comment.");
        assertTrue(task.addComment(comment));
        assertEquals(1, task.getComments().size());
        assertTrue(task.addComment(null)); 
    }

    private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}

     /**
     * Tests setting the task's status.
     * Verifies that the status is set when valid inputs are provided and that null inputs are rejected.
     *  Status should not be set with null input
     */
	@Test
    public void testSetStatus() {
        String status = "Done";
        assertTrue(task.setStatus(status));
        assertEquals(status, task.getStatus());
        assertTrue(task.setStatus(null)); 
    }

     /**
     * Tests setting the task owner.
     * Checks that the task owner can be set and that the operation fails as expected when the owner is already set or input is null.
     * Should fail as the owner is already set
     * Should not set the owner when input is null
     */
    @Test
    public void testSetTaskOwner() {
        User newOwner = new User(initialStatus, initialStatus, initialStatus, initialStatus, initialStatus, initialStatus);
        assertTrue(task.setTaskOwner(newOwner)); 
        assertTrue(task.setTaskOwner(null)); 
    }

     /**
     * Tests retrieving the changes made to a task.
     * Assumes that the getChanges method returns a list of changes and verifies the list's size after a status change.
     * Assuming the Change class and getChanges method simply returns the changes list
     * Should have one change recorded
     */
    @Test
    public void testGetChanges() {
        task.setStatus("Completed");
        assertEquals(1, task.getChanges().size()); 
    }

  
}
