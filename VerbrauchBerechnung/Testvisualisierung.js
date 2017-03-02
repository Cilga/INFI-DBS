function readFileStromValues (){
	$.ajax({
		url: 'Testdaten.txt',
		type: 'get',
		success: function(txt){
			var txtValues = txt.split('\n');
		}
	})
}

Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Testdaten'
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
            ['Januar', txtValues[0]],
            ['Februar', txtValues[1]],
            ['Maerz', txtValues[2]],
            ['April', txtValues[3]],
            ['Mai', txtValues[4]],
            ['Juni', txtValues[5]],
            ['Juli', txtValues[6]],
            ['August', txtValues[7]],
            ['September', txtValues[8]],
            ['Oktober', txtValues[9]],
            ['November', txtValues[10]],
            ['Dezember', txtValues[11]]
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