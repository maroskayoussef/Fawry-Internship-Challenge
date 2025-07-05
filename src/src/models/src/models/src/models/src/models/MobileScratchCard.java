
class MobileScratchCard extends Products{

    public MobileScratchCard(String name, double price, int quantity) {
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

