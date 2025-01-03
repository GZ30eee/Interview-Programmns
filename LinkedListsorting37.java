import java.util.LinkedList;

public class LinkedListsorting37 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(20);
        list.add(4);
        list.add(3);
        list.add(10);

        System.out.println("Linked list before sorting: " + list);

        list.sort(null);

        System.out.println("Linked list after sorting: " + list);
    }
}