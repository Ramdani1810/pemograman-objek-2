import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class SpiralShapeExample extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int shapeCount = 36; // Jumlah bentuk yang membentuk lingkaran
        int radius = 100;

        Random rand = new Random();

        for (int i = 0; i < shapeCount; i++) {
            // Atur transformasi rotasi
            AffineTransform at = new AffineTransform();
            at.translate(centerX, centerY);
            at.rotate(Math.toRadians(i * (360.0 / shapeCount)));

            // Bentuk segitiga tajam seperti pada gambar
            Polygon shape = new Polygon();
            shape.addPoint(0, -radius);
            shape.addPoint(20, -radius + 40);
            shape.addPoint(-20, -radius + 40);

            // Terapkan transformasi
            Shape transformedShape = at.createTransformedShape(shape);

            // Ganti warna acak untuk setiap bentuk
            g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            g2d.fill(transformedShape);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new SpiralShapeExample());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
