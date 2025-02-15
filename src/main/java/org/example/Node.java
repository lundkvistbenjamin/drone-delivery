package org.example;

import java.util.ArrayList;

public class Node {

    private final String name;
    private String key;
    private final double latitude;
    private final double longitude;
    private double f;
    private double g;
    private final ArrayList<Node> neighbors;
    private Node previous;

    Node(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.g = Double.POSITIVE_INFINITY;
        this.neighbors = new ArrayList<>();
    }

    /**
     * Metoder
     */

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public double calculateH(Node endNode) {
        return Utils.getDistance(this.latitude, this.longitude, endNode.getLatitude(), endNode.getLongitude());
    }

    public double distanceToPrevious() {
        if (previous != null) {
            return this.calculateH(previous);
        }
        return 0;
    }

    /**
     * Getters
     */

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getF() {
        return f;
    }

    public double getG() {
        return g;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public Node getPrevious() {
        return previous;
    }

    /**
     * Setters
     */

    public void setKey(String key) {
        this.key = key;
    }

    public void setF(double f) {
        this.f = f;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
