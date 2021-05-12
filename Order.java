
import java.io.PrintWriter;



/**
 *
 * @author User
 */
public class Order {

    private int orderID;
    private String customerName;
    private String customerID;
    private String orderTime;
    private String[] orderItems;
    private String[] quantIties;
    private String pickupTime;
    private Order next;
    
    // CONSTRUCTORS
    
    public Order(int orderID1, String customerID1, String customerName1, String orderTime1, String pickupTime1, String[] orderItems1, String[] quantIties1) {
        this.orderID = 0;
        this.customerName = null;
        this.customerID = null;
        this.orderTime = null;
        this.orderItems = null;
        this.quantIties = null;
        this.pickupTime = null;
        this.next = null;
    }

    public Order(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
        this.quantIties = quantIties;
        this.pickupTime = pickupTime;
        this.next = null;
    }

    public Order(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime, Order next) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
        this.quantIties = quantIties;
        this.pickupTime = pickupTime;
        this.next = next;
    }
    
    Order(Order temp) {
       temp = this.next;
    }

    Order(Order temp, Order top) {
       this.next = temp;
       
    }

     // ACCESSORS and MUTATORS
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String[] orderItems) {
        this.orderItems = orderItems;
    }

    public String[] getQuantIties() {
        return quantIties;
    }

    public void setQuantIties(String[] quantIties) {
        this.quantIties = quantIties;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Order getNext() {
        return next;
    }

    public void setNext(Order next) {
        this.next = next;
    }

    public void toString(PrintWriter write) {
        String add = "";
        for (int i = 0; i < this.getOrderItems().length; i++) {
            add += this.getOrderItems()[i]+",";
        }
        String add1 = "";
        for (int i = 0; i < this.getQuantIties().length; i++) {
            add1 += this.getQuantIties()[i]+",";
        }
        System.out.println("customer ID: " + customerID + "\n"
                + "customer name: " + customerName + "\n"
                + "order time: " + orderTime + "\n"
                + "pickup time: " + pickupTime + "\n"
                + "order items: " + add + "\n"
                + "quantality: " + add1+ "\n");
        write.println("customer ID: " + customerID + "\n"
                + "customer name: " + customerName + "\n"
                + "order time: " + orderTime + "\n"
                + "pickup time: " + pickupTime + "\n"
                + "order items: " + add + "\n"
                + "quantality: " + add1+ "\n");
    }

}
