/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Srneno
 */
public class BarcoDAOImp1 implements BarcoDAO{
    private final ConnectionFactory connectionFactory;
   
    public BarcoDAOImp1(ConnectionFactory connectionFactory) {
        this.connectionFactory=connectionFactory;
    }
    
    
    @Override
    public List<Barco> getAll() throws Exception {
        
        List<Barco> todo = null;        
         String user="root";
         String password="operation7";
        
         Connection con= null;
        
        Statement statement=null;
        //este es para poner las cosas en sql
        
        ResultSet resultSet=null;
       Barco aux= new Barco();
        try{
            //direccion de la base de datos de servidor
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Barcos?serverTimezone=UTC",user,password);
            //estado de la base de datos
            statement = con.createStatement();
            //codigo sql y se guardan las cosas en este mismo de los resultados
            resultSet=statement.executeQuery("SELECT * FROM barcos");
            
            
            while(resultSet.next()){
                aux=null;
               //genera el socio, lo mete a la lista uno por uno en el ciclo
               
                 String matricula=resultSet.getString("id");
                 String nombre = resultSet.getString("nombre");
                 int amarre = resultSet.getInt("amarre");
                 int cuota= resultSet.getInt("cuota");
                aux.setMatricula((matricula));
                aux.setNombre(nombre);
                aux.setAmarre(amarre);
                aux.setCuota(cuota);
                
                todo.add(aux);
                
            }
           
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
           
            
           //finalmente cuando uses cualquier de estos se tiene que cerrar las conexiones
            if(resultSet!=null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
            if(con!=null){
                try{
                    con.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }}
             //regresa la lista
                return todo;    
    }

    @Override
    public Barco find(String matricula) throws Exception {
         final String sql="SELECT matricula,nombre,amarre,cuota FROM socio WHERE matricula = ?";
        try(Connection connection=this.connectionFactory.getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);){
            statement.setString(1,matricula);
            try(ResultSet resultSet= statement.executeQuery()){
                if(resultSet.next()){
                    return new Barco(resultSet.getString(""),resultSet.getString("nombre"),resultSet.getInt("amarre"),resultSet.getInt("cuota"));
                }
            }
        }
        return null;
        
        
    }

    @Override
    public void add(Barco barco) throws Exception {
        String sql="insert into barcos(nombre,amarre,cuota) values (?,?,?)";
        try(
            Connection connection=this.connectionFactory.getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);){
            
            statement.setString(2,barco.getNombre());
             statement.setInt(1,barco.getAmarre());
              statement.setInt(1,barco.getCuota());
            int matricula= statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                
            }
    }

    @Override
    public void update(Barco barco) throws Exception {
         final String sql="update barcos set nombre = ?, amarre= ? , cuota= ?   FROM barcos HERE matricula = ?";
        try(Connection connection=this.connectionFactory.getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);){
            
            statement.setString(1,barco.getNombre());
            statement.setInt(1,barco.getAmarre());
            statement.setInt(1,barco.getCuota());
            
            statement.setString(1, barco.getMatricula());
            
            
    }
    }
    @Override
    public void delete(String matricula) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
