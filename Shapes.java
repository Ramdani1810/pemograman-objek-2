import javax.swing.JFrame;

public class Shapes {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShapesJPanel shapesJPanel = new ShapesJPanel();
        frame.add(shapesJPanel);
        frame.setSize(425, 200);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
