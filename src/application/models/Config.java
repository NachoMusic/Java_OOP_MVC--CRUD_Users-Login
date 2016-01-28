package application.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import application.modules.users.model.BLL.Arraylist_admin;
import application.modules.users.model.BLL.Arraylist_client;
import application.modules.users.model.BLL.Arraylist_registered_user;
import application.modules.users.model.models.singleton;

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
		this.date_config = date_config;// dd/mm/yyyy dd-mm-yyyy
		this.language_config = language_config;
		this.currency_config = currency_config;
		this.decimals_config = decimals_config;
		this.savingextension = savingextension;
		this.lookandfeel = lookandfeel;
	}
	public Config() {
		this.date_config = 0;// dd/mm/yyyy 
		this.language_config = "English";
		this.currency_config = '€';
		this.decimals_config = 2;
		this.savingextension = "json";
		this.lookandfeel = 0;
		
		//dummies
		
		singleton.admins = new Arraylist_admin();
		singleton.clients = new Arraylist_client();
		singleton.registered_users = new Arraylist_registered_user();
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
