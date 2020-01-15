package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import view.persistance.CurrenciesLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import model.Currency;

public class WebsiteCurrenciesLoader implements CurrenciesLoader {

	@Override
	public List<Currency> load(String link) {
		List<Currency> currencyList = new ArrayList<Currency>();
		String json = correctJSON(link);
		JSONObject obj = new JSONObject(json);
		JSONArray array = obj.getJSONArray("results");
		JSONObject currencyJSON = array.getJSONObject(0);
		Set<String> currenciesSet = currencyJSON.keySet();
		String currencySymbol;
		String currencyName = "";
		String id = "";
		for (String i : currenciesSet) {
			try {
				currencyName = currencyJSON.getJSONObject(i).getString("currencyName");
				id = currencyJSON.getJSONObject(i).getString("id");
				currencySymbol = currencyJSON.getJSONObject(i).getString("currencySymbol");
			} catch (Exception e){
				currencySymbol = "";
			}
			currencyList.add(new Currency(id,currencyName,currencySymbol));
		}
		return currencyList;
	}

	private String correctJSON(String link) {
		BufferedReader br;

		try {

			URL url = new URL(link);
			br = new BufferedReader(new InputStreamReader(url.openStream()));

			String line = br.readLine();
			line = line.replace("{\"results\":{","{\"results\":[{");
			line = line.replace("}}}","}}]}");
			br.close();
			return line;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
