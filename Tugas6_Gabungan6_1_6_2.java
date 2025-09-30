import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tugas6_Gabungan6_1_6_2 extends JFrame {
    private Color currentColor = Color.WHITE;
    private DrawPanel drawPanel;

    public Tugas6_Gabungan6_1_6_2() {
        setTitle("Tugas 6 - Warna & Tombol Aksi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- Panel Warna jadi Tombol (Tugas 6-1 sebagai tombol) ---
        JPanel warnaPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        Color[] colors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,
            Color.PINK, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.LIGHT_GRAY
        };
        String[] names = {
            "Merah", "Biru", "Hijau", "Kuning", "Oranye",
            "Pink", "Cyan", "Magenta", "Abu-abu", "Abu terang"
        };

        for (int i = 0; i < colors.length; i++) {
            JButton colorBtn = new JButton(names[i]);
            colorBtn.setBackground(colors[i]);
            colorBtn.setOpaque(true);
            colorBtn.setBorderPainted(false);
            colorBtn.setForeground(getContrastColor(colors[i]));
            colorBtn.setFont(new Font("SansSerif", Font.BOLD, 14));

            Color c = colors[i]; // variabel final untuk lambda
            colorBtn.addActionListener(e -> {
                currentColor = c;
                drawPanel.repaint();
            });

            warnaPanel.add(colorBtn);
        }

        // --- Panel Gambar Rectangle ---
        drawPanel = new DrawPanel();
        drawPanel.setPreferredSize(new Dimension(400, 200));
        drawPanel.setBackground(Color.WHITE);

        // --- Gabungkan ---
        add(warnaPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Panel custom untuk menggambar rectangle
    private class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(currentColor);
            g.fillRect(100, 50, 200, 100);
        }
    }

    // Fungsi untuk mendapatkan warna kontras (putih/ hitam) agar teks tombol terbaca jelas
    private Color getContrastColor(Color color) {
        double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
        return y >= 128 ? Color.BLACK : Color.WHITE;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tugas6_Gabungan6_1_6_2());
    }
}
