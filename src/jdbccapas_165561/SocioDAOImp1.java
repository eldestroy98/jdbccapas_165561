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
 * @author lv1013
 */
public class SocioDAOImp1 implements SocioDAO{
    private final ConnectionFactory connectionFactory;
    public SocioDAOImp1(ConnectionFactory connectionFactory) {
        this.connectionFactory=connectionFactory;
    }
    
    @Override
    public Socio find(int id) throws Exception {
        final String sql="SELECT id,dni,nombre FROM socio WHERE id = ?";
        try(Connection connection=this.connectionFactory.getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);){
            statement.setInt(1,id);
            try(ResultSet resultSet= statement.executeQuery()){
                if(resultSet.next()){
                    return new Socio(resultSet.getInt("id"),resultSet.getString("dni"),resultSet.getString("nombre"));
                }
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Socio> getAll() throws Exception {
       
       List<Socio> todo = null;        
         String user="root";
         String password="operation7";
        
         Connection con= null;
        
        Statement statement=null;
        //este es para poner las cosas en sql
        
        ResultSet resultSet=null;
       Socio aux= new Socio();
        try{
            //direccion de la base de datos de servidor
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/socios?serverTimezone=UTC",user,password);
            //estado de la base de datos
            statement = con.createStatement();
            //codigo sql y se guardan las cosas en este mismo de los resultados
            resultSet=statement.executeQuery("SELECT * FROM socios");
            
            
            while(resultSet.next()){
                aux=null;
               //genera el socio, lo mete a la lista uno por uno en el ciclo
               
                 String id=resultSet.getString("id");
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                aux.setId(Integer.parseInt(id));
                aux.setNombre(nombre);
                aux.setdni(dni);
                
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
    public void add(Socio socio) throws Exception {
    String sql="insert into socios(dni,nombre) values (?,?)";
        try(
            Connection connection=this.connectionFactory.getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);){
             statement.setString(1,socio.getDni());
            statement.setString(2,socio.getNombre());

            int id= statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            }
        }    

    @Override
    public void update(Socio socio) throws Exception {
        final String sql="update socios set dni= ? ,nombre = ?   FROM socios WHERE id = ?";
        try(Connection connection=this.connectionFactory.getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);){
            statement.setString(1,socio.getDni());
            statement.setString(1,socio.getNombre());
            statement.setInt(1,socio.getId());
            
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
