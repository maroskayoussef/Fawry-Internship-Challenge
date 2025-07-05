
class Receipt{
    public void calculateinvoice(Customer customer, Cart cart, double shippingFees, double totalPrice){
        System.out.println("**Checkout Receipt**");
        for (Items item :cart.getItems()) {
            System.out.println(item.getQuantity() + " x " + item.getProduct().getName() +"= " + item.getPrice());
        }
         System.out.println("Subtotal: "+ cart.getSubTotal());
        System.out.println("Shipping: "+ shippingFees);
        System.out.println("Amount: "+ totalPrice);
        System.out.println("Balance:"+ customer.getbalance());
}
}
