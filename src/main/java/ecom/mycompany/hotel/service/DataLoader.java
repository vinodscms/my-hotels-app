package ecom.mycompany.hotel.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ecom.mycompany.hotel.dto.CityDataModel;
import ecom.mycompany.hotel.exception.FileReadException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Data loader class. List of hotels in a region can be read from API or SOLR or database.
 * In this scenario reading from json
 *
 * @author Vinod
 */
@Service
public class DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    /**
     * This method reads the input Source and loads the hotel list for the city.
     * It can read from search engines like SOLR or Fredhopper or even from database
     * We can implement Caching strategy to reduce load time
     * This scenario we are reading from JSON
     * Since there is only 1 city in the input list, not fetching using location_id
     *
     * @param city
     * @return
     * @throws FileReadException
     */
    public CityDataModel loadHotelList(Integer locationId) throws FileReadException {
        logger.info("Entering Load data method" );

        ObjectMapper mapper = new ObjectMapper();
        CityDataModel cityData = null;
        try {
            long startTime = System.currentTimeMillis();

            InputStream inputStream = new ClassPathResource("json_data_set_unsorted.json").getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            cityData = mapper.readValue(br, CityDataModel.class);

            long endTime = System.currentTimeMillis();
            logger.info("Time taken for data load is " + (endTime-startTime) + "ms");
        } catch (IOException ioException) {
            logger.error(ioException.getMessage());
            throw new FileReadException("The data loader failed to fetch the hotel list");
        }

        logger.info("Loaded hotels for " + cityData.name + " city" );
        return cityData;
    }
}
