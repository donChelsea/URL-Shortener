# URL-Shortener

</br>The task for this project is to create a server that shortens URLs similar to how TinyURL shortens theirs.</br>

<h3> To run:</h3>
Download or clone it to your local machine. Once opened, import the gradle file to import all the dependencies. Afterwards, open the app class in src/main/java/com/katsidzira/ChelseaKatsidzira_URL_Shortener/ and run the app to start the server.</br> 

<br>To get a response, use Postman and enter the URL as http://localhost:8080/, switch the method to POST, and set the body to application/json. 

<h3>IDConverter</h3>
1. Creates a unique ID for shortened URL</br>
2. Also restore previous URL with the unique ID</br>


<h3>URLValidator</h3>
1. Validates the URL from controller</br>

<h3>URLController</h3>
1. Serving an endpoint to shorten URL</br>
2. Redirect shortened URL to the original URL</br>

<h3>URLRepository</h3>
1. Uses Redis database (Jedis library) for repository service</br>

<h3>URLConverterService</h3>
1. To abstract URL shortening processes</br>


<h3>ChelseaKatsidzira_URL_ShortenerApplication</h3>
1. The entry point for the Spring application</br>
