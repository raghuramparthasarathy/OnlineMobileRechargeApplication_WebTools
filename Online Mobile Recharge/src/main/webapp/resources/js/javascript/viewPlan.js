$(document).ready(function(){
	
});


function viewPlans(){
	$('#myModal').modal('show');
	var uri="plansAsJson.htm";
	callAjax(uri);
}

function callAjax(uri){
	$("#planList").jqGrid({
		url:uri,
		datatype:"json",
		loadonce:true,
		colNames: headers,
		colModel:[
		          {name:"planName",index:"planName",autowidth:true},
		          {name:"price",index:"price",autowidth:true},
               {name:"serviceProviderName",index:"serviceProviderName",autowidth:true}],
               onSelectRow: function(rowId){

            	   var rowId = $("#planList").jqGrid('getGridParam', 'selrow');

            	   var rowData = $("#planList").jqGrid('getRowData', rowId);
            	   var rowData1 = rowData.price;
            	   $('.ui-state-highlight').addClass("selected");
            	  $('#amount').val(rowData1);
            	  
               },
//		          
		          
		          sortable:false,
		          height:'100%',
		          width:'100%',
		          caption:"Recharge Plans",
		        	  
		        	  
	});
}