<p align="center"><img src="https://github.com/ManojCSE17/spring-rest-api-web/workflows/CICD%20pipeline/badge.svg?branch=master&event=push" alt="CI" /></p>

# Simple springboot CRUD Restful API

## Languages
<b>
Java,<br>
JSP
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

<b>Get list of all hotels (GET)</b><br/>

```
http://restapijava-env.subject-to-change.ap-southeast-1.elasticbeanstalk.com/api/hotels

Auth:
username: {{username}}
password: {{password}}
```

<b>Get hotel with id (GET)</b><br/>

```
http://restapijava-env.subject-to-change.ap-southeast-1.elasticbeanstalk.com/api/hotel/{id}

Auth:
username: {{username}}
password: {{password}}
```

<b>Add hotel details (POST)</b><br/>

```
http://restapijava-env.subject-to-change.ap-southeast-1.elasticbeanstalk.com/api/hotels

Auth:
username: {{username}}
password: {{password}}

Header:
X-XSRF-TOKEN: {{CSRF-TOKEN}}

Body (JSON):
{
        "hotelName": "ITC Kohenur",
        "hotelRating": 4.8,
        "hotelAddress": "Hyderabad",
        "hotelPinCode": 500044
}
```

<b>Update hotel details (PUT)</b><br/>

```
http://restapijava-env.subject-to-change.ap-southeast-1.elasticbeanstalk.com/api/hotels

Auth:
username: {{username}}
password: {{password}}

Header:
X-XSRF-TOKEN: {{CSRF-TOKEN}}

Body (JSON):
{
        "hotelId": 2,
        "hotelRating": 4.9,
}
```

<b>Delete hotel details (DEL)</b><br/>

```
http://restapijava-env.subject-to-change.ap-southeast-1.elasticbeanstalk.com/api/hotels/{id}

Auth:
username: {{username}}
password: {{password}}
```
