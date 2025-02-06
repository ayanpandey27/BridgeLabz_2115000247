import java.util.*;
class BankClass {
private String name;
private List&lt;Customer&gt; customers;
public BankClass(String name) {
this.name = name;
this.customers = new ArrayList&lt;&gt;();
}
public void openAccount(String customerName, String accountNumber,
double initialBalance) {
Customer customer = new Customer(customerName, this);
Account account = new Account(accountNumber, initialBalance, this);
customer.addAccount(account);
customers.add(customer);
}
public String getName() {
return name;
}
}
class Customer {
private String name;
private BankClass BankClass;
private List&lt;Account&gt; accounts;
public Customer(String name, BankClass BankClass) {
this.name = name;
this.BankClass = BankClass;
this.accounts = new ArrayList&lt;&gt;();
}
public void addAccount(Account account) {

accounts.add(account);
}
public double viewBalance(String accountNumber) {
for (Account account : accounts) {
if (account.getAccountNumber().equals(accountNumber)) {
return account.getBalance();
}
}
return 0.0;
}
public String getName() {
return name;
}
}
class Account {
private String accountNumber;
private double balance;
private BankClass BankClass;
public Account(String accountNumber, double balance, BankClass
BankClass) {
this.accountNumber = accountNumber;
this.balance = balance;
this.BankClass = BankClass;
}
public String getAccountNumber() {
return accountNumber;
}
public double getBalance() {
return balance;
}
}
public class Bank {
public static void main(String[] args) {
BankClass BankClass = new BankClass(&quot;BOB&quot;);
BankClass.openAccount(&quot;Ashish Singh&quot;, &quot;123456&quot;, 1000.0);
}
}
