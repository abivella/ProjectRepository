<?php
    session_start();
    require_once("menu.php");
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
        <a href = "signUp.php" class="btn btn-primary">Sign Up </a>
        <a href = "login.php" class="btn btn-primary">Login </a>
        </div>
    </div>
</div>

<?php require_once('footer.php'); ?>