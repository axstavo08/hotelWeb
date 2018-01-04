
/**
 * Toma el valor data-js del elemento y lo convierte en un  jQuery element Selector
 * de manera que omite el utilizar [data-js='el'] en cada declaración.
 * 
 * @param {string} el - nombre del selector
 * @param {string} sub [null] - subcomponentes del selector
 * @returns {jQuery element Selector}
 */
$.dataJS = function(el, sub) {
    if (!sub) {
        return $('[data-js=' + el + ']');
    } else {
        return $('[data-js=' + el + '] ' + sub);
    }
};

/**
 * Cambiar la activacion de la opcion del menu principal
 * @param {type} idName
 * @returns {undefined}
 */
function changeActiveOption(idName) {
    $.dataJS("menu-option").parent().removeClass("active");
    $("#" + idName).parent().addClass("active");
}

