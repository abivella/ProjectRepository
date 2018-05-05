$(document).ready(function(){
    $('#depCountry').change(function(){
        //Selected Val
        var inputVal = $(this).val();
        alert("Value: " + inputVal);

        $.ajax({
            url: 'AlphaFlights/bookFlight.php',
            type: 'POST',
            data: {id:id},
            success: function(data) {
                console.log(data); // Inspect this in your console
            }
        });
        
    });
});