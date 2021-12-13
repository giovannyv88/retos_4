/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Interfaces;

import Reto2_c4.Modelos.TablaPedidos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Giovanny Vanegas
 */
public interface pedidoInterfaz extends MongoRepository<TablaPedidos, Integer>{
    @Query("{'salesMan.zone':?0}")
    List <TablaPedidos> findBySalesManZone(String zona);
    
    @Query("{status: ?0}")
    List<TablaPedidos> findByStatus (final String estado);
    
    Optional<TablaPedidos> findTopByOrderByIdDesc();
      
}
