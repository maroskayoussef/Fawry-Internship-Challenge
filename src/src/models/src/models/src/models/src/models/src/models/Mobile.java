
class Mobile extends Products{

    public Mobile(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
} 
