import javax.xml.crypto.Data;
import java.util.Random;
import java.util.Scanner;

public class SkipList  implements Principal {
    private NodeSkipList head;
    private NodeSkipList tail;
    int elements;

    private final int NEG_INFINITY = Integer.MIN_VALUE;
    private final int POS_INFINITY = Integer.MAX_VALUE;

    private int heightOfSkipList = 0;

    public Random random = new Random();

    public SkipList() {
        head = new NodeSkipList(NEG_INFINITY);
        tail = new NodeSkipList(POS_INFINITY);
        head.next = tail;
        tail.prev = head;
    }


    private void removeReferencesToNode(NodeSkipList nodeToBeRemoved) {
        NodeSkipList afterNodeToBeRemoved = nodeToBeRemoved.next;
        NodeSkipList beforeNodeToBeRemvoed = nodeToBeRemoved.prev;

        beforeNodeToBeRemvoed.next = afterNodeToBeRemoved;
        afterNodeToBeRemoved.prev = beforeNodeToBeRemvoed;
    }

    private void canIncreaseLevel(int level) {
        if (level >= heightOfSkipList) {
            heightOfSkipList++;
            addEmptyLevel();
        }
    }

    private void addEmptyLevel() {
        NodeSkipList newHeadNode = new NodeSkipList(NEG_INFINITY);
        NodeSkipList newTailNode = new NodeSkipList(POS_INFINITY);

        newHeadNode.next = newTailNode;
        newHeadNode.below = head;
        newTailNode.prev = newHeadNode;
        newTailNode.below = tail;

        head.above = newHeadNode;
        tail.above = newTailNode;

        head = newHeadNode;
        tail = newTailNode;
    }

    private NodeSkipList insertAfterAbove(NodeSkipList position, NodeSkipList q, int value) {
        NodeSkipList newNode = new NodeSkipList(value);
        NodeSkipList nodeBeforeNewNode = position.below.below;

        setBeforeAndAfterReferences(q, newNode);
        setAboveAndBelowReferences(position, value, newNode, nodeBeforeNewNode);

        return newNode;
    }

    private void setBeforeAndAfterReferences(NodeSkipList q, NodeSkipList newNode) {
        newNode.next = q.next;
        newNode.prev = q;
        q.next.prev = newNode;
        q.next = newNode;
    }

    private void setAboveAndBelowReferences(NodeSkipList position, int value, NodeSkipList newNode, NodeSkipList nodeBeforeNewNode) {
        if (nodeBeforeNewNode != null) {
            while (true) {
                if (nodeBeforeNewNode.next.value != value) {
                    nodeBeforeNewNode = nodeBeforeNewNode.next;
                } else {
                    break;
                }
            }

            newNode.below = nodeBeforeNewNode.next;
            nodeBeforeNewNode.next.above = newNode;
        }

        if (position != null) {
            if (position.next.value == value) {
                newNode.above = position.next;
            }
        }
    }

    public void printSkipList() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nSkipList starting with top-left most node.\n");

        NodeSkipList starting = head;

        NodeSkipList highestLevel = starting;
        int level = heightOfSkipList;

        while (highestLevel != null) {
            sb.append("\nLevel: " + level + "\n");

            while (starting != null) {
                sb.append(starting.value);

                if (starting.next != null) {
                    sb.append(" : ");
                }

                starting = starting.next;
            }

            highestLevel = highestLevel.below;
            starting = highestLevel;
            level--;
        }

        System.out.println(sb.toString());
    }



     @Override
     public void Crear() {
         SkipList sl = new SkipList();
         Scanner scan = new Scanner(System.in);
         int elements = scan.nextInt();
         System.out.println("\nInsert number of elements:\n");

         // haceerlo funcion porque es create list
         int i=0;
         while (i < elements) {
             int numeroAleatorio;
             Inserir(numeroAleatorio=  (int) (Math.random() * 100 + 1));
             i = i + 1;
         }

     }

     @Override
     public void Inserir(int data) {
         NodeSkipList n = head;
         int cont=0;
         while (n.below != null) {
             n = n.below;

             while (data >=n.next.value) {
                 n = n.next;
                 cont=cont +1;
             }
         }
         NodeSkipList q;
         int level = -1;
         int numberOfHeads = -1;

         do {
             numberOfHeads++;
             level++;

             canIncreaseLevel(level);

             q = n;

             while (n.above == null) {
                 n = n.prev;
             }

             n = n.above;

             q = insertAfterAbove(n, q, data);

         } while (random.nextBoolean() == true);
         elements=elements+1;
     }

     @Override
     public void Esborrar(int data) {
         NodeSkipList n = head;
         int cont=0;
         while (n.below != null) {
             n = n.below;

             while (data >=n.next.value) {
                 n = n.next;
                 cont=cont +1;
             }
         }

         removeReferencesToNode(n);

         while (n != null) {
             removeReferencesToNode(n);

             if (n.above != null) {
                 n= n.above;
             } else {
                 break;
             }
         }
        elements=elements-1;
     }

     @Override
    public int Longitud() {
        return elements;
    }

     @Override
     public int Buscar(int data) {
         NodeSkipList n = head;
         int cont=1;
         boolean found= false;
         while (n.below != null) {
             n = n.below;

             while (data >=n.next.value) {
                 n = n.next;

             }
             if (n.value == data){
                 found=true;
                 break;
             }
             cont=cont +1;
         }
         System.out.print("Encontrado:" + found);
         System.out.println("\nPosiciones recorridas para encontrar num: " +cont);
         return cont;

     }
     }

