// Base class
class Order {
    protected int orderId;
    protected double baseAmount;
    static double deliveryCharge = 40; // Static variable

    public Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    // Polymorphic method
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

// Subclass for regular orders (no discount)
class RegularOrder extends Order {
    public RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

// Subclass for premium orders (20% discount)
class PremiumOrder extends Order {
    public PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        double discount = baseAmount * 0.20;
        return (baseAmount - discount) + deliveryCharge;
    }
}

// Main class to test orders
public class FoodDeliveryApp {
    public static void main(String[] args) {
        Order[] orders = new Order[4];
        orders[0] = new RegularOrder(101, 200);
        orders[1] = new PremiumOrder(102, 500);
        orders[2] = new RegularOrder(103, 150);
        orders[3] = new PremiumOrder(104, 800);

        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Total Bill: " + order.calculateBill());
        }
    }
}