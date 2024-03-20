package schwimmer.fallingsand;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the sand

        sand.fall();

        g.setColor(Color.darkGray);
        for (int y = 0; y < sand.getHeight(); y++) {
            for (int x = 0; x < sand.getWidth(); x++) {
                if (sand.isSand(x, y)) {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }

        repaint();
    }
}
