package controller;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculateExchangeRate implements ActionListener, Command {
    private MainFrame frame;

    public CalculateExchangeRate(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String from = frame.getDialog().getFrom();
        String to = frame.getDialog().getTo();
        String amount = frame.getDialog().getText();
        if (amount.equals("")){
            frame.getDisplay().setText("Error: Write an amount to change");
            return;
        }
        String link = "https://free.currconv.com/api/v7/convert?apiKey=8d1e297c68e7dbb046b6&q=" + from + "_" + to + "&compact=ultra";
        try {
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = br.readLine();
            line = line.substring(11,line.length()-1);
            double exchangeRate = Double.valueOf(line);
            String result = Double.toString(Double.valueOf(amount) * exchangeRate);
            frame.getDisplay().setText(result);
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void execute() {
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(this);

        frame.add(BorderLayout.SOUTH,calculate);
    }
}
