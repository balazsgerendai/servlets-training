$(document).ready(function() {                        // When the HTML DOM is ready loading, then execute the following function...
    $('#startBattle').click(function() {               // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
        $.get('logger', function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
            $('#battleReportContent').html(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
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