package com.example.s.actuacombatproject.tool;

/**
 * Created by s on 17-6-23.
 */

public class Question {
    private String title, a, b, c, d, answer, type, description, image;

    public Question(String title, String a, String b, String c, String d, String answer, String type, String description, String image) {
        this.title = title;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getAnswer() {
        return answer;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
