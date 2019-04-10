$(function() {
    $.ajax({

        type: "GET",
        dataType: 'json',
        url: "http://localhost:8080/MEW/water/getWaters/",
        crossDomain: true,
        success: function (data) {
            var labels = Object.keys(data);
            var blue_values = labels.map(function (v) {
                return data[v].upperWaterLevel;
            });
            var darkblue_values = labels.map(function (g) {
                return data[g].lowerWaterLevel;
            });
            showChart("canvas_red", labels, blue_values, darkblue_values, "rgba(0,0,255,0.4)", "Water");
        }
    })

    var showChart = function(canvas, labels,blue_values, darkblue_values, color, label){
        var ctx = document.getElementById(canvas).getContext("2d");
        window[canvas] = new Chart(ctx,{
            type: 'line',
            data:prepareChartData(labels, blue_values, darkblue_values, color, label),
            options:{
                responsive: true,
                showScale: true,
                scales:{
                    yAxes:[{
                        ticks:{
                            callback: function(tick) { return tick.toFixed(2); }
                        }
                    }]
                }
            }
        });
    }

    var prepareChartData = function(labels, blue_values, darkblue_values,color, label){
        var lineChartData = {
            labels : labels,
            datasets : [
                {
                    label: "Upper",
                    backgroundColor : color,
                    strokeColor : color,
                    pointColor : color,
                    pointHoverRadius:1,
                    pointStrokeColor : "#fff",
                    pointHighlightFill : "#fff",
                    pointHighlightStroke : "rgba(220,220,220,1)",
                    data : blue_values
                },
                {
                    label: "Lower",
                    backgroundColor: "rgba(0,0,255,0.6)",
                    strokeColor : color,
                    pointColor : color,
                    pointHoverRadius:1,
                    pointStrokeColor : "#fff",
                    pointHighlightFill : "#fff",
                    pointHighlightStroke : "rgba(220,220,220,1)",
                    data : darkblue_values
                }
            ]
        }
        return lineChartData;
    }


})
