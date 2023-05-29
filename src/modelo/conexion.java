/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Andres
 */
public class conexion {
    private final String CadenaConexion;
    
    public conexion() {
        this.CadenaConexion = "jdbc:sqlserver://DESKTOP-UULH0KG\\D3V;database=Tienda;user=sa;password=12345;loginTimeout=30;encrypt=true;trustServerCertificate=true";
    }
    
    // metodo pendiente por mejorar.
    // crear un metodo para ralizar consultas solo enviando la query.
    public void getConnection(){
        
        System.out.println("modelo.conexion.getConnection()");
        System.out.println(this.CadenaConexion);
        
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(this.CadenaConexion);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * FROM Productos";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
