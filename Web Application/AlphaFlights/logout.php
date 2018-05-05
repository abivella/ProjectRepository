<?php

    session_start();

    unset($_SESSION['email']);
    unset($_SESSION['time']);
    session_destroy();

    header('Location: index.php');

?>