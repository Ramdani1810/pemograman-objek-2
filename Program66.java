import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Program66 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("Program 6.6 - Shape Drawer", 50, 20);
        
        //draw Rectangle.2D
        g2.setColor(new Color(70, 130, 180));
        g2.fillRect(50, 30, 100, 50);
        g2.setColor(Color.BLACK);
        g2.drawRect(50, 30, 100, 50);

        //draw RoundRectangle2D.Double
        g2.setColor(new Color(244, 164, 96));
        g2.fillRoundRect(50, 90, 100, 50, 30, 30);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(50, 90, 100, 50, 30, 30);

        //draw Arc2D.Double
        g2.setColor(new Color(60, 179, 113));
        g2.fillArc(50, 150, 100, 50, 90, 180);
        g2.setColor(Color.BLACK);
        g2.drawArc(50, 150, 100, 50, 90, 180);


        //draw Line2D,Double
        g2.setColor(new Color(220, 20, 60));
        g2.setStroke(new BasicStroke(3));
        Line2D.Double line = new Line2D.Double(50, 290, 150, 250);  
        g2.draw(line);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Program 6.6 - Shape Drawer");
        Program66 panel = new Program66();

        frame.add(panel);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
