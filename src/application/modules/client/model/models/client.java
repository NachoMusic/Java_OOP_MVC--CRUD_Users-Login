package application.modules.client.model.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import application.modules.menu_config.model.Config;
import application.models.Dates;
import application.modules.users.model.users;
import application.utils.Format;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@SuppressWarnings("serial")
@XStreamAlias("client")
public class client extends users {

    @XStreamAlias("discharge_date")
    private String discharge_date;
    @XStreamAlias("client_type")
    private String client_type;
    @XStreamAlias("years_service")
    private int years_service;
    @XStreamAlias("shopping")
    private float shopping;
    @XStreamAlias("premium")
    private boolean premium;

    //constructor
    //fechaRegistro string, antiguedad int, compras float, premium boolean, client_type
    public client(String dni, String name, String subname, String phone_number, String email, String user, String pass,
            String avatar, String state, String date_birthday, String discharge_date,
            String client_type, float shopping, boolean premium) {
        super(dni, name, subname, phone_number, email, user, pass, avatar, state, date_birthday);
        this.discharge_date = discharge_date;
        this.client_type = client_type;
        this.shopping = shopping;
        this.premium = premium;
        this.years_service = calculate_years_of_service(discharge_date);
        super.setDiscount((int) calculate_advantages());
    }

    public client() {
        super();
    }
    //Constructor a petici�n de usuario

    public client(int i, Object option) {
        switch (i) {
            case 0:
                this.discharge_date = (String) option;
                break;
            case 1:
                this.client_type = (String) option;
                break;
            case 2:
                this.years_service = (int) option;
                break;
            case 4:
                this.shopping = (float) option;
                break;
            case 5:
                this.premium = (boolean) option;
                break;
        }
    }
    //Getters&setters

    public String getDischarge_date() {
        return discharge_date;
    }

    public void setDischarge_date(String discharge_date) {
        this.discharge_date = discharge_date;
        this.years_service = calculate_years_of_service(discharge_date);
        super.setDiscount((int) this.calculate_advantages());
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public int getYears_service() {
        return years_service;
    }

    public float getShopping() {
        return shopping;
    }

    public void setShopping(float shopping) {
        this.shopping = shopping;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    //to string

    public String toString(Config arg) {
        String cad = "";

        cad += super.toString() + "\n";
        cad += "Discharge date: " + this.getDischarge_date() + "\n";
        cad += "Discount: " + this.getDiscount() + "%\n";
        cad += "Client type: " + this.getClient_type() + "\n";
        cad += "Years of service: " + this.getYears_service() + "\n";
        cad += "Shopping: " + Format.formatEuro(this.getShopping(), arg.getDecimals_config()) + "\n";
        cad += "Premium: " + this.isPremium() + "\n";
        return cad;
    }
    //to string clave primaria

    public String toString(String dni) {
        return super.toString(dni);
    }
    //to String a petici�n de usuario

    public String toString(int i) {
        String cad = "";
        switch (i) {
            case 0:
                cad += this.getDischarge_date() + "\n";
                break;
            case 1:
                cad += this.getDiscount() + "\n";
                break;
            case 2:
                cad += this.getClient_type() + "\n";
                break;
            case 3:
                cad += this.getYears_service() + "\n";
                break;
            case 4:
                cad += this.getShopping() + "\n";
                break;
            case 5:
                cad += this.isPremium() + "\n";
                break;
        }
        return cad;
    }

    @Override
    public float calculate_advantages() {
        return (float) (getYears_service() * 1.5);
    }

    public int calculate_years_of_service(String date) {
        Dates date1 = new Dates(date);
        return date1.timeBetweetDates(date1.DateToCalendar(), date1.SystemDate(), 1);
    }

    public client DB_to_client(DBObject dBObjectWorker) {
        super.setDni((String) dBObjectWorker.get("dni"));
        super.setName((String) dBObjectWorker.get("name"));
        super.setSubname((String) dBObjectWorker.get("subname"));
        super.setPhone_number((String) dBObjectWorker.get("phone_number"));
        super.setEmail((String) dBObjectWorker.get("email"));
        super.setUser((String) dBObjectWorker.get("user"));
        super.setPass((String) dBObjectWorker.get("pass"));
        super.setAvatar((String) dBObjectWorker.get("avatar"));
        super.setState((String) dBObjectWorker.get("state"));
        super.setDate_birthday((String) dBObjectWorker.get("date_birthday"));
        super.setAge((int) dBObjectWorker.get("age"));
        this.setDischarge_date((String) dBObjectWorker.get("discharge_date"));
        this.setClient_type((String) dBObjectWorker.get("client_type"));
        this.setShopping(Float.parseFloat((Double) dBObjectWorker.get("shopping")+""));
        this.setPremium((boolean) dBObjectWorker.get("premium"));
        return new client(super.getDni(), super.getName(), super.getSubname(), super.getPhone_number(),
                super.getEmail(), super.getUser(), super.getPass(), super.getAvatar(), super.getState(),
                super.getDate_birthday(), this.getDischarge_date(), this.getClient_type(), this.getShopping(),
                this.isPremium());
    }

    public BasicDBObject client_to_BD() {
        BasicDBObject dBObjectWorker = new BasicDBObject();
        dBObjectWorker.append("dni", this.getDni());
        dBObjectWorker.append("name", this.getName());
        dBObjectWorker.append("subname", this.getSubname());
        dBObjectWorker.append("phone_number", this.getPhone_number());
        dBObjectWorker.append("email", this.getEmail());
        dBObjectWorker.append("user", this.getUser());
        dBObjectWorker.append("pass", this.getPass());
        dBObjectWorker.append("avatar", this.getAvatar());
        dBObjectWorker.append("state", this.getState());
        dBObjectWorker.append("date_birthday", this.getDate_birthday());
        dBObjectWorker.append("age", this.getAge());
        dBObjectWorker.append("discharge_date", this.getDischarge_date());
        dBObjectWorker.append("client_type", this.getClient_type());
        dBObjectWorker.append("shopping", this.getShopping());
        dBObjectWorker.append("premium", this.isPremium());
        return dBObjectWorker;
    }

}
