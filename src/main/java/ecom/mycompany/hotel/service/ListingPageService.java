package ecom.mycompany.hotel.service;

import ecom.mycompany.hotel.dto.CityDataModel;
import ecom.mycompany.hotel.dto.HotelDataModel;
import ecom.mycompany.hotel.dto.RateDataModel;
import ecom.mycompany.hotel.exception.FileReadException;
import ecom.mycompany.hotel.mapper.ListingPageRequest;
import ecom.mycompany.hotel.util.SortHotelName;
import ecom.mycompany.hotel.util.SortHotelRate;
import ecom.mycompany.hotel.util.SortingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class for the listing page. Sorting with distance, price, rating and name is implemented
 *
 * @author Vinod
 */
@Service
public class ListingPageService {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    DataLoader dataLoader;

    @Autowired
    SortingHelper sortingHelper;

    public String returnHotelList(ListingPageRequest request) throws FileReadException {
        logger.info("Loading hotels for location: " + request.location_id);

        CityDataModel cityHotels;
        List<HotelDataModel> hotelsList = new ArrayList<>();
        try {
            cityHotels = dataLoader.loadHotelList(request.location_id);

            long startTime = System.currentTimeMillis();
            switch (request.search_criteria) {
                case "distance": {

                }
                break;

                case "price": {
                    //Using Collections merge sort for Price
                    hotelsList = cityHotels.getHotels();
                    sortWithPriceOption(hotelsList, request.sort_option);
                }
                break;

                case "rating": {

                }
                break;

                default: {
                    //Using Bubble Sort from library for name
                    hotelsList = Arrays.asList((HotelDataModel[])
                            sortingHelper.bubbleSort(cityHotels.getHotels().stream().toArray(HotelDataModel[]::new),
                                    new SortHotelName(), request.sort_option));
                }

            }
            long endTime = System.currentTimeMillis();
            logger.info("Time taken for sorting is " + (endTime-startTime) + "ms");
        } catch (FileReadException fileReadException) {
            throw fileReadException;
        }

        return hotelsList.toString();
    }

    private List<HotelDataModel> sortWithPriceOption(List<HotelDataModel> hotelsList, String sort_option) {
        switch (sort_option.toLowerCase()) {
            case "asc":
            case "ascending": {
                hotelsList.stream()
                        .forEach(p -> p.getRates().sort(Comparator.comparing(RateDataModel::getBase_price)));
                Collections.sort(hotelsList, new SortHotelRate());
            }
            break;
            case "desc":
            case "descending": {
                hotelsList.stream()
                        .forEach(p -> p.getRates().sort(Comparator.comparing(RateDataModel::getBase_price).reversed()));
                Comparator comparator = Collections.reverseOrder(new SortHotelRate());
                Collections.sort(hotelsList, comparator);
            }
            break;
            default: {
                hotelsList.stream()
                        .forEach(p -> p.getRates().sort(Comparator.comparing(RateDataModel::getBase_price)));
                Collections.sort(hotelsList, new SortHotelRate());
            }
        }
        return hotelsList;
    }

}
