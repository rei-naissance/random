public class MyGenList<T> {
    T[] array;
    int size;

    public MyGenList() {
        array = (T[]) new Object[5];
        size = 0;
    }

    void add(T num) throws ArrayFullException{
        try {
            array[size] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num);
        }
    }

    void addAt(int pos, T cat) throws ArrayFullException {
        if(pos > size+1) {
            throw new InvalidPositionException(size+1);
        } if(size == 5) {
            throw new ArrayFullException(cat);
        }

        for(int i = size; i >= pos; i--) {
            array[i] = array[i-1];
        }

        array[pos-1] = cat;
        size++;
    }

    boolean remove(Object name) {
        int index = 0;
        boolean flag = false;

        for(int i = 0; i < size; i++) {
            if(array[i] == null) {
                break;
            } if(array[i].equals(name)) {
                index = i;
                flag = true;
                size--;
                break;
            }
        }

        for(int i = index; i < size; i++) {
            array[i] = array[i+1];
        }

        return flag;
    }

    T removeAt(int pos) {
        if(pos > size) {
            throw new InvalidPositionException(size);
        }

        T removed = array[pos-1];
        for(int i = pos-1; i < size; i++) {
            array[i] = array[i+1];
        }

        size--;
        return removed;
    }

    boolean contains(Object num) {
        for(T i : array) {
            if(i != null && i.equals(num)) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    T get(int pos) {
        if(pos > size || (pos-1) < 0) {
            throw new InvalidPositionException(size);
        }

        return array[pos-1];
    }

    T set(int pos, T name) {
        if(pos > size || (pos-1) < 0) {
            throw new InvalidPositionException(size);
        }

        T replaced = array[pos-1];
        array[pos-1] = name;

        return replaced;
    }
}