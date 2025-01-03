import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    // Peek operation to get the front element
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 1
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 2

        // Peek at the front element
        System.out.println("Front element: " + queue.peek()); // Should print 3

        // Dequeue the last element
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 3

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Should print true
    }
}