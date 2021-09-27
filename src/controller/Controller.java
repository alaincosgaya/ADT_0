/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelInterface;
import view.ViewInterface;

/**
 * El controlador que ejecuta la vista con los datos del modelo
 * @author 2dam
 */
public class Controller {
    /**
     * El metodo que muestra el saludo
     * @param view La vista que muestra los datos del modelo
     * @param model Lleva los datos a mostrar
     */
    public void run(ViewInterface view, ModelInterface model){
        String data;
        data = model.getGreeting();
        view.showGreeting(data);
    }
    
}
