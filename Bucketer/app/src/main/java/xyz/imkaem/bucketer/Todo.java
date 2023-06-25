package xyz.imkaem.bucketer;

import androidx.annotation.DrawableRes;

public class Todo {
    String name;
    String description;
    String type;
    int image;

    public Todo(String name, String description, String type, @DrawableRes int image) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.image = image;
    }
}
