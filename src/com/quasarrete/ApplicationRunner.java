package com.quasarrete;

import javax.swing.*;
import java.awt.*;

public class ApplicationRunner {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cubic Number Generator");
        frame.setContentPane(new CubeGenerator().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
