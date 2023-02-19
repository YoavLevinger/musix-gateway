# musix-gateway

## Instructions

###What's in this project:

    
* Standalone executable jar to meet with 1st requirement.

* Spring boot server exposing a service to meet with 2nd requirement.

* jMusixMatch dependency - "forked" from community SDK:
  https://github.com/sachin-handiekar/jMusixMatch
  And enhanced to match requirements and overcome musix bugs and data integrity errors. 

###Usage:

####Standalone executable jar command:

```java -jar <jarname.jar> <musixApiKey> <queryString(s)>'```

e.g.:

```java -jar musixApp-jar-with-dependencies.jar apiky123123123 "in god we trust"```

The result will be saved as csv in the run command workspace under the name: results_\<queryString\>.csv
The \<queryString\> will be replaced with the resolved query string, special characters will be replaced to match possible file name.
If there's more than one word in the query string, place the entire query string "in quotation marks".


####Spring boot server exposing a service


URL:
http://localhost:8080/api/v1/musix-query?queryString=In%20god%20we%20trust

Reply is in the json array form:
```
[
{"songName":"Delilah",
"performerName":"Kelly De Martino",
"albumName":"Honest",
"songShareURL":"https://www.musixmatch.com/lyrics/Kelly-De-Martino/Delilah?utm_source\u003dapplication\u0026utm_campaign\u003dapi\u0026utm_medium\u003dnone%3A1409622527409"},...
...
```

Set/replace API key if needed:
http://localhost:8080/api/v1/set-musix-api-key?apiKey=<your_key>

###Build:

Use Java version 8, Maven 3.8.1 or higher.

**jMusixMatch dependency, build the module:**

under /jMusixMatch folder run:

`mvn clean install`

**Create stand alone runnable:**

under the project's root folder: 

`mvn clean compile assembly:single`

**Create musix-gateway spring-boot server:**

under project root folder:

`mvn clean install`


### Wrap in docker instructions + passed apikey param...```

Use the Dockerfile located in the project's root.

run the following commands:
``` 
docker build -t <image-name> .
docker run -p 8080:8080 <image-name> <api-key>

```
###Notes:

* Using snapshot versions at this point/solution.
* Unit tests weren't created for this short term solution.
* Query assumes retrieve all results pages from Musix server.
* There are some bugs and data integrity gaps in the musix server, running same query with different result set.
* Meeting first requirement with a script rather than OOP is not recommended for multiple reasons.
* log4j using default settings.
* No pagination implemented for the created service.  
* Code created "fast and dirty"...plus some other excuses...mixed project module...etc.




