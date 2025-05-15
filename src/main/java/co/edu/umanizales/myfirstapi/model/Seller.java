package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Seller {
    private String identification;
    private String name;
    private String lastName;
    private char gender;
    private byte age;
    private String city;


}
