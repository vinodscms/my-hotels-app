package ecom.mycompany.hotel.mapper;

/**
 * This is the hotel listing page request object
 *
 * @author Vinod
 */
public class ListingPageRequest {

    public String location_id;
    public String search_criteria;
    public String sort_option;

    public ListingPageRequest(String location_id, String search_criteria, String sort_option) {
        this.location_id = location_id;
        this.search_criteria = search_criteria;
        this.sort_option = sort_option;
    }

    public ListingPageRequest() {
    }


    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getSearch_criteria() {
        return search_criteria;
    }

    public void setSearch_criteria(String search_criteria) {
        this.search_criteria = search_criteria;
    }

    public String getSort_option() {
        return sort_option;
    }

    public void setSort_option(String sort_option) {
        this.sort_option = sort_option;
    }

    @Override
    public String toString() {
        return "ListingPageRequest{" +
                "location_id='" + location_id + '\'' +
                ", search_criteria='" + search_criteria + '\'' +
                ", sort_option='" + sort_option + '\'' +
                '}';
    }
}
