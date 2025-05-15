package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Sale;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter
@RequestMapping(path = "/sale")
public class SaleController {

    @GetMapping
    public String getSale(){
        Sale mmm = new Sale("arreglo uñas","1","50.000");

        return "Venta";

    }
}
