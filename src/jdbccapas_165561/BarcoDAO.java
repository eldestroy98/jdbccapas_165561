/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;

import java.util.List;

/**
 *
 * @author Srneno
 */
public interface BarcoDAO {
    Barco find(String matricula) throws Exception;
    List<Barco> getAll() throws Exception;
    void add(Barco barco) throws Exception;
    void update(Barco barco)throws Exception;
    void delete(String matricula)throws Exception;
}
