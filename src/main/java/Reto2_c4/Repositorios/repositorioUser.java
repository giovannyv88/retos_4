/*
 * Clase repositorioUser definida como repositorio
 * Con metodos y CRUD para el modelo usuarios
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
//Indicamos con esta anotacion que la clase sera un repositorio
@Repository
//Inicio de la clase
public class repositorioUser {

    @Autowired
    private userInterfaz crudUser;//Metodod privado con instancia crudUser que me trae el crud de la interaz mongorepository
    //Metodo que me trae un usuario por su id

    public Optional<TablaUser> getUsuario(int id) {
        return crudUser.findById(id);//Me retorna el dato del usuario
    }

    //Metodo que me trae todos los usuarios de la coleccion
    public List<TablaUser> getUsuarios() {
        return crudUser.findAll();//Me retorna todos los registros de la clase TablaUsuarios

    }

    //Metodo que me permite crear un nuevo usuario
    public TablaUser crearUsuario(TablaUser usuario) {
        return crudUser.save(usuario);//Me registra el usuario creado
    }

    //Metodo para validar si ya existe un email registrado
    public boolean validarEmail(String email) {
        Optional<TablaUser> user = crudUser.findByEmail(email);//Me busca el email dentro de la app
        return !user.isEmpty();//Retorna el email del usuario
    }

    //Metodo que me permite loguearme dentro de la aplicacion
    public Optional<TablaUser> autenticarUsuario(String email, String password) {
        return crudUser.findByEmailAndPassword(email, password);//Me retorna el email y contraseña del usuario regiustrado

    }

    //Metodo que actualiza algun dato del usuario registrado
    public void updateUser(TablaUser usuario) {
        crudUser.save(usuario);//Retorna los nuevos datos del usuario
    }

    //Metodo que me elimina un usuario dentro de la app
    public void borrarUsuario(TablaUser usuario) {
        crudUser.delete(usuario);//Se procede a eliminar el registro
    }

    //Metodo que me trae un usuario con la orden de pedido mas alata
    public Optional<TablaUser> ultimoUser() {
        return crudUser.findTopByOrderByIdDesc();//Me retorna el registro del pedido relacionado al usuario
    }

    //Metodo que permite traer un usuario por su mes de cumpleaños
    public List<TablaUser> listaCumpleaños(String mes) {
        return crudUser.findByMonthBirthtDay(mes);//Me retorna un registro correspondiente al mes de cumpleañoss
    }

}//Fin de la clase 

