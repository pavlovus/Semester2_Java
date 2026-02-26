import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.random.RandomGenerator;

public class StartScreen extends JFrame{
    RandomGenerator rand = RandomGenerator.getDefault();
    private JTextField maxNumField;
    private JTextField numOfExField;

    public StartScreen() {
        super("Mathematical Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Mathematical Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        JLabel maxNumLabel = new JLabel("Max Number to use:");
        maxNumField = new JTextField();
        JLabel numOfExLabel = new JLabel("Number of exercises:");
        numOfExField = new JTextField();
        JButton generateButton = new JButton("Generate");

        generateButton.setPreferredSize(new Dimension(100, 30));
        generateButton.setBorder(null);
        generateButton.setFont(new Font("Arial", Font.PLAIN, 18));
        generateButton.setForeground(Color.WHITE);
        generateButton.setBackground(Color.BLACK);

        titlePanel.add(titleLabel);
        inputPanel.add(maxNumLabel);
        inputPanel.add(maxNumField);
        inputPanel.add(numOfExLabel);
        inputPanel.add(numOfExField);

        buttonPanel.add(generateButton);

        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        add(titlePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tryToPlay();
            }
        });
    }

    private void tryToPlay() {
        if(isInteger(maxNumField) && isInteger(numOfExField)) {
            playMathGame();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!!!", "Error", JOptionPane.ERROR_MESSAGE);
            maxNumField.setText("");
            numOfExField.setText("");
        }
    }

    private void playMathGame() {
        int maxNumber = Integer.parseInt(maxNumField.getText());
        int exercises = Integer.parseInt(numOfExField.getText());
        int[] answers = generateAnswers(maxNumber, exercises);
        String[] questions = generateQuestions(answers, maxNumber);
        GameFrame gameFrame = new GameFrame(questions, answers);
        gameFrame.setVisible(true);
        maxNumField.setText("");
        numOfExField.setText("");
    }

    private int[] generateAnswers(int maxNumber, int exercises) {
        int[] answers = new int[exercises];
        for(int i = 0; i < exercises; i++) {
            answers[i] = rand.nextInt(0, maxNumber+1);
        }
        return answers;
    }

    private String[] generateQuestions(int[] answers, int maxNumber) {
        String[] questions = new String[answers.length];

        for (int i = 0; i < answers.length; i++) {
            int numOfOperations = rand.nextInt(2) + 2;
            int currentValue = rand.nextInt(-1, maxNumber) + 1;
            String question = Integer.toString(currentValue);
            int tempValue = currentValue;

            for (int j = 0; j < numOfOperations; j++) {
                boolean canAdd = tempValue < maxNumber;
                boolean canSubtract = tempValue > 0;
                if (!canAdd && !canSubtract) break;
                boolean isAddition;
                if (canAdd && canSubtract) {
                    isAddition = rand.nextBoolean();
                } else {
                    isAddition = canAdd;
                }
                int operand;
                if (isAddition) {
                    int maxOperand = maxNumber - tempValue;
                    operand = rand.nextInt(-1, maxOperand) + 1;
                    tempValue += operand;
                    question+= "+" + (operand);
                } else {
                    int maxOperand = tempValue;
                    operand = rand.nextInt(-1, maxOperand) + 1;
                    tempValue -= operand;
                    question += "-" + operand;
                }
            }

            answers[i] = tempValue;
            questions[i] = question;
        }
        return questions;
    }

    private boolean isInteger(JTextField textField) {
        try {
            int number = Integer.parseInt(textField.getText().trim());
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
