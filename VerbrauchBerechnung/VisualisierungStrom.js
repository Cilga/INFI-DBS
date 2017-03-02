function readFileStromValues (){
	$.ajax({
		url: 'valuesWasser.txt',
		type: 'get',
		success: function(txt){
			var txtArrayWasserValues = txt.split('\n');
		}
	})
}

Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Absolute Wasserverbraeuche 2016'
    },
    subtitle: {
        text: 'Source: verbrauch.db'
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Verbrauch in kwh'
        }
    },
    legend: {
        enabled: false
    },
    series: [{
        name: 'Verbrauch',
        data: [
            ['Januar', txtArrayWasserValues[0]],
            ['Februar', txtArrayWasserValues[1]],
            ['Maerz', txtArrayWasserValues[2]],
            ['April', txtArrayWasserValues[3]],
            ['Mai', txtArrayWasserValues[4]],
            ['Juni', txtArrayWasserValues[5]],
            ['Juli', txtArrayWasserValues[6]],
            ['August', txtArrayWasserValues[7]],
            ['September', txtArrayWasserValues[8]],
            ['Oktober', txtArrayWasserValues[9]],
            ['November', txtArrayWasserValues[10]],
            ['Dezember', txtArrayWasserValues[11]]
        ],
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y:.1f}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});