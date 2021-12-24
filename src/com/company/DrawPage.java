package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPage {
    public DrawPage() {
        JFrame frame = new JFrame("DRAW");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        JLabel label = new JLabel("DRAW");
        label.setBounds(0,0, 800, 800);
        frame.getContentPane().setBackground(Color.BLUE);
        label.setFont(new Font("MV Boli", Font.BOLD, 50));
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);
        frame.setVisible(true);
    }
}
