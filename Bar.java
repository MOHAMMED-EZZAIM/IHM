package Exercice1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Bar{
    private static Point mouseDownCompCoords;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true);
            JPanel titleBar = createTitleBar(frame);
            frame.add(titleBar, BorderLayout.NORTH);
            JLabel l=new JLabel("My name is mohammed sir 2024!");
            l.setFont(new Font("",Font.BOLD,25));
            frame.add(l, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    private static JPanel createTitleBar(JFrame frame) {
        JPanel titleBar = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        titleBar.setBackground(Color.black);
        titleBar.setPreferredSize(new Dimension(0, 30));
        JLabel titleLabel = new JLabel();
        titleLabel.setForeground(Color.WHITE);
        titleBar.add(titleLabel);
        titleBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
        });
        titleBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });

        JButton minimizeButton = new JButton("-");
        customizeButton(minimizeButton);
        minimizeButton.setFont(new Font("",Font.BOLD,30));
        minimizeButton.setBounds(0, 0, 50, 20);
        minimizeButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));
        titleBar.add(minimizeButton);

        JButton maximizeRestoreButton = new JButton("□");
        customizeButton(maximizeRestoreButton);
        minimizeButton.setFont(new Font("",Font.BOLD,16));
        maximizeRestoreButton.addActionListener(e -> {
            int state = frame.getExtendedState();
            if ((state & Frame.MAXIMIZED_BOTH) == 0) {
                frame.setExtendedState(state | Frame.MAXIMIZED_BOTH);
            } else {
                frame.setExtendedState(state & ~Frame.MAXIMIZED_BOTH);
            }
        });
        titleBar.add(maximizeRestoreButton);

        JButton closeButton = new JButton("X");
        customizeButton(closeButton);
        closeButton.setBackground(Color.red);
        minimizeButton.setFont(new Font("",Font.BOLD,16));
        closeButton.addActionListener(e -> System.exit(0));

        titleBar.add(closeButton);
        return titleBar;
    }
    private static void customizeButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(Color.black);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }
}

