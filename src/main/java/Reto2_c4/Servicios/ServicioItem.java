/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Servicios;

import Reto2_c4.Modelos.TablaProducto;
import Reto2_c4.Repositorios.RepositorioItem;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovanny Vanegas
 */
@Service
public class ServicioItem {

    @Autowired
    private RepositorioItem repoItem;

    public List<TablaProducto> getItem() {
        return repoItem.getItem();//Crear metodo obtener items en servicio
    }

    public Optional<TablaProducto> getReferencia(String referencia) {
        return repoItem.getItem(referencia);
    }

    public TablaProducto crearItem(TablaProducto item) {
        if (item.getReference() == null) {
            return item;
        } else {
            return repoItem.crearItem(item);
        }
    }

    public TablaProducto actItem(TablaProducto item) {

        if (item.getReference() != null) {
            Optional<TablaProducto> upItem = repoItem.getItem(item.getReference());
            if (!upItem.isEmpty()) {
                if (item.getCategory() != null) {
                    upItem.get().setCategory(item.getCategory());
                }
                if (item.getDescription() != null) {
                    upItem.get().setDescription(item.getDescription());
                }
                if (item.getPrice() != 0.0) {
                    upItem.get().setPrice(item.getPrice());
                }
                if (item.getQuantity() != 0) {
                    upItem.get().setQuantity(item.getQuantity());
                }
                if (item.getPhotography() != null) {
                    upItem.get().setPhotography(item.getPhotography());
                }

                upItem.get().setAvailability(item.isAvailability());
                repoItem.updateItem(upItem.get());
                return upItem.get();

            } else {
                return item;
            }

        } else {
            return item;
        }
    }

    public boolean borrarItem(String referencia) {
        Optional<TablaProducto> item = repoItem.getItem(referencia);

        if (referencia.isEmpty()) {
            return false;
        } else {
            repoItem.borrarItem(item.get());
            return true;
        }
    }
    
    public List<TablaProducto> precioMenor (double precio){
        return repoItem.precioMenor(precio);
    }
    
    public List<TablaProducto> descripcionItem (String descripcion){
        return repoItem.descripcionItem(descripcion);
    }
    
}
