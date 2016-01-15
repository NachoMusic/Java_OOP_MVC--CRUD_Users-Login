package application.modules.users.models;

import java.util.Comparator;

public class sortbyAge implements Comparator <admin>{
	public int compare(admin arg0, admin arg1) {
		if(arg0.getDate_birthday().compareTo(arg1.getDate_birthday())>0)
			return 1;
		if(arg0.getDate_birthday().compareTo(arg1.getDate_birthday())<0)
			return -1;
		return 0;
	}
}
