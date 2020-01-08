package controller;

import loaders.WebsiteCurrenciesLoader;
import model.Currency;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebsiteCurrenciesLoader loader = new WebsiteCurrenciesLoader();
        List<Currency> currencyList = loader.load("https://free.currconv.com/api/v7/currencies?apiKey=8d1e297c68e7dbb046b6");
        MainFrame frame = new MainFrame("MainFrame",currencyList);
        new CalculateExchangeRate(frame).execute();

    }
}
