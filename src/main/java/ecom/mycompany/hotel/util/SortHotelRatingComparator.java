package ecom.mycompany.hotel.util;

import ecom.mycompany.hotel.dto.HotelDataModel;
import ecom.mycompany.hotel.dto.RateDataModel;
import ecom.mycompany.hotel.dto.UserRatingDataModel;

import java.util.Comparator;
import java.util.List;

/**
 * This Class is the comparator for user rating comparing
 *
 * @author Vinod
 */
public class SortHotelRatingComparator implements Comparator<HotelDataModel> {
    @Override
    public int compare(HotelDataModel o1, HotelDataModel o2) {
        return (int) (calculateAlgebraicMean(o1.getUser_ratings())-calculateAlgebraicMean(o2.getUser_ratings()));
    }

    private float calculateAlgebraicMean(List<UserRatingDataModel> ratingsList) {
        float rating = 0f;
        int sum = 0;
        if(ratingsList.size() == 0) {
            return rating;
        }
        for(UserRatingDataModel userRating:ratingsList) {
            sum+=userRating.rating.intValue();
        }
        rating=sum/ratingsList.size();
        return rating;
    }
}
