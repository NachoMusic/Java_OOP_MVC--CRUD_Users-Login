/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.pager;

import application.modules.users.model.models.singleton;
import static application.modules.users.view.admin_view.combopage;
import static application.modules.users.view.admin_view.model;
import static application.modules.users.view.admin_view.movepage;
import static application.modules.users.view.admin_view.page;

/**
 *
 * @author nacho
 */
public class Pager {
    public static void updatetable2() {
        int maxpage = singleton.admins.size();
        
        if (movepage > maxpage) {
            movepage = maxpage;
        }
        if (maxpage < 10) {
            for (int i = 0; i < singleton.admins.size(); i++) {
                model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                    singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                    singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                    singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                    singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                    singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                    singleton.admins.getData(i).getActivity()
                });
            }
        } else {
            if (movepage - page < 0 || movepage < 0) {
                movepage = 10;
                page = 10;
                combopage.setSelectedIndex(0);
                for (int i = 0; i < 10; i++) {
                    model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                        singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                        singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                        singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                        singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                        singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                        singleton.admins.getData(i).getActivity()
                    });
                }
            }
            for (int i = (movepage - page); i < movepage; i++) {
                model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                    singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                    singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                    singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                    singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                    singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                    singleton.admins.getData(i).getActivity()
                });
            }
        }
    }
}
