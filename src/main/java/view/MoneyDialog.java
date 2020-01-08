package view;

import model.Currency;
import model.Money;

import javax.swing.*;

public interface MoneyDialog {
    Money get();
    Currency getTo2();
}
