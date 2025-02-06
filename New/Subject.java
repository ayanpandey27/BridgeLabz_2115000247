import java.util.*;
class SchoolClass {
private String name;
private List&lt;Student&gt; students;
publicSchoolClass(String name) {
this.name = name;
this.students = new ArrayList&lt;&gt;();
}
public void addStudent(Student student) {
students.add(student);
}
}
class Student {
private String name;
private List&lt;Course&gt; courses;
public Student(String name) {
this.name = name;
this.courses = new ArrayList&lt;&gt;();
}
public void enroll(Course course) {
if (!courses.contains(course)) {
courses.add(course);
course.addStudent(this);
}
}
public List&lt;Course&gt; getCourses() {
return courses;
}

}
class Course {
private String title;
private List&lt;Student&gt; students;
public Course(String title) {
this.title = title;
this.students = new ArrayList&lt;&gt;();
}
public void addStudent(Student student) {
if (!students.contains(student)) {
students.add(student);
}
}
public List&lt;Student&gt; getStudents() {
return students;
}
}
public class School {
public static void main(String[] args) {
SchoolClassSchoolClass = newSchoolClass(&quot;ABC HighSchoolClass&quot;);
Student student1 = new Student(&quot;Ashish&quot;);
Student student2 = new Student(&quot;Prashant&quot;);
Course math = new Course(&quot;Mathematics&quot;);
Course science = new Course(&quot;Science&quot;);
student1.enroll(math);
student1.enroll(science);
student2.enroll(math);
SchoolClass.addStudent(student1);
SchoolClass.addStudent(student2);
System.out.println(&quot;Ashish&#39;s Courses: &quot;);
for (Course course : student1.getCourses()) {
System.out.println(course.title);

}
System.out.println(&quot;Mathematics Enrolled Students: &quot;);
for (Student student : math.getStudents()) {
System.out.println(student.name);
}
}
}
