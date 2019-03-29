package com.quasarrete;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ApplicationRunner {

    public static void main(String[] args) throws IOException {
        CubeGenerator cube = new CubeGenerator();
        JFrame frame = new JFrame("Cubic Number Generator");
        frame.setContentPane(cube.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
