
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

public class Project {

    private UUID id;
    private String title;
    private String description;
    private Map<String,ArrayList<User>> participants;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    
    public Project(String title, String description){
        this.title = title;
        this.description = description;
        this.participants = new HashMap<String, ArrayList<User>>();
        this.columns = new ArrayList<Column>();
        this.comments = new ArrayList<Comment>();
    }

    public Project(UUID id, String title, String description) {
        this(title, description);
        this.id = id;
    }

    public Project(UUID id, String title, String description, Map<String, ArrayList<User>> participants, ArrayList<Column> columns, ArrayList<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.participants = participants;
        this.columns = columns;
        this.comments = comments;
    }


    public boolean addParticipant(User user, String role) {
        if(user == null || role == null)
            return false;
        if(participants.get(role) == null)
            participants.put(role, new ArrayList<User>());
        participants.get(role).add(user);
        return true;
    }
    

    public boolean removeParticipant(User user, Role role) {
        if(user == null || role == null)
            return false;
        return participants.get(role).remove(user);
    }

    
    public boolean changeRole(User user, Role curRole, Role newRole) {
        if(user == null || curRole == null || newRole == null)
            return false;
        if(participants.get(curRole).remove(user) == false)
            return false;
        return participants.get(newRole).add(user);
    }
    

    public boolean addTask(Task task, String status) {
        if(task == null || status == null)
            return false;
        for(Column column : columns) {
            if(column.getColumnName().equals(status)){
                column.addTask(task);
                task.setStatus(status);
                return true;
            }
        }
        return false;
    }

    public boolean changeTaskStatus(Task task, String curStatus, String newStatus) {
        if(task == null || curStatus == null || newStatus == null)
            return false;
        for(Column column : columns) {
            if(column.getColumnName().equals(curStatus)) {
                column.removeTask(task);
            }
        }
        task.changeStatus(newStatus);
        return addTask(task, newStatus);
    }

    public boolean addComment(Comment comment) {
        if(comment == null)
            return false;
        return comments.add(comment);
    }

    public boolean addColumn(Column column) {
        if(column == null)
            return false;
        return columns.add(column);
    }

    public void print() {
	    try {
		    FileWriter newFile = new FileWriter("scrum.txt");
			newFile.write(title + " - "+description+"\n\n");
            newFile.write("Role\t\tParticpants\n\n");

            for(String role : participants.keySet()) {
                newFile.write(role+"\t\t");

                for(User user : participants.get(role)) {
                    newFile.write(user.getFirstName()+" "+user.getLastName()+"  ");
                }
                newFile.write("\n");
            }

            newFile.write("\nColumns\t\tTasks\n\n");

            for(Column column : columns) {
                newFile.write(column.getColumnName()+"\t\t");

                for(Task task : column.getTasks()) {
                    newFile.write(task.getTaskName()+" - ");
                    for(Comment comment : task.getComments()) {
                        newFile.write(comment.getComment()+" posted by "+comment.getAuthor()+"\n");
                    }
                }
                newFile.write("\n");
            }

            newFile.write("\nComments\n\n");
            for(Comment comment : comments) {
                newFile.write(comment.getComment()+" posted by "+comment.getAuthor()+"\n");
            }

			newFile.close();
				
		} catch (IOException e) {
			System.out.println("Error creating file");
			return;
		}	
	}

    public UUID getID() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Map<String, ArrayList<User>> getParticipants() {
        return participants;
    }
    public ArrayList<Column> getColumns() {
        return columns;
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
