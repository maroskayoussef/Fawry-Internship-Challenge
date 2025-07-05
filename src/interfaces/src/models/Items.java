class Items {
    Products product;
    int quantity;

    public Items(Products product, int quantity)throws QuantityException {
        if (quantity>product.getQuantity()){
                    throw new QuantityException(product.getName()+" quantity is not available at stock!");      
        }
            this.product = product;
            this.quantity = quantity;
        
    }
    
    public Products getProduct(){
        return product;
    }
    
    public int getQuantity(){
        return  quantity;
    }
    
    public double getPrice(){
        return product.getPrice()*quantity;
    }
    
    public double getWeight(){ //gets the total weight of the product with its ordered amount 
        if (product instanceof ShippableProducts){
        ShippableProducts shippable = (ShippableProducts)product;
         return shippable.getWeight()* quantity;    
        }
        return 0;
    }
}
