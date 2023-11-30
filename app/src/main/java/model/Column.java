import java.util.ArrayList;

public class Column {
    private String columnName;
    private Project project;
    private ArrayList<Task> tasks;
    private ArrayList<String> status;


    /**
     * Constructor for new columns
     */
    public Column(String name, String status) {
        columnName = name;
        this.tasks = new ArrayList<Task>();
        this.status = new ArrayList<String>();
        this.status.add(status);
    }

    /**
     * Adds the given task to the column
     * @param task Task to be added
     * @return boolean representing whether the addition of the task was successful
     */
    public boolean addTask(Task task) {
        if(task == null)
            return false;
        return tasks.add(task);
    }

    /**
     * Removes the given task from the column
     * @param task Task to be removed
     * @return boolean repersenting whether the removal of the task was sucessful
     */
    public boolean removeTask(Task task) {
        if(task == null)
            return false;
        return tasks.remove(task);

    }

    public String getColumnName() {
        return columnName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<String> getStatus() {
        return status;
    }
}