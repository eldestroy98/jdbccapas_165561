/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author lv1013
 */
public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
    
    
    
}
