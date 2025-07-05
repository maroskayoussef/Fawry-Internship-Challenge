-Example 1(successful):
java:
 Customer customer = new Customer("Maroska", 5000);

        Cheese cheese = new Cheese("Cheddar Cheese", 100, 5, 0.2, LocalDate.now().plusDays(5));
        TV tv = new TV("Samsung TV", 200, 3, 5.0);
        Biscuits biscuits = new Biscuits("Digestive Biscuits", 150, 10, LocalDate.now().plusDays(2));
        MobileScratchCard card = new MobileScratchCard("Orange Card", 50, 20);
        Mobile iPhone = new Mobile("iPhone13", 500, 3);

        Cart cart = new Cart();
        cart.add(cheese, 2);      
        cart.add(tv, 1);          
        cart.add(card, 1);         
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

   Console Output:
**Shipping Notice**
2x Cheddar Cheese     0.4kg
1x Samsung TV     5.0kg
Total package weight: 5.4kg

**Checkout Receipt**
2 x Cheddar Cheese = 200.0
1 x Samsung TV = 200.0
1 x Digestive Biscuits = 150.0
1 x Orange Card = 50.0
1 x iPhone13 = 500.0
Subtotal: 1100.0
Shipping: 270.0
Amount: 1370.0
Balance: 3630.0


-Example 2:(TVs are out of stock)
java:
Customer customer = new Customer("Maroska", 5000);

        Cheese cheese = new Cheese("Cheddar Cheese", 100, 5, 0.2, LocalDate.now().plusDays(5));
        TV tv = new TV("Samsung TV", 200, 0, 5.0);
        Biscuits biscuits = new Biscuits("Digestive Biscuits", 150, 10, LocalDate.now().plusDays(2));
        MobileScratchCard card = new MobileScratchCard("Orange Card", 50, 20);
        Mobile iPhone = new Mobile("iPhone13", 500, 3);

        Cart cart = new Cart();
        cart.add(cheese, 2);       
        cart.add(tv, 4);           
        cart.add(biscuits, 1);    
        cart.add(card, 1);        
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
        
console output:
Samsung TV quantity is not available at stock!
 **Shipping Notice**
2x Cheddar Cheese     0.4kg
total package weight:0.4
**Checkout Receipt**
2 x Cheddar Cheese= 200.0
1 x Digestive Biscuits= 150.0
1 x Orange Card= 50.0
1 x iPhone13= 500.0
Subtotal: 900.0
Shipping: 20.0
Amount: 920.0
Balance:4080.0


-Example 3:(empty card)
java:
 Customer customer = new Customer("Maroska", 5000);

        Cheese cheese = new Cheese("Cheddar Cheese", 100, 5, 0.2, LocalDate.now().plusDays(5));
        TV tv = new TV("Samsung TV", 200, 0, 5.0);
        Biscuits biscuits = new Biscuits("Digestive Biscuits", 150, 10, LocalDate.now().plusDays(2));
        MobileScratchCard card = new MobileScratchCard("Orange Card", 50, 20);
        Mobile iPhone = new Mobile("iPhone13", 500, 3);

        Cart cart = new Cart();
 
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
        
    console output:
    Checkout error:can't checkout due to empty card!


   - Example 4(Insufficient Balance Exception):
     
    java:
     Customer customer = new Customer("Maroska", 5);

        Cheese cheese = new Cheese("Cheddar Cheese", 100, 5, 0.2, LocalDate.now().plusDays(5));
        TV tv = new TV("Samsung TV", 200, 3, 5.0);
        Biscuits biscuits = new Biscuits("Digestive Biscuits", 150, 10, LocalDate.now().plusDays(2));
        MobileScratchCard card = new MobileScratchCard("Orange Card", 50, 20);
        Mobile iPhone = new Mobile("iPhone13", 500, 3);

        Cart cart = new Cart();
        cart.add(cheese, 2);       
        cart.add(tv, 1);           
        cart.add(biscuits, 1);    
        cart.add(card, 1);        
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

    console output:
     **Shipping Notice**
2x Cheddar Cheese     0.4kg
1x Samsung TV     5.0kg
total package weight:5.4
Payment error:insufficient balance!


-Example 5(expired product):

java:
Customer customer = new Customer("Maroska", 5000);

        Cheese cheese = new Cheese("Cheddar Cheese", 100, 5, 0.2, LocalDate.now().minusDays(2));
        TV tv = new TV("Samsung TV", 200, 3, 5.0);
        Biscuits biscuits = new Biscuits("Digestive Biscuits", 150, 10, LocalDate.now().plusDays(2));
        MobileScratchCard card = new MobileScratchCard("Orange Card", 50, 20);
        Mobile iPhone = new Mobile("iPhone13", 500, 3);

        Cart cart = new Cart();
        cart.add(cheese, 2);       
        cart.add(tv, 1);           
        cart.add(biscuits, 1);    
        cart.add(card, 1);        
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

      console output:
      Checkout error:Cheddar Cheese is expired.
