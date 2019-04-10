$(function(){
    $.ajax({

        type: "GET",
        dataType: 'json',
        url:"http://localhost:8080/MEW/speed/getSpeeds/",

    }).then(function(data) {
        var speedList = data;
        for(var i = 0; i < speedList.length; i++){
            var speedData = speedList[i];
            var col1 = '<td>' + speedData.id + '</td>';
            var col2 = '<td>' + speedData.generatorSpeed + '</td>';
            var col3 = '<td>' + speedData.turbineSpeed + '</td>';
            var row = '<tr>' + col1 + col2 +  col3 + '</tr>';
            $('#speedListTable').append(row);

        }

    })
})

