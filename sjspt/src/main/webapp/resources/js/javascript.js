$(document).ready(function() {                       
    $('#startBattle').click(function() {              
        $.get('logger', function(responseText) { 
            $('#battleReportContent').html(responseText);   
            $('#collapseOne').addClass('in');
            if(responseText.indexOf('Republic') > -1){
            	$( "#republicPanel" ).removeClass('hidden');
            	$( "#empirePanel" ).addClass('hidden');
            }else{
            	$( "#empirePanel" ).removeClass('hidden');
            	$( "#republicPanel" ).addClass('hidden');
            }
        });
    });
});