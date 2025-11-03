import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ARITHMETIC_GAME_CALCULATOR extends JFrame {

    private JLabel questionLabel, feedbackLabel, scoreLabel, timerLabel, difficultyLabel;
    private JTextField answerField;
    private JButton submitButton, nextButton;
    private JRadioButton addButton, subButton, mulButton, divButton;
    private JComboBox<String> difficultyBox;
    private ButtonGroup operationGroup;

    private int score = 0;
    private int num1, num2, correctAnswer;
    private char operator = '+';
    private int timeLeft = 20; // 20 seconds per item
    private Random rand = new Random();
    private Timer timer;

    public ARITHMETIC_GAME_CALCULATOR() {
        setTitle("Arithmetic Game Calculator");
        setSize(480, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(43, 43, 43)); // calculator-like color

        // === TOP: Score + Timer ===
        JPanel infoPanel = new JPanel(new GridLayout(1, 2));
        infoPanel.setBackground(new Color(60, 60, 60));

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scoreLabel.setForeground(Color.WHITE);

        timerLabel = new JLabel("Time: 20", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        timerLabel.setForeground(Color.WHITE);

        infoPanel.add(scoreLabel);
        infoPanel.add(timerLabel);
        add(infoPanel, BorderLayout.NORTH);

        // === LEFT: Operation Selection ===
        JPanel operationPanel = new JPanel(new GridLayout(5, 1));
        operationPanel.setBackground(new Color(70, 70, 70));
        operationPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            "Operation",
            0, 0, new Font("Arial", Font.BOLD, 12), Color.WHITE));

        addButton = new JRadioButton("Addition (+)");
        subButton = new JRadioButton("Subtraction (-)");
        mulButton = new JRadioButton("Multiplication (×)");
        divButton = new JRadioButton("Division (÷)");

        JRadioButton[] ops = {addButton, subButton, mulButton, divButton};
        operationGroup = new ButtonGroup();
        for (JRadioButton btn : ops) {
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(70, 70, 70));
            operationGroup.add(btn);
            operationPanel.add(btn);
        }
        addButton.setSelected(true);
        add(operationPanel, BorderLayout.WEST);

        ActionListener opListener = e -> {
            if (addButton.isSelected()) operator = '+';
            else if (subButton.isSelected()) operator = '-';
            else if (mulButton.isSelected()) operator = '*';
            else if (divButton.isSelected()) operator = '/';
            newQuestion();
        };
        addButton.addActionListener(opListener);
        subButton.addActionListener(opListener);
        mulButton.addActionListener(opListener);
        divButton.addActionListener(opListener);

        // === CENTER: Question + Feedback + Difficulty ===
        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.setBackground(new Color(43, 43, 43));

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 28));
        questionLabel.setForeground(Color.WHITE);

        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        feedbackLabel.setForeground(Color.LIGHT_GRAY);

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setBackground(new Color(43, 43, 43));
        difficultyLabel = new JLabel("Difficulty: ");
        difficultyLabel.setForeground(Color.WHITE);
        String[] levels = {"Easy (1–10)", "Medium (1–50)", "Hard (1–100)"};
        difficultyBox = new JComboBox<>(levels);
        difficultyBox.setBackground(new Color(70, 70, 70));
        difficultyBox.setForeground(Color.WHITE);
        difficultyBox.setFont(new Font("Arial", Font.PLAIN, 12));

        difficultyPanel.add(difficultyLabel);
        difficultyPanel.add(difficultyBox);

        centerPanel.add(questionLabel);
        centerPanel.add(feedbackLabel);
        centerPanel.add(difficultyPanel);

        add(centerPanel, BorderLayout.CENTER);

        // === BOTTOM: Answer Controls ===
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(60, 60, 60));

        answerField = new JTextField(6);
        submitButton = new JButton("Submit");
        nextButton = new JButton("Next");

        submitButton.setBackground(new Color(0, 120, 215));
        submitButton.setForeground(Color.WHITE);

        nextButton.setBackground(new Color(100, 100, 100));
        nextButton.setForeground(Color.WHITE);

        bottomPanel.add(new JLabel("Your Answer: "));
        bottomPanel.add(answerField);
        bottomPanel.add(submitButton);
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> checkAnswer());
        nextButton.addActionListener(e -> newQuestion());

        // === Timer ===
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft);
            if (timeLeft <= 0) {
                feedbackLabel.setText("⏰ Time's up! Correct: " + correctAnswer);
                timer.stop(); // stop timer until next question
            }
        });

        timer.start();
        newQuestion();
        setVisible(true);
    }

    private void newQuestion() {
        timeLeft = 20; // reset timer only when pressing Next
        timerLabel.setText("Time: " + timeLeft);
        timer.restart();

        int range = getRangeFromDifficulty();
        num1 = rand.nextInt(range) + 1;
        num2 = rand.nextInt(range) + 1;

        if (operator == '/' && num2 == 0) num2 = 1;

        switch (operator) {
            case '+': correctAnswer = num1 + num2; break;
            case '-': correctAnswer = num1 - num2; break;
            case '*': correctAnswer = num1 * num2; break;
            case '/': correctAnswer = num1 / num2; break;
        }

        questionLabel.setText(num1 + " " + operator + " " + num2 + " = ?");
        feedbackLabel.setText("");
        answerField.setText("");
    }

    private int getRangeFromDifficulty() {
        String selected = (String) difficultyBox.getSelectedItem();
        if (selected.contains("Easy")) return 10;
        if (selected.contains("Medium")) return 50;
        if (selected.contains("Hard")) return 100;
        return 10;
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerField.getText());
            if (userAnswer == correctAnswer) {
                feedbackLabel.setText("✅ Correct!");
                score += 1;
            } else {
                feedbackLabel.setText("❌ Wrong! Correct: " + correctAnswer);
            }
            scoreLabel.setText("Score: " + score);
            timer.stop(); // stop timer after submitting
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("⚠️ Enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new ARITHMETIC_GAME_CALCULATOR();
    }
}
