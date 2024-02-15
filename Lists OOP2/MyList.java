public class MyList {
    int[] array;
    int size;

    public MyList() {
        array = new int[5];
        size = 0;
    }

    void add(int num) throws ArrayFullException{
        try {
            array[size] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num);
        }
    }

    void addAt(int pos, int num) throws ArrayFullException {
        if(pos > size+1) {
            throw new InvalidPositionException(size+1);
        } if(size == 5) {
            throw new ArrayFullException(num);
        }

        for(int i = size; i >= pos; i--) {
            array[i] = array[i-1];
        }

        array[pos-1] = num;
        size++;
    }

    boolean remove(int num) {
        int index = 0;
        boolean flag = false;

        for(int i = 0; i < size; i++) {
            if(array[i] == num) {
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

    int removeAt(int pos) {
        if(pos > size) {
            throw new InvalidPositionException(size);
        }

        int removed = array[pos-1];
        for(int i = pos-1; i < size; i++) {
            array[i] = array[i+1];
        }

        size--;
        return removed;
    }

    boolean contains(int num) {
        for(int i = 0; i < size; i++) {
            if(array[i] == num) {
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

    int get(int pos) {
        if(pos > size || (pos-1) < 0) {
            throw new InvalidPositionException(size);
        }

        return array[pos-1];
    }

    int set(int pos, int num) {
        if(pos > size || (pos-1) < 0) {
            throw new InvalidPositionException(size);
        }

        int replaced = array[pos-1];
        array[pos-1] = num;

        return replaced;
    }

}