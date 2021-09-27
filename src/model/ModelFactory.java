/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ResourceBundle;

/**
 *
 * @author Idoia
 */
public class ModelFactory {
    private ResourceBundle data;
    
    
    public  ModelInterface getModel(){
       ModelInterface model = new ModelFileImplementation();
       return model;
    }
    
}
