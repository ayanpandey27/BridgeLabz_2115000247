import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " - " + courseType.getName();
    }
}

class CourseManagement {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public List<Course<? extends CourseType>> getCourses() {
        return courses;
    }

    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType course : courseTypes) {
            System.out.println(course.getName());
        }
    }
}

class University {
    public static void main(String[] args) {
        CourseManagement management = new CourseManagement();
        
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> history = new Course<>("History", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Physics Research", new ResearchCourse());

        management.addCourse(math);
        management.addCourse(history);
        management.addCourse(physics);

        System.out.println("Available Courses:");
        for (Course<? extends CourseType> course : management.getCourses()) {
            System.out.println(course);
        }
    }
}

