/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Interfaces;

import Reto2_c4.Modelos.TablaUser;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Giovanny Vanegas
 */
public interface userInterfaz extends MongoRepository<TablaUser, Integer>{
    
    Optional <TablaUser> findByEmail(String email);
    Optional <TablaUser> findByEmailAndPassword( String email, String password);
    Optional <TablaUser> findTopByOrderByIdDesc();
    List<TablaUser> findByMonthBirthtDay(String monthBirthtDay);
    
}
