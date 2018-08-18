package ecom.mycompany.hotel.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * This Class is the mapping class for City Object and json
 *
 * @author Vinod
 */
public class CityDataModel {

    public Integer location_id;
    public String name;
    public BigDecimal location_x;
    public BigDecimal location_y;
    public BigDecimal location_z;
    public List<TaxDataModel> taxes;
    public List<HotelDataModel> hotels;

    public CityDataModel() {super();}

    public CityDataModel(Integer location_id, String name, BigDecimal location_x, BigDecimal location_y, BigDecimal location_z, List<TaxDataModel> taxes, List<HotelDataModel> hotels) {
        this.location_id = location_id;
        this.name = name;
        this.location_x = location_x;
        this.location_y = location_y;
        this.location_z = location_z;
        this.taxes = taxes;
        this.hotels = hotels;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLocation_x() {
        return location_x;
    }

    public void setLocation_x(BigDecimal location_x) {
        this.location_x = location_x;
    }

    public BigDecimal getLocation_y() {
        return location_y;
    }

    public void setLocation_y(BigDecimal location_y) {
        this.location_y = location_y;
    }

    public BigDecimal getLocation_z() {
        return location_z;
    }

    public void setLocation_z(BigDecimal location_z) {
        this.location_z = location_z;
    }

    public List<TaxDataModel> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxDataModel> taxes) {
        this.taxes = taxes;
    }

    public List<HotelDataModel> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelDataModel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "CityDataModel{" +
                "location_id=" + location_id +
                ", name='" + name + '\'' +
                ", location_x=" + location_x +
                ", location_y=" + location_y +
                ", location_z=" + location_z +
                ", taxes=" + taxes +
                ", hotels=" + hotels +
                '}';
    }
}
