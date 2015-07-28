jQuery(document).ready(function ($) {
	
	var eventTrigger = 'yottaquake.filters_update';
	var filters = {};
	
	$(document).on('yottaquake.bounding_box_update', function(e, newBB){
		
		console.log(newBB);
		filters.zoom = newBB.zoom;
		filters.topLeftLat = newBB.topLeft.lat;
		filters.topLeftLng = newBB.topLeft.lng;
		filters.bottomRightLat = newBB.bottomRight.lat;
		filters.bottomRightLng = newBB.bottomRight.lng;
		
		$(document).trigger(eventTrigger, filters);
	});
	
	$("#filters input.magnitude").slider({
		min: 0, 
		max: 7, 
		value: [0, 7],
		range: true
	}).on('change', function(e){
		filters.minMagnitude = e.value.newValue[0];
		filters.maxMagnitude = e.value.newValue[1];
		$(document).trigger(eventTrigger, filters);
	});
	
	var depthSlider = $("#filters input.depth").slider({
		min: 0, 
		max: 10, 
		value: [0, 10],
		range: true
	}).on('change', function(e){
		filters.minDepth = e.value.newValue[0];
		filters.maxDepth = e.value.newValue[1];
		$(document).trigger(eventTrigger, filters);
	});
	
	var date = $('#filters input.from').datepicker({
		startDate: '01-01-2000',
        endDate: new Date()
	}).on('change', function(e){
		
		if( $(this).val() == '' ) {
			filters.fromDate = null;
		}else{
			var date = new Date(e.timeStamp);
			filters.fromDate = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay();
		}
		
		$(document).trigger(eventTrigger, filters);
	}).datepicker('setDate', null);
	
	$('#filters input.to').datepicker({
		startDate: '01-01-2000',
        endDate: new Date()
	}).on('change', function(e){
		
		if( $(this).val() == '' ) {
			filters.toDate = null;
		}else{
			var date = new Date(e.timeStamp);
			filters.toDate = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay();
		}
		
		$(document).trigger(eventTrigger, filters);
	}).datepicker('setDate', null);
	
	$('#filters .layers input[type=checkbox]')
		.attr('checked', false)
		.on('change', function() {
			var filterName = $(this).attr('data-layer-filter');
			var status = $(this).is(":checked");
			filters[filterName] = status; 
			$(document).trigger(eventTrigger, filters);
	    });
	
	
});
		
	