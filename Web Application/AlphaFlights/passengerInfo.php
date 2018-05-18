<?php   
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }

    $adult = $_SESSION['adult'];
    $child = $_SESSION['child'];   
    $infant = $_SESSION['infant'];
    $totalPassengers = (int)$adult + (int)$child + (int)$infant;

    
    $class = $_SESSION['class'];
    $depPrice = $_SESSION['depPrice'];
    $retPrice = $_SESSION['retPrice'];

    $dep = $_SESSION['dep'];
    $ret = $_SESSION['ret'];

    echo "dep: $dep";
    echo "ret: $ret";

    echo "total passengers: $totalPassengers";
?>
    <div class="container-fluid">
        <form method="post" id="passengerInfo">
<?php
    for($i=1; $i <= $totalPassengers; $i++){
        ?>
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
            <div class="row">
                <div class="col-sm-4">
                    <label>Passenger Type</label>
                        <?php
                            echo '<select name="type'.$i. '" class="form-control">';
                            $conn = connectToMySQL();
                            $query = "SELECT * FROM passengertype_tbl";

                            $result = mysqli_query($conn, $query)
                            or die("Error in query: " . mysqli_error($conn));
                    
                            while ($row = mysqli_fetch_assoc($result))
                            {
                                $TypeId = $row['TypeId'];
                                echo "<option value='$TypeId'>".$row['PassengerType']."</option>";
                            }
                        ?>
                    </select>
                </div>
            </div>     
            <hr>     
        
<?php
    } //for loop
?>      
            <div class="row mt-4">
                <div class="col-sm-4 mb-4">
                    <button name="bookFlight" class="btn btn-primary btn-block" type="submit">Book Flight</button>
                </div>
            </div>
        </form>
    </div>

    <?php
        if(isset($_POST['bookFlight'])){
            $conn = connectToMySQL();
            $depFlight = $_GET['retFlight'];
            $retFlight = $_GET['depFlight'];
            for($i=1; $i <= $totalPassengers; $i++){


                if(isset($_POST['insurance'.$i])){$insurance='Y';}else{$insurance='N';}
                if(isset($_POST['contactPerson'.$i])){$contactPerson='Y';}else{$contactPerson='N';}
                if(isset($_POST['extraLugg'.$i])){$extraLugg='Y';}else{$extraLugg='N';}

                $name = $_POST['name'.$i];
                $surname = $_POST['surname'.$i];                
                $title = $_POST['title'.$i];
                $passportNumber = $_POST['passportNumber'.$i];
                $phoneNumber = $_POST['phoneNumber'.$i];
                $idCardNo = $_POST['IDCardNumber'.$i];
                $extraLuggWeight = $_POST['extraLuggage'.$i];
                $sportEquip = $_POST['sportsEquip'.$i];
                $babyEquip = $_POST['babyEquip'.$i];
                $type = $_POST['type'.$i];

                $totalDepPrice = (int)$depPrice * (int)$totalPassengers;
                $totalRetPrice = (int)$retPrice * (int)$totalPassengers;

                $finalPrice = $totalDepPrice + $totalRetPrice;

                echo "dep flight: $depFlight";
                echo "ret flight: $retFlight";
                echo "name : $name";
                echo "surname : $surname";
                echo "title : $title";
                echo "passport number : $passportNumber";
                echo "phone number : $phoneNumber";
                echo "id number : $idCardNo";
                echo "extra luggage weight : $extraLuggWeight";
                echo "price for 1 passenger : $depPrice";
                echo "total price : $totalDepPrice";
                echo "passenger type: $type";

                /*$query = "SELECT* FROM passenger_tbl WHERE IDCardNo = '$idCardNo'";
                $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));

                $row = mysqli_fetch_row($result);
                $count = $row[0];

                if($count > 0){
                    echo "<div class='alert alert-danger'>Passesnger exists</div>";
                }
                else{
                    $query = "INSERT INTO passenger_tbl(PassengerId, FirstName, LastName, Title, IsContactPerson, PhoneNumber, PassportNumber, IDCardNo) 
                    VALUES(NULL, '$name', '$surname', '$title', '$contactPerson', '$phoneNumber', '$passportNumber', '$idCardNo')";
                    

                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));

                    //Insert departure flight
                    $query = "INSERT INTO passengerflight_tbl(BookingId, FlightId, PassengerId, ClassId, SportsEquipment, BabyEquipment, ExtraLuggage,
                     ExtraLuggageWeight, isInsured, FinalPrice, TypeId, isCheckedIn)
                     VALUES(NULL, '$depFlight',
                     (SELECT PassengerId FROM Passenger_tbl WHERE IDCardNo = '$idCardNo'), 
                     (SELECT ClassId FROM flightClass_tbl WHERE Class = '$class'), 
                     '$sportEquip', '$babyEquip', '$extraLugg', '$extraLuggWeight', '$insurance', '$finalPrice', '$TypeId', 'N')";

                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));
                }*/
            }
        }
    ?>