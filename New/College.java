import java.util.ArrayList;
class University {
ArrayList&lt;Student&gt; students;
ArrayList&lt;Professor&gt; professors;
ArrayList&lt;Course&gt; courses;
public University() {
students = new ArrayList&lt;&gt;();
professors = new ArrayList&lt;&gt;();
courses = new ArrayList&lt;&gt;();
}
public void addStudent(Student student) {
students.add(student);
}
public void addProfessor(Professor professor) {
professors.add(professor);
}
public void addCourse(Course course) {
courses.add(course);
}
}

class Student {
String name;
ArrayList&lt;Course&gt; courses;
public Student(String name) {
this.name = name;
courses = new ArrayList&lt;&gt;();
}
public void enrollCourse(Course course) {
System.out.println(name + &quot; has enrolled in &quot; +
course.getCourseName());
courses.add(course);
course.addStudent(this);
}
}
class Professor {
String name;
ArrayList&lt;Course&gt; courses;
public Professor(String name) {
this.name = name;
courses = new ArrayList&lt;&gt;();
}
public void assignProfessor(Course course) {
System.out.println(name + &quot; is teaching &quot; +
course.getCourseName());
courses.add(course);
course.setProfessor(this);
}
}
class Course {
String courseName;
Professor professor;
ArrayList&lt;Student&gt; students;
public Course(String courseName) {
this.courseName = courseName;

students = new ArrayList&lt;&gt;();
}
public String getCourseName() {
return courseName;
}
public void setProfessor(Professor professor) {
this.professor = professor;
}
public void addStudent(Student student) {
students.add(student);
}
}
public class UniversityManagement {
public static void main(String[] args) {
University university = new University();
Student student1 = new Student(&quot;Prashant&quot;);
Student student2 = new Student(&quot;Rasali&quot;);
Professor professor1 = new Professor(&quot;Dr. Ashish&quot;);
Professor professor2 = new Professor(&quot;Dr. Singh&quot;);
Course course1 = new Course(&quot;Computer Science 101&quot;);
Course course2 = new Course(&quot;Mathematics 101&quot;);
university.addStudent(student1);
university.addStudent(student2);
university.addProfessor(professor1);
university.addProfessor(professor2);
university.addCourse(course1);
university.addCourse(course2);
student1.enrollCourse(course1);
student2.enrollCourse(course2);
professor1.assignProfessor(course1);

professor2.assignProfessor(course2);
}
}
