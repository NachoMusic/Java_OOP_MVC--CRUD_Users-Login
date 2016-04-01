package application.modules.admin.model.models;

import java.util.Comparator;

public class sortbyAge implements Comparator <users>{
	public int compare(users arg0, users arg1) {
		if(arg0.getDate_birthday().compareTo(arg1.getDate_birthday())>0)
			return 1;
		if(arg0.getDate_birthday().compareTo(arg1.getDate_birthday())<0)
			return -1;
		return 0;
	}
}
