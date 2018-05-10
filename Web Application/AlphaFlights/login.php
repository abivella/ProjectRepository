<?php
    session_start();
    require_once("menu.php");

    if(isset($_SESSION['email'])){
        header('Location: home.php');
    }
?>
    <div class="container">
        <form method="post" action="login.php">
            <div class="row">
                <div class="col-sm-3">
                    <h2>Login</h2>
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
                    <button type="submit" id="submit" name="submit" class="btn btn-primary">Login</button>
                </div>
            </div>
        </form>
    </div>
    <?php
        require_once('connection.php');
        if(isset($_POST['submit'])){
            $email = $_POST['email'];
            $password = $_POST['password'];

            
            $query = "SELECT* FROM account_tbl WHERE Email = '$email' AND Pass =  sha1('$password')";
            $result = mysqli_query(connectToMySQL(), $query) or die("Error in query: ". mysqli_error(connectToMySQL()));

            $row = mysqli_fetch_row($result);
            $count = $row[0];

            if($count > 0){
                $_SESSION['email'] = $email;
                $_SESSION['time'] = time();
                header('Location: home.php');
            }
            else{
                $query = "SELECT* FROM account_tbl WHERE Email = '$email'";
                $result = mysqli_query(connectToMySQL(), $query) or die("Error in query: ". mysqli_error(connectToMySQL()));

                $row = mysqli_fetch_row($result);
                $count = $row[0];

                if($count > 0){
                    ?>
                    <div class="alert alert-danger">Incorrect Password!</div>
                    <?php
                }
                else{
                    ?>
                    <div class="alert alert-danger">Email Does Not Exist. Please Sign up</div>
                    <?php
                }
            }
        } 
        
    ?>

<?php require_once('footer.php'); ?>