package xyz.imkaem.kaemslog;

public class Project {
    String name;
    String description;
    // this is from R.drawable.file_name - Java converts resources to integers
    int image;

    public Project(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
