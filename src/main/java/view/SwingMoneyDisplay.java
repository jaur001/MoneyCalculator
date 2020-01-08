package view;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JPanel {
    JTextArea text;

    public SwingMoneyDisplay() {
        super();
        text = new JTextArea("dfsadfsadfsadfsadf");
        text.setSize(200,100);
        add(text);
    }

    public void setText(String number){
        text.setText(number);
    }
}
