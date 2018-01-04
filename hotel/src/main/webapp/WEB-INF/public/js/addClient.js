/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initClient() {
    modalAddClient();
}

function modalAddClient(){
    if (addClientSuccess == 0){
        $("#modalEmployee").modal({
           backdrop: 'static',
           keyboard: false,
           show: true
        });
    }
}
