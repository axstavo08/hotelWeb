/* 
 * version: 1.4
 */

var CONTEXT_PATH = "/hotel";

/**
 * Se devuelve la URI completa para una petecion
 * @param {type} uriController
 * @returns {CONTEXT_PATH|String}
 */
function getURIComplete(uriController){
    if( uriController.charAt(0) === '/' ){
        return CONTEXT_PATH + uriController;
    }    
    return CONTEXT_PATH + '/' + uriController;
}


