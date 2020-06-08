package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Advert {

    long id;
    String modelCar;
    String colorCar;
    int yearCar;
    double priceCar;
    long id_user;
    List <String> message;

    public Advert(String modelCar, String colorCar, int yearCar, double priceCar, long id_user) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.id_user = id_user;
    }
}
