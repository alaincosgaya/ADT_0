/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.*;
import java.net.ConnectException;
import java.sql.*;
import java.util.*;


import model.*;

/**
 *
 * @author Idoia Ormaetxea
 */
public class DaoImplementation implements DaoInterface {

    private Connection con = null;
    private Properties prope;
    private PreparedStatement stmt = null;

    private ResourceBundle configFile;
    private String driverBD;
    private String urlDB;
    private String userBD;
    private String passwordBD;

    public DaoImplementation() {
        this.configFile = ResourceBundle.getBundle("control.config");
        this.driverBD = this.configFile.getString("Driver");
        this.urlDB = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

    public void conectar() throws DaoException {
        try {
            Class.forName(this.driverBD);
            con = DriverManager.getConnection(this.urlDB, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            throw new DaoException("Error en la SQL al conectar" + e.getMessage());
        } catch (ClassNotFoundException e1) {
            throw new DaoException("No se ha encontrado el driver para la conexion" + e1.getMessage());
        }
    }

    public void desconectar() throws DaoException {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new DaoException("Error de SQL " + e.getMessage());
        }
    }

    private final String createCustomer = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String consultCustomer = "SELECT customer.* FROM customer WHERE customer.id = ?";
    private final String consultAccounts = "SELECT account.* FROM customer_account, account WHERE customer_account.customers_id = ? AND customer_account.accounts_id = account.id";
    private final String createAccount = "INSERT INTO account VALUES (?,?,?,?,?,?,?)";
    private final String createCustomerAccount = "INSERT INTO customer_account VALUES (?,?)";
    private final String consultDataAccount = "SELECT account.* FROM account WHERE account.id = ?";
    private final String createMovement = "INSERT INTO movement VALUES (?,?,?,?,?,?)";
    private final String consultMovement = "SELECT movement.* FROM account, movement WHERE movement.account_id = account.id AND account.id = ?";


    @Override
    public void createCustomer(Customer cust) throws CreateException, ConnectException, DaoException {
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createCustomer);
            stmt.setInt(1, cust.getId());
            stmt.setString(2, cust.getFirstName());
            stmt.setString(3, cust.getLastName());
            stmt.setString(4, cust.getMiddleInitial());
            stmt.setString(5, cust.getStreet());
            stmt.setString(6, cust.getCity());
            stmt.setString(7, cust.getState());
            stmt.setInt(8, cust.getZip());
            stmt.setInt(9, cust.getPhone());
            stmt.setString(10, cust.getEmail());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new CreateException("Error al Crear");
        }
        this.desconectar();

    }

    @Override
    public Customer consultCustomer(int id) throws CreateException, ConnectException, DaoException {
        Customer cust = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultCustomer);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                cust = new Customer();
                cust.setId(id);
                cust.setFirstName(rs.getString("customer.firstName"));
                cust.setLastName(rs.getString("customer.lastName"));
                cust.setMiddleInitial(rs.getString("customer.middleInitial"));
                cust.setStreet(rs.getString("customer.street"));
                cust.setCity(rs.getString("customer.city"));
                cust.setState(rs.getString("customer.state"));
                cust.setZip(rs.getInt("customer.zip"));
                cust.setPhone(rs.getInt("customer.phone"));
                cust.setEmail(rs.getString("customer.email"));
            }

        } catch (Exception e) {
            throw new CreateException("Error al consultar");
        }
        this.desconectar();
        
        return cust;
    }

    @Override
    public Customer_account consultAccounts(int idCustom) throws CreateException, ConnectException, DaoException {
        
        Customer_account cust = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultAccounts);
            stmt.setInt(1, idCustom);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                cust = new Customer_account();
                cust.setIdCustom(idCustom);
                cust.setIdAccount(rs.getInt("customer_account.accounts_id"));
                
            }

        } catch (Exception e) {
            throw new CreateException("Error al consultar");
        }
        this.desconectar();
        
        return cust;
        
    }

    @Override
    public void createAccount(int id, Account account) throws CreateException, ConnectException, DaoException {
        
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createAccount);
            stmt.setInt(1, account.getId());
            stmt.setString(2, account.getDescription());
            stmt.setFloat(3, account.getBalance());
            stmt.setFloat(4, account.getCreditLine());
            stmt.setFloat(5, account.getBeginBalance());
            stmt.setDate(6, account.getBeginBalanceTimestamp());
            stmt.setString(7, account.getType().toString());

            stmt.executeUpdate();
            
            //stmt = con.prepareStatement(createCustomerAccount);
            //stmt.setInt(1, account.getId());
            //stmt.setInt(2, id);
            
            //stmt.executeUpdate();

        } catch (Exception e) {
            throw new CreateException("Error al Crear");
        }
        this.desconectar();
        
        createCustomerAccount(id, account);
    }
    
    @Override
    public void createCustomerAccount(int id, Account account) throws CreateException, ConnectException, DaoException {
        
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createCustomerAccount);
            stmt.setInt(1, id);
            stmt.setInt(2, account.getId());
            
            
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new CreateException("Error al Crear");
        }
        this.desconectar();
    }

    @Override
    public Account consultDataAccount(int id) throws CreateException, ConnectException, DaoException {
        
        Account account = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultDataAccount);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                account = new Account();
                account.setId(id);
                account.setDescription(rs.getString("account.description"));
                account.setBalance(rs.getFloat("account.balance"));
                account.setCreditLine(rs.getFloat("account.creditLine"));
                account.setBeginBalance(rs.getFloat("account.beginBalance"));
                account.setBeginBalanceTimestamp(rs.getDate("account.beginBalanceTimestamp"));
                account.setType(rs.getString("account.type"));
                
            }

        } catch (Exception e) {
            throw new CreateException("Error al consultar");
        }
        this.desconectar();
        
        return account;
    }

    @Override
    public void createMovement(Movement move) throws CreateException, ConnectException, DaoException {
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createMovement);
            stmt.setInt(1, move.getId());
            stmt.setInt(2, move.getIdAccount());
            stmt.setDate(3, move.getTimestamp());
            stmt.setFloat(4, move.getAmount());
            stmt.setFloat(5, move.getBalance());
            stmt.setString(6, move.getDescription());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new CreateException("Error al Crear");
        }
        this.desconectar();
    }

    @Override
    public Movement consultMovement(int id) throws CreateException, ConnectException, DaoException {
        Movement move = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoException e1) {
            throw new ConnectException(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultMovement);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                move = new Movement();
                move.setId(id);
                move.setIdAccount(rs.getInt("movement.idAccount"));
                move.setTimestamp(rs.getDate("movement.timestamp"));
                move.setAmount(rs.getFloat("movement.amount"));
                move.setBalance(rs.getFloat("movement.balance"));
                move.setDescription(rs.getString("movement.description"));
                
            }

        } catch (Exception e) {
            throw new CreateException("Error al consultar");
        }
        this.desconectar();
        
        return move;
    }

   

    

}
