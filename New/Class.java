import java.util.*;
class CompanyClass {
private String name;
private List&lt;Department&gt; departments;
public CompanyClass(String name) {
this.name = name;
this.departments = new ArrayList&lt;&gt;();
}
public void addDepartment(String departmentName) {
departments.add(new Department(departmentName));
}
public String getName() {
return name;
}
}
class Department {
private String name;
private List&lt;Employee&gt; employees;
public Department(String name) {
this.name = name;
this.employees = new ArrayList&lt;&gt;();

}
public void addEmployee(String employeeName) {
employees.add(new Employee(employeeName));
}
public String getName() {
return name;
}
}
class Employee {
private String name;
public Employee(String name) {
this.name = name;
}
public String getName() {
return name;
}
}
public class Company {
public static void main(String[] args) {
CompanyClass CompanyClass = new CompanyClass(&quot;TechCorp&quot;);
CompanyClass.addDepartment(&quot;IT&quot;);
}
}
