package ecom.mycompany.hotel.dto;

/**
 * This Class is the mapping class for User Rating Object and json
 *
 * @author Vinod
 */
public class UserRatingDataModel {

    public String user_id;
    public Integer rating;

    public UserRatingDataModel() {super();}

    public UserRatingDataModel(String user_id, Integer rating) {
        this.user_id = user_id;
        this.rating = rating;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "UserRatingDataModel{" +
                "user_id='" + user_id + '\'' +
                ", rating=" + rating +
                '}';
    }
}
