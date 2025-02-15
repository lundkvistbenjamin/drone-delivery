package org.example;

import java.util.*;

public class Utils {

    /**
     * Metod för att beräkna distansen mellan två geografiska koordinater
     */
    public static double getDistance(double lat1, double lon1, double lat2, double lon2) {

        // Konvertera grader till radians
        lat1 = lat1 * Math.PI / 180.0;
        lon1 = lon1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        lon2 = lon2 * Math.PI / 180.0;

        // Räkna ut distansen med haversinformeln
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1)
                * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // Jordens radie i km
        double r = 6371;
        // returnera resultatet i km
        return (c * r);

    }

    /**
     * Metoder för att skapa listor
     */

    public static String listNodesAndLinks(ArrayList<Node> nodes) {
        String result = "";

        for (Node node : nodes) {
            result += "[" + node.getKey() + "] " + node.getName();
            ArrayList<Node> neighbors = node.getNeighbors();

            if (!neighbors.isEmpty()) {
                for (Node neighbor : neighbors) {
                    result += "[" + neighbor.getKey() + "]";
                }
                result += "\n";
            }
        }
        return result;
    }

    public static String listBestRoute(ArrayList<Node> nodes) {
        String result = "";

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            result += (i + 1) + ". [" + node.getKey() + "] " + node.getName() + " " + (Math.floor(node.distanceToPrevious() * 100) / 100) + " km\n";
        }
        return result;
    }

    /**
     * Metod för att hitta nod med en key
     */

    public static Node getNodeByKey(ArrayList<Node> nodes, String key) {
        for (Node node : nodes) {
            if (node.getKey().equals(key)) {
                return node;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Metod för att hitta noden med minsta f-värdet
     */

    public static Node getNodeSmallestF(ArrayList<Node> nodes) {
        Node smallestF = nodes.get(0);
        for (Node node : nodes) {
            if (node.getF() < smallestF.getF()) {
                smallestF = node;
            }
        }
        return smallestF;
    }

    /**
     * Metoder för att få avstånd
     */

    public static double getRouteDistance(ArrayList<Node> nodes) {
        return nodes.get(nodes.size() - 1).getG();
    }

    public static double getGeoDistance(Node start, Node goal) {
        return start.calculateH(goal);
    }

    /**
     * Sorteringsmetod för att sortera enligt namn (A-Ö)
     */

    public static ArrayList<Node> sortNodesByName(ArrayList<Node> nodes) {
        // Skapar kopia av ArrayList
        ArrayList<Node> sortedList = new ArrayList<>(nodes);

        // Loopar så länge det finns nodes i listan
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = 1; j < sortedList.size() - i; j++) {
                // Jämför namnet i föregående nod med nuvarande
                if (sortedList.get(j - 1).getName().compareTo(sortedList.get(j).getName()) > 0) {
                    // Byter plats på noderna
                    Node temp = sortedList.get(j - 1);
                    sortedList.set(j - 1, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }

    /**
     * Sorteringsmetod för att sortera enligt latitud (Norr-Söder)
     */

    public static ArrayList<Node> sortNodesByLat(ArrayList<Node> nodes) {
        // Skapar kopia av ArrayList
        ArrayList<Node> sortedList = new ArrayList<>(nodes);

        // Loopar så länge det finns nodes i listan
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = 1; j < sortedList.size() - i; j++) {
                // Jämför latituden i föregående nod med nuvarande
                if (sortedList.get(j - 1).getLatitude() < sortedList.get(j).getLatitude()) {
                    // Byter plats på noderna
                    Node temp = sortedList.get(j - 1);
                    sortedList.set(j - 1, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }

}
