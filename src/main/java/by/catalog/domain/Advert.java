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
    long idUser;
    List<String> message;

    public Advert(String modelCar, String colorCar, int yearCar, double priceCar, long idUser, List<String> message) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
        this.message = message;
    }

    public Advert( String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }


}
