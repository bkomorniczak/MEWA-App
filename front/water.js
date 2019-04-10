$(function(){
    $.ajax({

        type: "GET",
        dataType: 'json',
        url:"http://localhost:8080/MEW/water/getWaters/",

    }).then(function(data) {
       // var waterList = getRandom(data,12);
        var waterList = data;
        for(var i = 0; i < 12; i++){
            var waterData = waterList[i];
            var col1 = '<td>' + waterData.id + '</td>';
            var col2 = '<td>' + waterData.lowerWaterLevel + '</td>';
            var col3 = '<td>' + waterData.upperWaterLevel + '</td>';
            var row = '<tr>' + col1 + col2 +  col3 + '</tr>';
            $('#waterListTable').append(row);

        }

    })
})

/*
function getRandom(arr, n) {
    var result = new Array(n),
        len = arr.length,
        taken = new Array(len);
    if (n > len)
        throw new RangeError("getRandom: more elements taken than available");
    while (n--) {
        var x = Math.floor(Math.random() * len);
        result[n] = arr[x in taken ? taken[x] : x];
        taken[x] = --len in taken ? taken[len] : len;
    }
    return result;
}*/
