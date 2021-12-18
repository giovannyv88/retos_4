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
    private repositorioUser repoUser;//Intsancia del repositorio con el objeto repoUser

    public List<TablaUser> getUsuarios() {//Metodo que me trae todos los usuarios 
        return repoUser.getUsuarios();
    }
    
    public Optional<TablaUser> getUsuario(int id) {//Metodo que me devuelve un usuario especifico por su id
        return repoUser.getUsuario(id);
    }
    
    
    
    public boolean validarEmail(String email) {//Metodod que valida si el email del usuario se encuentra registrado o no
        return repoUser.validarEmail(email);
    }

    public TablaUser autenticarUsuario(String email, String password) {//Metodo que valida el email y la contraseña
        Optional<TablaUser> usuario = repoUser.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {//La condicion evalua si el campo del usuario esta vacio
            return new TablaUser();//Me guarda el usuario nuevo
        } else {
            return usuario.get();//Si ya existe el usuario, me lo retorna

        }
    }
    
    public TablaUser crearUsuario(TablaUser usuario) {//Metodo para registrar un nuevo usuario
        if (usuario.getId() == null) {//Valida si el id esta vacio, de ser asi, me retorna el usuario
            return usuario;
        } else {
            Optional<TablaUser> usuarios = repoUser.getUsuario(usuario.getId());//Obtiene un usuario por el id
            if (usuarios.isEmpty()) {//Valida si no hay registro
                if (validarEmail(usuario.getEmail()) == false) {//Evalua si el correo del ususario se encuntra registrado no existe
                    return repoUser.crearUsuario(usuario);//Me guarda el usuario
                } else {
                    return usuario;//Me retorna datos con el usuario creado
                }
            } else {
                return usuario;//Si ya existe el registro, solo me lo retorna
            }
        }
    }

    
 
    
    public TablaUser usuarioUpdate(TablaUser usuario) {//Metodo que actualiza los datos de un usuario ya registrado

        if (usuario.getId() != null) {//Evalua primero si el id del usuario ya existe
            Optional<TablaUser> upUsuario = repoUser.getUsuario(usuario.getId());//Procede a obetner el id del registro
            if (!upUsuario.isEmpty()) {
                if (usuario.getIdentification() != null) {//Evalua que la cedula no este vacia
                    upUsuario.get().setIdentification(usuario.getIdentification());//De ser cierto, actualiza el campo cedula
                }
                if (usuario.getName() != null) {//Evalua que el nombre ya exista
                    upUsuario.get().setName(usuario.getName());//De ser true, actualiza el campo nombre
                }
                if (usuario.getAddress() != null) {//Evalua que la cedula no este vacia
                    upUsuario.get().setAddress(usuario.getAddress());//Si es true,actualiza la direccion 
                }
                if (usuario.getCellPhone() != null) {//Evalua que el telefono no este vacio
                    upUsuario.get().setCellPhone(usuario.getCellPhone());//Si es true, actualiza el registro
                }
                if (usuario.getEmail() != null) {//Evalua que el correo electronico no este vacio
                    upUsuario.get().setEmail(usuario.getEmail());//Si es verdadero, actualiza el registro con set
                }
                if (usuario.getPassword() != null) {//Evalua que la contraseña no este vacia
                    upUsuario.get().setPassword(usuario.getPassword());//Actualiza la contraseña
                }
                if (usuario.getZone() != null) {//Evalua que la zona no este vacia
                    upUsuario.get().setZone(usuario.getZone());//Actualiza el registro
                }

                repoUser.updateUser(upUsuario.get());//Objeto repoUser procede a llamar el metodo UpdateUser
                return upUsuario.get();//Retorna el registro del usuario actualizado
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
    
    public boolean borrarUsuario(int userId) {//Metodo que elimina un registro de la coleccion
        Optional<TablaUser> usuario = repoUser.getUsuario(userId);//Se usa el optional para evitar el NullPointerExcepction
        
        if (usuario.isEmpty()){//Condicion que evalua si el registro se encuntra vacio
            return false;//Si es true no realiza la operacion
        }else{
            repoUser.borrarUsuario(usuario.get());//De lo contrario, procede a ejecutar el metodo borrarUsuario
            return true;
        }
        
    }
    
    
    public List<TablaUser> listaCumpleaños( String mes){
        return repoUser.listaCumpleaños(mes);
    }
     
}
