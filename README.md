<p align="center"><img src="https://github.com/ManojCSE17/spring-rest-api-web/workflows/CICD%20pipeline/badge.svg?branch=master&event=push" alt="CI" /></p>

# Simple springboot CRUD Restful API

## Languages
<b>
Java,<br>
JSP,<br>
Bootstrap,<br>
HTML,<br>
JavaScript
</b>

<br>

## Project built using maven 

<b>clean</b><br/>

```cmd
mvn clean
```

<b>compile</b><br>

```cmd
mvn compile
```

<b>test</b><br>

```cmd
mvn test
```

<b>package</b><br>

```cmd
mvn package
```

<br>

## Packaging
<b>WAR</b>

<br>

## Deployment (AWS Elastic Beanstalk + MySQL RDS)

<br>

## Rest API URLs 

<b>Get list of all hotels (GET) - to retrieve XSRF-TOKEN</b><br/>

```
http://springrestapiweb-env.eba-ixp9jwys.ap-southeast-1.elasticbeanstalk.com/hotels

Auth:
username: {{username}}
password: {{password}}

Tests:
pm.environment.set('csrf-token', pm.cookies.get('XSRF-TOKEN'))
```

<b>Get list of all hotels (POST)</b><br/>

```
http://springrestapiweb-env.eba-ixp9jwys.ap-southeast-1.elasticbeanstalk.com/api

Headers:
X-XSRF-TOKEN: {{csrf-token}}

Auth:
username: {{username}}
password: {{password}}

Body:
query {
    returnHotels {
        hotelId
        hotelName
        hotelRating
    }
}
```

<b>Get hotel with id (POST)</b><br/>

```
http://springrestapiweb-env.eba-ixp9jwys.ap-southeast-1.elasticbeanstalk.com/api

Headers:
X-XSRF-TOKEN: {{csrf-token}}

Auth:
username: {{username}}
password: {{password}}

Body:
query {
    returnHotel(hotelId: 7) {
        hotelName
        hotelRating
    }
}
```

<b>Add hotel details (POST)</b><br/>

```
http://springrestapiweb-env.eba-ixp9jwys.ap-southeast-1.elasticbeanstalk.com/api

Headers:
X-XSRF-TOKEN: {{csrf-token}}

Auth:
username: {{username}}
password: {{password}}

Header:
X-XSRF-TOKEN: {{CSRF-TOKEN}}

Body:
mutation {
    addHotelDetails(hotelDTO: {
        hotelName: "Taj Banjara"
        hotelRating: 4.6
        hotelPinCode: 500044
        hotelAddress: "Hyderabad"
    })
}
```

<b>Update hotel details (POST)</b><br/>

```
http://springrestapiweb-env.eba-ixp9jwys.ap-southeast-1.elasticbeanstalk.com/api

Headers:
X-XSRF-TOKEN: {{csrf-token}}

Auth:
username: {{username}}
password: {{password}}

Header:
X-XSRF-TOKEN: {{CSRF-TOKEN}}

Body:
mutation {
    updateHotelDetails(hotelDTO: {
        hotelId: 7
        hotelPinCode: 500062
        hotelRating: 3.9
    })
}
```

<b>Delete hotel details (POST)</b><br/>

```
http://springrestapiweb-env.eba-ixp9jwys.ap-southeast-1.elasticbeanstalk.com/api

Headers:
X-XSRF-TOKEN: {{csrf-token}}

Auth:
username: {{username}}
password: {{password}}

Body:
query {
    deleteHotelDetails(hotelId: 1002)
}
```
