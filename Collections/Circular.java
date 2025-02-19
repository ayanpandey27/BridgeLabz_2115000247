import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size, head, tail, count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.head = this.tail = this.count = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;
        if (count < size) {
            count++;
        } else {
            head = (head + 1) % size;
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(buffer[(head + i) % size]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer: " + buffer.getBuffer());

        buffer.insert(4);
        System.out.println("Buffer After Inserting 4: " + buffer.getBuffer());

        buffer.insert(5);
        System.out.println("Buffer After Inserting 5: " + buffer.getBuffer());
    }

