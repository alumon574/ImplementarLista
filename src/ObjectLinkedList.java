import java.util.LinkedList;

public class ObjectLinkedList {
    private Element firstElement = null;

    public ObjectLinkedList() {
    }

    public void insertFirst(Object obj) {
        Element newElement = new Element(obj);
        newElement.setNext(firstElement);
        firstElement = newElement;
    }

    public void insertLast(Object obj) {
        Element lastElement = new Element(obj);
        Element currentElement = firstElement;
        if (currentElement != null) {
            while (currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }
            currentElement.setNext(lastElement);
        }
    }

    public void print() {
        Element currentElement = firstElement;
        if (currentElement != null) {
            while (currentElement.getNext() != null) {
                System.out.println(currentElement);
                currentElement = currentElement.getNext();
            }
    }
        }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public void remove(Object obj) throws ObjectNotFoundException, EmptyListException {
        int indexOfObject = findIndexOf(obj);
        if (indexOfObject<0) return;
        Element targetElement=getElementAtPosition(indexOfObject);
        Element nextElement = targetElement.getNext();
        if (targetElement==firstElement)
            firstElement=firstElement.getNext();
        else{
            Element previousElement = getElementAtPosition(indexOfObject-1);
            previousElement.setNext(nextElement);
        }
        targetElement.delete();
    }

    private int findIndexOf(Object obj) {
        int index=-1;
        Element currentElement = firstElement;
        while (currentElement!=null){
            index++;
            if (currentElement.getObject()==obj)
                break;
            currentElement=currentElement.getNext();
        }
        return index;
    }

    public Object getFirstObject() throws EmptyListException {
        return firstElement;
    }

    public Object getLastObject() throws EmptyListException {
        Element currentElement = firstElement;
        if (currentElement != null) {
            while (currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }
        }
        return currentElement;
    }

    public Object getObjectAtPosition(int i) throws EmptyListException, InvalidIndexException {
        Element element = getElementAtPosition(i);
        if (element == null) return null;
        return element.getObject();
    }

    private Element getElementAtPosition(int i){
        int target=0;
        Element currentElement = firstElement;
        while (target!=i){
            currentElement=currentElement.getNext();
            i++;
        }
        return currentElement;
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
