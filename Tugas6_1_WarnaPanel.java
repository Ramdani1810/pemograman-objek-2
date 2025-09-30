import java.awt.*;
import javax.swing.*;

public class Tugas6_1_WarnaPanel extends JFrame {
    public Tugas6_1_WarnaPanel() {
        setTitle("Panel Warna dan Keterangan");
        setLayout(new GridLayout(5, 2, 10, 10)); // 10 warna

        // Array warna dan nama
        Color[] colors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,
            Color.PINK, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.LIGHT_GRAY
        };

        String[] names = {
            "Merah", "Biru", "Hijau", "Kuning", "Oranye",
            "Pink", "Cyan", "Magenta", "Abu-abu", "Abu terang"
        };

        // Tambahkan panel berwarna dan labelnya
        for (int i = 0; i < colors.length; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(colors[i]);
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(new JLabel(names[i]));
            add(panel);
        }

        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tugas6_1_WarnaPanel());
    }
}
