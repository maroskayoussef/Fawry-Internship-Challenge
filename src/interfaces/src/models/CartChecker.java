
class Cartchecker{
    public void checkCart (Cart cart)throws EmptyCartException, ExpiryException{
        if (cart.cartitems.isEmpty()){
            throw new EmptyCartException("can't checkout due to empty card!");
        }
        for(Items item: cart.cartitems){
            if (item.getProduct() instanceof ExpirableProducts){
                ExpirableProducts expirable = (ExpirableProducts) item.getProduct();
                if (expirable.isExpired()){
                    throw new ExpiryException(item.getProduct().getName() + " is expired");
                }
        }
    }   
}
}
