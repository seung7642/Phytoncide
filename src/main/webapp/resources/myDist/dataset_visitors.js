$(function() {
	'use strict'
	
	var ticksStyle = {
			fontColor : '#495057',
			fontStyle : 'bold'
	}
	
	var mode = 'index'
    var intersect = true
	
	var $visitorsChart = $('#visitors-chart')
	var visitorsChart = new Chart($visitorsChart, {
		data : {
			labels : ['18일', '20일', '22일', '24일', '26일', '28일', '30일'],
			datasets : [{
				type : 'line',
				data : [100, 120, 170, 167, 180, 177, 160],
				backgroundColor : 'transparent',
				borderColor : '#007bff',
				pointBorderColor : '#007bff',
				pointBackgroundColor: '#007bff',
				fill : false
			}, {
			type : 'line',
			data : [60, 80, 70, 67, 80, 77, 60],
			backgroundColor : 'transparent',
			borderColor : '#ced4da',
			pointBorderColor : '#ced4da',
			pointBackgroundColor: '#ced4da',
			fill : false
			}]
		},
		options : {
			maintainAspectRatio : false,
			tooltips : {
				mode : mode,
				intersect : intersect
			},
			hover : {
				mode : mode,
				intersect : intersect
			},
			legend : {
				display : false
			}, 
			scales : {
				yAxes : [{
					gridLines : {
						display : true,
						lineWidth : '4px',
						color : 'rgba(0, 0, 0, .2)',
						zeroLineColor : 'transparent'
					},
					ticks : $.extend({
						beginAtZero : true,
						suggetedMax : 200
					}, ticksStyle)
				}],
				xAxes : [{
					display : true,
					gridLines : {
						display : false
					},
					ticks : ticksStyle
				}]
			}
		}
	})
})