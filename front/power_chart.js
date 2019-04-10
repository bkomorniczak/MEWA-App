$(function() {
    $.ajax({

        type: "GET",
        dataType: 'json',
        url: "http://localhost:8080/MEW/power/getPowers/",
        crossDomain: true,
        success: function (data) {
            var labels = Object.keys(data);
            var red_values = labels.map(function (v) {
                return data[v].power;
            });
            showChart("canvas_red", labels, red_values, "rgba(255,0,0,0.4)", "Moc");
        }
    })

    var showChart = function(canvas, labels, values, color, label){
        var ctx = document.getElementById(canvas).getContext("2d");
        window[canvas] = new Chart(ctx,{
            type: 'line',
            data:prepareChartData(labels, values, color, label),
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

    var prepareChartData = function(labels, values, color, label){
        var lineChartData = {
            labels : labels,
            datasets : [
                {
                    label: label,
                    backgroundColor : color,
                    strokeColor : color,
                    pointColor : color,
                    pointHoverRadius:1,
                    pointStrokeColor : "#fff",
                    pointHighlightFill : "#fff",
                    pointHighlightStroke : "rgba(220,220,220,1)",
                    data : values
                }
            ]
        }
        return lineChartData;
    }


})
