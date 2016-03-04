/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.pager;

import application.modules.users.model.models.singleton;
import static application.modules.users.view.admin_view.adminstable;
import static application.modules.users.view.admin_view.*;
import application.utils.Functions;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nacho
 */
public class Pager {
    public int maxpage;
    public int movepage;
    public int page;
    public static String selected;
    public static DefaultTableModel model;

    public Pager() {
        this.movepage=10;
        this.page=0;
    }
    
    public void updatetable2() {
        this.maxpage = singleton.admins.size();
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
    
    public void forward(){
        if (page < (singleton.admins.size() / this.movepage)) {
            page++;
        }
    }
    
    public void backwards(){
        if (page > 0) {
            page--;
        }
    }
    
    public void pagefield(){
        int prepage;
        prepage = Functions.validateInt(pagefield.getText()) - 1;
        if (prepage >= 0 && prepage < singleton.admins.size() / movepage) {
            page = prepage;
        }
    }
    
    public void pagenum(){//pruebas
        int num = (int)((maxpage/(movepage))+1), num1=1,num2=2,num3=3,num4=4,num5=5,num6=6,num7=7;
        if(num>7){
            num1=num-6;
            num2=num-5;
            num3=num-4;
            num4=num-3;
            num5=num-2;
            num6=num-1;
            num7=num;
            num = 7;
        }
        numtab7.setVisible(false);
        numtab6.setVisible(false);
        numtab5.setVisible(false);
        numtab4.setVisible(false);
        numtab3.setVisible(false);
        numtab2.setVisible(false);
        switch(num){
            case 7:
                numtab7.setText(String.valueOf(num7));
                numtab7.setVisible(true);
            case 6:
                numtab6.setText(String.valueOf(num6));
                numtab6.setVisible(true);  
            case 5:
                numtab5.setText(String.valueOf(num5));
                numtab5.setVisible(true);
            case 4:
                numtab4.setText(String.valueOf(num4));
                numtab4.setVisible(true);
            case 3:
                numtab3.setText(String.valueOf(num3));
                numtab3.setVisible(true);
            case 2:
                numtab2.setText(String.valueOf(num2));
                numtab2.setVisible(true);
            case 1:
                numtab1.setText(String.valueOf(num1));
                numtab1.setVisible(true);
        }
    }
    
    public void selectadmin(){
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
