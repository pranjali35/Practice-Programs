
public class SinglyLinkedList {

	
	 Node head;  // head of list
	 
	    /* Node Class */
	    class Node
	    {
	        int data;
	        Node next;
	          
	        // Constructor to create a new node
	        Node(int d) {data = d; next = null; }
	    }
	    
	    /* Function to print middle of linked list */
	    
	    Node reverse(Node node) {
	        Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        node = prev;
	        return node;
	    }
	    boolean compareLists(Node head1, Node head2) 
	    {
	        Node temp1 = head1;
	        Node temp2 = head2;
	 
	        while (temp1 != null && temp2 != null) 
	        {
	            if (temp1.data == temp2.data) 
	            {
	                temp1 = temp1.next;
	                temp2 = temp2.next;
	            } else
	                return false;
	        }
	 
	        /* Both are empty reurn 1*/
	        if (temp1 == null && temp2 == null)
	            return true;
	 
	        /* Will reach here when one is NULL
	           and other is not */
	        return false;
	    }
	    void printMiddle()
	    {
	        Node slow_ptr = head;
	        Node fast_ptr = head;
	        if (head != null)
	        {
	            while (fast_ptr != null && fast_ptr.next != null)
	            {
	                fast_ptr = fast_ptr.next.next;
	                slow_ptr = slow_ptr.next;
	            }
	            System.out.println("The middle element is [" +
	                                slow_ptr.data + "] \n");
	        }
	    }
	    void deleteNode(int key)
	    {
	        // Store head node
	        Node temp = head, prev = null;
	 
	        // If head node itself holds the key to be deleted
	        if (temp != null && temp.data == key)
	        {
	            head = temp.next; // Changed head
	            return;
	        }
	 
	        // Search for the key to be deleted, keep track of the
	        // previous node as we need to change temp.next
	        while (temp != null && temp.data != key)
	        {
	            prev = temp;
	            temp = temp.next;
	        }    
	 
	        // If key was not present in linked list
	        if (temp == null) return;
	 
	        // Unlink the node from linked list
	        prev.next = temp.next;
	    }
	    public void push(int new_data)
	    {
	        /* 1 & 2: Allocate the Node &
	                  Put in the data*/
	        Node new_node = new Node(new_data);
	     
	        /* 3. Make next of new Node as head */
	        new_node.next = head;
	     
	        /* 4. Move the head to point to new Node */
	        head = new_node;
	    }
	    
	    /* This function is in LinkedList class.
	    Inserts a new node after the given prev_node. This method is 
	    defined inside LinkedList class shown above */
	 public void insertAfter(Node prev_node, int new_data)
	 {
	     /* 1. Check if the given Node is null */
	     if (prev_node == null)
	     {
	         System.out.println("The given previous node cannot be null");
	         return;
	     }
	  
	     /* 2. Allocate the Node &
	        3. Put in the data*/
	     Node new_node = new Node(new_data);
	  
	     /* 4. Make next of new Node as next of prev_node */
	     new_node.next = prev_node.next;
	  
	     /* 5. make next of prev_node as new_node */
	     prev_node.next = new_node;
	 }
	 
	 public void append(int new_data)
	 {
	     /* 1. Allocate the Node &
	        2. Put in the data
	        3. Set next as null */
	     Node new_node = new Node(new_data);
	  
	     /* 4. If the Linked List is empty, then make the
	            new node as head */
	     if (head == null)
	     {
	         head = new Node(new_data);
	         return;
	     }
	  
	     /* 4. This new node is going to be the last node, so
	          make next of it as null */
	     new_node.next = null;
	  
	     /* 5. Else traverse till the last node */
	     Node last = head; 
	     while (last.next != null)
	         last = last.next;
	  
	     /* 6. Change the next of last node */
	     last.next = new_node;
	     return;
	 }
	 
	 public void printList()
	    {
	        Node tnode = head;
	        while (tnode != null)
	        {
	            System.out.print(tnode.data+" ");
	            tnode = tnode.next;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Start with the empty list */
        SinglyLinkedList llist = new SinglyLinkedList();
 
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
 
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
 
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
    }

	
	

}
