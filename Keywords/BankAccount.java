class BankAccount{
    static String Bankname = "XYZ";
    static int totalAc=0;
    String AccName;
    double AccBalance;
    final int AccNumber;
    
    BankAccount(String AccName,double AccBalance,int AccNumber){
        this.AccName = AccName;
        this.AccBalance = AccBalance;
        this.AccNumber = AccNumber;
        totalAc++;
    }
    
    static void getTotalAccounts(){
        System.out.println("The total Accounts are"+ "" +totalAc);
        
    }
    void DisplayDetails(){
        if(this instanceof BankAccount){
            System.out.println("Account Holder name"+AccName);
            System.out.println("Account Holder Balance"+AccBalance);
            System.out.println("Account Holder Bank"+Bankname);
            System.out.println("Account Holder Number"+AccNumber);
            
        }
    }
    public static void main(String [] args){
        BankAccount acc1 = new BankAccount("Ayan",5000,123);
        BankAccount acc2 = new BankAccount("Ayush",50000,124);
        acc1.DisplayDetails();
        acc2.DisplayDetails();
        BankAccount.getTotalAccounts();
    }
}
