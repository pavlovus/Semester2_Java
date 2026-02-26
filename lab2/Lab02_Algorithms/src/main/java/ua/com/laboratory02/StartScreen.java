package ua.com.laboratory02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class StartScreen extends JFrame {

    /**
     * Constructs the start application window.
     * Opens up a MainScreen frame on click.
     */
    public StartScreen() {
        super("єМагазин");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel titleLabel = new JLabel("єМагазин", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 62));
        titleLabel.setForeground(new Color(0, 51, 153));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JButton startButton = new JButton("Розпочати");

        startButton.setFont(new Font("Segoe UI", Font.BOLD, 28));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(0, 102, 204));
        startButton.setContentAreaFilled(false);
        startButton.setOpaque(true);
        startButton.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.setFocusPainted(false);

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(new Color(0, 76, 153));
                startButton.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(0, 51, 153), 3),
                        BorderFactory.createEmptyBorder(20, 50, 20, 50)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBackground(new Color(0, 102, 204));
                startButton.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartScreen.this.setVisible(false);
                GroupFile saving = new GroupFile("data.dat");
                Store<ItemGroup> saved = new Store<>();
                try {
                    saved = saving.retrieveGroups();
                    MainScreen mainScreen = new MainScreen();
                    mainScreen.store = saved;
                    mainScreen.addStoreToPanel();
                    mainScreen.setVisible(true);

                } catch (FileNotFoundException exception) {
                    MainScreen mainScreen = new MainScreen();
                    mainScreen.setVisible(true);
                }
                StartScreen.this.dispose();
            }
        });

        JLabel footerLabel = new JLabel("Prod by Pavlo Vus & Rodion Shapoval", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        footerLabel.setForeground(new Color(100, 100, 100));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(startButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        StartScreen frame = new StartScreen();
        frame.setVisible(true);
    }
}

