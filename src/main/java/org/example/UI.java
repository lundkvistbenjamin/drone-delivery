package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    static Scanner strInput = new Scanner(System.in);

    /**
     * UI metoder för display
     */

    public static void displayNodesAndLinks(ArrayList<Node> nodes) {
        System.out.println("NOD    NAMN                     GRANNAR");
        System.out.println(Utils.listNodesAndLinks(nodes));
    }

    public static void displayBestRoute(ArrayList<Node> nodes) {
        System.out.println(Utils.listBestRoute(nodes));
    }

    public static void displayGeoDistance(Node start, Node goal) {
        System.out.printf("Geografiskt avstånd: %.2f km\n", Utils.getGeoDistance(start, goal));
    }

    public static void displayRouteDistance(ArrayList<Node> nodes) {
        System.out.printf("Kortaste rutten (%.2f km):\n", Utils.getRouteDistance(nodes));
    }

    /**
     * UI metoder för promts av användaren
     */

    public static Node promptStartNode(ArrayList<Node> graphNodes) {
        while (true) {
            try {
                System.out.print("Ange startnod: ");
                return Utils.getNodeByKey(graphNodes, strInput.nextLine());
            } catch (Exception e) {
                System.out.println("ERROR: Felaktig nod, försök igen!");
            }
        }
    }

    public static Node promptGoalNode(ArrayList<Node> graphNodes) {
        while (true) {
            try {
                System.out.print("Ange slutnod: ");
                return Utils.getNodeByKey(graphNodes, strInput.nextLine());
            } catch (Exception e) {
                System.out.println("ERROR: Felaktig nod, försök igen!");
            }
        }
    }

    public static void promptSortingMethod(ArrayList<Node> graphNodes) {
        while (true) {
            try {
                System.out.print("Sortera noder A-Ö (1) eller Norr-Söder (2)? ");
                int choice = Integer.parseInt(strInput.nextLine());

                if (choice == 1) {
                    UI.displayNodesAndLinks(Utils.sortNodesByName(graphNodes));
                    break;
                } else if (choice == 2) {
                    UI.displayNodesAndLinks(Utils.sortNodesByLat(graphNodes));
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ERROR: Felaktigt val, försök igen!");
            }
        }
    }

    public static boolean promptSearchAgain() {
        while (true) {
            try {
                System.out.print("Sök igen (y/n)? ");
                String choice = strInput.nextLine();

                if (choice.equals("y")) {
                    return true;
                } else if (choice.equals("n")) {
                    System.out.println("Hejdå!");
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ERROR: Felaktigt val, försök igen!");
            }
        }
    }


}
