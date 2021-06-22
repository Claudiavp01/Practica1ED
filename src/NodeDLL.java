public class NodeDLL {
    int item;


    NodeDLL prev;
    NodeDLL next;



    public NodeDLL(int item) {
        this.item= item;
        this.prev= null;
        this.next= null;
    }

    public NodeDLL getPrev() {
        return prev;
    }

    public NodeDLL getNext() {
        return next;
    }

    public void setNext(NodeDLL next) {
        this.next = next;
    }

    public void setPrev(NodeDLL prev) {
        this.prev = prev;
    }
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
}
