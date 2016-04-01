package application.modules.admin.model.models;

import application.modules.admin.model.BLL.Arraylist_admin;
import application.modules.admin.model.BLL.Arraylist_client;
import application.modules.admin.model.BLL.Arraylist_registered_user;
import application.modules.admin.model.pager.Pager;

public class singleton {
	public static Arraylist_admin admins;
	public static Arraylist_client clients;
	public static Arraylist_registered_user registered_users;
        public static Pager pager;
}
