package ecom.mycompany.hotel.dto;

import java.math.BigDecimal;

public class RateDataModel {

    public BigDecimal base_price;
    public Integer room_id;
    public String name;

    public RateDataModel() {super();}

    public RateDataModel(BigDecimal base_price, Integer room_id, String name) {
        this.base_price = base_price;
        this.room_id = room_id;
        this.name = name;
    }

    public BigDecimal getBase_price() {
        return base_price;
    }

    public void setBase_price(BigDecimal base_price) {
        this.base_price = base_price;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RateDataModel{" +
                "base_price=" + base_price +
                ", room_id=" + room_id +
                ", name='" + name + '\'' +
                '}';
    }

}
