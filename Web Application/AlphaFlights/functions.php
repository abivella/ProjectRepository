<?php
    require_once('connection.php');

        function airportInfo($id){
            $airport = null;
            $city = null;
            $country = null;

            $query = "SELECT * FROM airport_tbl WHERE AirportId = '$id'";

            $result = mysqli_query(connectToMySQL(), $query)
            or die("Error in query1: " . mysqli_error(connectToMySQL()));

            while ($row = mysqli_fetch_assoc($result))
            {
            $airport = $row['AirportName'];
            }

            $query = "SELECT * FROM city_tbl WHERE CityId = (SELECT CityId FROM airport_tbl WHERE AirportId = '$id')";

            $result = mysqli_query(connectToMySQL(), $query)
            or die("Error in query2: " . mysqli_error(connectToMySQL()));

            while ($row = mysqli_fetch_assoc($result))
            {
            $city = $row['CityName'];
            }

            $query = "SELECT * FROM country_tbl WHERE CountryId = (SELECT CountryId FROM city_tbl WHERE CityId = (SELECT CityId FROM airport_tbl WHERE AirportId = '$id'))";

            $result = mysqli_query(connectToMySQL(), $query)
            or die("Error in query3: " . mysqli_error(connectToMySQL()));

            while ($row = mysqli_fetch_assoc($result))
            {
            $country = $row['CountryName'];
            }

            return "$airport ($country, $city)";
        }
?>