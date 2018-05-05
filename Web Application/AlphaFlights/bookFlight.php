<!DOCTYPE html>
<?php
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }
?>


    <div class="container">
        <form action="bookFlight.php" method="post">
            <div class="row">
                <div class="col-sm-6">
                    <label><b>Departure</b></label>
                </div>
                <div class="col-sm-6">
                    <label><b>Destination</b></label>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">     
                    <select id="departure" name="departure" class="form-control" required>
                        <?php
                            $query = "SELECT * FROM airport_tbl";

                            $result = mysqli_query(connectToMySQL(), $query)
                            or die("Error in query: " . mysqli_error(connectToMySQL()));
                    
                            while ($row = mysqli_fetch_assoc($result))
                            {
                                echo "<option>".airportInfo($row['AirportId'])."</option>";
                            }        
                        ?>
                    </select>
                </div>
                <div class="col-sm-6">
                    <select id="destination" name="destination" class="form-control" required>
                        <?php
                            $query = "SELECT * FROM airport_tbl";

                            $result = mysqli_query(connectToMySQL(), $query)
                            or die("Error in query: " . mysqli_error(connectToMySQL()));
                    
                            while ($row = mysqli_fetch_assoc($result))
                            {
                                echo "<option>".airportInfo($row['AirportId'])."</option>";
                            }     
                        ?>
                    </select>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-sm-3">
                    <label><b>Departing</b></label>
                </div>
                <div class="col-sm-3">
                    <label><b>Returning</b></label>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-sm-3">
                    <?php
                        $currentDay = date("Y-m-d");
                        $maxDay = date("Y-m-d",strtotime(date("Y-m-d", mktime()) . " + 365 day"));
                        echo "<input type='date' name='depDate' class='form-control' onkeydown='return false' min='$currentDay' max='$maxDay'>";
                    ?>
                </div>
                <div class="col-sm-3">
                    <?php
                        echo "<input type='date' name='RetDate' class='form-control' onkeydown='return false' min='$currentDay' max='$maxDay'>";
                    ?>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-sm-1">
                    <label>Adults<label>
                </div>
                <div class="col-sm-1">
                    <label>Child<label>
                </div>
                <div class="col-sm-1">
                    <label>Infant<label>
                </div>
                <div class="col-sm-2">
                    <label>Class<label>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-1">
                    <input type="number" class="form-control" min="1" max="10" value="1">
                </div>
                <div class="col-sm-1">
                    <input type="number" class="form-control" min="0" max="10" value="0">
                </div>
                <div class="col-sm-1">
                    <input type="number" class="form-control" min="0" max="10" value="0">
                </div>
                <div class="col-sm-2">
                    <select id="class" name="class" class="form-control">
                        <option>Economy Class</option>
                        <option>Business Class</option>
                        <option>First Class</option>
                    </select>
                </div>
            </div>
            
            <div class="row mt-4">
                <div class="col-sm-6">
                    <button type="submit" name="search" class="btn btn-primary">Search Flight</button><br/>
                </div>
            </div>
        </form>
    </div>

<?php require_once('footer.php'); ?>