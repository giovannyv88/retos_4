/*
 * Controlador del reto 2 que contiene las peticiones HTTP get, post
    put y delete para la clase TablaUser contenida en el paquete Modelos
 */
package Reto2_c4.Controladores;

import Reto2_c4.Modelos.TablaUser;
import Reto2_c4.Servicios.servicioUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giovanny Vanegas
 */
@RestController//Anotacion controlador
@RequestMapping("/api/user")//Direccion URL que se ubica en el browser que realiza la peticion HTTP
@CrossOrigin("*")
public class controladorUser {//Clase controlador para la coleccion usuario

    @Autowired
    private servicioUser servicioUsuario;//Objeto servicioUsuario que trae los services de la clase TablaUsuario

    @GetMapping("/all")//URL get que me trae el JSON de todos los usuarios
    public List<TablaUser> getUsuarios() {//Metodo que me trea en lista todos los documentos de la coleccion Usuario
        return servicioUsuario.getUsuarios();//Me retorna el valor de la peticion GET
    }
    
    @GetMapping("/{id}")
    public Optional <TablaUser> getUsuario(@PathVariable("id")int id ){
        return servicioUsuario.getUsuario(id);
    }
    

    @GetMapping("/emailexist/{email}")//Direccion URL que me trae el JSON del email y el usuario relacionado
    public boolean validarEmail(@PathVariable("email") String email) {//Metodo que me trae la funcion validar contenida en el service
        return servicioUsuario.validarEmail(email);//Valores que me retorna la peticion GET
    }

    @GetMapping("/{email}/{password}")//Direccion URL que me trae el JSON cons los datos relacionados al email y contraseña del usuario
    public TablaUser autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {//Metodo que me valida por el path el documento email
        return servicioUsuario.autenticarUsuario(email, password);//Me retorna los valores de la peticion GET

    }

    @PostMapping("/new")//Direccion URL con la peticion post para registrar un usuario
    @ResponseStatus(HttpStatus.CREATED)
    public TablaUser crearUsuario(@RequestBody TablaUser usuario) {//Metodo que me crea un usuario nuevo
        return servicioUsuario.crearUsuario(usuario);//Me retorna con el usuario creado
    }

    @PutMapping("/update")//Direccion URL con la peticion Put para actualizar datos de un usuario existente
    @ResponseStatus(HttpStatus.CREATED)
    public TablaUser usuarioUpdate(@RequestBody TablaUser usuario) {//Metodo que me actualiza los datos de un documento
        return servicioUsuario.usuarioUpdate(usuario);//Me retorna un documento actualizado

    }
    
    @DeleteMapping("/{id}")//Direccion URL para la peticion delete con el parametro del id del usuario creado 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarUsuario(@PathVariable("id") int id){//Metodo que me elimina un usuario existente tomando como parametro el id de la clase Tablauser
        return servicioUsuario.borrarUsuario(id);//Me retorna un campo vacion, el usuario se elimino correctamente
    }
    
    @GetMapping("/birthday/{month}")
    public List <TablaUser> listaCumpleaños(@PathVariable("month") String mes){
        return servicioUsuario.listaCumpleaños(mes);
    }

}
