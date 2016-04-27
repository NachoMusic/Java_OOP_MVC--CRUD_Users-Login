package application.models;

import application.modules.menu_config.model.Language;
import application.modules.menu_config.model.Config;
import application.mongodb.Mongo_DB;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class SingletonF {

    public static Config configApp;
    public static Language language;
    //mongo
    public static Mongo_DB mongo;
    public static Mongo client;
    public static String nom_bd;
    public static DB db;
    public static String nom_table;
    public static DBCollection collection;
    //User
    public static String typeconnected;
    public static String usernameConnected;
}
