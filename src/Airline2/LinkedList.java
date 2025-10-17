package Airline2;

//  Service , ticket 
//SinglyLinkedList
public class LinkedList<E> {
//---------------- nested Node class ----------------

    private static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
//----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public LinkedList() {
    } // constructs an initially empty list

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) {
            head = newest; // special case: previously empty list
        } else {
            tail.setNext(newest); // new node after existing tail
        }
        tail = newest; // new node becomes the tail
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null; // nothing to remove
        }
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;
    }

    public E removeLast() {  // removes and returns the last node
        if (size == 0) {
            return null; // nothing to remove
        } else {
            E data = tail.getElement();  // get a copy of the data stored in the last node
            if (size == 1) { // only one node in the list
                head = tail = null;
            } else { // at least two nodes
                Node temp1 = head;;// make temp1 point to the head 
                Node temp2 = null; // make temp2 point to null
                while (temp1.getNext() != null) { // find last node
                    temp2 = temp1;
                    temp1 = temp1.getNext();
                }
                temp2.setNext(null); // null out the next pointer of the last node 
                tail = temp2; // update the value of tail
            }
            size--; //decrement the size of list
            return data; // return the value stored in the removed node
        }
    }

    public void display() {

        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getElement());
            System.out.println("--------------------------------------------------");
            current = current.getNext();

        }
    }

    public void bookCarService(CarService service) {
        addFirst((E) service);
        System.out.println("Your service has been successfully booked.");
    }

    public void cancelCarService() {
        if (isEmpty()) {
            System.out.println("There are no services to cancel!");
        } else {
            removeLast();
            System.out.println("Your service has been successfully cancelled.");
        }
    }

    public void DisplayCarService() {
        if (isEmpty()) {
            System.out.println("There is no Service to display!");
        } else {
            display();

        }

    }

    public void DisplayHotelService() {
        if (isEmpty()) {
            System.out.println("There is no Service!");
        } else {
            display();
        }

    }

    public void bookHotelervice(HotelService service) {
        addFirst((E) service);
        System.out.println("Service has been successfully booked.");
    }

//    
    public void cancelHotelService() {
        if (isEmpty()) {
            System.out.println("There are no services to cancel!");
        } else {
            removeLast();
            System.out.println("Your Service has been successfully cancelled.");
        }
    }

}
