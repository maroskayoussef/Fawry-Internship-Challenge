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
![Main](Screenshot%20(169).png)


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
![Main](Screenshot%20(170).png)



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
![Main](Screenshot%20(171).png)


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
![Main](Screenshot%20(172).png)



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
![Main](Screenshot%20(173).png)
