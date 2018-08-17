package ecom.mycompany.hotel.util;

import ecom.mycompany.hotel.dto.HotelDataModel;

import java.util.Comparator;

public class SortHotelRate implements Comparator<HotelDataModel> {
    @Override
    public int compare(HotelDataModel o1, HotelDataModel o2) {
        return o1.getRates().get(0).getBase_price().compareTo(o2.getRates().get(0).getBase_price());
    }
}
