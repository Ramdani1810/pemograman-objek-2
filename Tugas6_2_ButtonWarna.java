import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tugas6_2_ButtonWarna extends JFrame {
    private Color currentColor = Color.WHITE;

    public Tugas6_2_ButtonWarna() {
        setTitle("Tampilkan Rectangle Berwarna");
        setLayout(new BorderLayout());

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        JButton merahBtn = new JButton("Merah");
        JButton hijauBtn = new JButton("Hijau");
        JButton biruBtn = new JButton("Biru");

        buttonPanel.add(merahBtn);
        buttonPanel.add(hijauBtn);
        buttonPanel.add(biruBtn);
        add(buttonPanel, BorderLayout.NORTH);

        // Panel untuk menggambar rectangle
        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(currentColor);
                g.fillRect(100, 50, 200, 100);
            }
        };

        drawPanel.setPreferredSize(new Dimension(400, 300));
        drawPanel.setBackground(Color.WHITE);
        add(drawPanel, BorderLayout.CENTER);

        // ActionListener
        merahBtn.addActionListener(e -> {
            currentColor = Color.RED;
            drawPanel.repaint();
        });

        hijauBtn.addActionListener(e -> {
            currentColor = Color.GREEN;
            drawPanel.repaint();
        });

        biruBtn.addActionListener(e -> {
            currentColor = Color.BLUE;
            drawPanel.repaint();
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tugas6_2_ButtonWarna());
    }
}
