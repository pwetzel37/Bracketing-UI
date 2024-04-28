import javax.swing.*;

/**
 * Using the different models to create a bracket system.
 */
public class BracketSetup {
    public static void main(String[] args) {
        Wrestler bradenDavis = new Wrestler("Braeden Davis", "19-2", "PSU", 1);
        Wrestler lukeStanich = new Wrestler("Luke Stanich", "19-3", "LEH", 2);
        Wrestler drakeAyala = new Wrestler("Drake Ayala", "23-4", "IOWA", 3);
        Wrestler mattRamos = new Wrestler("Matt Ramos", "25-5", "PUR", 4);
        Wrestler[] wrestlers = {bradenDavis, lukeStanich, drakeAyala, mattRamos};

        JFrame frame = new JFrame("Bracket UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        frame.setSize(750,1000);
        frame.setLayout(null);

        JButton[] matchWinners = new JButton[3];
        for (int i = 0; i < matchWinners.length; i++) {
            matchWinners[i] = new JButton();
            matchWinners[i].setBounds((i < 2) ? 240 : 450, (i < 2) ? 45 + i * 80 : 85, 200, 30);
            int finalI = i;
            matchWinners[i].addActionListener(e -> matchWinners[finalI].setText(matchWinners[finalI].getText()));
            frame.add(matchWinners[i]);
        }

        JButton[] wrestlerButtons = new JButton[4];
        for (int i = 0; i < wrestlers.length; i++) {
            wrestlerButtons[i] = new JButton(wrestlers[i].toString());
            wrestlerButtons[i].setBounds(25, 25 + i * 40, 200, 30);
            int finalI = i;
            wrestlerButtons[i].addActionListener(e -> matchWinners[finalI / 2].setText(wrestlerButtons[finalI].getText()));
            frame.add(wrestlerButtons[i]);
        }

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(650, 15, 75, 20);
        resetButton.addActionListener(e -> {
            for (JButton matchWinner : matchWinners) matchWinner.setText("");
        });
        frame.add(resetButton);

        frame.setVisible(true);
    }

    private static void matchWinner(int matchIndex, JButton[] wrestlers, String winner) {
        if (matchIndex % 2 == 0)
            wrestlers[matchIndex / 2 + 2].setText(winner);
        else
            wrestlers[matchIndex / 2 + 1].setText(winner);
    }
}