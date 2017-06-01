/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function estimation() {
   document.getElementById("weightandtime").innerHTML="";
  
    
    var allDataEntered = true;
    var url = "bearcatAirlinesServelet?";


if (document.getElementById("type").value === "DC9") {
      url += "&type=" + document.getElementById("type").value;
   } else if (document.getElementById("type").value === "MD83") {
      url += "&type=" + document.getElementById("type").value;
   } else {
      allDataEntered = false;
      alert("You must select the type of aircraft.");
  }
  
   if (document.getElementById("topoff").checked) {
        url += "&size=" + document.getElementById("topoff").value;
    } else if (document.getElementById("half").checked) {
        url += "&size=" + document.getElementById("half").value;
    } else if (document.getElementById("minimum").checked) {
        url += "&size=" + document.getElementById("minimum").value;
    } else {
        allDataEntered = false;
        alert("Please select any Size ");
    }
   
   
     if (!(document.getElementById("passengers").value))
    {
        allDataEntered = false;
        alert("Please enter the number of passengers");
    } else if (!((document.getElementById("passengers").value < 100) && (document.getElementById("passengers").value > 1))) {
        allDataEntered = false;
        alert("Please enter the number of passengers from 1 to 100");
    } else {
        url += "&passengers=" + document.getElementById("passengers").value;
    }


   if (document.getElementById("raft").checked)
    {
        url += "&raft=" + document.getElementById("raft").value;
    } else
    {
        url += "&raft=" + 0;
    }
    if (document.getElementById("vest").checked)
    {
        url += "&vest=" + document.getElementById("vest").value;
    } else {
        url += "&vest=" + 0;
    }


if (allDataEntered) 
    {
        request = new XMLHttpRequest();
        request.open("GET", url, true); // Second parameter is URL of servlet
        request.onreadystatechange = displayMessage;
        request.send(null);
    }
}
    
           
        
    function displayMessage() {
    if (request.readyState === 4 && request.status === 200) {
        
        document.getElementById("weightandtime").innerHTML = request.responseText;
      
        
    }
}


window.onload = function() {
    document.getElementById("estimate").onclick = estimation;
};

