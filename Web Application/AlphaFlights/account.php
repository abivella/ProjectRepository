<?php
    session_start();
    require_once('menu.php'); 
    require_once('connection.php'); 
    require_once('functions.php');

    if(!isset($_SESSION['email'])){
        header('Location: login.php');
    }

    $email = $_SESSION['email'];

    $query = "SELECT* FROM account_tbl WHERE Email = '$email'";
    $conn = connectToMySQL();
    $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));

?>

<div class="container">
    <form method="post" action="account.php">
        <div class="row mt-5">
            <div class="col-sm-3">
                <label>First Name</label>
                <?php
                    while($row = mysqli_fetch_assoc($result)){
                        $name = $row['FirstName'];
                        echo '<input type="text" name="name" class="form-control" placeholder="First Name" value="'.$name.'">';
                ?>
            </div>
            <div class="col-sm-3">
                <label>Last Name</label>
                <?php
                    $surname = $row['LastName'];
                    echo '<input type="text" name="surname" class="form-control" placeholder="Last Name" value="'.$surname.'">';
                ?>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-sm-3">
                <label><b>Change Password</b></label>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <label>Password</label>
                <?php
                    echo '<input type="password" name="pass" class="form-control" placeholder="Password">';
                ?>
            </div> 
            <div class="col-sm-3">
                <label>Confirm Password</label>
                <?php
                    echo '<input type="password" name="Confirmpass" class="form-control" placeholder="Confirm Password">';
                ?>
            </div> 
            
        </div>
        <?php
                }
        ?>
        <div class="row mt-4 mb-4">
            <div class="col-sm-6">
                <button class="btn btn-primary btn-block" name="save">Save Details</button>
            </div>
        </div>
    </form>
</div>

<?php
    if(isset($_POST['save'])){
        $name = $_POST['name'];
        $surname = $_POST['surname'];
        $password = $_POST['pass'];
        $confirmPass = $_POST['Confirmpass'];

        if($password != ""){
            if($password == $confirmPass){
                //Update with pass
                $query = "UPDATE account_tbl SET FirstName='$name', LastName='$surname', Pass=sha1('$password') WHERE Email='$email'";
                $conn = connectToMySQL();
                $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
    
                echo '<div class="alert alert-success">Details Updated Successfully</div>';
            }
            else{
                echo '<div class="alert alert-danger">Passwords Do Not Match!</div>';
            }
        }
        else{
            //Update w/out pass
            $query = "UPDATE account_tbl SET FirstName='$name', LastName='$surname' WHERE Email='$email'";
            $conn = connectToMySQL();
            $result = mysqli_query($conn, $query) or die("Error in query: ". mysqli_error($conn));
    
            echo '<div class="alert alert-success">Details Updated Successfully</div>';
        }
    }
?>

<?php require_once('footer.php'); ?>