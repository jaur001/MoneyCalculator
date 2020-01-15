package view.persistance;

import java.util.List;

import model.Currency;
import model.ExchangeRate;

public interface CurrenciesLoader {
	List<Currency> load(String link);

}
