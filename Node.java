public class Node<E> {
    E object;
    Node<E> next;

    public Node() {
        object = (E) new Object();
    }

    @Override
    public String toString() {
        if (object instanceof String) {
            return object.toString();
        } else {
            return (String) object;
        }
    }


}
