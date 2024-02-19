public class MyGenLL<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public MyGenLL() {
        size = 0;
    }

    protected void addTail(Object o) {
        Node<T> n = new Node<T>();
        n.object = (T) o;

        if (isEmpty()) {
            head = n;
            tail = n;
            size++;
            return;
        }

        tail.next = n;
        tail = n;

        size++;
    }
    protected void set(Object e, int pos){
        Node<T> n = head;
        int ctr= 1;
        while(ctr != pos){
            n = n.next;
            ctr++;
        }


    }

    public int GetSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node<T> curr = head;

        while (curr != tail) {
            System.out.println(curr + " -> ");
            curr = curr.next;
        }
    }


}
