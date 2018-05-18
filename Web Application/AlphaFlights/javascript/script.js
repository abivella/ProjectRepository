$("#oneWay").click(function(){
    if($("#oneWay").is(':checked')){
        document.getElementById("retDate").disabled = true;
    }
    else{
        document.getElementById("retDate").disabled = false;
    }
});

/*alert("btn clicked");
$('#passengerInfo').hide();
$('#flightDetails').show();

$("#next").click(function() {
    //alert("btn clicked");
    $('#passengerInfo').show();
    $('#flightDetails').hide();
});*/