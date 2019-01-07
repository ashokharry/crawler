Built With

* Java 7 or above - Code Language
* Maven - Build Tool

Testing
* Junit

Using an IDE
1. git clone https://github.com/ashokharry/crawler.git
2. import as existing project
3. run as spring boot project

Using Command Line
1. git clone https://github.com/ashokharry/crawler.git
2. cd crawler
3. mvn clean install
4. mvn spring-boot:run

To Test -
Open any browser and hit below url
http://localhost:8080/site-map?url={Any site you want to test}

example - http://localhost:8080/site-map?url=https://test.com/

TODO
1. Dockerize the app
2. Code optimisation- asynchronous calls and control over crawl depth
3. Additional Code coverage with more test cases