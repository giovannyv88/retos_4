/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Interfaces;

import Reto2_c4.Modelos.TablaProducto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Giovanny Vanegas
 */
public interface itemInterfaz extends MongoRepository<TablaProducto, String>{
    
}
