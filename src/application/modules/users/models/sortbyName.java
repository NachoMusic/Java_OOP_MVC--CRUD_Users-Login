package application.modules.users.models;

import java.util.Comparator;

public class sortbyName implements Comparator <users> {
	@Override
	public int compare(users arg0, users arg1) {
		if(arg0.getName().toUpperCase().compareTo(arg1.getName().toUpperCase())>0)
			return 1;
		if(arg0.getName().toUpperCase().compareTo(arg1.getName().toUpperCase())<0)
			return -1;
		return 0;
	}
}
