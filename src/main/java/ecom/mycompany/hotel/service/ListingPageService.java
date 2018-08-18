package ecom.mycompany.hotel.service;

import ecom.mycompany.hotel.dto.CityDataModel;
import ecom.mycompany.hotel.dto.CoordinateDataModel;
import ecom.mycompany.hotel.dto.HotelDataModel;
import ecom.mycompany.hotel.dto.RateDataModel;
import ecom.mycompany.hotel.exception.FileReadException;
import ecom.mycompany.hotel.mapper.ListingPageRequest;
import ecom.mycompany.hotel.util.*;
import ecom.mycompany.library.SortingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class for the listing page. Sorting with various criteria like distance, price,
 * rating and name is implemented. Implemented Bubble sort, Insertion sort and Collection's merge sort
 *
 * @author Vinod
 */
@Service
public class ListingPageService {

    private static final Logger logger = LoggerFactory.getLogger(ListingPageService.class);

    //Sorting algorithms from the library jar
    private SortingHelper sortingHelper = new SortingHelper();

    @Autowired
    DataLoader dataLoader;

    public List<HotelDataModel> returnHotelList(ListingPageRequest request) throws FileReadException {
        logger.info("Loading hotels for location: " + request.location_id);

        CityDataModel cityDetails;
        List<HotelDataModel> hotelsList = new ArrayList<>();
        try {
            cityDetails = dataLoader.loadHotelList(request.location_id);
            hotelsList = cityDetails.getHotels();

            logger.info("Sorting by " + request.search_criteria+" in " + request.sort_option);
            long startTime = System.currentTimeMillis();
            switch (request.search_criteria) {
                case "distance": {
                    //Using Bubble Sort from library for name
                    CoordinateDataModel cityLocation = new CoordinateDataModel(cityDetails.location_x,
                            cityDetails.location_y,cityDetails.location_z);
                    hotelsList = Arrays.asList((HotelDataModel[])
                            sortingHelper.bubbleSort(cityDetails.getHotels().stream().toArray(HotelDataModel[]::new),
                                    new SortHotelDistanceComparator(cityLocation), request.sort_option));
                }
                break;

                case "price": {
                    //Using Collections merge sort for Price
                    hotelsList = cityDetails.getHotels();
                    sortWithPriceOption(hotelsList, request.sort_option);
                }
                break;

                case "rating": {
                    //Using Insertion Sort for user rating
                    hotelsList = Arrays.asList((HotelDataModel[])
                            sortingHelper.insertionSort(cityDetails.getHotels().stream().toArray(HotelDataModel[]::new),
                                    new SortHotelRatingComparator(), request.sort_option));
                }
                break;

                default: {
                    //Using Bubble Sort from library for name
                    hotelsList = Arrays.asList((HotelDataModel[])
                            sortingHelper.bubbleSort(cityDetails.getHotels().stream().toArray(HotelDataModel[]::new),
                                    new SortHotelNameComparator(), request.sort_option));
                }

            }
            long endTime = System.currentTimeMillis();
            logger.info("Time taken for sorting is " + (endTime-startTime) + "ms");
        } catch (FileReadException fileReadException) {
            throw fileReadException;
        }

        return hotelsList;
    }

    /**
     * This method sort price criteria in ascending or descending. Stream method used to sort inner node
     * of base_price and then sorted the whole collection
     *
     * @param hotelsList
     * @param sort_option
     * @return
     */
    private List<HotelDataModel> sortWithPriceOption(List<HotelDataModel> hotelsList, String sort_option) {
        switch (sort_option.toLowerCase()) {
            case "asc":
            case "ascending": {
                hotelsList.stream()
                        .forEach(p -> p.getRates().sort(Comparator.comparing(RateDataModel::getBase_price)));
                Collections.sort(hotelsList, new SortHotelRateComparator());
            }
            break;
            case "desc":
            case "descending": {
                hotelsList.stream()
                        .forEach(p -> p.getRates().sort(Comparator.comparing(RateDataModel::getBase_price).reversed()));
                Comparator comparator = Collections.reverseOrder(new SortHotelRateComparator());
                Collections.sort(hotelsList, comparator);
            }
            break;
            default: {
                hotelsList.stream()
                        .forEach(p -> p.getRates().sort(Comparator.comparing(RateDataModel::getBase_price)));
                Collections.sort(hotelsList, new SortHotelRateComparator());
            }
        }
        return hotelsList;
    }

}
