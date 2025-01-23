package LabOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPanel extends JPanel {
    private final Register register = new Register();
    private final JTextField input = new JTextField(10);
    private final PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        setLayout(new BorderLayout());

        input.addActionListener(new InputListener());
        input.setText("0.0");  // Default amount

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);

        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
