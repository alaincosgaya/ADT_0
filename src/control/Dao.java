/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.DaoException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.ejb.CreateException;
import model.Customer;

/**
 *
 * @author 2dam
 */
public class Dao implements DaoInterface{
    
    private Connection con = null;
    private Properties prope;
    private PreparedStatement stmt = null;
    
    private ResourceBundle configFile;
    private String driverBD;
    private String urlDB;
    private String userBD;
    private String passwordBD;
    
    public Dao(){
        this.configFile = ResourceBundle.getBundle("control.config");
        this.driverBD = this.configFile.getString("Driver");
        this.urlDB = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }
    
    public void conectar() throws DaoException{
        try{
            Class.forName(this.driverBD);
            con = DriverManager.getConnection(this.urlDB, this.userBD, this.passwordBD);
        }catch(SQLException e){
            throw new DaoException("Error en la SQL al conectar"+ e.getMessage());
        }catch(ClassNotFoundException e1){
            throw new DaoException("No se ha encontrado el driver para la conexion"+ e1.getMessage());
        }
    }
    public void desconectar() throws DaoException{
        try{
            if(stmt !=null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
        }catch(SQLException e){
            throw new DaoException ("Error de SQL "+ e.getMessage());
        }
    }
    
    
    private final String createCustomer = "INSERT INTO customer(id,city,email,firstName,lastName,middleInitial,phone,state,street,zip) VALUES (?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void createCustomer(Customer cust, int Id, String firstName, String lastName, 
            String middleInitial, String street, String city, String state, int zip, 
            int phone, String email) throws CreateException, ConnectException {
        try {
			con = conectar();
		} catch (DaoException e1) {
			throw new ConnectException(e1.getMessage());
		}
		try {
			stmt = con.prepareStatement(createCustomer);
			stmt.setInt(1, Id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, middleInitial);
			stmt.setString(5, street);
                        stmt.setString(6, city);
                        stmt.setString(7, state);
                        stmt.setInt(8, zip);
                        stmt.setInt(9, phone);
                        stmt.setString(10, email);

			stmt.executeUpdate();

		} catch (Exception e) {
			throw new CreateException("Error al Crear");
		}
                desconectar(stmt, con);

	}
    
}
