package ecom.mycompany.hotel;

import ecom.mycompany.hotel.dto.CityDataModel;
import ecom.mycompany.hotel.dto.HotelDataModel;
import ecom.mycompany.hotel.mapper.ListingPageRequest;
import ecom.mycompany.hotel.service.DataLoader;
import ecom.mycompany.hotel.service.ListingPageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListingPageControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ListingPageService listingPageService;

    @Autowired
    private DataLoader dataLoader;

    @Test
    public void checkApplicationStatus() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hotels/ping",
                String.class)).contains("Application is up and running");
    }

    @Test
    public void checkDataLoad() throws Exception {
        CityDataModel response = dataLoader.loadHotelList(1);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.name, "Galactic center");
    }

    @Test
    public void checkNameSort() throws Exception {
        ListingPageRequest listingPageRequest =
                new ListingPageRequest("1","name","asc");
        List<HotelDataModel> response = listingPageService.returnHotelList(listingPageRequest);
        Assert.assertNotNull(response);
    }

    @Test
    public void checkDistanceSort() throws Exception {
        ListingPageRequest listingPageRequest =
                new ListingPageRequest("1","distance","asc");
        List<HotelDataModel> response = listingPageService.returnHotelList(listingPageRequest);
        Assert.assertNotNull(response);
    }

    @Test
    public void checkPriceSort() throws Exception {
        ListingPageRequest listingPageRequest =
                new ListingPageRequest("1","price","asc");
        List<HotelDataModel> response = listingPageService.returnHotelList(listingPageRequest);
        Assert.assertNotNull(response);
    }

    @Test
    public void checkRatingSort() throws Exception {
        ListingPageRequest listingPageRequest =
                new ListingPageRequest("1","rating","asc");
        List<HotelDataModel> response = listingPageService.returnHotelList(listingPageRequest);
        Assert.assertNotNull(response);
    }

}
