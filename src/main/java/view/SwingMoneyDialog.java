package view;

import model.Currency;
import model.Money;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{
    List<Currency> currencyList;
    private JComboBox from;
    private JComboBox to;
    JTextField text;


    public SwingMoneyDialog(List<Currency> currencyList) {
        super();
        this.currencyList = currencyList;

        from = new JComboBox();
        to = new JComboBox();
        List<String> auxList = new ArrayList<String>();
        for(Currency i :currencyList){
            auxList.add(i.getCode());
        }
        Collections.sort(auxList);
        for(String i : auxList){
            from.addItem(i);
            to.addItem(i);
        }

        text = new JTextField(20);
        this.add(from);
        this.add(text);
        this.add(to);
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public String getText() {
        return text.getText();
    }

    public String getFrom() {
        return (String)from.getSelectedItem();
    }

    public String getTo() {
        return (String)to.getSelectedItem();
    }

    public Money get() {
        //currencyList.indexOf()
        //return new Money(text.getText(),(String)to.getSelectedItem());
        return null;
    }

    public Currency getTo2() {
        return null;
    }
}
