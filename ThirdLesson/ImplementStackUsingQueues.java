package ThirdLesson;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        var poppedVal = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedVal;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        var topVal = queue1.peek();
        queue2.add(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topVal;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}