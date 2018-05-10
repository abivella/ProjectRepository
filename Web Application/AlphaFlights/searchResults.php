<?php
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }

    $depAirport = $_GET['departure'];
    $destAirport = $_GET['destination'];
    $depDate = $_GET['depDate'];

    $adult = $_GET['passengerAdult'];
    $child = $_GET['passengerChild'];
    $infant = $_GET['passengerInfant'];
    $totalPassengers = $adult + $child + $infant;

    $query = "SELECT * FROM flights_tbl WHERE AirportDep = '$depAirport' AND AirportDest = '$destAirport' AND FlightDate = '$depDate'";

    ?>

    <div class="container-fluid">
        <form id="flightDetails">
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
                    <th>Select Flight</th>
                </tr>
            <?php
                while ($row = mysqli_fetch_assoc($result))
                {   
                    ?>
                    
                        <div class="row">
                            <div class="col-sm-12">
                                <?php
                                    echo "<tr><td>$row[FlightNo]</td> <td>".airportInfo($row['AirportDep'])."</td> <td>".airportInfo($row['AirportDest'])."</td> <td>$row[FlightDate]</td> <td>$row[Duration]</td> <td>$row[TimeFrom]</td> <td>$row[TimeTo]</td> <td>€$row[Price]</td> <td><input type='checkbox' name='selectDep'></td> </tr>";
                                ?>
                            </div>
                        </div>
                    <?php   
                } 
            ?>
            <?php
                if(isset($_GET['retDate']) && !$_GET['retDate'] == ""){
                    $retDate = $_GET['retDate'];
                    $queryRet = "SELECT * FROM flights_tbl WHERE AirportDep = '$destAirport' AND AirportDest = '$depAirport' AND FlightDate = '$retDate'";
                    $result = mysqli_query(connectToMySQL(), $queryRet)
                    or die("Error in query: " . mysqli_error(connectToMySQL()));

                    ?>
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
                            <th>Select Flight</th>
                        </tr>
                    <?php
                        while ($row = mysqli_fetch_assoc($result))
                        {   
                            ?>
                            
                                <div class="row">
                                    <div class="col-sm-12">
                                        <?php
                                            echo "<tr><td>$row[FlightNo]</td> <td>".airportInfo($row['AirportDep'])."</td> <td>".airportInfo($row['AirportDest'])."</td> <td>$row[FlightDate]</td> <td>$row[Duration]</td> <td>$row[TimeFrom]</td> <td>$row[TimeTo]</td> <td>€$row[Price]</td> <td><input type='checkbox' name='selectRet'></td> </tr>";
                                        ?>
                                    </div>
                                </div>
                            <?php   
                        } 
                    ?>
                    <tr><th colspan="9"></th></tr>
                    <tr><th colspan="9"></th></tr>
                </table>
                
            <?php
                }
            ?>
            <div class="row mt-4">
                <div class="col-sm-4">
                    <button id="next" name="next" class="btn btn-primary btn-block" type="button">Next</button>
                </div>
            </div>
        </form> 
        
        <?php
            for($i=1; $i <= $totalPassengers; $i++){
                ?>
                <form action="bookFlight2.php" method="post" id="passengerInfo">
                    <div class="row mt-5 pt-5">
                        <div class="col-sm-1">
                        <?php
                            echo "<label><b>Passenger ".$i."</b><label>"
                        ?>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <label>First Name</label>
                            <?php
                                echo '<input type="text" name="name'.$i.'" class="form-control" placeholder="First Name" required>';
                            ?>
                        </div>
                        <div class="col-sm-2">
                            <label>Last Name</label>
                            <?php
                                echo '<input type="text" name="surname'.$i.'" class="form-control" placeholder="Last Name" required><br/>';
                            ?>
                        </div>
                        <div class="col-sm-1">
                            <label>Add insurance</label>
                            <?php
                                echo '<input type="checkbox" name="insurance'.$i.'" class="form-control"><br/>';
                            ?>
                        </div> 
                    </div>
                    <div class="row">
                        <div class="col-sm-1">
                            <label>Title</label>
                            <?php
                                echo '<select name="title'.$i.'" class="form-control" required>
                                    <option>Mr.</option>
                                    <option>Ms.</option>
                                    <option>Mrs.</option>
                                    <option>Miss.</option>
                                </select>';
                            ?>
                        </div>
                        <div class="col-sm-3">
                            <label>Passport Number</label>
                            <?php
                                echo '<input type="text" name="passportNumber'.$i.'" class="form-control" placeholder="Passport Number" required></br>';
                            ?>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <label>Contact Person</label>
                        </div>
                        <div class="col-sm-1">
                            <?php
                                echo '<input type="checkbox" name="contactPerson'.$i.'" class="form-check-input"></br></br>';
                            ?>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label>Phone Number</label>
                            <?php
                                echo '<input type="text" name="phoneNumber'.$i.'" class="form-control" placeholder="Phone Number"></br>';
                            ?>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label>ID Card Number</label>
                            <?php
                                echo '<input type="text" name="IDCardNumber'.$i.'" class="form-control" placeholder="ID Card Number"></br>';
                            ?>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <label>Sports Equipment (Kg)</label>
                            <?php
                                echo '<input type="text" name="sportsEquip'.$i.'" class="form-control" placeholder="Equipment Weight(Kg)"><br/>';
                            ?>
                        </div>
                        <div class="col-sm-2">
                            <label>Baby Equipment (Kg)</label>
                            <?php
                                echo '<input type="text" name="babyEquip'.$i.'" class="form-control" placeholder="Equipment Weight(Kg)"><br/>';
                            ?>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2">
                            <label>Extra Luggage</label>
                            <?php
                                echo '<input type="checkbox" name="extraLugg'.$i.'" class="form-control extraLuggCkb"><br/>';
                            ?>
                        </div>
                        <div class="col-sm-2">
                            <label class="extraLuggLbl">Extra Luggage Weight (Kg)</label>
                            <?php
                                echo '<input type="text" name="extraLuggage'.$i.'" class="form-control extraLuggTxt" placeholder="Extra Luggage Weight(Kg)"><br/>';
                            ?>
                        </div>
                    </div>            
            <?php
            }
        ?>         
    </div>
<?php require_once('footer.php'); ?>