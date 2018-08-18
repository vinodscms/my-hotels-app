package ecom.mycompany.hotel.dto;

import java.math.BigDecimal;

/**
 * This Class is the mapping class for Tax Object and json
 *
 * @author Vinod
 */
public class TaxDataModel {

    public String name;
    public BigDecimal rate;

    public TaxDataModel() {super();}

    public TaxDataModel(String name, BigDecimal rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "TaxDataModel{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

}
