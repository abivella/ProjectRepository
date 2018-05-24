<?php   
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');
   
    $depAirport = $_GET['departure'];
    $destAirport = $_GET['destination'];
    $depDate = $_GET['depDate'];

    $adult = $_GET['passengerAdult'];
    $child = $_GET['passengerChild'];
    $infant = $_GET['passengerInfant'];
    $totalPassengers =  (int)$adult + (int)$child + (int)$infant;

    $class = $_GET['class'];

    $query = "SELECT * FROM flights_tbl WHERE AirportDep = '$depAirport' AND AirportDest = '$destAirport' AND FlightDate = '$depDate'";

    if(isset($_POST['next'])){
        
        $_SESSION['dep'] = $_POST['selectDep'];
        $a = $_SESSION['dep'];
        $_SESSION['ret'] = $_POST['selectRet'];
        $_SESSION['adult'] = $adult;
        $_SESSION['child'] = $child;
        $_SESSION['infant'] = $infant;
        $_SESSION['class'] = $class;

        $_SESSION['retPrice'] = $retPrice;
        $_SESSION['depPrice'] = $depPrice;

        echo " dep price: ";   
        header("Location: passengerInfo.php", true);
    }

    ?>

    <div class="container-fluid">
        <form id="flightDetails" method="post">
    <?php

            $result = mysqli_query(connectToMySQL(), $query)
            or die("Error in query: " . mysqli_error(connectToMySQL()));

            ?>           
            <table class="table">
                <tr><th colspan="9">Departure</th></tr>
                <tr>
                    <th>Flight Number</th>
                    <th>Departure</th>
                    <th>Destination</th>
                    <th>Flight Date</th>
                    <th>Duration</th>
                    <th>Time From</th>
                    <th>Time To</th>
                    <th>Price</th>
                </tr>
            <?php
                while ($row = mysqli_fetch_assoc($result))
                {   
                    $depFlight = $row['FlightId'];
                    ?>
                    
                        <div class="row">
                            <div class="col-sm-12">
                                <?php
                                    echo "<tr><td>$row[FlightNo]</td> <td>".airportInfo($row['AirportDep'])."</td> <td>".airportInfo($row['AirportDest'])."</td> <td>$row[FlightDate]</td> <td>$row[Duration]</td> <td>$row[TimeFrom]</td> <td>$row[TimeTo]</td> <td>€$row[Price]</td></tr>";
                                ?>
                            </div>
                        </div>
                    <?php   
                } 
            ?>
            </table>

            <h5>Select Departure Flight</h5>
            <select name='selectDep' class="form-control">
            <?php
                $query = "SELECT * FROM flights_tbl WHERE AirportDep = '$depAirport' AND AirportDest = '$destAirport' AND FlightDate = '$depDate'";
                $conn = connectToMySQL();
                $result = mysqli_query($conn, $query)
                or die("Error in query: " . mysqli_error($conn));
                

                while ($row = mysqli_fetch_assoc($result)){
                    $flight = $row['FlightNo'];
                    $depFlightId = $row['FlightId'];
                    $depPrice = $row['Price'];
                    echo "<option value='$depFlightId'>".$flight."</option>";
                }
            ?>           
            </select>
            <?php
                if(isset($_GET['retDate']) && !$_GET['retDate'] == ""){
                    $retDate = $_GET['retDate'];
                    $queryRet = "SELECT * FROM flights_tbl WHERE AirportDep = '$destAirport' AND AirportDest = '$depAirport' AND FlightDate = '$retDate'";
                    $conn = connectToMySQL();
                    $result = mysqli_query($conn, $queryRet)
                    or die("Error in query: " . mysqli_error($conn));

                    ?>
                    <table class="table">
                        <tr><th colspan="9"></th></tr>
                        <tr><th colspan="9" class="pt-5">Return</th></tr>
                        <tr>
                            <th>Flight Number</th>
                            <th>Departure</th>
                            <th>Destination</th>
                            <th>Flight Date</th>
                            <th>Duration</th>
                            <th>Time From</th>
                            <th>Time To</th>
                            <th>Price</th>
                        </tr>
                        <?php
                            while ($row = mysqli_fetch_assoc($result))
                            {   
                                $retFlight = $row['FlightId'];
                                ?>
                                
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <?php
                                                echo "<tr><td>$row[FlightNo]</td> <td>".airportInfo($row['AirportDep'])."</td> <td>".airportInfo($row['AirportDest'])."</td> <td>$row[FlightDate]</td> <td>$row[Duration]</td> <td>$row[TimeFrom]</td> <td>$row[TimeTo]</td> <td name='retPrice'>€$row[Price]</td></tr>";
                                            ?>
                                        </div>
                                    </div>
                                <?php   
                            } 
                        ?>
                        <tr><th colspan="9"></th></tr>
                        <tr><th colspan="9"></th></tr>
                    </table>

                <h5>Select Return Flight</h5>
                <select name='selectRet' class="form-control">
                <?php
                    $query = "SELECT * FROM flights_tbl WHERE AirportDep = '$destAirport' AND AirportDest = '$depAirport' AND FlightDate = '$retDate'";
                    $conn = connectToMySQL();
                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));
                    

                    while ($row = mysqli_fetch_assoc($result)){
                        $flight = $row['FlightNo'];
                        $retFlightId = $row['FlightId'];
                        $retPrice = $row['Price'];
                        echo "<option value='$retFlightId'>".$flight."</option>";
                    }
                ?>
                </select>
            <?php
                }
            ?> 
            <div class="row mt-4">
                <div class="col-sm-4">
                    <button class="btn btn-primary btn-block" name="next">Next</button>
                </div>
            </div>
        </form>        
    </div>
<?php require_once('footer.php'); ?>