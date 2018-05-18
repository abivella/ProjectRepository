/*$(document).ready(function(){
    $('#depCountry').change(function(){
        //Selected Val
        var inputVal = $(this).val();
        alert("Value: " + inputVal);

        $.ajax({
            url: 'bookFlight.php',
            type: 'POST',
            data: {depCountry:inputVal},
            success: function(result) {
                console.log(result);
            }
        });
        
    });
});*/

function fill(val){
    if (val == "") {
        document.getElementById("depCity").innerHTML = "";
        return;
    } else { 
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {                
                document.getElementById("depCity").innerHTML = this.responseText;                                
            }
        };
        xmlhttp.open("GET","test.php?country="+val,true);
        xmlhttp.send();
    }
}