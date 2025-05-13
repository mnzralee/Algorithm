package data_structures;

public class Edge {
    private int destination;
    private int capacity;

    public Edge(int destination, int capacity) {
        this.destination = destination;
        this.capacity = capacity;
    }

    public int getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "(" + destination + ", " + capacity + ")";
    }
}
