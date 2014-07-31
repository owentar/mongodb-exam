function(key, values) {
	var sum = 0;
	
	for(var i = 0; i < values.length; i++) {
		sum += values[i];
	}
	
	var avg = sum / values.length;
	
	var deviation = 0;
	
	for (var i = 0; i < values.length; i++) {
		deviation += Math.abs(avg - values[i]);
	}
	
	return deviation / values.length;
}
