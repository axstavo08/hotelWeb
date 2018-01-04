/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initFunction() {
    initTableRoom();
}

function initTableRoom() {
    var oTabla = $('#tableRoom').dataTable({
        "oLanguage": datatableTextSpanish()
    });
    //$("#tableRoom").dataTable();
}
