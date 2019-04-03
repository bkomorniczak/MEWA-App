$(function(){
$.ajax({

type: "GET",
dataType: 'json',
url:"http://localhost:8080/MEW/power/getPowers/",

}).then(function(data) {
var powerList = data;
for(var i = 0; i < powerList.length; i++){
    var powerData = powerList[i];
    var col1 = '<td>' + powerData.id + '</td>';
    var col2 = '<td>' + powerData.power + '</td>';
    var row = '<tr>' + col1 + col2 + '</tr>';
    $('#powerListTable').append(row);

}

})
})

var powerData = {id:null, powerValue:1};
var powerJSON = JSON.stringify(powerData);
