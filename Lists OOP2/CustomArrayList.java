public class CustomArrayList {
    private static final int CAPACITY = 5;
    private int[] array;
    private int size;

    public CustomArrayList() {
        this.array = new int[CAPACITY];
        this.size = 0;
    }

    public void add(int num) throws ArrayFullException {
        if (size == CAPACITY) {
            throw new ArrayFullException("Array is full");
        }
        array[size++] = num;
    }

    public void addAt(int pos, int num) throws InvalidPositionException, ArrayFullException {
        if (pos < 0 || pos >= size) {
            throw new InvalidPositionException("Invalid position");
        }
        if (size == CAPACITY) {
            throw new ArrayFullException("Array is full");
        }
        // Shift elements to the right to make space for the new element
        for (int i = size; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = num;
        size++;
    }

    public boolean remove(int num) {
        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean removeAt(int pos) throws InvalidPositionException {
        if (pos < 0 || pos >= size) {
            throw new InvalidPositionException("Invalid position");
        }
        // Shift elements to the left to fill the gap
        for (int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int pos) throws InvalidPositionException {
        if (pos < 0 || pos >= size) {
            throw new InvalidPositionException("Invalid position");
        }
        return array[pos];
    }

    public int set(int pos, int num) throws InvalidPositionException {
        if (pos < 0 || pos >= size) {
            throw new InvalidPositionException("Invalid position");
        }
        int oldValue = array[pos];
        array[pos] = num;
        return oldValue;
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        try {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
            list.addAt(2, 25);
            list.remove(30);
            System.out.println("Size: " + list.size());
            System.out.println("Contains 20? " + list.contains(20));
            System.out.println("Element at position 2: " + list.get(2));
            System.out.println("Is list empty? " + list.isEmpty());
        } catch (ArrayFullException | InvalidPositionException e) {
            e.printStackTrace();
        }
    }
}

class ArrayFullException extends Exception {
    public ArrayFullException(String message) {
        super(message);
    }
}

class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
