package schwimmer.fallingsand;

import javax.swing.JComponent;
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
    }
}
