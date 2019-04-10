$(function(){
    $.ajax({

        type: "GET",
        dataType: 'json',
        url:"http://localhost:8080/MEW/temperature/getTemperatures/",

    }).then(function(data) {
        var temperatureList = data;
        for(var i = 0; i < temperatureList.length; i++){
            var temperatureData = temperatureList[i];
            var col1 = '<td>' + temperatureData.id + '</td>';
            var col2 = '<td>' + temperatureData.lowerBearingTemp + '</td>';
            var col3 = '<td>' + temperatureData.upperBearingTemp + '</td>';
            var row = '<tr>' + col1 + col2 +  col3 + '</tr>';
            $('#temperatureListTable').append(row);

        }

    })
})

