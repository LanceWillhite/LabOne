package LabOne;

import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        frame.setVisible(true);
    }
}
