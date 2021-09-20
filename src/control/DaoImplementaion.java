/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.DaoException;
import java.net.ConnectException;
import java.util.ResourceBundle;
import javax.ejb.CreateException;
import model.Customer;

/**
 *
 * @author 2dam
 */
public class DaoImplementaion implements DaoInterface{
    private Dao dao = new Dao();

    private ResourceBundle configFile;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String contraBD;
    
    private final String createCustomer = "INSERT INTO customer(id,city,email,firstName,lastName,middleInitial,phone,state,street,zip) VALUES (?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void createCustomer(Customer cust, int Id, String firstName, String lastName, 
            String middleInitial, String street, String city, String state, int zip, 
            int phone, String email) throws CreateException, ConnectException {
        try {
			dao.con = dao.conectar();
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
                dao.desconectar(stmt, con);

	}
    }
}
