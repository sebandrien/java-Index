import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int ID;

    public Person(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + ID;
    }
}

class Course {
    private String courseName;
    private String courseCode;
    private Professor professor;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return courseCode + ": " + courseName + " (Taught by: " + 
               (professor != null ? professor.getName() : "No professor assigned") + ")";
    }
}

class Student extends Person {
    private String major;
    private String year;
    private List<Course> courses = new ArrayList<>();

    public Student(String name, int ID, String major, String year) {
        super(name, ID);
        this.major = major;
        this.year = year;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayEnrolledCourses() {
        System.out.println(getName() + "'s Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Major: " + major + ", Year: " + year;
    }
}

class Professor extends Person {
    private String department;
    private int publications;
    private List<Course> courses = new ArrayList<>();

    public Professor(String name, int ID, String department, int publications) {
        super(name, ID);
        this.department = department;
        this.publications = publications;
    }

    public void assignCourse(Course course) {
        courses.add(course);
        course.setProfessor(this);
    }

    public void displayCourses() {
        System.out.println(getName() + "'s Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department + ", Publications: " + publications;
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Student alice = new Student("Alice", 123456, "Computer Science", "Sophomore");
        Professor drSmith = new Professor("Dr. Smith", 654321, "Engineering", 10);

        Course cs101 = new Course("Introduction to Programming", "CS101");
        Course eng201 = new Course("Advanced Thermodynamics", "ENG201");

        drSmith.assignCourse(cs101);
        drSmith.assignCourse(eng201);

        alice.enrollInCourse(cs101);

        System.out.println(alice);
        alice.displayEnrolledCourses();
        System.out.println();

        System.out.println(drSmith);
        drSmith.displayCourses();
    }
}
