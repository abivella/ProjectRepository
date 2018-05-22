<?php   
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }

    $conn = connectToMySQL();

    $email = $_SESSION['email'];
    $conn = connectToMySQL();

    $query = "SELECT* FROM account_tbl WHERE Email = '$email'";
    $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
    while($row = mysqli_fetch_assoc($result)){
        $accountId = $row['AccountId'];
    }

    $query = "SELECT f.*, pf.* FROM passengerflight_tbl pf INNER JOIN flights_tbl f ON pf.FlightId = f.FlightId WHERE AccountId = '$accountId'";
    $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
            

?>

<div class="container-fluid">
    <form method="post" action="myFlights.php">
    <table class="table">
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
    </form>
</div>

<?php require_once('footer.php'); ?>