function readFileStromValues (){
	$.ajax({
		url: 'valuesStrom.txt',
		type: 'get',
		success: function(txt){
			var txtArrayStromValues = txt.split('\n');
		}
	})
}

function readFileWasserValues (){
	$.ajax({
		url: 'valuesWasser.txt',
		type: 'get',
		success: function(txt){
			var txtArrayWasserValues = txt.split('\n');
		}
	})
}
$(function () {
    Highcharts.chart('container', {
        title: {
            text: 'Strom - und Wasserverbrauch',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: verbrauch.db',
            x: -20
        },
        xAxis: {
            categories: ['Januar 2016', 'Febuar 2016', 'Maerz 2016', 'April 2016',
                'Mai 2016', 'Juni 2016', 'Juli 2016', 'August 2016', 'September 2016', 'Oktober 2016', 'November 2016', 'Dezember 2016']
        },
        yAxis: {
            title: {
                text: 'Verbrauch in kWh'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'kWh'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Strom',
            data: [txtArrayStromValues[0], txtArrayStromValues[1], txtArrayStromValues[2], txtArrayStromValues[3], txtArrayStromValues[4]
			, txtArrayStromValues[5], txtArrayStromValues[6], txtArrayStromValues[7], txtArrayStromValues[8],
			txtArrayStromValues[9], txtArrayStromValues[10], txtArrayStromValues[11]]
        },
		{
            name: 'Wasser',
            data: [txtArrayWasserValues[0], txtArrayWasserValues[1], txtArrayWasserValues[2], txtArrayWasserValues[3], txtArrayWasserValues[4]
			, txtArrayWasserValues[5], txtArrayStromValues[6], txtArrayStromValues[7], txtArrayStromValues[8]
			, txtArrayStromValues[9], txtArrayStromValues[10], txtArrayStromValues[11]]
        }]
    });
});