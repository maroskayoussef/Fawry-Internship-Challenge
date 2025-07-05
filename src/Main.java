import java.time.LocalDate;
import java.util.ArrayList;

public class ECommerceSystem {

    public static void main(String[] args) {
        Customer customer = new Customer("Maroska", 5000);

        Cheese cheese = new Cheese("Cheddar Cheese", 100, 5, 0.2, LocalDate.now().plusDays(5));
        TV tv = new TV("Samsung TV", 200, 3, 5.0);
        Biscuits biscuits = new Biscuits("Digestive Biscuits", 150, 10, LocalDate.now().plusDays(2));
        MobileScratchCard card = new MobileScratchCard("Orange Card", 50, 20);
        Mobile iPhone = new Mobile("iPhone13", 500, 3);

        // 3. Add items to the cart
        Cart cart = new Cart();
        cart.add(cheese, 2);       // 2 x 100 = 200
        cart.add(tv, 1);           // 1 x 200 = 200
        cart.add(biscuits, 1);     // 1 x 150 = 150
        cart.add(card, 1);         // 1 x 50 = 50
        cart.add(iPhone, 1);
        Cartchecker checker = new Cartchecker();
        try {
            checker.checkCart(cart);
        } catch (EmptyCartException | ExpiryException e) {
            System.out.println("Checkout error:" + e.getMessage());
            return;
        }

        ShippingService shipping = new ShippingService();
        shipping.printShipmentNotice(cart.getShipabbleItems());

        FinalPayment payment = new FinalPayment();
        double totalAmount = 0;
        try {
            totalAmount = payment.calculateTotal(cart, shipping, customer);
        } catch (InsufficientBalanceException e) {
            System.out.println("Payment error:" + e.getMessage());
            return;
        }

        Receipt receipt = new Receipt();
        double shippingFees = shipping.calculateFees(cart.getShipabbleItems());
        receipt.calculateinvoice(customer, cart, shippingFees, totalAmount);
    }
    }
