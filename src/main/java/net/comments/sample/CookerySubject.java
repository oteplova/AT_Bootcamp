package net.comments.sample;

/**
 * Class represents the technical subjects.
 */
public class CookerySubject implements Subject {
    private final String subjectName = "bake a cake";

    /**
     * Returns subject's name
     */
    public String getSubjectName() {
        return this.subjectName;
    }

    public void readBy(Teacher someTeacher) {
        System.out.println("Teacher " + someTeacher.getName() + " tells about:");
        System.out.println("1. how to select the ingredients;");
        System.out.println("2. what ingredients should be taken;");
        System.out.println("3. how to knead the dough;");
        System.out.println("4. how to bake shortcakes;");
        System.out.println("5. how to prepare the cream;");
        System.out.println("6. how to decorate the cake;");
    }

    public void learnBy(Student someStudent) {
        System.out.println("Student " + someStudent.getName() + " will learn about:");
        System.out.println("1. how to select the ingredients;");
        System.out.println("2. what ingredients should be taken;");
        System.out.println("3. how to knead the dough;");
        System.out.println("4. how to bake shortcakes;");
        System.out.println("5. how to prepare the cream;");
        System.out.println("6. how to decorate the cake;");
    }
}
