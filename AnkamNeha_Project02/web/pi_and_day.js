/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calculatePi() {
    var iteration = parseInt(document.getElementById("iterations").value);
    var pi;
    var key=0;
    var i;
    for(i=0;i<iteration;i++){
        if(i % 2 === 0){
            key = key + (1/(1+(2*i)));
        }else{
            key = key - (1/(1+(2*i)));
        }
    }
    key = 4*key;
    var pererr=Math.abs(((Math.PI-key)/Math.PI)*100);
    document.getElementById("estimate").value = key;
    document.getElementById("error").value = pererr.toFixed(2);
}
  
function calculateDay(){
    var q = parseInt(document.getElementById("day").value);
    var year = parseInt(document.getElementById("year").value);
    var month = parseInt(document.getElementById("month").value);
    if(month < 1 || month > 12)
    {
        alert("month entered is incorrect");
    }else if(q < 1 || q > 31)
    {
         alert("day entered is incorrect");
    }
    else
    {
    var mon;
    if(month === 1 || month === 2){
        mon = month+12;
        year -= 1;
    }
    else{
        mon = month;
    }
    var j = parseInt(year/100);
    var k = parseInt(year%100);
    var h = Math.round((q + Math.floor((13*(mon+1))/5) + k + Math.floor(k/4) + Math.floor(j/4) + 5*j)%7);
    switch(h){
        case 0:
            alert("The Day of the Week is Saturday");
            break;
        case 1:
            alert("The Day of the Week is Sunday");
            break;
        case 2:
            alert("The Day of the Week is Monday");
            break;
        case 3:
            alert("The Day of the Week is Tuesday");
            break;
        case 4:
            alert("The Day of the Week is Wednesday");
            break;
        case 5:
            alert("The Day of the Week is Thursday");
            break;
        case 6:
            alert("The Day of the Week is Friday");
            break;
    }
}
}
window.onload = function() {
    document.getElementById("calculatePi").onclick = calculatePi;
    document.getElementById("calculateDay").onclick = calculateDay;
};

