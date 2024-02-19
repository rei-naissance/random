public class MyGenLL<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public MyGenLL() {
        size = 0;
    }

    public void addTail(Object o) {
        Node<T> n = new Node<T>();
        n.object = (T) o;

        if (size == 0) {
            head = n;
            tail = n;
            size++;
            return;
        }

        tail.next = n;
        tail = n;
        size++;
        return;
    }

    public T set(Object e, int pos){
        if(pos < 0 || pos > size){
            throw new IllegalArgumentException("Invalid position: " + pos);
        }

        Node<T> n = head;
        int ctr = 1;
        while(ctr != pos){
            n = n.next;
            ctr++;
        }

        T ret = n.object;
        n.object = (T) e;

        return ret;
    }
}
