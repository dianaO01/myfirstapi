package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.Chromaticity;

@Getter
@Setter

public class Store {
    private Location location;
    private String name;
    private String address;
    private String code;
    private String id;


    public Store(String code, String name, String address, String location, String identification) {
    }

    public Object getLocation() {
        return null;
    }
     public Store(String code, String name, String address, String location) {

     }
}
