import java.util.ArrayList;
class HospitalClass {
ArrayList&lt;Doctor&gt; doctors;
ArrayList&lt;Patient&gt; patients;
public HospitalClass() {
doctors = new ArrayList&lt;&gt;();
patients = new ArrayList&lt;&gt;();
}
public void addDoctor(Doctor doctor) {
doctors.add(doctor);
}
public void addPatient(Patient patient) {
patients.add(patient);

}
}
class Doctor {
String name;
ArrayList&lt;Patient&gt; patients;
public Doctor(String name) {
this.name = name;
patients = new ArrayList&lt;&gt;();
}
public void consult(Patient patient) {
System.out.println(name + &quot; is consulting with &quot; +
patient.getName());
patients.add(patient);
}
}
class Patient {
String name;
ArrayList&lt;Doctor&gt; doctors;
public Patient(String name) {
this.name = name;
doctors = new ArrayList&lt;&gt;();
}
public String getName() {
return name;
}
public void consult(Doctor doctor) {
System.out.println(name + &quot; is consulting with &quot; + doctor.name);
doctors.add(doctor);
}
}
public class Hospital {
public static void main(String[] args) {
HospitalClass HospitalClass = new HospitalClass();

Doctor doctor1 = new Doctor(&quot;Dr. Ashish&quot;);
Doctor doctor2 = new Doctor(&quot;Dr. Singh&quot;);
Patient patient1 = new Patient(&quot;Ayan&quot;);
Patient patient2 = new Patient(&quot;Dhairya&quot;);
HospitalClass.addDoctor(doctor1);
HospitalClass.addDoctor(doctor2);
HospitalClass.addPatient(patient1);
HospitalClass.addPatient(patient2);
doctor1.consult(patient1);
doctor2.consult(patient1);
doctor1.consult(patient2);
patient1.consult(doctor1);
patient2.consult(doctor2);
}
}
