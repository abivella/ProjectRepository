<?php
    session_start();
    require_once("menu.php");

    if(isset($_SESSION['email'])){
        header('Location: index.php');
    }
?>
<div class="container">
    <form method="post" action="signUp.php">
        <div class="row">
            <div class="col-sm-3">
                <h2>Sign Up </h2>
                <label>Email</label>
                <input type="text" name="email" class="form-control" placeholder="Email" required><br/><br/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control" placeholder="Password" required><br/><br/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <button type="submit" id="submit" name="submit" class="btn btn-primary">Sign Up</button>
            </div>
        </div>
    </form>
</div>
<?php
    require_once('connection.php');
    if(isset($_POST['submit'])){
        $email = $_POST['email'];
        $password = $_POST['password'];

        

        
        $selQuery = "SELECT* FROM account_tbl WHERE Email = '$email'";
        $result = mysqli_query(connectToMySQL(), $selQuery) or die("Error in query: ". mysqli_error(connectToMySQL()));

        $row = mysqli_fetch_row($result);
        $count = $row[0];

        if($count > 0){
            ?>
            <div class="alert alert-danger">Email Already Exists</div>
            <?php
        }
        else{
            $_SESSION['email'] = $email;
            $_SESSION['password'] = $password;
            $_SESSION['time'] = time();

            $query = "INSERT INTO account_tbl(AccountId, Email, Pass) VALUES (null, '$email', sha1('$password'))";
            $result = mysqli_query(connectToMySQL(), $query) or die("Error in query: ". mysqli_error(connectToMySQL()));
            
            ?>
            <div class="alert alert-success">Account Created Successfully</div>        
            <?php
            header("Location: index.php");
        }
    } 
?>

<?php require_once('footer.php'); ?>