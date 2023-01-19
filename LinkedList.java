package linkedlist;

public class LinkedList {

    private class Node {
        int data;
        Node next;
    }


    private Node head;
    private Node tail;
    private int size;



    public void display() {

        System.out.println(" ");

        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

        System.out.println(" ");
        System.out.println("");

    }


    public void addLast(int item) {



        Node nn = new Node();
        nn.data = item;
        nn.next = null;



        if (this.size >= 1) {
            this.tail.next = nn;
        }


        if (this.size == 0) {
            this.tail = nn;
            this.head = nn;
            this.size++;
        } else {
            this.tail = nn;
            this.size++;
        }

    }


    public void addFirst(int item) {


        Node nn = new Node();
        nn.data = item;
        nn.next = null;


        if (this.size >= 1) {
            nn.next = this.head;
        }


        if (size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            this.head = nn;
            this.size++;
        }

    }


    public void addAt(int item, int index) throws Exception {

        System.out.println(this.size);

        if (index == 0) {
            addFirst(item);
        } else if (index == this.size) {
            addLast(item);
        } else {
            Node npresent = getNodeAt(index);
            Node nprevious = getNodeAt(index - 1);
            Node temp = new Node();
            temp.data = item;
            temp.next = npresent;
            nprevious.next = temp;
            this.size++;
        }

    }



    public int getAt(int index) throws Exception {

        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }

        if (index < 0 || index >= this.size) {
            throw new Exception("Invalid Index");
        }

        Node temp = this.head;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }


    private Node getNodeAt(int index) throws Exception { // Returns Entire Node

        if (this.size == 0) {
            throw new Exception("Empty LL");
        }

        if (index < 0 || index >= this.size) {
            throw new Exception("Invalid Index");
        }

        Node temp = this.head;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp;

    }


    public int removeFirst() throws Exception {

        if (this.size == 0) {
            throw new Exception("Empty LL");
        }

        int returnValue = this.head.data;

        if (size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
//			Node temp= this.head;
//			this.head= temp.next;
//			or
            this.head = this.head.next;
            this.size--;
        }

        return returnValue;

    }


    public int removeLast() throws Exception {

        int returnValue = this.tail.data;

        if (this.size == 0) {
            throw new Exception("Empty List");
        }

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            Node temp = getNodeAt(this.size - 2);
            this.tail = temp;
            this.tail.next = null;
            this.size--;
        }

        return returnValue;
    }

    public void reverseData() throws Exception {
        int left = 0;
        int right = this.size - 1;
        while (left < right) {
            Node nl = getNodeAt(left);
            Node nr = getNodeAt(right);
            int temp = nl.data;
            nl.data = nr.data;
            nr.data = temp;
            left++;
            right--;
        }

    }

    public void reversePointers() throws Exception {

        Node previous, current;

        previous = this.head;
        current = previous.next;

        while (current != null) {
            Node ahead = current.next;

            // changing next
            current.next = previous;

            // shifting variables
            previous = current;
            current = ahead;

        }

        // swapping head and tail
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        // tail.next should be null
        this.tail.next = null;
    }


}