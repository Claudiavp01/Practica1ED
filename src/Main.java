
import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     int data= 0;
     Scanner scan = new Scanner(System.in);

     // DOUBLY LINKED LIST execution
     DoublyLinkedList dll = new DoublyLinkedList() ;

        System.out.println("\nDOUBLY LINKED LIST\n");
        System.out.println("\nEnter the number of elements you want.");
        //Create the DOUBLY LINKED LIST
        dll.Crear();
        dll.printDLL();
        //
        System.out.println("\nNumber of elements on the list: "+dll.Longitud());
        // Insert a number on the list
        System.out.println("\nEnter the number you want to insert on the list.");
        data= scan.nextInt();
        dll.Inserir(data);
        dll.printDLL();
        //
        System.out.println("\nNumber of elements on the list: "+dll.Longitud());
        // Delete a number of the list (PDI)
        System.out.println("\nEnter the number you want to delete of the list.");
        dll.Esborrar(data);
        dll.printDLL();
        //
        System.out.println("\nNumber of elements on the list: "+dll.Longitud());




        // SKIPLIST execution
        SkipList sl = new SkipList();

        System.out.println("\nSKIPLIST\n");
        System.out.println("Enter the number of elements you want.");
        //Create the SkipList
        sl.Crear();
        sl.printSkipList();
        //
        System.out.println("Number of elements on the list:"+sl.Longitud());
        // Insert a number on the list
        System.out.println("Enter the number you want to insert on the list.");
        data= scan.nextInt();
        sl.Inserir(data);
        sl.printSkipList();
        // Delete a number of the list
        System.out.println("Enter the number you want to delete of the list.");
        data= scan.nextInt();
        sl.Esborrar(data);
        //
        System.out.println("Number of elements on the list:"+sl.Longitud());
        sl.printSkipList();
        // Search
        System.out.println("Enter the number you want to search if exist on the list.");
        data= scan.nextInt();
        sl.Buscar(data);

    }
}
