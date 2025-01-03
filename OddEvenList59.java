class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Function to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Function to demerge the list into odd and even lists
    public void demerge(DoublyLinkedList oddList, DoublyLinkedList evenList) {
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                evenList.insert(current.data); // Insert into even list
            } else {
                oddList.insert(current.data); // Insert into odd list
            }
            current = current.next;
        }
    }

    // Function to print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class OddEvenList59 {
    public static void main(String[] args) {
        DoublyLinkedList originalList = new DoublyLinkedList();
        originalList.insert(1);
        originalList.insert(2);
        originalList.insert(3);
        originalList.insert(4);
        originalList.insert(5);
        originalList.insert(6);

        System.out.println("Original List:");
        originalList.printList();

        DoublyLinkedList oddList = new DoublyLinkedList();
        DoublyLinkedList evenList = new DoublyLinkedList();

        originalList.demerge(oddList, evenList);

        System.out.println("Odd List:");
        oddList.printList();

        System.out.println("Even List:");
        evenList.printList();
    }
}