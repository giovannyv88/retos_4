/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Repositorios;

import Reto2_c4.Interfaces.itemInterfaz;
import Reto2_c4.Modelos.TablaProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovanny Vanegas
 */
@Repository
public class RepositorioItem {
    
    @Autowired
    private itemInterfaz crudItem;
    
    public List<TablaProducto> getItem() {
        return crudItem.findAll();        
    }
    
    public Optional<TablaProducto> getItem(String referencia) {
        return crudItem.findById(referencia);
        
    }
    
    public TablaProducto crearItem(TablaProducto item){
        return crudItem.save(item);
               
    }
    
    public void updateItem(TablaProducto item){
         crudItem.save(item);
    }
    
    public void borrarItem(TablaProducto item){
        crudItem.delete(item);
    }
    
    
      
}
