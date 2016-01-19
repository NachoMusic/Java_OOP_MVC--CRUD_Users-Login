package application.models;

public class Config {
	private String language_config;
	private char currency_config;
	private int date_config,decimals_config;
	
	public Config(int date_config, String language_config, char currency_config, int decimals_config) {
		super();
		this.date_config = date_config;// dd/mm/yyyy dd-mm-yyyy
		this.language_config = language_config;
		this.currency_config = currency_config;
		this.decimals_config = decimals_config;
	}
	public Config() {
		super();
		this.date_config = 0;// dd/mm/yyyy 
		this.language_config = "English";
		this.currency_config = '€';
		this.decimals_config = 2;
	}
	public int getDate_config() {
		return date_config;
	}
	public void setDate_config(int date_config) {
		this.date_config = date_config;
	}
	public String getLanguage_config() {
		return language_config;
	}
	public void setLanguage_config(String language_config) {
		this.language_config = language_config;
	}
	public char getCurrency_config() {
		return currency_config;
	}
	public void setCurrency_config(char currency_config) {
		this.currency_config = currency_config;
	}
	public int getDecimals_config() {
		return decimals_config;
	}
	public void setDecimals_config(int decimals_config) {
		this.decimals_config = decimals_config;
	}
	
	@Override
	public String toString() {
		return "Config [date_config=" + date_config + ", language_config=" + language_config + ", currency_config="
				+ currency_config + ", decimals_config=" + decimals_config + "]";
	}
	
}
