/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dijkstraapp;

/**
 *
 * @author mariachzhen
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphPanel extends JPanel {
    private Graph graph;
    private List<Vertex> shortestPath;

    public GraphPanel(Graph graph) {
        this.graph = graph;
    }

    public void setShortestPath(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for (Vertex node : graph.getVertices()) {
            int x = node.getX();
            int y = node.getY();
            g.fillOval(x, y, 10, 10);
            g.drawString(node.getName(), x, y);
        }

        for (Edge edge : graph.getEdges()) {
            int x1 = edge.getSource().getX();
            int y1 = edge.getSource().getY();
            int x2 = edge.getDestination().getX();
            int y2 = edge.getDestination().getY();
            g.drawLine(x1+5, y1+5, x2+5, y2+5);
        }

        if (shortestPath != null && !shortestPath.isEmpty()) {
            g2.setColor(Color.RED);
            for (int i = 0; i < shortestPath.size() - 1; i++) {
                Vertex node1 = shortestPath.get(i);
                Vertex node2 = shortestPath.get(i + 1);
                int x1 = node1.getX();
                int y1 = node1.getY();
                int x2 = node2.getX();
                int y2 = node2.getY();
                g.drawLine(x1 + 5, y1 + 5, x2 + 5, y2 + 5);
            }
        }
    }
}
