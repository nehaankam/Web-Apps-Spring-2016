/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function calculateWeightAndTime() {
    DC9 = 50000;
    MD83 = 75000;
    TopOff = 10000;
    Half = 5000;
    Minimum = 1000;
    LifeRaft = 150;
    LifeVest = 300;

   var weight = 0.00;
   var time = 0;
   var allDataEntered = true;

   if (document.getElementById("type").value === "DC9") {
      weight += DC9;
   } else if (document.getElementById("type").value === "MD83") {
      weight += MD83;
   } else {
      allDataEntered = false;
      alert("You must select the type of aircraft.");
   }
   
    if (document.getElementById("topoff").checked) {
      weight += TopOff;
   } else if (document.getElementById("half").checked) {
      weight += Half;
   } else if (document.getElementById("minimum").checked) {
      weight += Minimum;
   } else {
      weight += Minimum;
   }

   var noOfPassengers = parseInt(document.getElementById("passengers").value);
   if((noOfPassengers < 0 || noOfPassengers > 100)) 
   {
       alert("The no of passengers should be between 0 and 100");
       allDataEntered = false;
   }
   else if(parseInt(document.getElementById("passengers").value))
       weight = weight + (noOfPassengers * 150);
   else{
       alert("Select the number of passengers");
       allDataEntered = false;
   }
   
   if (document.getElementById("raft").checked) {
      weight += LifeRaft;
   }

   if (document.getElementById("vest").checked) {
      weight += LifeVest;
   }
   time = (Math.floor(Math.random() * (3 - 1 + 1)) + 1) * noOfPassengers;
        
   if (allDataEntered) {
    document.getElementById("weight").innerHTML="Estimated weight of the aircraft is "+weight+" lb.";
    document.getElementById("time").innerHTML="Estimated boarding time for the aircraft is "+time+" minutes.";
   }

}
window.onload = function() { 
   document.getElementById("estimate").onclick = calculateWeightAndTime;
};

