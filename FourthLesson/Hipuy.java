package FourthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class MaxHeap {
    private int[] heap;
    private int size;
    private final int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size >= capacity) {
            return; // не добавляем, если мощность превышена
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            return -1; // или бросьте исключение
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index] > heap[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, largest;
        while (index < size) {
            largest = index;
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;

            if (leftChild < size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }

            if (rightChild < size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine().trim());
        MaxHeap heap = new MaxHeap(N);

        for (int i = 0; i < N; i++) {
            String command = reader.readLine().trim();
            if (command.startsWith("0")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                heap.insert(number);
            } else if (command.equals("1")) {
                int max = heap.extractMax();
                writer.write(String.valueOf(max));
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }
}