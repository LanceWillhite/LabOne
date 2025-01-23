package LabOne;

import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();  // Repaint to display updated purse
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 20;
        for (var entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey();
            int quantity = entry.getValue();
            g.drawString(denomination.name() + ": " + quantity, 10, y);
            y += 20;
        }
    }
}
