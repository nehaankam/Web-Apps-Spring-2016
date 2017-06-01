/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Aircraft(){
    //weight list
    DC9 =50000.0; 
    MD83 =75000.0;
    TOP_OFF =10000.0;
    HALF=5000.0;
    MINIMUM=1000.0;
    PASSENGER=150.0;
    LIFE_RAFT=150.0;
    LIFE_VEST=300.0;
    
    var weight=0.0;
    var time=Math.floor(Math.random()* (3)) + 1;
    var allDataEntered = true;
    if ($('#aircraftType').val() === 'DC9') {   
      weight += DC9;
      
   } else{
      weight+= MD83;
   }
  if( $(":radio[name=level]:checked").val()==="Top"){
      weight += TOP_OFF;
   } else if($(":radio[name=level]:checked").val()==="Half")  {
      weight += HALF;
   } else if ($(":radio[name=level]:checked").val()==="Minimum") {
      weight += MINIMUM;
   } else {
            allDataEntered=false;  
           alert("You must select fuel level");
       
   }
   var pass=parseInt($('#pas').val());
   if(($('#pas').val())){
       if(pass>0 && pass<100){
       weight +=(PASSENGER * pass);
         var boardtime=time*pass;
     }else{
         allDataEntered=false;
         alert("Enter a integer between 0 and 100");  
     }
   }
   else{
           allDataEntered=false;  
           alert("You must enter num of passengers");
       }
   
   if ($(":checkbox[name=Raft]:checked").val()==="Raft") {
      weight += LIFE_RAFT;
   }
   if ($(":checkbox[name=Vest]:checked").val()=== "Vest") {
      weight += LIFE_VEST;
   }

   if (allDataEntered) {
        if ($("#aircraftType").val() === "DC9") {

            $("body").css("background-color", "pink");
        }
        else if ($("#aircraftType").val() === "MD83") {

            $("body").css("background-color", "yellow");
        }
     $('#weight').html('Estimated weight of the aircraft is '+weight+' lb');      
     $('#time').html('Estimated boarding time for the aircraft is '+boardtime+' minutes'); 
   
   $("#aircraft").slideDown(5000);
}
}
   
$(document).ready(function() {
    
   $('#estimate').click(Aircraft);
     $('#aircraft').hide();
});
