import java.util.LinkedList;

public class ObjectLinkedList {
    public ObjectLinkedList() {
    }

    public void insertFirst(Object obj) {

    }

    public void insertLast(Object obj) {
    }

    public void print() {
    }

    public boolean isEmpty() {
        return false;
    }

    public void remove(Object obj) throws ObjectNotFoundException, EmptyListException {
    }

    public Object getFirstObject() throws EmptyListException {
    }

    public Object getLastObject() throws EmptyListException {
    }

    public Object getObjectAtPosition(int i) throws EmptyListException, InvalidIndexException {
    }

    private class Element {

        Object object = null;
        Element next = null;

        public Element(Object newObject) {
            this.object = newObject;

        }

        public void setNext(Element newNext) {
            this.next = newNext;
        }

        public Element getNext() {
            return next;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object newObject) {
            object = newObject;
        }

        public void delete() {
            object = null;
            next = null;
        }
    }
}
