function(key, values) {
	return (values.length < 2) ? 0 : (values[0].population - values[1].population) / values[1].population * 100;
}
