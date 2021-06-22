

public class NodeSkipList {

    public NodeSkipList above;
    public NodeSkipList below;
    public NodeSkipList next;
    public NodeSkipList prev;
    public int value;

    public NodeSkipList( int value) {
        this.value = value;
        this.above = null;
        this.below = null;
        this.next = null;
        this.prev = null;
    }
}
