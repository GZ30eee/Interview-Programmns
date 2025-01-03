import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation
    public void push(int value) {
        // Enqueue the new element to queue1
        queue1.offer(value);

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // Swap the names of the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.poll();
    }

    // Top operation
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Get the top element
        System.out.println("Top element: " + stack.top()); // Should print 3

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop()); // Should print 3
        System.out.println("Popped: " + stack.pop()); // Should print 2

        // Get the top element again
        System.out.println("Top element: " + stack.top()); // Should print 1

        // Pop the last element
        System.out.println("Popped: " + stack.pop()); // Should print 1

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Should print true
    }
}