package net.comments.sample;

public class ProgrammingTeacher implements Teacher{

    private final String name;

    public ProgrammingTeacher(String name){
        this.name = name;
    }

    public void teach() {
        System.out.println(this.name + " is teaching students to write AT test");
    }

    public String getName() {
        return this.name;
    }
}
