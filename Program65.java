import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Program65 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Program 6-5: Gambar Bentuk Terisi Warna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Tambahkan panel custom
        frame.add(new GambarPanel());

        frame.setLocationRelativeTo(null); // posisi tengah layar
        frame.setVisible(true);
    }
}

// Kelas panel khusus untuk menggambar bentuk
class GambarPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Polygon
        int[] xPoints = {50, 100, 150, 100};
        int[] yPoints = {50, 20, 50, 100};
        g.setColor(Color.MAGENTA);
        g.fillPolygon(xPoints, yPoints, xPoints.length);

        // Rectangle
        g.setColor(Color.BLUE);
        g.fillRect(200, 30, 100, 60);

        // Oval
        g.setColor(Color.GREEN);
        g.fillOval(50, 120, 100, 50);

        // Arc
        g.setColor(Color.ORANGE);
        g.fillArc(200, 120, 100, 100, 0, 135); // seperti pie chart
    }
}
