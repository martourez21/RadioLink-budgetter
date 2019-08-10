package sample.model;

public class ProjectModel {
    public static String name;
    public static String gen;
    public static String id;

    public String getGen() {
        return gen;
    }

    public ProjectModel(String name, String gen) {
        this.name = name;
        this.gen = gen;
    }

    public  ProjectModel() {
    }

    public ProjectModel(String name, String gen, String id) {
        this.name = name;
        this.gen = gen;
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setProject(ProjectModel project) {
        this.name = project.getName();
        this.gen = project.getGen();
        this.id = project.getId();
    }

    public ProjectModel getProject(){
        return this;
    }
}
