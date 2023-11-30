
import java.util.ArrayList;

public class ProjectList {

    private static ProjectList projectList = null;
    private ArrayList<Project> projects;
    
    private ProjectList() {
        projects = FileLoader.getProjects();
    }

    public static ProjectList getInstance(){
        if (projectList == null){
            projectList = new ProjectList();
        }
        return projectList;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public Project getProject(String title){
       for(Project project : projects) {
            if(project.getTitle().equals(title))
                return project;
       }
       return null;
    }
    
}

