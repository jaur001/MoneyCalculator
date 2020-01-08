package model;

public class Currency {
	public Currency(String code, String name, String symbol) {
		this.code = code;
		this.name = name;
		this.symbol = symbol;
	}

	public String getCode() {
		return code;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	private String code;
	private String name;
	private String symbol;
}
