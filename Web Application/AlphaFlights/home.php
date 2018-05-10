<?php
    session_start();
    require_once('menu.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }
?>

<div class="container">
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-3">
            <h2>Alpha Flights</h2>
            <p>Welcome to alpha flights</p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-3">
            <img src = "Images\Logo.jpg" alt="logo">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-3">
            <a href = "bookFlight.php" class="btn btn-primary">Book a flight</a>
            <a href = "account.php" class="btn btn-primary">My Account</a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-3"></div>
    </div>
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-3">
            <a href = "checkin.php" class="btn btn-primary">Online Check-in</a>
        </div>
    </div>
</div>

<?php require_once('footer.php'); ?>