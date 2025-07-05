class Biscuits extends Products implements ExpirableProducts{
    LocalDate expiryDate;
    
    public Biscuits(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
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
}
