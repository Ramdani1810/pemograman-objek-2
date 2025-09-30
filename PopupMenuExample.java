import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopupMenuExample extends JFrame {
    private JPopupMenu popupMenu;
    private JPanel panel;

    public PopupMenuExample() {
        setTitle("Using JPopupMenus");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setComponentPopupMenu(createPopupMenu());

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) popupMenu.show(panel, e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) popupMenu.show(panel, e.getX(), e.getY());
            }
        });

        add(panel);
        setLocationRelativeTo(null); // agar muncul di tengah layar
    }

    private JPopupMenu createPopupMenu() {
        popupMenu = new JPopupMenu();

        JRadioButtonMenuItem blueItem = new JRadioButtonMenuItem("Blue");
        JRadioButtonMenuItem yellowItem = new JRadioButtonMenuItem("Yellow");
        JRadioButtonMenuItem redItem = new JRadioButtonMenuItem("Red");

        ButtonGroup group = new ButtonGroup();
        group.add(blueItem);
        group.add(yellowItem);
        group.add(redItem);

        popupMenu.add(blueItem);
        popupMenu.add(yellowItem);
        popupMenu.add(redItem);

        // Tambahkan aksi ketika warna dipilih
        blueItem.addActionListener(e -> panel.setBackground(Color.BLUE));
        yellowItem.addActionListener(e -> panel.setBackground(Color.YELLOW));
        redItem.addActionListener(e -> panel.setBackground(Color.RED));

        return popupMenu;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PopupMenuExample().setVisible(true);
        });
    }
}
