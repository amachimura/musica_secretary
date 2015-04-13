$(document).ready(function(){
	$.getJSON("load", function(json){
		$("#singers").html(JSON.stringify(json));
	})
});