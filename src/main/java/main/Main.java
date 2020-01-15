package main;

import controller.Command;
import controller.ExchangeRateCommand;
import implementation.WebsiteCurrenciesLoader;
import model.Currency;
import implementation.swing.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Currency> currencyList = new WebsiteCurrenciesLoader().load("https://free.currconv.com/api/v7/currencies?apiKey=8d1e297c68e7dbb046b6");
        final String link = "https://free.currconv.com/api/v7/convert?apiKey=8d1e297c68e7dbb046b6&q=_&compact=ultra";
        final MainFrame frame = new MainFrame("MainFrame",currencyList);
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExchangeRateCommand(frame,link).execute();
            }
        });
        frame.add(BorderLayout.SOUTH,calculate);

    }
}
