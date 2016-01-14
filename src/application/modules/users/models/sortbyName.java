package application.modules.users.models;

import java.util.Comparator;

public class sortbyName implements Comparator <admin> {
	@Override
	public int compare(admin arg0, admin arg1) {
		if(arg0.getName().toUpperCase().compareTo(arg1.getName().toUpperCase())>0)
			return 1;
		if(arg0.getName().toUpperCase().compareTo(arg1.getName().toUpperCase())<0)
			return -1;
		return 0;
	}
}
