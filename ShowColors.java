import javax.swing.JFrame;

public class ShowColors {
    public static void main(String[] args) {
        // Membuat frame dengan judul
        JFrame frame = new JFrame("Using colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menambahkan panel kustom ke frame
        ColorJPanel colorJPanel = new ColorJPanel();
        frame.add(colorJPanel);

        // Mengatur ukuran dan menampilkan frame
        frame.setSize(400, 180);
        frame.setVisible(true);
    }
}
