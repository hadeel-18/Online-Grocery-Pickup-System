
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author User
 */
public class OnlineOrderMenu {

    /**
     * @param args the command line arguments
     */
    public static void printmenu(PrintWriter write) {
        System.out.println("1. Add a new order\n"
                + "2. Lookup the first order\n"
                + "3. Fulfill order\n"
                + "4. Restock orders\n"
                + "5. Print orders\n"
                + "6. Exit.");
        write.println("1. Add a new order\r\n"
                + "2. Lookup the first order\r\n"
                + "3. Fulfill order\r\n"
                + "4. Restock orders\r\n"
                + "5. Print orders\r\n"
                + "6. Exit.");
    }
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        // Create a file
        File output = new File("output.txt");
        // Create a Print Writer for the file
        PrintWriter write = new PrintWriter(output);
        //ٍMake Scanner 
        Scanner input = new Scanner(System.in);
        // Other variables
        int choice = 0;
        int choice1 = 0;
        int count = 0;
        int orderId = 0;
        Order temp = null;
        Order temp1 = null;
        NumberFormat numberFormatter = new DecimalFormat("##.000");
        String result = numberFormatter.format(orderId);
        // Make a new Linked List
        OnlineGroceryQueue orderQueue = new OnlineGroceryQueue();
        OnlineGroceryStack orderStack = new OnlineGroceryStack();
        // Do/while loop showing menu, getting user choice, and performing actions
        do {
            System.out.println();
            // Show menu and get user choice
            printmenu(write);
            choice = input.nextInt();
            System.out.println();
            if (choice == 1) {
                System.out.print("Please enter the order information:\n\r"
                        + "customer ID: ");
                String customerID = input.next();
                write.println("Please enter the order information:\n"
                        + "customer ID: " + customerID);
                System.out.print("customer name: ");
                String customerName = input.next();
                write.print("customer name: " + customerName);
                System.out.print("order time: ");
                String orderTime = input.next();
                write.print("order time: " + orderTime);
                System.out.print("pickup time: ");
                String pickupTime = input.next();
                write.print("pickup time: " + pickupTime);
                System.out.print("order items: ");
                input.nextLine();
                String orderItems = input.nextLine();
                write.print("order items: " + orderItems);
                String[] orderItems1 = orderItems.split(",");
                System.out.print("quantality: ");
                String quantIties = input.next();
                write.print("quantality: " + quantIties);
                String[] quantIties1 = quantIties.split(",");
                ////////////////////////////////////////////////////
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                Date orderTime1 = format.parse(orderTime);
                Date pickupTime1 = format.parse(pickupTime);
                long difference = pickupTime1.getTime() - orderTime1.getTime();
                long diffHours = difference / (60 * 60 * 1000);
                if (diffHours < 2) {
                    System.out.println("Can’t add the order because the order pick-up time less than 2\n"
                            + "hours!!!");
                    write.println("Can’t add the order because the order pick-up time less than 2\n"
                            + "hours!!!");
                } else {
                    orderQueue.addOrder(orderId++, customerName, customerID, orderTime, orderItems1, quantIties1, pickupTime);
                    System.out.println("The order is added!");
                    System.out.println("----------------------------------------------------------------------");
                    write.println("The order is added!");
                    write.println("----------------------------------------------------------------------");
                    //counter for intial new Order
                    count++;
                }
            } else if (choice == 2) {
                System.out.println();
                System.out.println("The first order information:");
                System.out.println();
                //print first order
                orderQueue.peek().toString(write);
                write.println();
                write.println("The first order information:");
                write.println();
            } else if (choice == 3) {
                System.out.println("Please select your option:\n"
                        + "1. Fulfill one order\n"
                        + "2. Fulfill multiple orders");
                int choicef = input.nextInt();
                write.println("Please select your option:\n"
                        + "1. Fulfill one order\n"
                        + "2. Fulfill multiple orders\n" + choicef);
                if (choicef == 1) {
                    //print first order
                    orderQueue.peek().toString(write);
                    //delete first order
                    temp = orderQueue.dequeue();
                    // Invoke push method 
                    orderStack.push(temp);
                    System.out.println("The order is fulfilled!");
                    write.println("The order is fulfilled!");
                } else if (choicef == 2) {
                    System.out.print("Please enter the number of orders that you would like to fulfill:");
                    int numberoforders = input.nextInt();
                    for (int i = 1; i <= numberoforders; i++) {
                        orderQueue.peek().toString(write);
                        //delete orders 
                        temp1 = orderQueue.dequeue();
                        //insert in the stack
                        orderStack.push(temp1);   
                    }
                    System.out.println("The orders above are fulfilled!!");
                    System.out.println();
                    write.print("Please enter the number of orders that you would like to fulfill:" + numberoforders);
                    write.println();
                    System.out.println("The orders information:");
                    System.out.println();
                    write.println("The orders information:");
                    write.println();
                    write.println("The orders above are fulfilled!!");
                }
            } else if (choice == 4) {
                System.out.println("All waiting orders:");
                System.out.println();
                write.println("All waiting orders:");
                write.println();
                //print orders
                orderQueue.PrintOrders(write);
                System.out.print("Please enter the number of orders to restock:");
                int restock = input.nextInt();
                System.out.println();
                write.print("Please enter the number of orders to restock:" + restock);
                write.println();
                if (restock > count) {
                    System.out.println("Can’t restock the orders, the number of orders is less than your\n"
                            + "input!!!");
                    write.println("Can’t restock the orders, the number of orders is less than your\n"
                            + "input!!!");
                } else {
                    for (int i = 1; i <= restock; i++) {
                        orderQueue.restok();
                    }
                    //print orders from the Queue
                    orderQueue.PrintOrders(write);
                    System.out.println("The order(s) restocked successfully!\n"
                            + "____________________________________________________________");
                    write.println("The order(s) restocked successfully!\n"
                            + "____________________________________________________________");
                }
            } else if (choice == 5) {
                System.out.println("Orders did not fulfill yet:\n"
                        + "The orders information:");
                write.println("Orders did not fulfill yet:\n"
                        + "The orders information:");
                //print orders from the Queue
                orderQueue.PrintOrders(write);
                System.out.println("_______________");
                System.out.println("Already Fulfilled orders:\n"
                        + "The orders information:");
                System.out.println();
                //print orders from the Stack
                orderStack.PrintStack(write);
                write.println("_______________");
                write.println("Already Fulfilled orders:\n"
                        + "The orders information:");
                write.println();
                // Exit
            } else if (choice == 6) {
                write.flush();
                write.close();
                System.exit(0);
            }
        } while (choice != 6);
        
    }
}



