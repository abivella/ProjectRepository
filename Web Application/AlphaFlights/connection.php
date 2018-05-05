<?php
    function connectToMySQL(){
        $conn = mysqli_connect("localhost", "root", "", "alphaflights", "3306") or die('Error connecting to the database');
        return $conn;
    }
?>