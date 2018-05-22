<?php   
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }

    $email = $_SESSION['email'];
    $conn = connectToMySQL();

    $query = "SELECT* FROM account_tbl WHERE Email = '$email'";
    $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
    while($row = mysqli_fetch_assoc($result)){
        $accountId = $row['AccountId'];
    }
            

?>

<div class="container">
    <form method="post" action="checkIn.php">
        <div class="row">
            <div class="col-sm-4">
                <h4>Select Flight To Check-In</h4>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-sm-3">
                <select name="flight" class="form-control">
                    <?php
                        $currentDay = date("Y-m-d");
                        $query="SELECT f.FlightNo, f.FlightId, pf.isCheckedIn, f.FlightDate FROM passengerflight_tbl pf INNER JOIN flights_tbl f ON pf.FlightId = f.FlightId WHERE AccountId = '$accountId' AND pf.isCheckedIn='N' AND f.FlightDate >= '$currentDay'";
                        $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
                        while($row = mysqli_fetch_assoc($result)){
                            $flightId = $row['FlightId'];
                            $flightNo = $row['FlightNo'];
                            echo "<option value='$flightId'>$flightNo</option>";
                        }
                    ?>
                </select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-sm-4">
                <label><b>Check-In</b></label>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-sm-4">
                <input type="checkbox" name="checkin">Check-in
            </div>
        </div>
        <div class="row mt-4 mb-4">
            <div class="col-sm-4">
                <button class="btn btn-primary" name="submit">Check-In</button>
            </div>
        </div>
    </form>
</div>

<?php
    if(isset($_POST['submit'])){
        $flight = $_POST['flight'];
        if(isset($_POST['checkin'])){
            $checkedin='Y';
            echo '<div class="alert alert-success">Checked-In for flight number: '.$flightNo.'</div>';}else{$checkedin='N'; echo '<div class="alert alert-danger">Not checked-In for flight number: '.$flightNo.'. Please tick the checkbox to check-in </div>';}
            $query = "UPDATE passengerflight_tbl SET isCheckedIn='$checkedin' WHERE AccountId='$accountId' AND FlightId='$flight'";

            $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
    }
?>