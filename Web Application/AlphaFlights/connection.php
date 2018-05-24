<?php
    function connectToMySQL(){
        $conn = mysqli_connect("localhost", "root", "", "alphaflights", "3307") or die('Error connecting to the database');
        return $conn;
    }
?>