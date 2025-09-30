import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.font.GlyphVector;

public class StrokeAndFill extends JFrame implements ItemListener {
    private JLabel primLabel, lineLabel, paintLabel, strokeLabel;
    private ShapePanel display;
    private static JComboBox<String> primitive, line, paint, stroke;
    public static boolean noD = false;

    public StrokeAndFill() {
        super("Stroke and Fill Example");
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new GridLayout(2, 4, 10, 5));
        Font newFont = new Font("SansSerif", Font.BOLD, 14);

        primLabel = createLabel("Primitive", newFont);
        controlPanel.add(primLabel);

        lineLabel = createLabel("Lines", newFont);
        controlPanel.add(lineLabel);

        paintLabel = createLabel("Paints", newFont);
        controlPanel.add(paintLabel);

        strokeLabel = createLabel("Rendering", newFont);
        controlPanel.add(strokeLabel);

        primitive = createComboBox(new String[]{"Rectangle", "Ellipse", "Text"}, newFont);
        controlPanel.add(primitive);

        line = createComboBox(new String[]{"Thin", "Thick", "Dashed"}, newFont);
        controlPanel.add(line);

        paint = createComboBox(new String[]{"Red", "Gradient", "Texture"}, newFont);
        controlPanel.add(paint);

        stroke = createComboBox(new String[]{"Stroke", "Fill", "Stroke & Fill"}, newFont);
        controlPanel.add(stroke);

        add(controlPanel, BorderLayout.NORTH);

        display = new ShapePanel();
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.CENTER);

        display.renderShape();
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(font);
        return label;
    }

    private JComboBox<String> createComboBox(String[] items, Font font) {
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setFont(font);
        combo.addItemListener(this);
        return combo;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            display.renderShape();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-no2d")) {
            noD = true;
        }

        SwingUtilities.invokeLater(() -> {
            StrokeAndFill frame = new StrokeAndFill();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 450);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    class ShapePanel extends JPanel {
        public void renderShape() {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (!noD) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Shape shape;
                String selected = (String) primitive.getSelectedItem();
                if ("Rectangle".equals(selected)) {
                    shape = new Rectangle2D.Double(100, 50, 200, 100);
                } else if ("Ellipse".equals(selected)) {
                    shape = new Ellipse2D.Double(100, 50, 200, 100);
                } else {
                    Font font = new Font("Serif", Font.BOLD, 24);
                    String text = "Ramdani\nNIM : 2350081055";

                    // Multiline text render manual
                    shape = null;
                    String[] lines = text.split("\n");
                    int y = 100;
                    for (String line : lines) {
                        GlyphVector gv = font.createGlyphVector(g2.getFontRenderContext(), line);
                        Shape lineShape = gv.getOutline(100, y);
                        if (shape == null) {
                            shape = lineShape;
                        } else {
                            Area area = new Area(shape);
                            area.add(new Area(lineShape));
                            shape = area;
                        }
                        y += 40; // Spasi antar baris
                    }
                }

                String paintType = (String) paint.getSelectedItem();
                if ("Red".equals(paintType)) {
                    g2.setPaint(Color.RED);
                } else if ("Gradient".equals(paintType)) {
                    g2.setPaint(new GradientPaint(100, 50, Color.BLUE, 300, 150, Color.YELLOW, true));
                } else {
                    BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
                    Graphics2D big = bi.createGraphics();
                    big.setColor(Color.YELLOW);
                    big.fillRect(0, 0, 10, 10);
                    big.setColor(Color.BLUE);
                    big.fillRect(1, 1, 5, 5);
                    big.dispose();
                    g2.setPaint(new TexturePaint(bi, new Rectangle(10, 10)));
                }

                String lineType = (String) line.getSelectedItem();
                if ("Thin".equals(lineType)) {
                    g2.setStroke(new BasicStroke(1.0f));
                } else if ("Thick".equals(lineType)) {
                    g2.setStroke(new BasicStroke(5.0f));
                } else {
                    float[] dashes = {10.0f};
                    g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_BEVEL, 10.0f, dashes, 0.0f));
                }

                String strokeType = (String) stroke.getSelectedItem();
                if ("Fill".equals(strokeType)) {
                    g2.fill(shape);
                } else if ("Stroke".equals(strokeType)) {
                    g2.draw(shape);
                } else {
                    g2.fill(shape);
                    g2.setPaint(Color.BLACK);
                    g2.draw(shape);
                }
            }
        }
    }
}
