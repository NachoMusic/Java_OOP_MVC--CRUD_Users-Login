package application.modules.admin.model.BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import application.models.SingletonF;
import static application.modules.admin.controller.admin_controller.updatetable;
import application.modules.admin.model.DAO.functions_users;
import application.modules.admin.model.models.admin;
import application.modules.users.model.singleton;
import application.utils.Functions;

public class Arraylist_admin {

    private ArrayList<admin> admins = new ArrayList<admin>();

    public Arraylist_admin() {
        //constructor
    }

    public ArrayList<admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<admin> admins) {
        this.admins = admins;
    }

    public void addData(admin a) {
        admin admin1 = a;
        boolean action = true;

        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).equals(admin1, 0)) {
                action = false;
            }
        }
        if (action) {
            admins.add(a);
        } else {
            JOptionPane.showMessageDialog(null, SingletonF.language.getProperty("dnierror"));
        }
    }

    public int size() {
        return admins.size();
    }

    public admin getData(int num) {
        return admins.get(num);
    }

    public void changeData() {
        try {
            int action = 0;
            String dni;
            int num = Functions.validateint(SingletonF.language.getProperty("adminchange"), SingletonF.language.getProperty("adminchange2"));

            dni = admins.get(num - 1).getDni();
            functions_users.getuser(admins.get(num - 1), 0);
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(num - 1).equals(admins.get(i), 0)) {
                    if (i != num - 1) {
                        action++;
                    }
                }
            }
            if (action != 0) {
                admins.get(num - 1).setDni(dni);
                JOptionPane.showMessageDialog(null, SingletonF.language.getProperty("dnierror"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, SingletonF.language.getProperty("doesntexist"));
        }
    }

    public void printArraylist() {
        int times = 0;

        for (int i = 0; i < admins.size(); i++) {
            JOptionPane.showMessageDialog(null, (i + 1) + ":\n" + admins.get(i).toString());
            times++;
        }
        if (times == 0) {
            JOptionPane.showMessageDialog(null, "No admins found");
        }
    }

    public void find(int option, String dniname) {
        admin admin1 = new admin();
        int times = 0;

        switch (option) {
            case 0://By dni
                admin1.setDni(dniname);
                for (int i = 0; i < admins.size(); i++) {
                    if (admins.get(i).equals(admin1, 0)) {
                        JOptionPane.showMessageDialog(null, admins.get(i).toString());
                        times++;
                    }
                }
                if (times == 0) {
                    JOptionPane.showMessageDialog(null, "No admins found");
                }
                break;
            case 1://By name
                admin1.setName(dniname);
                if ("".equals(dniname)) {
                    updatetable(0);
                }
                else {
                    updatetable(1);
                }
                for (int i = 0; i < admins.size(); i++) {
                    if (admins.get(i).equals(admin1, 1)) {
                        singleton.pagerA.printadmins(i);
                        times++;
                    }
                }
                break;
        }
    }

    public void changeFormatCurrency(char monedaAnterior) {
        try {
            for (int i = 0; i < admins.size(); i++) {
                admins.get(i).changeCurrency(monedaAnterior);
            }
        } catch (Exception e) {
        };
    }

    public void deleteData(int num) {
        try {
            admins.remove(num - 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The admin does not exist");
        }
    }
}
