class Cheese extends Products implements ExpirableProducts, ShippableProducts{
    double weight;
    LocalDate expiryDate;
    
    public Cheese(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
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
    
    
    @Override
    public boolean isExpired(){
        return expiryDate.isBefore(LocalDate.now());
    }
    
    public boolean shippable(){
        return true;
    }
    
    @Override
    public double getWeight(){
        return weight;
    }
}

    
