class Course {
    protected String courseName;
    protected int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%");
    }
}

public class EducationalCourseSystem {
    public static void main(String[] args) {
        Course course1 = new Course("Java Basics", 6);
        OnlineCourse course2 = new OnlineCourse("Python for Beginners", 8, "Udemy", true);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Advanced AI", 12, "Coursera", true, 199.99, 20);
        
        course1.displayDetails();
        System.out.println();
        course2.displayDetails();
        System.out.println();
        course3.displayDetails();
    }
}
