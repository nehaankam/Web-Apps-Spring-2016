/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getProvincesFromServer() {
    var allDataEntered = true;
    if ($("#population").val() === "") {
      allDataEntered = false;
      alert("Enter population");
    }
    if ($("#land").val()==="") {
      allDataEntered = false;
      alert("Enter land area");
    }
    if ($("#water").val() === "") {
      allDataEntered = false;
      alert("Enter water area");
    }
    if(allDataEntered)
    $.getJSON("CanadianProvinceServelet?&population=" + $("#population").val() + "&land=" + $("#land").val() + "&water=" + $("#water").val(), displayMenu);
}

function displayMenu(data) {
    $("#provinces").empty();
    $.each(data.province,
            function() {
                $("#provinces").append(
                        "<tr>"
                        + "<td>" + this.name + "</td>"
                        + "<td>" + this.population + "</td>"
                        + "<td>" + this.landArea + "</td>"
                        + "<td>" + this.waterArea + "</td>"
                        + "<td>" + this.totalArea + "</td>"
                        + "<td>" + this.officialLanguage + "</td>"
                        + "</tr>");
            });
}

$(document).ready(
        function() {
            $("#find").click(getProvincesFromServer);
        }
);
