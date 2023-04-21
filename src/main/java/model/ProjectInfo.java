package model;

public class ProjectInfo {
    public final int index;
    public final String name;
    public final String projectManager;
    public ProjectInfo(int index, String name, String projectManager) {
        this.index = index;
        this.name = name;
        this.projectManager = projectManager;
    }
}
