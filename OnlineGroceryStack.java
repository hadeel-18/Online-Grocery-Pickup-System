
import java.io.PrintWriter;



/**
 *
 * @author User
 */
public class OnlineGroceryStack {

    private Order top;

    // CONSTRUCTORS
    
    public OnlineGroceryStack() {
        this.top = null;
    }

    public OnlineGroceryStack(Order top) {
        this.top = this.top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        top = push(top, orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
    }

    private Order push(Order top, int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
//set the "next" of this new node to the same address as top
        top = new Order(orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime, top);
// Now, return the newly updated top.
        return top;
    }

    private Order pop(Order top) {
// Set top equal to the next order.
// This will make top point to the 2nd node instead
// of the first node.
        top = top.getNext();
// return the address/reference of the new top node
        return top;
    }

    public Order pop() {
// Save a reference to the current top node
// because we will change where top points to
        Order temp = top;
// Now, invoke the pop method with top as a parameter.
// This method will return a new top node.
        top = pop(top);
// Finally, return temp, which is the previous top node
// that we just "popped" off the list.
        return temp;
    }

    public void push(Order temp) {
      
      top = push (temp,top);
    }
    
    private Order push(Order temp,Order top){
        //set the "next" of this new node to the same address as top
        temp.setNext(top);
        top=temp;
        // Now, return the newly updated top.
        return top;
    }
    
    public void PrintStack(PrintWriter write) {
		PrintStack(top,write);
	}

	private void PrintStack(Order top,PrintWriter write) {
		// We need to traverse...so we need a help ptr
		Order helpPtr = top;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print of the node
			helpPtr.toString(write);
			// Step one node over
                        System.out.println();
                        write.println();
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
                write.println();
	}

}

