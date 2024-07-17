package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton, clearButton;

    public CalculatorGUI() {
        // Set up the frame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create text fields
        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        // Create labels
        JLabel firstNumberLabel = new JLabel("First Number:");
        JLabel secondNumberLabel = new JLabel("Second Number:");
        JLabel resultLabel = new JLabel("Result:");

        // Create buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        moduloButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Add action listeners to buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        moduloButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to frame
        gbc.gridx = 0; gbc.gridy = 0;
        add(firstNumberLabel, gbc);
        gbc.gridx = 1;
        add(firstNumberField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(secondNumberLabel, gbc);
        gbc.gridx = 1;
        add(secondNumberField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(resultLabel, gbc);
        gbc.gridx = 1;
        add(resultField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(addButton, gbc);
        gbc.gridx = 1;
        add(subtractButton, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(multiplyButton, gbc);
        gbc.gridx = 1;
        add(divideButton, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        add(moduloButton, gbc);
        gbc.gridx = 1;
        add(clearButton, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1, num2, result = 0;
        try {
            num1 = Double.parseDouble(firstNumberField.getText());
            num2 = Double.parseDouble(secondNumberField.getText());

            if (e.getSource() == addButton) {
                result = CalculatorOperations.add(num1, num2);
            } else if (e.getSource() == subtractButton) {
                result = CalculatorOperations.subtract(num1, num2);
            } else if (e.getSource() == multiplyButton) {
                result = CalculatorOperations.multiply(num1, num2);
            } else if (e.getSource() == divideButton) {
                result = CalculatorOperations.divide(num1, num2);
            } else if (e.getSource() == moduloButton) {
                result = CalculatorOperations.modulo(num1, num2);
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }
}
