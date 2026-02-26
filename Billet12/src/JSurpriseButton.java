import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JSurpriseButton extends JButton {
    private static int amountOfTries;
    private boolean withSurprise;
    public JSurpriseButton(String text, boolean withSurprise, JFrame frame) {
        super(text);
        this.withSurprise = withSurprise;
        amountOfTries = 0;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(amountOfTries < 3) {
                    amountOfTries++;
                    if (withSurprise) {
                        JOptionPane.showMessageDialog(frame, "Урааааа!!! Ви вгадали!!! Ваш приз - 40 балів за екзамен з програмування", "Успіх", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "На жаль, Ви не вгадали", "Помилка!!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Схоже, що в вас закінчились спроби, перезапустіть програму, щоб розпочати заново", "Кінець спроб", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
