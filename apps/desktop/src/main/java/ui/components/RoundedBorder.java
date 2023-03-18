package ui.components;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedBorder implements Border {
    private final int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Shape oldClip = g.getClip();
        g.setColor(c.getBackground());
        g.clipRect(x, y, width, height);
        g.fillRoundRect(x, y, width, height, radius, radius);
        g.setClip(oldClip);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public Shape getInteriorRectangle(Component c, int x, int y, int width, int height) {
        return new RoundRectangle2D.Float(x, y, width, height, radius, radius);
    }
}
