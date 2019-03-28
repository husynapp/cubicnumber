package com.quasarrete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class CubeGenerator {
    private JButton buttonClick;
    private JPanel panelMain;
    private JLabel displayResult;
    private JLabel fixedLabel;
    private JTextField guessNumber;
    private JButton submitButton;
    private JLabel showAnswer;
    private Random random;
    private String guessedNumber;
    private int originalValue;

    public CubeGenerator() {
        originalValue = 0;
        guessedNumber = "0";
        random = new Random();
        fixedLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        displayResult.setFont(new Font("Serif", Font.PLAIN, 100));
        showAnswer.setFont(new Font("Serif", Font.PLAIN, 25));
//        fixedLabel.setText("Your randomly generated number is: ");
        buttonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayResult();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (guessNumber.getText() != null) {
                    guessedNumber = guessNumber.getText();
                }
                setShowAnswer();

            }
        });
    }

    public void setShowAnswer() {
        int numberGuessed = 0;
        if (guessedNumber != "0") {
            numberGuessed = parseInt(guessedNumber);
        }

        if (numberGuessed == originalValue) {

            showAnswer.setText("You are correct!, answer is : " + originalValue);
            displayResult();
        } else if (originalValue == 0) {
            showAnswer.setText("Please generate a number and guess a value");

        } else {
            showAnswer.setText("You are incorrect! Please try again");

        }
    }

    public void displayResult() {
        int randomValue = random.nextInt(101);
        originalValue = randomValue;
        int cubedValue = (int) Math.pow(randomValue, 3);
        displayResult.setText(Integer.toString(cubedValue));

    }

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

