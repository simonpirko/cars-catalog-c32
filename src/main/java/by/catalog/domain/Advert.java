package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Advert {

    private long id;
    private String modelCar;
    private String colorCar;
    private int yearCar;
    private double priceCar;
    private long idUser;
    private List<Message> message;

    public Advert(String modelCar, String colorCar, int yearCar, double priceCar, long idUser, List<Message> message) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
        this.message = message;
    }

    public Advert(String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }

}
