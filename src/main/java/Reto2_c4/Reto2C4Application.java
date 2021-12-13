package Reto2_c4;

import Reto2_c4.Interfaces.itemInterfaz;
import Reto2_c4.Interfaces.pedidoInterfaz;
import Reto2_c4.Interfaces.userInterfaz;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2C4Application implements CommandLineRunner {

    @Autowired
    private userInterfaz userInter;
    @Autowired
    private itemInterfaz itemInter;
    @Autowired
    private pedidoInterfaz pedidoInter;

    public static void main(String[] args) {
        SpringApplication.run(Reto2C4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userInter.deleteAll();
        itemInter.deleteAll();
        pedidoInter.deleteAll();

    }

}
