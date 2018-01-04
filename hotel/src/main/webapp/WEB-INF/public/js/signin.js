/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initSignin(){
    modalSignin();
}

function modalSignin(){
    if (signinSuccess == 0){
        $("#modalSignin").modal({
           backdrop: 'static',
           keyboard: false,
           show: true
        });
    }
}
