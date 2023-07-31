/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dijkstraapp;

/**
 *
 * @author mariachzhen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class DijkstraApp extends JFrame {
    private JTextField sourceField;
    private JTextField targetField;
    private JTextArea resultArea;
    private Graph graph;
    private DijkstraAlgorithm dijkstra;
    private GraphPanel graphPanel;
    public DijkstraApp(Graph graph) {
        this.graph = graph;
        this.dijkstra = new DijkstraAlgorithm(graph);
        
        graphPanel = new GraphPanel(graph);

        JFrame frame = new JFrame("Dijkstra's Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new BorderLayout());
        frame.add(graphPanel, BorderLayout.CENTER);

        sourceField = new JTextField(10);
        targetField = new JTextField(10);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> executeDijkstra());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Source:\n Enter source name as shown on the map above"));
        panel.add(sourceField);
        panel.add(new JLabel("Target:\n Enter source name as shown on the map above"));
        panel.add(targetField);
        panel.add(calculateButton);
        panel.add(new JScrollPane(resultArea));
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    private void executeDijkstra() {
        String source = sourceField.getText();
        String target = targetField.getText();
        resultArea.setText("");
        Vertex sourceNode = null;
        Vertex targetNode = null;

        for(Vertex v : graph.getVertices()){
            if(v.getName().equals(source))
                sourceNode = v;
            if(v.getName().equals(target))
                targetNode = v;
        }

        if(sourceNode != null && targetNode != null){
            dijkstra.execute(sourceNode);
            LinkedList<Vertex> path = dijkstra.getPath(targetNode);
            for (Vertex node : path) {
                resultArea.append(node.toString() + "\n");
            }
            graphPanel.setShortestPath(path);
        }
        else {
            resultArea.append("Invalid source or target.\n");
        }
    }

    public static void main(String[] args) {
        
        Vertex WSS = new Vertex("0", "Westdale Secondary", 563, 400);
        Vertex MainStW = new Vertex("1", "Main St W", 601, 422);
        Vertex Valentinos = new Vertex("2", "Valentino's Restaurant", 654, 257);
        Vertex FoodBasics = new Vertex("3", "Food Basics", 613, 245);
        Vertex LavaPizza = new Vertex("4", "Lava Pizza", 576, 222);
        Vertex CootesParadise = new Vertex("5", "Cootes Paradise", 514, 213);
        Vertex HPL = new Vertex("6", "Library", 463, 244);
        Vertex Shoppers = new Vertex("7", "Shopper's", 392, 289);
        Vertex Mikels = new Vertex("8", "Mikel's Coffee", 403, 273);
        Vertex WestdaleVillage = new Vertex("9", "Westdale Village", 356, 310);
        Vertex IdealCaregivers = new Vertex("10", "Ideal Caregivers", 512, 434);
        Vertex WestdaleSouth = new Vertex("11", "Westdale South", 467, 446);
        Vertex TechStore = new Vertex("12", "Tech Store", 538, 221);
        Vertex PianoStudio = new Vertex("13", "Piano Studio", 417, 457);
        Vertex GasStation = new Vertex("14", "Gas Station", 296, 476);
        Vertex MainCline = new Vertex("15", "Main Cline Residences", 178, 492);
        Vertex Church = new Vertex("16", "Church", 218, 371);
        Vertex SterlingSt = new Vertex("17", "Sterling St", 249, 274);
        Vertex ClineAveN = new Vertex("18", "Cline Ave N", 376, 191);
        Vertex BeverlyHills = new Vertex("19", "Beverly Hills", 741, 352);
        
        
        Edge WSS_to_MainStW = new Edge("WSStoMainStW", WSS, MainStW, 1);
        Edge MainStW_to_WSS = new Edge("MainStWtoWSS", MainStW, WSS, 1);
        Edge Valentinos_to_MainStW = new Edge("Valentinos_to_MainStW", Valentinos, MainStW, 4);
        Edge MainStW_to_Valentinos = new Edge("MainStW_to_Valentinos", MainStW, Valentinos, 4);
        Edge Valentinos_to_FoodBasics = new Edge("Valentinos_to_FoodBasics", Valentinos, FoodBasics, 1);
        Edge FoodBasics_to_Valentinos = new Edge("FoodBasics_to_Valentinos", FoodBasics, Valentinos, 1);
        Edge FoodBasics_to_LavaPizza = new Edge("FoodBasics_to_LavaPizza", FoodBasics, LavaPizza, 1);
        Edge LavaPizza_to_FoodBasics = new Edge("LavaPizza_to_FoodBasics", LavaPizza, FoodBasics, 1);
        Edge LavaPizza_to_CootesParadise = new Edge("LavaPizza_to_CootesParadise", LavaPizza, CootesParadise, 2);
        Edge CootesParadise_to_LavaPizza = new Edge("CootesParadise_to_LavaPizza", CootesParadise, LavaPizza, 2);
        Edge CootesParadise_to_HPL = new Edge("CootesParadise_to_HPL", CootesParadise, HPL, 2);
        Edge HPL_to_CootesParadise = new Edge("HPL_to_CootesParadise", HPL, CootesParadise, 2);
        Edge HPL_to_Shoppers = new Edge("HPL_to_Shoppers", HPL, Shoppers, 1);
        Edge Shoppers_to_HPL = new Edge("Shoppers_to_HPL", Shoppers, HPL, 1);
        Edge Shoppers_to_Mikels = new Edge("Shoppers_to_Mikels", Shoppers, Mikels, 1);
        Edge Mikels_to_Shoppers = new Edge("Mikels_to_Shoppers", Mikels, Shoppers, 1);
        Edge WestdaleVillage_to_Mikels = new Edge("WestdaleVillage_to_Mikels", WestdaleVillage, Mikels, 1);
        Edge Mikels_to_WestdaleVillage = new Edge("Mikels_to_WestdaleVillage", Mikels, WestdaleVillage, 1);
        Edge IdealCaregivers_to_LavaPizza = new Edge("IdealCaregivers_to_LavaPizza", IdealCaregivers, LavaPizza, 5);
        Edge LavaPizza_to_IdealCaregivers = new Edge("LavaPizza_to_IdealCaregivers", LavaPizza, IdealCaregivers, 5);
        Edge MainStW_to_IdealCaregivers = new Edge("MainStW_to_IdealCaregivers", MainStW, IdealCaregivers, 3);
        Edge IdealCaregivers_to_MainStW = new Edge("IdealCaregivers_to_MainStW", IdealCaregivers, MainStW, 3);
        Edge WestdaleSouth_to_IdealCaregivers = new Edge("WestdaleSouth_to_IdealCaregivers", WestdaleSouth, IdealCaregivers, 1);
        Edge IdealCaregivers_to_WestdaleSouth = new Edge("IdealCaregivers_to_WestdaleSouth", WestdaleSouth, IdealCaregivers, 1);
        Edge TechStore_to_WestdaleSouth = new Edge("TechStore_to_WestdaleSouth", TechStore, WestdaleSouth, 6);
        Edge WestdaleSouth_to_TechStore = new Edge("WestdaleSouth_to_TechStore", WestdaleSouth, TechStore, 6);
        Edge TechStore_to_CootesParadise = new Edge("TechStore_to_CootesParadise", TechStore, CootesParadise, 1);
        Edge CootesParadise_to_TechStore = new Edge("CootesParadise_to_TechStore", CootesParadise, TechStore, 1);
        Edge LavaPizza_to_TechStore = new Edge("LavaPizza_to_TechStore", LavaPizza, CootesParadise, 1);
        Edge TechStore_to_LavaPizza = new Edge("TechStore_to_LavaPizza", CootesParadise, LavaPizza, 1);
        Edge PianoStudio_to_GasStation = new Edge("PianoStudio_to_GasStation", PianoStudio, GasStation, 3);
        Edge GasStation_to_PianoStudio = new Edge("GasStation_to_PianoStudio", GasStation, PianoStudio, 3);
        Edge GasStation_to_MainCline = new Edge("GasStation_to_MainCline", GasStation, MainCline, 3);
        Edge MainCline_to_GasStation = new Edge("MainCline_to_GasStation", MainCline, GasStation, 3);
        Edge PianoStudio_to_WestdaleVillage = new Edge("PianoStudio_to_WestdaleVillage", PianoStudio, WestdaleVillage, 4);
        Edge WestdaleVillage_to_PianoStudio = new Edge("WestdaleVillage_to_PianoStudio", WestdaleVillage, PianoStudio, 4);
        Edge MainCline_to_Church = new Edge("MainCline_to_Church", MainCline, Church, 3);
        Edge Church_to_MainCline = new Edge("Church_to_MainCline", Church, MainCline, 3);
        Edge Church_to_SterlingSt = new Edge("Church_to_SterlingSt", Church, SterlingSt, 2);
        Edge SterlingSt_to_Church = new Edge("Church_to_SterlingSt", SterlingSt, Church, 2);
        Edge SterlingSt_to_ClineAveN = new Edge("SterlingSt_to_ClineAveN", SterlingSt, ClineAveN, 4);
        Edge ClineAveN_to_SterlingSt = new Edge("ClineAveN_to_SterlingSt", ClineAveN, SterlingSt, 4);
        Edge WestdaleSouth_to_PianoStudio = new Edge("WestdaleSouth_to_PianoStudio", WestdaleSouth, PianoStudio, 2);
        Edge PianoStudio_to_WestdaleSouth = new Edge("PianoStudio_to_WestdaleSouth", PianoStudio, WestdaleSouth, 2);
        Edge Church_to_WestdaleVillage = new Edge("Church_to_WestdaleVillage", Church, WestdaleVillage, 4);
        Edge WestdaleVillage_to_Church = new Edge("WestdaleVillage_to_Church", WestdaleVillage, Church, 4);
        Edge SterlingSt_to_WestdaleVillage = new Edge("SterlingSt_to_WestdaleVillage", SterlingSt, WestdaleVillage, 5);
        Edge WestdaleVillage_to_SterlingSt = new Edge("WestdaleVillage_to_SterlingSt", WestdaleVillage, SterlingSt, 5);
        Edge ClineAveN_to_WestdaleVilalge = new Edge("ClineAveN_to_WestdaleVilalge", ClineAveN, WestdaleVillage, 2);
        Edge WestdaleVillage_to_ClineAveN = new Edge("WestdaleVillage_to_ClineAveN", WestdaleVillage, ClineAveN, 2);
        Edge ClineAveN_to_CootesParadise = new Edge("ClineAveN_to_CootesParadise", ClineAveN, CootesParadise, 4);
        Edge CootesParadise_to_ClineAveN = new Edge("CootesParadise_to_ClineAveN", CootesParadise, ClineAveN, 4);
        Edge BeverlyHills_to_Valentinos = new Edge("BeverlyHills_to_Valentinos", BeverlyHills, Valentinos, 5);
        Edge Valentinos_to_BeverlyHills = new Edge("Valentinos_to_BeverlyHills", Valentinos, BeverlyHills, 5);
        Edge BeverlyHills_to_WSS = new Edge("BeverlyHills_to_WSS", BeverlyHills, WSS, 6);
        Edge WSS_to_BeverlyHills = new Edge("WSS_to_BeverlyHills", WSS, BeverlyHills, 6);
        Edge GasStation_to_WestdaleVillage = new Edge("GasStation_to_WestdaleVillage", GasStation, WestdaleVillage, 7);
        Edge WestdaleVillage_to_GasStation = new Edge("WestdaleVillage_to_GasStation", WestdaleVillage, GasStation, 7);
        
        Graph graph = new Graph();
        graph.addVertex(WSS);
        graph.addVertex(MainStW);
        graph.addVertex(Valentinos);
        graph.addVertex(FoodBasics);
        graph.addVertex(LavaPizza);
        graph.addVertex(CootesParadise);
        graph.addVertex(HPL);
        graph.addVertex(Shoppers);
        graph.addVertex(Mikels);
        graph.addVertex(WestdaleVillage);
        graph.addVertex(IdealCaregivers);
        graph.addVertex(WestdaleSouth);
        graph.addVertex(TechStore);
        graph.addVertex(PianoStudio);
        graph.addVertex(GasStation);
        graph.addVertex(MainCline);
        graph.addVertex(Church);
        graph.addVertex(SterlingSt);
        graph.addVertex(ClineAveN);
        graph.addVertex(BeverlyHills);
        
        graph.addEdge(WSS_to_MainStW);
        graph.addEdge(MainStW_to_WSS);
        graph.addEdge(Valentinos_to_MainStW);
        graph.addEdge(MainStW_to_Valentinos);
        graph.addEdge(Valentinos_to_FoodBasics);
        graph.addEdge(FoodBasics_to_Valentinos);
        graph.addEdge(FoodBasics_to_LavaPizza);
        graph.addEdge(LavaPizza_to_FoodBasics);
        graph.addEdge(LavaPizza_to_CootesParadise);
        graph.addEdge(CootesParadise_to_LavaPizza);
        graph.addEdge(CootesParadise_to_HPL);
        graph.addEdge(HPL_to_CootesParadise);
        graph.addEdge(HPL_to_Shoppers);
        graph.addEdge(Shoppers_to_HPL);
        graph.addEdge(Shoppers_to_Mikels);
        graph.addEdge(Mikels_to_Shoppers);
        graph.addEdge(WestdaleVillage_to_Mikels);
        graph.addEdge(Mikels_to_WestdaleVillage);
        graph.addEdge(IdealCaregivers_to_LavaPizza);
        graph.addEdge(LavaPizza_to_IdealCaregivers);
        graph.addEdge(MainStW_to_IdealCaregivers);
        graph.addEdge(IdealCaregivers_to_MainStW);
        graph.addEdge(IdealCaregivers_to_WestdaleSouth);
        graph.addEdge(WestdaleSouth_to_IdealCaregivers);
        graph.addEdge(TechStore_to_WestdaleSouth);
        graph.addEdge(WestdaleSouth_to_TechStore);
        graph.addEdge(TechStore_to_CootesParadise);
        graph.addEdge(CootesParadise_to_TechStore);
        graph.addEdge(LavaPizza_to_TechStore);
        graph.addEdge(TechStore_to_LavaPizza);
        graph.addEdge(PianoStudio_to_GasStation);
        graph.addEdge(GasStation_to_PianoStudio);
        graph.addEdge(GasStation_to_MainCline);
        graph.addEdge(MainCline_to_GasStation);
        graph.addEdge(PianoStudio_to_WestdaleVillage);
        graph.addEdge(WestdaleVillage_to_PianoStudio);
        graph.addEdge(MainCline_to_Church);
        graph.addEdge(Church_to_MainCline);
        graph.addEdge(Church_to_SterlingSt);
        graph.addEdge(SterlingSt_to_Church);
        graph.addEdge(SterlingSt_to_ClineAveN);
        graph.addEdge(ClineAveN_to_SterlingSt);
        graph.addEdge(WestdaleSouth_to_PianoStudio);
        graph.addEdge(PianoStudio_to_WestdaleSouth);
        graph.addEdge(Church_to_WestdaleVillage);
        graph.addEdge(WestdaleVillage_to_Church);
        graph.addEdge(SterlingSt_to_WestdaleVillage);
        graph.addEdge(WestdaleVillage_to_SterlingSt);
        graph.addEdge(ClineAveN_to_WestdaleVilalge);
        graph.addEdge(WestdaleVillage_to_ClineAveN);
        graph.addEdge(ClineAveN_to_CootesParadise);
        graph.addEdge(CootesParadise_to_ClineAveN);
        graph.addEdge(BeverlyHills_to_Valentinos);
        graph.addEdge(Valentinos_to_BeverlyHills);
        graph.addEdge(BeverlyHills_to_WSS);
        graph.addEdge(WSS_to_BeverlyHills);
        graph.addEdge(GasStation_to_WestdaleVillage);
        graph.addEdge(WestdaleVillage_to_GasStation);
        
        new DijkstraApp(graph);
    }

}