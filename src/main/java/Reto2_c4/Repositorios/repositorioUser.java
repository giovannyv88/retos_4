/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Repositorios;

import Reto2_c4.Interfaces.userInterfaz;
import Reto2_c4.Modelos.TablaUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovanny Vanegas
 */
@Repository
public class repositorioUser {

    @Autowired
    private userInterfaz crudUser;

    public Optional<TablaUser> getUsuario(int id) {
        return crudUser.findById(id);
    }

    public List<TablaUser> getUsuarios() {
        return crudUser.findAll();

    }

    public TablaUser crearUsuario(TablaUser usuario) {
        return crudUser.save(usuario);
    }

    public boolean validarEmail(String email) {
        Optional<TablaUser> user = crudUser.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional<TablaUser> autenticarUsuario(String email, String password) {
        return crudUser.findByEmailAndPassword(email, password);

    }

    public void updateUser(TablaUser usuario) {
        crudUser.save(usuario);
    }
    
    public void borrarUsuario(TablaUser usuario){
        crudUser.delete(usuario);
    }
    
    public Optional <TablaUser> ultimoUser(){
        return crudUser.findTopByOrderByIdDesc();
    }
    

}
