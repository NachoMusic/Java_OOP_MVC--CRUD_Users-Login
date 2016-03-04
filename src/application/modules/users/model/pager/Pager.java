/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.pager;

import application.modules.users.model.models.singleton;
import application.modules.users.view.admin_view;
import static application.modules.users.view.admin_view.adminstable;
import static application.modules.users.view.admin_view.*;
import static application.modules.users.view.admin_view.model;
import static application.modules.users.view.admin_view.movepage;
import static application.modules.users.view.admin_view.page;
import static application.modules.users.view.admin_view.selected;
import application.utils.Functions;

/**
 *
 * @author nacho
 */
public class Pager {
    public static int maxpage;
    public static void updatetable2() {
        maxpage = singleton.admins.size();
        int translatedpage = 0;

        if (maxpage < movepage) //SI HAY MENOS ADMINS QUE NUM PAGINACIÓN 
            for (int i = 0; i < singleton.admins.size(); i++) 
                printadmins(i);
        else {  //SI HAY MÁS ADMINS QUE NUM PAGINACIÓN 
            if (page == 0)
                translatedpage = 0;
            else 
                translatedpage = page * movepage;          
            if ((translatedpage + movepage) >= maxpage) 
                for (int i = translatedpage; i < singleton.admins.size(); i++)
                    printadmins(i);               
            else
                for (int i = translatedpage; i < translatedpage + movepage; i++) 
                    printadmins(i);                          
        }
        pagefield.setText(String.valueOf(page+1)+"/"+(int)((maxpage/(movepage))+1));
    }
    
    public static void printadmins(int i){
        model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                    singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                    singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                    singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                    singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                    singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                    singleton.admins.getData(i).getActivity()
                });
    }
    
    public static void forward(){
        if (page < (singleton.admins.size() / movepage)) {
            page++;
        }
    }
    
    public static void backwards(){
        if (page > 0) {
            page--;
        }
    }
    
    public static void pagefield(){
        int prepage;
        prepage = Functions.validateInt(pagefield.getText()) - 1;
        if (prepage >= 0 && prepage < singleton.admins.size() / movepage) {
            page = prepage;
        }
    }
    
    public static void pagenum(){//pruebas
        int num = (int)(maxpage/(movepage))+1;
        if(num<8){
            if(num==1){
                numtab1.setText("1");
                numtab1.setVisible(true);
            }
            if(num==2){
                numtab1.setText("1");
                numtab1.setVisible(true);
                numtab2.setText("2");
                numtab2.setVisible(true);
            }
        }

    }
    
    public static void selectadmin(){
        selected = String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 0));
        dniform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 1)));
        nameform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 2)));
        surnameform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 3)));
        phoneform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 4)));
        emailform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 5)));
        userform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 6)));
        stateform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 7)));
        birthdayform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 8)));
        ageform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 9)));
        hiringdateform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 10)));
        salaryform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 11)));
        activityform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 12)));
    }
}
