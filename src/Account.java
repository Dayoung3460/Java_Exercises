package src;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    public void depositFunds(double depositAmount) {
        balance += depositAmount;
        System.out.println(depositAmount + " " + balance);
    }

//    same as class name. no return value.
    public Account() {
        this("5677", 2.50, "default name", "default phone", "default email");
        System.out.println("empty constructor called");
    }
    public Account(String number, double balance, String customerName, String phone, String email) {
        System.out.println("Account constructor with params called");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        customerEmail = email;
        customerPhone = phone;
    }
    public void withdrawFunds(double withdrawalAmount) {
        if(balance - withdrawalAmount < 0) {
            System.out.println("insufficient Funds. balance: " + balance);
        } else {
            balance -= withdrawalAmount;
            System.out.println("success" + withdrawalAmount + " " + balance);
        }
    }
    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getGetCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setGetCustomerEmail(String getCustomerEmail) {
        this.customerEmail = getCustomerEmail;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
