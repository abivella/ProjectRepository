$("#oneWay").click(function(){
    if($("#oneWay").is(':checked')){
        document.getElementById("retDate").disabled = true;
    }
    else{
        document.getElementById("retDate").disabled = false;
    }
});

$('#passengerInfo').hide();
$('#flightDetails').show();

$("#next").click(function() {
    $('#passengerInfo').show();
    $('#flightDetails').hide();
});