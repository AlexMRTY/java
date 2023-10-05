package model;

import model.exeptions.TitleNotUniqueException;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projectList;

    /**
     * Constructor for ProjectsManager
     */
    public ProjectsManager() {
        projectList = new ArrayList<>();
    }

    /**
     * Takes in a list of projects and sets the projectList to that list.
     * @param incomingProjects - list of projects to be set
     */
    public void setProjects(List<Project> incomingProjects) {
        projectList.clear();
        for (Project project : incomingProjects) {
            addProject(project.getTitle(), project.getDescription());
        }
    }

    /**
     * checks if the title is unique
     * @param title - title to be checked
     * @return true if title is unique, false if not
     */
    public boolean isTitleUnique(String title) {
        for (Project project : projectList) {
            if (project.getTitle().equals(title)) return false;
        };
        return true;
    }

    /**
     * Adds a project to the projectList
     * @param title - title of the project to be added
     * @param descr - description of the project to be added
     * @return the project that was added
     */
    public Project addProject(String title, String descr) {
        if (!isTitleUnique(title)) throw new TitleNotUniqueException();

        Project newProject = new Project(title, descr, nextProjectId);
        projectList.add(newProject);
        nextProjectId++;
        return newProject;
    }

    /**
     * Removes a project from the projectList
     * @param project - project to be removed
     */
    public void removeProject(Project project) {
        projectList.remove(project);
    }

    /**
     * Returns a project with the given id
     * @param id - id of the project to be returned
     * @return the project with the given id
     */
    public Project getProjectById(int id) {
        Project copy;
        for (Project project : projectList) {
            if (project.getProjectId() == id) {
                copy = new Project(project.getTitle(), project.getDescription(), id);
                return copy;
            }
        }
        return null; // Project does not exist
    }

    /**
     * Returns a list of projects with the given title
     * @param titleStr - title to be searched for
     * @return list of projects with the given title
     */
    public List<Project> findProjects(String titleStr) {
        ArrayList<Project> result = new ArrayList<>();
        for (Project project : projectList) {
            if (project.getTitle().contains(titleStr)){
                result.add(project);
            }
        }
        return result;
    }

    /**
     * @return the highest id of all projects
     */
    private int getHighestId() {
        int highestId = 0;
        for (Project project : projectList) {
            if (project.getProjectId() > highestId) {
                highestId = project.getProjectId();
            }
        }
        return highestId;
    }

    public ArrayList<Project> getProjects() {
        return new ArrayList<>(this.projectList);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Project project: projectList) {
            str.append(project).append("\n");
        }
        return str.toString();
    }

//    public static void main(String[] args) {
//        ProjectsManager manager = new ProjectsManager();
//
//        manager.addProject("Blyat", "Suka");
//        manager.addProject("Suka", "Blyat");
//        Project projectToFuckUp = manager.getProjectById(1);
//        manager.removeProject(projectToFuckUp);
//
//        manager.getProjects().forEach(project -> {
//            System.out.println(project.toString());
//        });
//
//
//    }

}
