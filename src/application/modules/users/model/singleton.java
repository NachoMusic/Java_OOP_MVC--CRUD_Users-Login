package application.modules.users.model;

import application.modules.admin.model.BLL.Arraylist_admin;
import application.modules.client.model.BLL.Arraylist_client;
import application.modules.registered.model.BLL.Arraylist_registered_user;
import application.modules.admin.model.pager.Pager;
import application.modules.client.model.pager.PagerC;
import application.modules.registered.model.pager.PagerR;

public class singleton {
	public static Arraylist_admin admins;
	public static Arraylist_client clients;
	public static Arraylist_registered_user registered_users;
        public static Pager pagerA;
        public static PagerC pagerC;
        public static PagerR pagerR;
}
