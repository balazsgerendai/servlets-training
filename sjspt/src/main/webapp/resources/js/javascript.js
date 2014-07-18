	function nl2br (str, is_xhtml) {   
	    var breakTag = (is_xhtml || typeof is_xhtml === 'undefined') ? '<br />' : '<br>';    
	    return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1'+ breakTag +'$2');
	}

    $('#startBattle').click(function() {              
        $.get('logger', function(responseText) { 
            $('#battleReportContent').html(nl2br(responseText));   
            if(responseText.indexOf('Republic') > -1){
            	$( "#republicPanel" ).removeClass('hidden');
            	$( "#empirePanel" ).addClass('hidden');
            }else{
            	$( "#empirePanel" ).removeClass('hidden');
            	$( "#republicPanel" ).addClass('hidden');
            }
           
        });
    });
