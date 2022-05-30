public class Main {
    public static void main(String[] args) throws ObjectNotFoundException, EmptyListException {
        Contact contacto1 = new Contact("Pepe");
        Contact contacto2 = new Contact("pepe2");
        Contact contacto3 = new Contact("pepe3");
        Contact contacto4 = new Contact("pepe4");

        ObjectLinkedList<Contact> objectLinkedList = new ObjectLinkedList<Contact>();
        objectLinkedList.insertFirst(contacto4);
        objectLinkedList.insertFirst(contacto3);
        objectLinkedList.insertFirst(contacto2);
        objectLinkedList.insertFirst(contacto1);
        objectLinkedList.print();
        objectLinkedList.remove(contacto4);
        objectLinkedList.print();
    }
}
