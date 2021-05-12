
import java.io.PrintWriter;
import static java.nio.file.Files.write;



/**
 *
 * @author User
 */
public class OnlineGroceryQueue {

    private Order front;
    private Order back;
    private int numOrders;

    // CONSTRUCTORS
    
    public OnlineGroceryQueue() {
        this.front = null;
        this.back = null;
        this.numOrders = 0;
    }

    public OnlineGroceryQueue(Order front, Order back, int numOrders) {
        this.front = front;
        this.back = back;
        this.numOrders = numOrders;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void printOrders() {
    }

    public Order getFront() {
        return front;
    }

    public void setFront(Order front) {
        this.front = front;
    }

    public Order getBack() {
        return back;
    }

    public void setBack(Order back) {
        this.back = back;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }

    public void addOrder(int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        if (isEmpty()) {
            front = back = addOrder(front, back, orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
        } else {
            back = addOrder(front, back, orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
        }

    }

    private Order addOrder(Order front, Order back, int orderID, String customerName, String customerID, String orderTime, String[] orderItems, String[] quantIties, String pickupTime) {
        // Make a new QueueNode with data values
        Order temp = new Order(orderID, customerName, customerID, orderTime, orderItems, quantIties, pickupTime);
        // Now, if the list is empty, return the reference for temp
        if (isEmpty()) {
            return temp;
        } // ELSE, the queue is not empty. We need to insert temp at the back of the queue.
        // So save the address of the new node into the next of back.
        // Then, make back "traverse" one node over, so it now points to the new back node.
        // Finally, return the updated address of back.
        else {
            back.setNext(temp);
            back = back.getNext();
            return back;
        }
    }

    public Order dequeue() {
        Order temp = front;
        front = dequeue(front);
        if (front == null) {
            back = null;
        }
        return temp;
    }

    private Order dequeue(Order front) {
        front = front.getNext();
        return front;
    }
    
    public Order peek() {
		// Invoke the peek method with front as a parameter
		Order frontValue = peek(front);
		// return topValue
		return frontValue;
	}

	private Order peek(Order front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front;
	}
        
        	public void PrintOrders(PrintWriter write) {
		PrintOrders(front,write);
	}

	private void PrintOrders(Order front, PrintWriter write) {
		// We need to traverse...so we need a help ptr
		Order helpPtr = front;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print of the node
			helpPtr.toString(write);
                        System.out.println();
                        write.println();
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
                write.println();
	}
        
        public Order enqueue(Order temp) {
		if (isEmpty()) {
			front = back = enqueue(front, back, temp);
		}
		else {
			back = enqueue(front, back, temp);
		}
        return null;	
	}

	private Order enqueue(Order front, Order back, Order temp) {
		// Make a new QueueNode with object
		Order temp1 = new Order(temp);
		// Now, if the list is empty, return the reference for temp
		if (isEmpty()) {
			return temp1;
		}
		// ELSE, the queue is not empty. We need to insert temp at the back of the queue.
		// So save the address of the new node into the next of back.
		// Then, make back "traverse" one node over, so it now points to the new back node.
		// Finally, return the updated address of back.
		else {
			back.setNext(temp1);
			back = back.getNext();
			return back;
		}
	}
        
        
    public Order top() {
// Invoke the top method with top as a parameter
        Order topValue = top(front);
// return topValue
        return topValue;
    }

    private Order top(Order front) {
// Return the data value of the top node.
        return front;
    }
        
        public void restok (){
            Order temp1 = front;
           front = temp1.getNext();
            back.setNext(temp1);
            back = temp1;
            temp1.setNext(null);
        }

}


