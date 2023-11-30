package model;
/**
 * Represents a change or modification made by a user.
 * @author yingdongfeng
 */
public class Change {
    /** Description of the change. */
    private String changeDescription;
    
    /** Author of the change. */
    private User changeAuthor;  

    /**
     * Constructs a new Change object with the specified description and author.
     *
     * @param description Description of the change.
     * @param author Author who made the change.
     */
    public Change(String description, User author) {
        this.changeDescription = description;
        this.changeAuthor = author; 
    }

    /**
     * Retrieves the description of the change.
     *
     * @return A string representing the description of the change.
     */
    public String getChangeDescrption() {
        return changeDescription;
    }

    /**
     * Retrieves the full name of the author of the change.
     *
     * @return A string representing the first name and last name of the change author.
     */
    public String getChangeAuthor() {
        return changeAuthor.getFirstName() + " " + changeAuthor.getLastName();
    }
}
