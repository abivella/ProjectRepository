<?php   
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

?>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Help</h1>
        <p class="lead">AlphaFlights Help</p>
        <hr class="my-4">
        <p>To book a flight, login or create a new account.</p>
        <p>- Select the departure and destination airport</p>
        <p>- select departure date and return date(if not one-way)</p>
        <p>- choose the amount of passengers and the flight class (Economy, Business or first Class)</p>
        <p>After enetering the details above, you will be shown the available flight/s which you can choose from to book</p>
        <p>After selecting a departure and/or a return flight, you will be asked to enter the passenger details:</p>
        <ul>
            <li>First Name</li>
            <li>Last Name</li>
            <li>Title(Mr, Ms, Mrs, Miss)</li>
            <li>Passport Number</li>
            <li>ID Card Number</li>
            <li>Insurnace</li>
            <li>Contact Person</li>
            <li>Extra Luggage</li>
            <li>Baby Equipment</li>
            <li>Sports Equipment</li>
        </ul>
        <p>After the details have been entered, the booking will be made</p>
        <p>Make sure to check-in online from the 'Online Check-in Page'</p>
        <p>All flights can be viewed from the 'My Flights' page</p>
        <p class="lead">
            <?php
            echo '<a class="btn btn-primary mr-4" href="index.php" role="button">Book a Flight</a>';

            if(isset($_SESSION['email'])){
                echo '<a class="btn btn-primary mr-4" href="checkIn.php" role="button">Online Check-in</a>';
            }
            else{
                echo '<a class="btn btn-primary mr-4" href="login.php" role="button">Login</a>';
                echo '<a class="btn btn-primary mr-4" href="signUp.php" role="button">Register</a>';
            }

            ?>
        </p>
    </div>
</div>