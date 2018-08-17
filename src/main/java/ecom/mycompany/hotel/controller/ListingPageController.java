package ecom.mycompany.hotel.controller;

import ecom.mycompany.hotel.dto.CityDataModel;
import ecom.mycompany.hotel.exception.FileReadException;
import ecom.mycompany.hotel.mapper.ListingPageRequest;
import ecom.mycompany.hotel.service.DataLoader;
import ecom.mycompany.hotel.service.ListingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for the Hotels landing page
 *
 * @author Vinod
 */
@RestController
@RequestMapping("/hotels")
public class ListingPageController {

    @Autowired
    DataLoader dataLoader;

    @Autowired
    ListingPageService listingPageService;

    @GetMapping(value = "/ping")
    public String checkApplicationHealth() {
        return "Application is up and running";
    }

    @GetMapping(value = "/load-hotels")
    public ResponseEntity loadHotelsData() {
        try {
            CityDataModel response = dataLoader.loadHotelList("Galactic center");
            return new ResponseEntity(response.toString(),HttpStatus.OK);
        } catch (FileReadException fileReadException) {
            return new ResponseEntity(fileReadException.getMessage(),HttpStatus.OK);
        }
    }

    @PostMapping(value="/hotels-listing")
    public ResponseEntity getHotelListing(@RequestBody ListingPageRequest request) {
        //return new ResponseEntity(, HttpStatus.OK);
        try {
            String response = listingPageService.returnHotelList(request);
            return new ResponseEntity(response.toString(),HttpStatus.OK);
        } catch (FileReadException fileReadException) {
            return new ResponseEntity(fileReadException.getMessage(),HttpStatus.OK);
        }
    }
}
