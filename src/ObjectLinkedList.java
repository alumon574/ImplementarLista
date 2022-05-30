import java.util.LinkedList;

public class ObjectLinkedList<T> {
    private Element<T> firstElement = null;
    private T t;
    private Element<T> prevElement = null;
    private Element<T> lastElement = null;


    public ObjectLinkedList() {
    }

    public void insertFirst(T t) {
        Element<T> newElement = new Element<T>(t);
        newElement.setNext(firstElement);
        firstElement = newElement;
        firstElement.setPrev(prevElement);
    }

    public void insertLast(T t) {
        Element<T> lastElement = new Element<T>(t);
        Element<T> currentElement = firstElement;
        if (currentElement != null) {
            while (currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }
            currentElement.setNext(lastElement);
            currentElement.setPrev(setPrevious(t));
        }
    }

    public void print() {
        Element<T> currentElement = firstElement;
        String cadena = "";
        int length = cadena.length();
        while (currentElement != null) {
            if (currentElement.getNext() != null)
                cadena += currentElement.getObject() + ",";

            else if (currentElement.getObject()==null)
                cadena.replace(cadena.charAt(length),"");
            else cadena += currentElement.getObject();
            currentElement = currentElement.getNext();
        }
        System.out.println("[" + cadena + "]");
    }


//    @Override
//    public String toString() {
//        Element currentElement = firstElement;
//        String cadena = "";
//        while (currentElement != null) {
//            if (currentElement.getNext() != null)
//                cadena += currentElement.getObject() + ",";
//
//            else cadena += currentElement.getObject();
//            currentElement = currentElement.getNext();
//        }
//        return cadena;
//    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public void remove(T t) throws ObjectNotFoundException, EmptyListException {
        int indexOfObject = findIndexOf(t);
        if (indexOfObject < 0) return;
        Element<T> targetElement = getElementAtPosition(indexOfObject);
        Element<T> nextElement;
        if (t == getLastObject()) {
            nextElement = null;
        } else {
            nextElement = targetElement.getNext();
        }
        if (targetElement == firstElement) {
            firstElement = firstElement.getNext();
            firstElement.setPrev(prevElement);
        } else {
            prevElement = setPrevious(t);
            lastElement = nextElement;
        }
        targetElement.delete();
    }

    private int findIndexOf(T t) {
        int index = -1;
        Element<T> currentElement = firstElement;
        while (currentElement != null) {
            index++;
            if (currentElement.getObject() == t)
                break;
            currentElement = currentElement.getNext();
        }
        return index;
    }

    public Element<T> setPrevious(T t) {
        int index = findIndexOf(t);
        prevElement = getElementAtPosition(index - 1);
        return prevElement;
    }

    public Element<T> getFirstObject() throws EmptyListException {
        return firstElement;
    }

    public Element<T> getPrevElement(T t) {
        int i = findIndexOf(t);
        prevElement = getElementAtPosition(i - 1);
        return prevElement;
    }

    public Element<T> getLastObject() throws EmptyListException {
        Element<T> currentElement = firstElement;
        if (currentElement != null) {
            while (currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }
        }
        return currentElement;
    }

    public T getObjectAtPosition(int i) throws EmptyListException, InvalidIndexException {
        Element<T> element = getElementAtPosition(i);
        if (element == null) return null;
        return element.getObject();
    }

    private Element<T> getElementAtPosition(int i) {
        int target = 0;
        Element<T> currentElement = firstElement;
        while (target != i) {
            currentElement = currentElement.getNext();
            target++;
        }
        return currentElement;
    }

    public Element<T> getLastElement() {
        lastElement = getLastElement();
        return lastElement;

    }

    private class Element<E> {
        private E e;
        Element<E> next = null;
        Element<E> prev = null;

        public Element(E e) {
            this.e = e;
        }

        public void setNext(Element<E> newNext) {
            this.next = newNext;
        }

        public void setPrev(Element<E> prev) {
            this.prev = prev;
        }

        public Element<E> getNext() {
            return next;
        }

        public E getObject() {
            return e;
        }

        public void setObject(E newObject) {
            e = newObject;
        }

        public void delete() {
            e = null;
            next = null;
        }
    }
}
