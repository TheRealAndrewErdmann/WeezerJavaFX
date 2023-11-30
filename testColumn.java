public class testColumn {
    public static void main(String[] args) {
        //initialize variables
        String projectName = "test project name";
        String projectStatus = "test project status";

        String taskName = "test taskname";
        String taskDescription = "test task description";
        String taskPriority = "test priority (high)";

        String columnName = "test column name";
        String columnStatus = "test column status";

        Project projectNoId = new Project(projectName, projectStatus);
        Category taskCategory = Category.Feature;
        Task task = new Task(projectNoId, taskName, taskDescription, taskCategory, taskPriority);
        Column column = new Column(columnName, columnStatus);

        //testing
        System.out.println(column.addTask(task));
        //System.out.println(column.removeTask(task));
        System.out.println(column.getColumnName());
        System.out.println(column.getTasks());  //doesn't give the task name, gives memory location instead
        System.out.println(column.getStatus());
    }
}
