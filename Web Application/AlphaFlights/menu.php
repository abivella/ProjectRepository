<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Alpha Flights</title>

        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark p-3 mb-3">
                
            <div class="container">
            
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>   
                </button>
                <a class="navbar-brand" href="index.php">
                    <img src="Images/Logo.png" alt="Logo" style="width:175px; height:75px;"/>
                </a>

                <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <?php
                            if(isset($_SESSION['email'])){
                                ?>
                                    <li class="nav-item">
                                        <a class="nav-link" href="index.php">Book Flight</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="checkIn.php">Online check-In</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="account.php">My Account</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="logout.php"><b>Log out</b></a>
                                    </li>
                                <?php
                            }
                            else{
                               ?>
                                    <li class="nav-item pl-5">
                                        <a class="nav-link" href="login.php">Login</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="register.php">Register</a>
                                    </li>
                                <?php 
                            }
                        ?>
                    </ul>
                </div>               
            </div>
        </nav>