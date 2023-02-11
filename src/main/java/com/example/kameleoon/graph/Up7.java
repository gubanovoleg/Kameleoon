package com.example.kameleoon.graph;

import javax.swing.*;
import java.awt.*;

public class Up7 extends JFrame {
    public static int x[] = {50, 100, 150, 200, 250};
    public static int y[] = {80, 200, 150, 320, 100};
    public static int n = 5;

    public Up7() {
        super("Score chart over time");
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent(), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Up7().setVisible(true);
    }
}
