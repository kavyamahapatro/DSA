import java.util.*;

class MyStack {

    private Queue<Integer> q = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        q.offer(x);

        // Move previous elements behind x
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

// time push -> O(n) pop -> O(1) top -> O(1) empty -> O(1) space -> O(n)