import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ShowColors2JFrame extends JFrame {
    private JButton changeColorJButton;
    private Color color = Color.LIGHT_GRAY;
    private JPanel colorJPanel;

    // Konstruktor
    public ShowColors2JFrame() {
        super("Using JColorChooser");

        // Panel utama dengan warna latar awal
        colorJPanel = new JPanel();
        colorJPanel.setBackground(color);

        // Tombol untuk mengganti warna
        changeColorJButton = new JButton("Change Color");
        changeColorJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Menampilkan dialog pemilih warna
                color = JColorChooser.showDialog(
                    ShowColors2JFrame.this,
                    "Choose a color", color
                );

                // Jika pengguna membatalkan, kembali ke warna default
                if (color == null) {
                    color = Color.LIGHT_GRAY;
                }

                // Terapkan warna yang dipilih ke panel
                colorJPanel.setBackground(color);
            }
        });

        // Menambahkan panel dan tombol ke frame
        add(colorJPanel, BorderLayout.CENTER);
        add(changeColorJButton, BorderLayout.SOUTH);

        // Konfigurasi jendela
        setSize(400, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // penting agar program keluar saat jendela ditutup
        setLocationRelativeTo(null); // agar jendela muncul di tengah layar
        setVisible(true);
    }

    // Method main untuk menjalankan program
    public static void main(String[] args) {
        new ShowColors2JFrame();
    }
}
