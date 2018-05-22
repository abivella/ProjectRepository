<?php   
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }

    $email = $_SESSION['email'];
    $adult = $_SESSION['adult'];
    $child = $_SESSION['child'];   
    $infant = $_SESSION['infant'];
    $totalPassengers = (int)$adult + (int)$child + (int)$infant;

    
    $class = $_SESSION['class'];

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
                    echo "<label><b>Passenger ".$i."</b></label>"
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
                        echo '<select name="sportsEquip'.$i.'" class="form-control">
                                <option value="0">0Kg</option>
                                <option value="2">2Kg</option>
                                <option value="5">5Kg</option>
                                <option value="7">7Kg</option>
                                <option value="10">10Kg</option>
                                <option value="15">15Kg</option>
                                <option value="20">20Kg</option>
                                </select>';
                    ?>
                </div>
                <div class="col-sm-2">
                    <label>Baby Equipment (Kg)</label>
                    <?php
                        echo '<select name="babyEquip'.$i.'" class="form-control">
                                <option value="0">0Kg</option>
                                <option value="2">2Kg</option>
                                <option value="5">5Kg</option>
                                <option value="7">7Kg</option>
                                <option value="10">10Kg</option>
                                </select>';
                    ?>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-2">
                    <label class="extraLuggLbl">Extra Luggage Weight (Kg)</label>
                    <?php
                        echo '<select name="extraLuggage'.$i.'" class="form-control">
                                <option value="0">0Kg</option>
                                <option value="2">2Kg</option>
                                <option value="5">5Kg</option>
                                <option value="7">7Kg</option>
                                <option value="10">10Kg</option>
                                <option value="15">15Kg</option>
                                <option value="20">20Kg</option>
                                </select>';
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

            <div class="row">
                <div class="col-sm-4">
                <?php
                    //GET DEP PRICE
                    $query = "SELECT * FROM flights_tbl WHERE FlightId = '$dep'";
                    $conn = connectToMySQL();
                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));


                    while ($row = mysqli_fetch_assoc($result)){
                        $price = $row['Price'];
                        echo "<input type='hidden' name='depPrice' value='$price'>";
                        echo "<label>Departure Price</label>";
                        $tPrice = $price*$totalPassengers;
                        echo "<input type='text' class='form-control' value='€$tPrice' disabled>";
                    }
                ?>

            
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4">
                <?php
                    //GET RET PRICE
                    $query = "SELECT * FROM flights_tbl WHERE FlightId = '$ret'";
                    $conn = connectToMySQL();
                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));


                    while ($row = mysqli_fetch_assoc($result)){
                        $price = $row['Price'];
                        echo "<input type='hidden' name='retPrice' value='$price'>";
                        echo "<label>Return Price</label>";
                        $rPrice = $price*$totalPassengers;
                        echo "<input type='text' class='form-control' value='€$rPrice' disabled>";
                    }
                ?>

            
                </div>
            </div>

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
            $depPrice = $_POST['depPrice'];

            $query = "SELECT* FROM account_tbl WHERE Email = '$email'";
            $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
            while($row = mysqli_fetch_assoc($result)){
                $accountId = $row['AccountId'];
            }
            
            for($i=1; $i <= $totalPassengers; $i++){


                if(isset($_POST['insurance'.$i])){$insurance='Y';}else{$insurance='N';}
                if(isset($_POST['contactPerson'.$i])){$contactPerson='Y';}else{$contactPerson='N';}

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

                

                echo "dep price: $depPrice";

                $totalDepPrice = (float)$depPrice * (float)$totalPassengers;
               

                $finalPrice = $totalDepPrice;

                echo "dep flight: $dep";
                echo "ret flight: $ret";
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
                echo "class: $class";

                $query = "SELECT* FROM passenger_tbl WHERE IDCardNo = '$idCardNo'";
                $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));

                $row = mysqli_fetch_row($result);
                $count = $row[0];

                if($count > 0){
                    echo "<div class='alert alert-danger'>Passesnger exists</div>";
                    $query = "UPDATE passenger_tbl SET FirstName = '$name', LastName = '$surname', Title = '$title', PassportNumber = '$passportNumber', PhoneNumber = '$phoneNumber', IDCardNo = '$idCardNo' WHERE IDCardNo='$idCardNo'";
                    

                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));

                    //Insert departure flight
                    $query = "INSERT INTO passengerflight_tbl(BookingId, FlightId, PassengerId, ClassId, SportsEquipment, BabyEquipment,
                     ExtraLuggageWeight, isInsured, FinalPrice, TypeId, isCheckedIn, IsContactPerson, AccountId)
                     VALUES(NULL, '$dep',
                     (SELECT PassengerId FROM Passenger_tbl WHERE IDCardNo = '$idCardNo'), 
                     '$class', '$sportEquip', '$babyEquip', '$extraLuggWeight', '$insurance', '$depPrice', '$type', 'N', '$contactPerson', '$accountId')";

                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));

                    //Insert return flight
                    if($ret != ""){
                        $retPrice = $_POST['retPrice'];
                        $totalRetPrice = (float)$retPrice * (float)$totalPassengers;
                        $finalPrice = $totalDepPrice + $totalRetPrice;

                        //Insert rerturn flight
                        $query = "INSERT INTO passengerflight_tbl(BookingId, FlightId, PassengerId, ClassId, SportsEquipment, BabyEquipment, ExtraLuggage,
                        ExtraLuggageWeight, isInsured, FinalPrice, TypeId, isCheckedIn, IsContactPerson, AccountId)
                        VALUES(NULL, '$ret',
                        (SELECT PassengerId FROM Passenger_tbl WHERE IDCardNo = '$idCardNo'), 
                        '$class', '$sportEquip', '$babyEquip', '$extraLuggWeight', '$insurance', '$retPrice', '$type', 'N', '$contactPerson', '$accountId')";

                        $result = mysqli_query($conn, $query)
                        or die("Error in query: " . mysqli_error($conn));
                    }
                }
                else{
                    $query = "INSERT INTO passenger_tbl(PassengerId, FirstName, LastName, Title, PhoneNumber, PassportNumber, IDCardNo) 
                    VALUES(NULL, '$name', '$surname', '$title', '$phoneNumber', '$passportNumber', '$idCardNo')";
                    

                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));

                    //Insert departure flight
                    $query = "INSERT INTO passengerflight_tbl(BookingId, FlightId, PassengerId, ClassId, SportsEquipment, BabyEquipment,
                     ExtraLuggageWeight, isInsured, FinalPrice, TypeId, isCheckedIn, IsContactPerson, AccountId)
                     VALUES(NULL, '$dep',
                     (SELECT PassengerId FROM Passenger_tbl WHERE IDCardNo = '$idCardNo'), 
                     '$class', '$sportEquip', '$babyEquip', '$extraLuggWeight', '$insurance', '$depPrice', '$type', 'N', '$contactPerson', '$accountId')";

                    $result = mysqli_query($conn, $query)
                    or die("Error in query: " . mysqli_error($conn));

                    //Insert return flight
                    if($ret != ""){
                        $retPrice = $_POST['retPrice'];
                        $totalRetPrice = (float)$retPrice * (float)$totalPassengers;
                        $finalPrice = $totalDepPrice + $totalRetPrice;

                        //Insert rerturn flight
                        $query = "INSERT INTO passengerflight_tbl(BookingId, FlightId, PassengerId, ClassId, SportsEquipment, BabyEquipment,
                        ExtraLuggageWeight, isInsured, FinalPrice, TypeId, isCheckedIn, IsContactPerson, AccountId)
                        VALUES(NULL, '$ret',
                        (SELECT PassengerId FROM Passenger_tbl WHERE IDCardNo = '$idCardNo'), 
                        '$class', '$sportEquip', '$babyEquip', '$extraLuggWeight', '$insurance', '$retPrice', '$type', 'N', '$contactPerson', '$accountId')";

                        $result = mysqli_query($conn, $query)
                        or die("Error in query: " . mysqli_error($conn));
                        }
                }
            }
        }
    ?>

    <?php require_once('footer.php'); ?>