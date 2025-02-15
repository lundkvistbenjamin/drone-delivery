package org.example;

import java.util.ArrayList;

public class Route {

    private final Node start;
    private final Node goal;
    private final ArrayList<Node> bestRoute;

    Route(Node start, Node goal) {
        this.start = start;
        this.goal = goal;
        this.bestRoute = new ArrayList<>();
    }

    public ArrayList<Node> aStar() {

        ArrayList<Node> openNodes = new ArrayList<>();
        openNodes.add(start);
        start.setG(0);
        start.setF(start.getG() + start.calculateH(goal));

        while (!openNodes.isEmpty()) {
            Node current = Utils.getNodeSmallestF(openNodes);
            if (current == goal) {
                while (current != start) {
                    bestRoute.add(0, current);
                    current = current.getPrevious();
                }
                bestRoute.add(0, start);
                return bestRoute;
            }
            openNodes.remove(current);

            for (Node neighbor : current.getNeighbors()) {
                double checkG;
                checkG = current.getG() + current.calculateH(neighbor);
                if (checkG < neighbor.getG()) {
                    neighbor.setPrevious(current);
                    neighbor.setG(checkG);
                    neighbor.setF(neighbor.getG() + neighbor.calculateH(goal));

                    if (!openNodes.contains(neighbor)) {
                        openNodes.add(neighbor);
                    }
                }
            }
        }
        return null;
    }

}
