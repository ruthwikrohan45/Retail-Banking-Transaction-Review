
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;

public class Task4_StackQueue {

    // CUSTOM QUEUE IMPLEMENTATION
    static class MyQueue {

        int[] queue = new int[10];
        int front = 0;
        int rear = -1;

        // Add transaction to queue
        void enqueue(int value) {

            if (rear == queue.length - 1) {
                System.out.println("Queue is full");
                return;
            }

            queue[++rear] = value;
            System.out.println("Added to review: " + value);
        }

        // Remove first transaction
        int dequeue() {

            if (front > rear) {
                System.out.println("Queue is empty");
                return -1;
            }

            return queue[front++];
        }

        void display() {

            System.out.print("Queue: ");

            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

    // CUSTOM STACK IMPLEMENTATION
    static class MyStack {

        int[] stack = new int[10];
        int top = -1;

        // Add adjustment
        void push(int value) {

            if (top == stack.length - 1) {
                System.out.println("Stack is full");
                return;
            }

            stack[++top] = value;
            System.out.println("Adjustment added: " + value);
        }

        // Remove latest adjustment
        int pop() {

            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }

            return stack[top--];
        }

        void display() {

            System.out.print("Stack (top to bottom): ");

            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("CUSTOM QUEUE");

        MyQueue q = new MyQueue();

        q.enqueue(1001);
        q.enqueue(1002);
        q.enqueue(1003);

        q.display();

        System.out.println("Processed transaction: "
                + q.dequeue());

        q.display();

        System.out.println("\nCUSTOM STACK");

        MyStack s = new MyStack();

        s.push(500);
        s.push(1000);
        s.push(1500);

        s.display();

        System.out.println("Reversed adjustment: "
                + s.pop());

        s.display();

        // BUILT-IN QUEUE
        System.out.println("\nBUILT-IN QUEUE");

        Queue<Integer> builtInQueue = new ArrayDeque<>();

        builtInQueue.offer(1001);
        builtInQueue.offer(1002);
        builtInQueue.offer(1003);

        System.out.println("Queue: " + builtInQueue);
        System.out.println("Processed: "
                + builtInQueue.poll());

        // BUILT-IN STACK using Deque
        System.out.println("\nBUILT-IN STACK");

        Deque<Integer> builtInStack = new ArrayDeque<>();

        builtInStack.push(500);
        builtInStack.push(1000);
        builtInStack.push(1500);

        System.out.println("Stack: " + builtInStack);
        System.out.println("Reversed adjustment: "
                + builtInStack.pop());
    }
}
