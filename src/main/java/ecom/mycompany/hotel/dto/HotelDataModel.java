package ecom.mycompany.hotel.dto;

import java.math.BigDecimal;
import java.util.List;

public class HotelDataModel {

    public String name;
    public BigDecimal location_x;
    public BigDecimal location_y;
    public BigDecimal location_z;
    public List<RateDataModel> rates;
    public Integer star_rating;
    public List<UserRatingDataModel> user_ratings;

    public HotelDataModel() {super();}

    public HotelDataModel(String name, BigDecimal location_x, BigDecimal location_y, BigDecimal location_z, List<RateDataModel> rates, Integer star_rating, List<UserRatingDataModel> user_ratings) {
        this.name = name;
        this.location_x = location_x;
        this.location_y = location_y;
        this.location_z = location_z;
        this.rates = rates;
        this.star_rating = star_rating;
        this.user_ratings = user_ratings;
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

    public List<RateDataModel> getRates() {
        return rates;
    }

    public void setRates(List<RateDataModel> rates) {
        this.rates = rates;
    }

    public Integer getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Integer star_rating) {
        this.star_rating = star_rating;
    }

    public List<UserRatingDataModel> getUser_ratings() {
        return user_ratings;
    }

    public void setUser_ratings(List<UserRatingDataModel> user_ratings) {
        this.user_ratings = user_ratings;
    }

    @Override
    public String toString() {
        return "HotelDataModel{" +
                "name='" + name + '\'' +
                ", location_x=" + location_x +
                ", location_y=" + location_y +
                ", location_z=" + location_z +
                ", rates=" + rates +
                ", star_rating=" + star_rating +
                ", user_ratings=" + user_ratings +
                '}';
    }
}
