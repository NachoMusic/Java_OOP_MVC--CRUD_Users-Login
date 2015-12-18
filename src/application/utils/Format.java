package application.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

//1 2 o 3 decimales, euros dolares libras
public class Format {
	public static String format1decimal(float number){
		DecimalFormat format1 = new DecimalFormat(".#");
		return format1.format(number);
	}
	public static String format2decimals(float number){
		DecimalFormat format1 = new DecimalFormat(".##");
		return format1.format(number);
	}
	public static String format3decimals(float number){
		DecimalFormat format1 = new DecimalFormat(".###");
		return format1.format(number);
	}
	public static String formatEuro(float currency, int maxDecimals){
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.FRANCE);
		coin.setMaximumFractionDigits(maxDecimals);
		return coin.format(currency);
	}
	public static String formatDollar(float currency, int maxDecimals){
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.US);
		coin.setMaximumFractionDigits(maxDecimals);
		return coin.format(currency);
	}
	public static String formatLibra(float currency, int maxDecimals){
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.UK);
		coin.setMaximumFractionDigits(maxDecimals);
		return coin.format(currency);
	}
}
