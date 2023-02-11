package com.example.kameleoon.graph;

import javax.swing.*;
import java.awt.*;

class DrawingComponent extends JPanel {
    int xg[] =  Up7.x;
    int yg[] =  Up7.y;
    int ng = Up7.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

