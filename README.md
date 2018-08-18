# Hotel Application

This application is created to simulate a sample hotel booking site with selected functionalities

## How to build and execute

Build Library using maven and java 1.8 -> https://github.com/vinodscms/sorting-artifacts

Build this application using maven and java 1.8

Directly execute jar file

java -jar hotels-app-0.0.1-SNAPSHOT.jar

Logs will be found in Root directory + /log/hotel-app.log

## Health Check URLS
Health Check    - http://localhost:8083/hotels/ping

Actuator        - http://localhost:8083/actuator/health

## Application URL
http://localhost:8083/hotels/hotels-listing

###Sample requests
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


