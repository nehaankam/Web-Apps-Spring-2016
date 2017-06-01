/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getInsults(){
    var uri = "http://localhost:8080/AnkamNeha_Project13/webresources/shake";
    $.getJSON(uri,display);
}
function display(data){
    $("#adjec1").html(data.first);
    $("#noun").html(data.noun);
    $("#adjec2").html(data.last);
}
$(document).ready(
        function(){
            getInsults();
        }
);
