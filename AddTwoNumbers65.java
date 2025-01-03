class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class AddTwoNumbers65 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify the result list
        ListNode current = dummyHead; // Pointer to construct the new list
        int carry = 0; // Initialize carry to 0

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int sum = carry; // Start with carry

            // Add the value of the first list if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // Move to the next node
            }

            // Add the value of the second list if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // Move to the next node
            }

            // Calculate carry and the digit to store in the result
            carry = sum / 10; // Update carry for next iteration
            current.next = new ListNode(sum % 10); // Create a new node with the result digit
            current = current.next; // Move to the next node in the result list
        }

        // If there's a carry left after the last addition
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // Return the next node of dummy head, which is the actual head of the result list
    }

    public static void main(String[] args) {
        // Create first linked list: 2 -> 4 -> 3 (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second linked list: 5 -> 6 -> 4 (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers65 solution = new AddTwoNumbers65();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result linked list
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output should be: 7 0 8 (represents 807)
    }
}