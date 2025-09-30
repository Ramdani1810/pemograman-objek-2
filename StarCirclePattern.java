import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class StarCirclePattern extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStarCircle((Graphics2D) g);
    }

    private void drawStarCircle(Graphics2D g2d) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100;

        // Set rendering hints for smooth graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create 5-pointed star
        Shape star = createStar(0, 0, 30, 60, 5);

        // Draw 36 stars rotated around the center
        for (int i = 0; i < 36; i++) {
            double angle = Math.toRadians(i * 10);
            AffineTransform at = new AffineTransform();
            at.translate(centerX + Math.cos(angle) * radius, centerY + Math.sin(angle) * radius);
            at.rotate(angle);

            // Set random color
            g2d.setColor(new Color((int)(Math.random() * 0x1000000)));
            g2d.fill(at.createTransformedShape(star));
        }
    }

    private Shape createStar(double x, double y, double innerRadius, double outerRadius, int numRays) {
        GeneralPath path = new GeneralPath();
        double angle = Math.PI / numRays;

        for (int i = 0; i < numRays * 2; i++) {
            double r = (i % 2 == 0) ? outerRadius : innerRadius;
            double theta = i * angle;
            double dx = x + Math.cos(theta) * r;
            double dy = y + Math.sin(theta) * r;
            if (i == 0) {
                path.moveTo(dx, dy);
            } else {
                path.lineTo(dx, dy);
            }
        }
        path.closePath();
        return path;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new StarCirclePattern());
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
