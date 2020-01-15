package implementation.swing;

import view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private JTextArea text;

    public SwingMoneyDisplay() {
        super();
        text = new JTextArea("               ");
        text.setMinimumSize(new Dimension(200,100));
        text.setSize(200,100);
        add(text);
    }

    @Override
    public void setText(String number){
        text.setText(number);
    }
}
