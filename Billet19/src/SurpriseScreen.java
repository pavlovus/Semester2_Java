import javax.swing.*;
import java.awt.*;

public class SurpriseScreen extends JFrame {
    public SurpriseScreen() {
        super("Surprize Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setLayout(new BorderLayout(5,5));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel title = new JLabel("Вгадайте за якою кнопкою сюрприз. У Вас є 3 спроби");
        titlePanel.add(title);

        JSurpriseButton buttonOne = new JSurpriseButton("Кнопка 1", false, this);
        JSurpriseButton buttonTwo = new JSurpriseButton("Кнопка 2", false, this);
        JSurpriseButton buttonThree = new JSurpriseButton("Кнопка 3", false, this);
        JSurpriseButton buttonFour = new JSurpriseButton("Кнопка 4", false, this);
        JSurpriseButton buttonFive = new JSurpriseButton("Кнопка 5", false, this);
        JSurpriseButton buttonSix = new JSurpriseButton("Кнопка 6", false, this);
        JSurpriseButton buttonSeven = new JSurpriseButton("Кнопка 7", true, this);
        JSurpriseButton buttonEight = new JSurpriseButton("Кнопка 8", false, this);
        JSurpriseButton buttonNine = new JSurpriseButton("Кнопка 9", false, this);
        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonFour);
        buttonPanel.add(buttonFive);
        buttonPanel.add(buttonSix);
        buttonPanel.add(buttonSeven);
        buttonPanel.add(buttonEight);
        buttonPanel.add(buttonNine);

        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SurpriseScreen screen = new SurpriseScreen();
        screen.setVisible(true);
    }
}
