package ecom.mycompany.hotel.util;

import ecom.mycompany.hotel.dto.HotelDataModel;

import java.util.Comparator;

public class SortHotelName implements Comparator<HotelDataModel> {
    @Override
    public int compare(HotelDataModel o1, HotelDataModel o2) {
        return o1.name.compareToIgnoreCase(o2.name);
    }
}
