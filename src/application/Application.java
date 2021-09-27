/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controller.Controller;
import model.ModelFactory;
import view.ViewFactory;

/**
 *
 * @author Alain Cosgaya
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewFactory view = new ViewFactory();
        
        ModelFactory model = new ModelFactory();
        Controller controller = new Controller();
        controller.run(view.getView(),model.getModel());
        
        
    }
    
}
