package ecom.mycompany.hotel.util;

import ecom.mycompany.hotel.dto.HotelDataModel;

import java.util.Comparator;

/**
 * This Class is the comparator for name comparing
 *
 * @author Vinod
 */
public class SortHotelNameComparator implements Comparator<HotelDataModel> {
    @Override
    public int compare(HotelDataModel o1, HotelDataModel o2) {
        return o1.name.compareToIgnoreCase(o2.name);
    }
}
