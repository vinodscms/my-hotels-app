package ecom.mycompany.hotel.util;

import ecom.mycompany.hotel.dto.CoordinateDataModel;
import ecom.mycompany.hotel.dto.HotelDataModel;
import ecom.mycompany.hotel.service.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * This Class is the comparator for distance calculation and comparing
 *
 * @author Vinod
 */
public class SortHotelDistanceComparator implements Comparator<HotelDataModel> {
    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    public CoordinateDataModel cityCenter;

    public SortHotelDistanceComparator(CoordinateDataModel cityCenter) {
        this.cityCenter = cityCenter;
    }

    @Override
    public int compare(HotelDataModel o1, HotelDataModel o2) {
        CoordinateDataModel point1 = new CoordinateDataModel(o1.location_x,o1.location_y,o1.location_z);
        CoordinateDataModel point2 = new CoordinateDataModel(o2.location_x,o2.location_y,o2.location_z);

        return distanceBetweenPoints(cityCenter,point1).subtract(distanceBetweenPoints(cityCenter,point2)).intValue();
    }

    /**
     * This method calculates Euclidean distance using Pythagorean Theorem
     * Square root of (x2−x1)^2+(y2−y1)^2+(z2−z1)^2
     *
     * @param pointA
     * @param pointB
     * @return
     */
    private BigDecimal distanceBetweenPoints(CoordinateDataModel pointA, CoordinateDataModel pointB) {
        BigDecimal distance = new BigDecimal(0);
        distance = new BigDecimal(Math.sqrt((pointA.location_x.subtract(pointB.location_x)).pow(2)
                .add((pointA.location_y.subtract(pointB.location_y)).pow(2))
                .add((pointA.location_z.subtract(pointB.location_z)).pow(2)).doubleValue()));
        return distance;
    }

}
