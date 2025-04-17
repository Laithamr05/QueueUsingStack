import java.util.Stack;

public class StackQueue<T> implements QueueInterface<T> {
    Stack<T> stack1;
    Stack<T> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    @Override
    public void enqueue(T data) {
        stack1.push(data);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public void clear() {
        stack1.clear();
        stack2.clear();
    }
}