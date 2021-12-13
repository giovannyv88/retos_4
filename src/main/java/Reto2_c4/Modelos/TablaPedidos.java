
package Reto2_c4.Modelos;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Giovanny Vanegas
 */
@Document (collection ="ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TablaPedidos {
    
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private TablaUser salesMan;
    private Map<String, TablaProducto> products;
    private Map<String, Integer> quantities;
    
}
