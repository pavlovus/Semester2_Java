import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuestionsScreen extends JFrame {
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

    public QuestionsScreen() {
        initializeUI();
        setupQuestionPanel();
    }

    private void initializeUI() {
        setTitle("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void setupQuestionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel("Найкраща мова(мови) програмування?");
        panel.add(questionLabel);

        String[] answers = {"Java", "С#", "Python", "C++"};
        boolean[] correctAnswers = {true, false, false, false};

        for (int i = 0; i < answers.length; i++) {
            JCheckBox checkBox = new JCheckBox(answers[i]);
            checkBox.putClientProperty("correct", correctAnswers[i]);
            checkBoxes.add(checkBox);
            panel.add(checkBox);
        }

        JButton submitButton = new JButton("Перевірити");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
            }
        });
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    private void checkAnswers() {
        boolean allCorrect = true;
        for (JCheckBox checkBox : checkBoxes) {
            boolean selected = checkBox.isSelected();
            boolean correct = (boolean) checkBox.getClientProperty("correct");
            if (selected != correct) {
                allCorrect = false;
                break;
            }
        }
        if (allCorrect) {
            JOptionPane.showMessageDialog(this, "Урааааа!!! Відповідь правильна!!! Ваш приз - 40 балів за екзамен з програмування", "Успіх", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "На жаль, відповідь неправильна!", "Помилка!!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        QuestionsScreen app = new QuestionsScreen();
        app.setVisible(true);
    }
}