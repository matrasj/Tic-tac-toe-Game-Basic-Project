package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame implements ActionListener {
    private JFrame frame;
    private JTextField jTextField;
    private Font myFont = new Font("MV Boli", Font.BOLD, 40);
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
    private boolean isXTurn = true;

    public TicTacToeGame() {
        frame = new JFrame("Tic Tac Toe Game");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\jkobm\\OneDrive\\Pulpit\\m.jpg");
        frame.setIconImage(imageIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setResizable(false);


        jTextField = new JTextField();
        jTextField.setBounds(0,0,800, 100);
        jTextField.setText("Tic-tac-toe  First X - turn");
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setFocusable(false);
        jTextField.setBackground(Color.GRAY);
        jTextField.setOpaque(true);
        jTextField.setBorder(border);
        jTextField.setFont(myFont);

        panel = new JPanel();
        panel.setBounds(0, 100, 800, 700);
        panel.setBackground(Color.BLACK);
        panel.setBorder(border);
        panel.setLayout(new GridLayout(3,3, 2,2));

        for (int i=0; i<9; i++) {
            buttons[i] = new JButton();
            buttons[i].setBorder(border);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this::actionPerformed);
            buttons[i].setFont(myFont);
            panel.add(buttons[i]);
        }

        frame.add(jTextField);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void check() {

        if (
                buttons[0].getText().equals("X")&&
                buttons[1].getText().equals("X")&&
                buttons[2].getText().equals("X")
           )  {
            xWins(0, 1, 2);
        }

        if (
                        buttons[3].getText().equals("X")&&
                        buttons[4].getText().equals("X")&&
                        buttons[5].getText().equals("X")
        )  {
            xWins(3, 4, 5);
        }

        if (
                        buttons[6].getText().equals("X")&&
                        buttons[7].getText().equals("X")&&
                        buttons[8].getText().equals("X")
        )  {
            xWins(0, 1, 2);
        }

        if (
                        buttons[0].getText().equals("X")&&
                        buttons[3].getText().equals("X")&&
                        buttons[6].getText().equals("X")
        )  {
            xWins(0, 3, 6);
        }

        if (
                        buttons[1].getText().equals("X")&&
                        buttons[4].getText().equals("X")&&
                        buttons[7].getText().equals("X")
        )  {
            xWins(0, 4, 7);
        }

        if (
                        buttons[2].getText().equals("X")&&
                        buttons[5].getText().equals("X")&&
                        buttons[8].getText().equals("X")
        )  {
            xWins(2, 5, 8);
        }

        if (
                        buttons[0].getText().equals("X")&&
                        buttons[4].getText().equals("X")&&
                        buttons[8].getText().equals("X")
        )  {
            xWins(0, 4, 8);
        }

        if (
                        buttons[2].getText().equals("X")&&
                        buttons[4].getText().equals("X")&&
                        buttons[6].getText().equals("X")
        )  {
            xWins(0, 1, 2);
        }

        if (
                        buttons[0].getText().equals("Y")&&
                        buttons[1].getText().equals("Y")&&
                        buttons[2].getText().equals("Y")
        )  {
            yWins(0, 1, 2);
        }

        if (
                        buttons[3].getText().equals("Y") &&
                        buttons[4].getText().equals("Y") &&
                        buttons[5].getText().equals("Y")
        ) {
            yWins(3, 4, 5);
        }

        if (
                        buttons[6].getText().equals("Y") &&
                        buttons[7].getText().equals("Y") &&
                        buttons[8].getText().equals("Y")
        ) {
            yWins(0, 1, 2);
        }

        if (
                        buttons[0].getText().equals("Y") &&
                        buttons[3].getText().equals("Y") &&
                        buttons[6].getText().equals("Y")
        ) {
            yWins(0, 3, 6);
        }

        if (
                        buttons[1].getText().equals("Y") &&
                        buttons[4].getText().equals("Y") &&
                        buttons[7].getText().equals("Y")
        ) {
            yWins(0, 4, 7);
        }

        if (
                        buttons[2].getText().equals("Y") &&
                        buttons[5].getText().equals("Y") &&
                        buttons[8].getText().equals("Y")
        ) {
            yWins(2, 5, 8);
        }

        if (
                        buttons[0].getText().equals("Y") &&
                        buttons[4].getText().equals("Y") &&
                        buttons[8].getText().equals("Y")
        ) {
            yWins(0, 4, 8);
        }

        if (
                        buttons[2].getText().equals("Y") &&
                        buttons[4].getText().equals("Y") &&
                        buttons[6].getText().equals("Y")
        ) {
            xWins(0, 1, 2);
        }

        boolean isEveryFull = true;
        for (int i=0; i<9; i++) {
            if (buttons[i].getText().equals("")) {
                isEveryFull = false;
            }
        }
        checkIfDraw(isEveryFull);

    }

    public void checkIfDraw(boolean isEveryFull) {
        if (isEveryFull) {
            frame.dispose();
            DrawPage drawPage = new DrawPage();
        }
    }
    public void xWins(int x, int y, int z) {
        frame.dispose();
        WinPageX winPageX = new WinPageX(x,y,z);
    }

    public void yWins(int x, int y, int z) {
        frame.dispose();
        WinPageY winPageY = new WinPageY(x,y,z);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++) {
            check();
            if (e.getSource().equals(buttons[i])) {
                if (isXTurn) {
                    if (buttons[i].getText().equals("")){
                        buttons[i].setBackground(Color.RED);
                        jTextField.setBackground(Color.YELLOW);
                        buttons[i].setText("X");
                        jTextField.setText("O - Turn");
                        isXTurn = false;
                    }
                } else {
                    if (buttons[i].getText().equals("")){
                        buttons[i].setBackground(Color.yellow);
                        jTextField.setBackground(Color.RED);
                        buttons[i].setText("O");
                        jTextField.setText("X - Turn");
                        isXTurn = true;
                    }
                }
            }
        }
    }
}
