
class Cart{
     ArrayList<Items> cartitems = new ArrayList<>();  
     ArrayList <Items> shippableItems = new ArrayList<>();
      
    public void add(Products product, int quantity){
        try{
        cartitems.add(new Items(product,quantity));
        }
        catch(QuantityException e){
            System.out.println(e.getMessage());
        }
    }
   
    public ArrayList<Items> getItems() {
    return cartitems;
}

    public double getSubTotal(){
        double subTotal = 0;
        for(Items item: cartitems){
            subTotal += item.getPrice();
        }
        return subTotal;
    }
    
    public double getTotalWeight(){
    double totalWeight=0;
    for(Items item: cartitems){
            totalWeight += item.getWeight();
        }
    return totalWeight;
    }
    
    public ArrayList<Items> getShipabbleItems(){
        for(Items item: cartitems){
            if (item.getProduct() instanceof ShippableProducts)
                shippableItems.add(item);
        }
        return shippableItems;
    }
}
