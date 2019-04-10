$(function() {
    $.ajax({

        type: "GET",
        dataType: 'json',
        url: "http://localhost:8080/MEW/speed/getSpeeds/",
        crossDomain: true,
        success: function (data) {
            var labels = Object.keys(data);
            var red_values = labels.map(function (v) {
                return data[v].turbineSpeed;
            });
            var darkred_values = labels.map(function (g) {
                return data[g].generatorSpeed;
            });
            showChart("canvas_red", labels, red_values, darkred_values, "rgba(255,0,0,0.4)", "Speed");
        }
    })

    var showChart = function(canvas, labels,red_values, darkred_values, color, label){
        var ctx = document.getElementById(canvas).getContext("2d");
        window[canvas] = new Chart(ctx,{
            type: 'line',
            data:prepareChartData(labels, red_values, darkred_values, color, label),
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

    var prepareChartData = function(labels, red_values, darkred_values,color, label){
        var lineChartData = {
            labels : labels,
            datasets : [
                {
                    label: "Generator",
                    backgroundColor : color,
                    strokeColor : color,
                    pointColor : color,
                    pointHoverRadius:1,
                    pointStrokeColor : "#fff",
                    pointHighlightFill : "#fff",
                    pointHighlightStroke : "rgba(220,220,220,1)",
                    data : red_values
                },
                {
                    label: "Turbine",
                    backgroundColor: "rgba(255,0,0,0.6)",
                    strokeColor : color,
                    pointColor : color,
                    pointHoverRadius:1,
                    pointStrokeColor : "#fff",
                    pointHighlightFill : "#fff",
                    pointHighlightStroke : "rgba(220,220,220,1)",
                    data : darkred_values
                }
            ]
        }
        return lineChartData;
    }


})
