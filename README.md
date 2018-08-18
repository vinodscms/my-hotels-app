# Hotel Application

This application is created to simulate a sample hotel booking site with selected functionalities.
Hotel listing page api functionalitites with following options to sort.

	1. Sort by Distance
	2. Sort by Price
	3. Sort by Rating
	4. Sort by Name


## How to build and execute

1. Build the sortinglLibrary using maven and java 1.8 -> https://github.com/vinodscms/sorting-artifacts

2. Build this repository using maven and java 1.8

3. Directly execute jar file in target folder

   java -jar hotels-app-1.0.jar

4. Logs will be found in Console and Root directory + /log/hotel-app.log

## Health Check URLS
Health Check    - http://localhost:8083/hotels/ping

Actuator        - http://localhost:8083/actuator/health

## Application URL
http://localhost:8083/hotels/hotels-listing

### Sample requests
{
	"location_id" : "1",
	"search_criteria" : "name",
	"sort_option" : "asc"
}

{
	"location_id" : "1",
	"search_criteria" : "distance",
	"sort_option" : "ascending"
}

{
	"location_id" : "1",
	"search_criteria" : "distance",
	"sort_option" : "desc"
}

{
	"location_id" : "1",
	"search_criteria" : "price",
	"sort_option" : "asc"
}

{
	"location_id" : "1",
	"search_criteria" : "price",
	"sort_option" : "desc"
}

{
	"location_id" : "1",
	"search_criteria" : "rating",
	"sort_option" : "ascending"
}


