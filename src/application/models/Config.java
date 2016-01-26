package application.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("Config")
public class Config implements Serializable{
	@XStreamAlias("Clanguage_config")
	private String language_config;
	@XStreamAlias("currency_config")
	private char currency_config;
	@XStreamAlias("date_config")
	private int date_config;
	@XStreamAlias("decimals_config")
	private int decimals_config;
	@XStreamAlias("lookandfeel")
	private int lookandfeel;
	@XStreamAlias("savingextension")
	private String savingextension;
	
	public Config(int date_config, String language_config, char currency_config, int decimals_config, String savingextension, int lookandfeel) {
		super();
		this.date_config = date_config;// dd/mm/yyyy dd-mm-yyyy
		this.language_config = language_config;
		this.currency_config = currency_config;
		this.decimals_config = decimals_config;
		this.savingextension = savingextension;
		this.lookandfeel = lookandfeel;
	}
	public Config() {
		super();
		this.date_config = 0;// dd/mm/yyyy 
		this.language_config = "English";
		this.currency_config = '€';
		this.decimals_config = 2;
		this.savingextension = "json";
		this.lookandfeel = 0;
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
	public String getSavingextension() {
		return savingextension;
	}
	public void setSavingextension(String savingextension) {
		this.savingextension = savingextension;
	}
	public int getLookandfeel() {
		return lookandfeel;
	}
	public void setLookandfeel(int lookandfeel) {
		this.lookandfeel = lookandfeel;
	}
	
	@Override
	public String toString() {
		return "Config [date_config=" + date_config + ", language_config=" + language_config + ", currency_config="
				+ currency_config + ", decimals_config=" + decimals_config + "]";
	}
	
}
