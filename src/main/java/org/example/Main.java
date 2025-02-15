package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Projekt 1 - ruttsökning med A*
 * <p>
 * Datastrukturer och algoritmer
 * <p>
 * Programmeringsteam: lundkvib
 */
public class Main {

    public static void main(String[] args) {
        Scanner strInput = new Scanner(System.in);

        do {

            ArrayList<Node> graphNodes = GraphData.createGraph();
            //  Frågar användaren hur hen vill sortera noderna
            UI.promptSortingMethod(graphNodes);

            // Frågar användaren om start- och slutnod
            Node start = UI.promptStartNode(graphNodes);
            Node goal = UI.promptGoalNode(graphNodes);

            // Printar geografiskt avstånd (fågelvägen)
            UI.displayGeoDistance(start, goal);

            // Skapar rutt av start och mål, sparar bästa rutten enligt aStar i bestRoute
            Route route = new Route(start, goal);
            ArrayList<Node> bestRoute = route.aStar();

            // Visar total avstånd och listar rutten
            UI.displayRouteDistance(bestRoute);
            UI.displayBestRoute(bestRoute);

            // Frågar till sist om användaren vill söka igen

        } while (UI.promptSearchAgain());

    }

}