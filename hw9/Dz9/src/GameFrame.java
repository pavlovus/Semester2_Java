import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    JTextField[] textFields;
    int[] answers;
    public GameFrame(String[] questions, int[] answers) {
        super("Mathematical Game");
        this.answers = answers;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel inputPanel = new JPanel(new GridLayout(questions.length, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Mathematical Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titlePanel.add(titleLabel);

        textFields = new JTextField[questions.length];
        for (int i = 0; i < textFields.length; i++) {
            JLabel questionLabel = new JLabel(questions[i]);
            JTextField answerField = new JTextField();
            textFields[i] = answerField;
            inputPanel.add(questionLabel);
            inputPanel.add(answerField);
        }

        JScrollPane scrollPane = new JScrollPane(inputPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        submitButton.setBorder(null);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        buttonPanel.add(submitButton);

        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        add(titlePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAnswers();
            }
        });
    }

    private void submitAnswers() {
        if(answersAreValid()) {
            checkAnswers();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid answers (WHOLE numbers >= 0) !!!", "Error", JOptionPane.ERROR_MESSAGE);
            clearTextFields();
        }
    }

    private void checkAnswers() {
        int count = 0;
        for (int i = 0; i < textFields.length; i++) {
           if(Integer.parseInt(textFields[i].getText().trim()) == answers[i]){
               textFields[i].setBackground(Color.decode("#0bda51"));
               count++;
           } else {
               textFields[i].setBackground(Color.decode("#E32636"));
           }
        }
        JOptionPane.showMessageDialog(this, "You get " + count + " out of " + answers.length + " answers correct", "Results", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearTextFields() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    private boolean answersAreValid() {
        for (JTextField textField : textFields) {
            try {
                int number = Integer.parseInt(textField.getText().trim());
                if(number <0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}

