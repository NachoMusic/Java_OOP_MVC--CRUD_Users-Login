package application.modules.users.model.models;

import application.models.Config;
import application.modules.users.model.utils.Arraylist_admin;
import application.modules.users.model.utils.Arraylist_client;
import application.modules.users.model.utils.Arraylist_registered_user;

public class singleton {
	public static Arraylist_admin admins;
	public static Arraylist_client clients;
	public static Arraylist_registered_user registered_users;
	public static Config configApp;
}
