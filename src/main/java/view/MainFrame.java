package view;

import model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MainFrame extends JFrame {

    private SwingMoneyDisplay display;
    private  SwingMoneyDialog dialog;

    public MainFrame(String title, List<Currency> currencyList) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        dialog = new SwingMoneyDialog(currencyList);
        dialog.setPreferredSize(new Dimension(this.getSize().height/2,this.getSize().width/2));
        this.getContentPane().add(BorderLayout.NORTH,dialog);
        display = new SwingMoneyDisplay();
        display.setPreferredSize(new Dimension(this.getSize().height/2,this.getSize().width/2));
        this.getContentPane().add(BorderLayout.CENTER,display);
        setVisible(true);
    }

    public SwingMoneyDisplay getDisplay() {
        return display;
    }

    public SwingMoneyDialog getDialog() {
        return dialog;
    }
}
