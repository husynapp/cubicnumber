package com.quasarrete;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showMessageDialog;

public class CubeGenerator {
    private JButton buttonClick;
    protected JPanel panelMain;
    private JLabel displayResult;
    private JLabel fixedLabel;
    private JTextField guessNumber;
    private JButton submitButton;
    private JLabel showAnswer;

    private JLabel imageField;

    public CubeGenerator() {
        originalValue = 0;
//        guessedNumber = null;
        random = new Random();
        fixedLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        displayResult.setFont(new Font("Serif", Font.PLAIN, 80));
        showAnswer.setFont(new Font("Serif", Font.PLAIN, 25));
//        fixedLabel.setText("Your randomly generated number is: ");
        buttonClick.addActionListener(e -> displayResult());
        submitButton.addActionListener(e -> {
            validateTextField();
            setShowAnswer();

        });
    }

    private Random random;
    private String guessedNumber;
    private int originalValue;

    public JLabel getImageField() {
        return imageField;
    }

    private void setShowAnswer() {
        int numberGuessed = -1;
        if (guessedNumber != "0") {
            try {
                numberGuessed = parseInt(guessedNumber);
            } catch (NumberFormatException e) {

            }
        }
        if (numberGuessed == originalValue) {

            showAnswer.setText("You are correct: " + originalValue);
            displayResult();
            guessedNumber = null;
        } else if (originalValue == 0) {
            showAnswer.setText("Please generate a number and guess a value");

        } else {
            showAnswer.setText("You are incorrect! Please try again");

        }
    }

    private void displayResult() {
        int randomValue = random.nextInt(101);
        originalValue = randomValue;
        int cubedValue = (int) Math.pow(randomValue, 3);
        displayResult.setText(Integer.toString(cubedValue));

    }

    private void validateTextField() {
        if (guessNumber.getText().equals("")) {
            showMessageDialog(null, "Make sure field is not EMPTY!!!!");

        } else {

            guessedNumber = guessNumber.getText();

        }

    }

}

