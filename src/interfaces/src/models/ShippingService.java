class ShippingService{
     static final double shippingFeePerKG= 50;
    
    public void printShipmentNotice(ArrayList<Items>shippableItems){ //prints the shipment notice after calculating each item's weight
        System.out.println(" **Shipping Notice**");
        double packageWeight = 0;
        for(Items item: shippableItems ){
            System.out.println(item.getQuantity()+"x"+" "+item.getProduct().getName()+"     "+ item.getWeight()+"kg");
            packageWeight+=item.getWeight();
        }
        System.out.println("total package weight:"+packageWeight);
    }
    
    public double calculateFees(ArrayList<Items>shippableItems){ // returns the total of calculated shipping feesfees 
        double totalWeight=0;
        for(Items item: shippableItems ){
        totalWeight+=item.getWeight();
        }
        return totalWeight* shippingFeePerKG;
    }
   
}
