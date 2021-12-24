package com.company;

import javax.swing.*;
import java.awt.*;

public class WinPageX {
    private int x;
    private int y;
    private int z;
    public WinPageX(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        JFrame frame = new JFrame("X WINS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        JLabel label = new JLabel("X WINS");
        label.setBounds(0,0, 800, 800);
        frame.getContentPane().setBackground(Color.RED);
        label.setFont(new Font("MV Boli", Font.BOLD, 50));
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);
        frame.setVisible(true);
    }
}
