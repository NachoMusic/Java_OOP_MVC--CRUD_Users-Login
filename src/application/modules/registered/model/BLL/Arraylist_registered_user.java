package application.modules.registered.model.BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import application.modules.admin.model.DAO.functions_users;
import application.modules.admin.model.models.admin;
import application.modules.registered.model.models.registered_user;
import application.utils.Functions;

public class Arraylist_registered_user {

    private ArrayList<registered_user> registered_users = new ArrayList<registered_user>();

    public Arraylist_registered_user() {
        //constructor
    }
    
    public ArrayList<registered_user> getRegistered() {
        return registered_users;
    }
    
    public int size() {
        return registered_users.size();
    }
    
    public void addData(registered_user a) {
        registered_user registered_user1 = a;
        boolean action = true;

        for (int i = 0; i < registered_users.size(); i++) {
            if (registered_users.get(i).equals(registered_user1, 0)) {
                action = false;
            }
        }
        if (action) {
            registered_users.add(a);
        } else {
            JOptionPane.showMessageDialog(null, "There is already a user with the same DNI");
        }
    }

    public registered_user getData(int num) {
        return registered_users.get(num);
    }

    public void changeData() {
        try {
            int action = 0;
            String dni;
            int num = Functions.validateint("Type the number of"
                    + " the admin to change", "Change users");

            dni = registered_users.get(num - 1).getDni();
            functions_users.getuser(registered_users.get(num - 1), 0);
            for (int i = 0; i < registered_users.size(); i++) {
                if (registered_users.get(num - 1).equals(registered_users.get(i), 0)) {
                    if (i != num - 1) {
                        action++;
                    }
                }
            }
            if (action != 0) {
                registered_users.get(num - 1).setDni(dni);
                JOptionPane.showMessageDialog(null, "There is already a user with that DNI");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The admin does not exist");
        }
    }

    public void printArraylist() {
        int times = 0;

        for (int i = 0; i < registered_users.size(); i++) {
            JOptionPane.showMessageDialog(null, (i + 1) + ":\n" + registered_users.get(i).toString());//I removed config from it
            times++;
        }
        if (times == 0) {
            JOptionPane.showMessageDialog(null, "No admins found");
        }
    }

    public registered_user find(int option, String param) {
        admin admin1 = new admin();
        registered_user usreg = new registered_user();
        int times = 0;

        switch (option) {
            case 0://By dni
                admin1.setDni(param);
                for (int i = 0; i < registered_users.size(); i++) {
                    if (registered_users.get(i).equals(admin1, 0)) {
                        JOptionPane.showMessageDialog(null, registered_users.get(i).toString());// I removed config from it
                        times++;
                    }
                }
                if (times == 0) {
                    JOptionPane.showMessageDialog(null, "No user found");
                }
                break;
            case 1://By name
                admin1.setName(param);
                for (int i = 0; i < registered_users.size(); i++) {
                    if (registered_users.get(i).equals(admin1, 1)) {
                        JOptionPane.showMessageDialog(null, registered_users.get(i).toString());//I removed config from it
                        times++;
                    }
                }
                if (times == 0) {
                    JOptionPane.showMessageDialog(null, "No user found");
                }
                break;
            case 2://By username
                admin1.setUser(param);
                for (int i = 0; i < registered_users.size(); i++) {
                    if (registered_users.get(i).equals(admin1, 2)) {
                        usreg = registered_users.get(i);
                        times++;
                    }
                }
                break;
        }
        return usreg;
    }

    public void deleteData(int i) {
        try {
            registered_users.remove(i - 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The registered user does not exist");
        }
    }
}
