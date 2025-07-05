
class FinalPayment{
    public double calculateTotal (Cart cart, ShippingService shipping, Customer customer)throws InsufficientBalanceException {
        double totalPayment = cart.getSubTotal() + shipping.calculateFees(cart.getShipabbleItems());
        if (customer.getbalance()<totalPayment){
            throw new InsufficientBalanceException("insufficient balance!");
        }
        customer.deductBalance(totalPayment);
        return totalPayment;
    }
  
}
