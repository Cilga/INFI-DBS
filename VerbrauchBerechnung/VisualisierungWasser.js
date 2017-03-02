function readFileStromValues (){
	$.ajax({
		url: 'valuesStrom.txt',
		type: 'get',
		success: function(txt){
			var txtArrayStromValues = txt.split('\n');
		}
	})
}

Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Absolute Stromverbraeuche 2016'
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
            ['Januar', txtArrayStromValues[0]],
            ['Februar', txtArrayStromValues[1]],
            ['Maerz', txtArrayStromValues[2]],
            ['April', txtArrayStromValues[3]],
            ['Mai', txtArrayStromValues[4]],
            ['Juni', txtArrayStromValues[5]],
            ['Juli', txtArrayStromValues[6]],
            ['August', txtArrayStromValues[7]],
            ['September', txtArrayStromValues[8]],
            ['Oktober', txtArrayStromValues[9]],
            ['November', txtArrayStromValues[10]],
            ['Dezember', txtArrayStromValues[11]]
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