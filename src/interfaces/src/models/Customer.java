
class Customer{
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    public double getbalance(){
        return balance;
    }
    
    public void deductBalance(double totalAmount){
        balance-=totalAmount;
    }
}
