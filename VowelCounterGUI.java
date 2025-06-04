import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VowelCounterGUI extends JFrame implements ActionListener {

    private JTextField inputField;
    private JTextField resultField;
    private JButton countButton, resetButton, exitButton;

    public VowelCounterGUI() {
        setTitle("Vowel Counter");
        setSize(500, 200); // Increased width
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Main panel with padding and vertical layout
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel inputLabel = new JLabel("Enter String:");
        JLabel resultLabel = new JLabel("Result:");

        inputField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        mainPanel.add(inputLabel);
        mainPanel.add(inputField);
        mainPanel.add(resultLabel);
        mainPanel.add(resultField);

        // Button panel
        countButton = new JButton("CountVowel");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        countButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        buttonPanel.add(countButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);

        // Add both panels to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = inputField.getText();
            int count = countVowels(text);
            resultField.setText(String.valueOf(count));
        } else if (e.getSource() == resetButton) {
            inputField.setText("");
            resultField.setText("");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private int countVowels(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new VowelCounterGUI();
    }
}
