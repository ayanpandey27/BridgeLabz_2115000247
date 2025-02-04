class Employee{
    static String CompanyName = "MK";
    final int id;
    String name;
    String designation;
    static int totalEmp=0;
    
    Employee(String name, String designation, int id){
        this.name = name;
        this.designation = designation;
        this.id =id;
        totalEmp++;
    }
    
    static void displaytotalemp(){
        System.out.println("Total Employes are"+" "+totalEmp);
    }
    void displaydetails(){
        if(this instanceof Employee){
            System.out.println("The name of Comapny is"+" "+CompanyName);
            System.out.println("The Name is"+" "+name);
            System.out.println("The designation is"+" "+designation);
            System.out.println("The id is"+" "+id);
        }
    }
    public static void main(String [] args){
        Employee e1 = new Employee("Ayan","SDE",12);
        Employee e2 = new Employee("Latika","DA",13);
        e1.displaydetails();
        e2.displaydetails();
        Employee.displaytotalemp();
    }
}
