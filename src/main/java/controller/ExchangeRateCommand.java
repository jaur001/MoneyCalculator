package controller;

import implementation.swing.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRateCommand implements Command {
    private MainFrame frame;
    private String link;

    public ExchangeRateCommand(MainFrame frame, String link) {
        this.frame = frame;
        this.link = link;
    }


    @Override
    public void execute() {
        /*
        En esta manera de obtener el exchange rate es innecesario usar la clase exchangeRate y money de por medio ya que
         el link trabaja con string diréctamente, que son sacados como string también diréctamente de la interfaz gráfica.
         Si lo usaramos sería para crearla y sacar luego la string de cada uno de los parametros, algo sin sentido.
        */
        String from = frame.getDialog().getFrom();
        String to = frame.getDialog().getTo();
        String amount = frame.getDialog().getText();
        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException nfe) {
            frame.getDisplay().setText("Error: Write an amount to change");
            return;
        }
        link = link.replace("_",from+"_"+to);

        try {
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = br.readLine();
            line = line.substring(11,line.length()-1);
            double exchangeRate = Double.parseDouble(line);
            String result = Double.toString(Double.parseDouble(amount) * exchangeRate);
            frame.getDisplay().setText(result);
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
