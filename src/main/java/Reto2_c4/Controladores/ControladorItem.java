/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Controladores;

import Reto2_c4.Modelos.TablaProducto;
import Reto2_c4.Servicios.ServicioItem;
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
@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin("*")
public class ControladorItem {
    
    @Autowired
    private ServicioItem serviItem;
    
    
    @GetMapping("/all")
    public List<TablaProducto> getItem(){
        return serviItem.getItem();
    }
    
    @GetMapping("/{reference}")
    public Optional<TablaProducto> getReferencia(@PathVariable("reference") String referencia){
        return serviItem.getReferencia(referencia); 
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaProducto crearItem(@RequestBody TablaProducto item){
        return serviItem.crearItem(item);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaProducto actItem(@RequestBody TablaProducto item){
        return serviItem.actItem(item);//Crear metodo actualizar item
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarItem(@PathVariable("reference") String referencia){
        return serviItem.borrarItem(referencia);//Crear metodo eliminar
    }
    
    @GetMapping("/price/{price}")
    public List<TablaProducto> precioMenor(@PathVariable("price")double precio){
        return serviItem.precioMenor(precio);
    }
    
    @GetMapping("/description/{description}")
    public List <TablaProducto> descripcionItem(@PathVariable("description") String descripcion){
        return serviItem.descripcionItem(descripcion);
    }
    
}
