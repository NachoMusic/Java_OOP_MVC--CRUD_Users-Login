/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.view.app_view;

/**
 *
 * @author nacho
 */
public class main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new app_view().setVisible(true);
            }
        }
        );
    }
}