import java.util.ArrayList;
import java.util.List;
class Faculty {
String name;
Faculty(String name) {
this.name = name;
}
}
class Department {
String name;
Department(String name) {
this.name = name;
}
}

class UniversityClass {
String name;
List&lt;Department&gt; departments;
List&lt;Faculty&gt; faculties;
UniversityClass(String name) {
this.name = name;
this.departments = new ArrayList&lt;&gt;();
this.faculties = new ArrayList&lt;&gt;();
}
void addDepartment(Department dept) {
departments.add(dept);
}
void addFaculty(Faculty faculty) {
faculties.add(faculty);
}
void closeUniversityClass() {
departments.clear();
}
}
public class University {
public static void main(String[] args) {
UniversityClass UniversityClass = new UniversityClass(&quot;Tech
UniversityClass&quot;);
Department cs = new Department(&quot;Computer Science&quot;);
Department ee = new Department(&quot;Electrical Engineering&quot;);
Faculty profA = new Faculty(&quot;Dr. Ashish&quot;);
Faculty profB = new Faculty(&quot;Dr. Singh&quot;);
UniversityClass.addDepartment(cs);
UniversityClass.addDepartment(ee);
UniversityClass.addFaculty(profA);
UniversityClass.addFaculty(profB);
UniversityClass.closeUniversityClass();

System.out.println(&quot;Departments after closing UniversityClass: &quot; +
UniversityClass.departments.size());
System.out.println(&quot;Faculties still exist: &quot; +
UniversityClass.faculties.size());
}
}
