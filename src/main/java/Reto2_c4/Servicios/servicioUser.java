/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Servicios;

import Reto2_c4.Modelos.TablaUser;
import Reto2_c4.Repositorios.repositorioUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovanny Vanegas
 */
@Service
public class servicioUser {

    @Autowired
    private repositorioUser repoUser;

    public List<TablaUser> getUsuarios() {
        return repoUser.getUsuarios();
    }
    
    public Optional<TablaUser> getUsuario(int id) {
        return repoUser.getUsuario(id);
    }
    
    
    
    public boolean validarEmail(String email) {
        return repoUser.validarEmail(email);
    }

    public TablaUser autenticarUsuario(String email, String password) {
        Optional<TablaUser> usuario = repoUser.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new TablaUser();
        } else {
            return usuario.get();

        }
    }
    
    public TablaUser crearUsuario(TablaUser usuario) {
        if (usuario.getId() == null) {
            return usuario;
        } else {
            Optional<TablaUser> usuarios = repoUser.getUsuario(usuario.getId());
            if (usuarios.isEmpty()) {
                if (validarEmail(usuario.getEmail()) == false) {
                    return repoUser.crearUsuario(usuario);
                } else {
                    return usuario;
                }
            } else {
                return usuario;
            }
        }
    }

    
 
    
    public TablaUser usuarioUpdate(TablaUser usuario) {

        if (usuario.getId() != null) {
            Optional<TablaUser> upUsuario = repoUser.getUsuario(usuario.getId());
            if (!upUsuario.isEmpty()) {
                if (usuario.getIdentification() != null) {
                    upUsuario.get().setIdentification(usuario.getIdentification());
                }
                if (usuario.getName() != null) {
                    upUsuario.get().setName(usuario.getName());
                }
                if (usuario.getAddress() != null) {
                    upUsuario.get().setAddress(usuario.getAddress());
                }
                if (usuario.getCellPhone() != null) {
                    upUsuario.get().setCellPhone(usuario.getCellPhone());
                }
                if (usuario.getEmail() != null) {
                    upUsuario.get().setEmail(usuario.getEmail());
                }
                if (usuario.getPassword() != null) {
                    upUsuario.get().setPassword(usuario.getPassword());
                }
                if (usuario.getZone() != null) {
                    upUsuario.get().setZone(usuario.getZone());
                }

                repoUser.updateUser(upUsuario.get());
                return upUsuario.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
    
    public boolean borrarUsuario(int userId) {
        Optional<TablaUser> usuario = repoUser.getUsuario(userId);
        
        if (usuario.isEmpty()){
            return false;
        }else{
            repoUser.borrarUsuario(usuario.get());
            return true;
        }
        
    }
    
    
    
}
