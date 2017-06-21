package com.example.s.actuacombatproject.base;

/**
 * Created by s on 17-6-21.
 */

public class Questions {
    private String title,a,b,c,d,answer,type;

    public Questions(String title, String a, String b, String c, String d, String answer, String type) {
        this.title = title;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
        this.type = type;
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
}
