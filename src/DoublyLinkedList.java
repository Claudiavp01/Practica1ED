
import java.util.Scanner;

public class DoublyLinkedList implements Principal{
    private NodeDLL head=null;
    private NodeDLL tail=null;
    private int item;
    private NodeDLL PDI=null;
    private int nElements=0;

    public  DoublyLinkedList(){
        this.head= null;
        this.tail= null;
        this.PDI=  null;
    }

    public void First(){
        this.PDI=this.head;
    }
    public void Last(){
        this.PDI=this.tail;
    }
    public void Next(){
        this.PDI=PDI.getNext();
    }
    public void Prev(){
        this.PDI=PDI.getPrev();
    }

    public void printDLL() {
        System.out.print("\nDoubly Linked List = ");

        if (nElements == 0) {
            System.out.print("empty\n");
            return;
        }

        if (head.getNext() == null) {
            System.out.println(head.getItem());
            return;
        }

        NodeDLL ptr =head;
        System.out.print(head.getItem() + " | ");
        ptr = head.getNext();

        while (ptr.getNext() != null) {
            System.out.print(ptr.getItem() + " | ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getItem() + "\n");
    }



    public void Crear() {
        int numAleatorio;
        nElements=4;
        int i=0;
        while (i < nElements) {
            item = numAleatorio = (int) (Math.random() * 10 + 1);
            NodeDLL nptr = new NodeDLL(item);
            if (head == null) {
                head = nptr;
                tail = head;
            } else {
                head.setPrev(nptr);
                nptr.setNext(head);
                head = nptr;
            }i=i+1;
        }

    }




    @Override
    public void Inserir(int data) {
        int pos = 1;
        item=data;
        NodeDLL nptr = new NodeDLL(item);
        if (pos == 1) {
            if (head == null) {
                head = nptr;
               tail = head;
            } else {
                head.setPrev(nptr);
                nptr.setNext(head);
                head= nptr;
            }
        }

        NodeDLL ptr = head;
        for (int i = 2; i <= nElements; i++) {
            if (i == pos) {
                NodeDLL tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setPrev(ptr);
                nptr.setNext(tmp);
                tmp.setPrev(nptr);
            }
            ptr = ptr.getNext();
        }
        nElements=nElements+1;
    }





    @Override
    public void Esborrar(int data) {
        int pos=3;
        if (pos == 1) {
            if ( nElements== 1) {
                head = null;
                tail= null;
                nElements= 0;
            }

           head = head.getNext();
            head.setPrev(null);
            nElements=nElements -1;
            return;
        }

        if (pos == nElements) {
            tail = tail.getPrev();
            tail.setNext(null);
            nElements=nElements-1;
        }

        NodeDLL ptr = head.getNext();

        for (int i = 2; i <= nElements; i++) {
            if (i == pos) {
                NodeDLL p = ptr.getPrev();
                NodeDLL n = ptr.getNext();
                p.setNext(n);
                n.setPrev(p);
                nElements=nElements-1;
                return;
            }

            ptr = ptr.getNext();
        }

    }

    @Override
    public int Longitud() {
        return nElements;
    }

    @Override
    public int Buscar(int data) {
        return cont ;
    }
}
