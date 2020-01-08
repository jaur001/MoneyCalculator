package view;


import javax.swing.*;
import java.awt.*;

public class MainFrame2 extends JFrame {

    private SwingMoneyDisplay display;
    private SwingMoneyDialog dialog;

    public MainFrame2(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width, dim.height);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame2 frame = new MainFrame2("Administration");
    }


}
