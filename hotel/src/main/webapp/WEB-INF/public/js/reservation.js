/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initReserv() {
    checkinDateTime();
    checkoutDateTime();
    modalReserv();
}

function checkinDateTime() {

    $('#checkin').daterangepicker({
        autoUpdateInput: false,
        singleDatePicker: true,
        timePicker: true,
        timePickerIncrement: 30,
        locale: {
            //format: 'DD/MM/YYYY h:mm A',
            applyLabel: 'Aplicar',
            cancelLabel: 'Clear',
            daysOfWeek: [
                'Do',
                'Lu',
                'Ma',
                'Mi',
                'Ju',
                'Vi',
                'Sa'
            ],
            monthNames: [
                'Enero',
                'Febrero',
                'Marzo',
                'Abril',
                'Mayo',
                'Junio',
                'Julio',
                'Agusto',
                'Septiembre',
                'Octubre',
                'Noviembre',
                'Diciembre'
            ],
            firstDay: 1
        }
    });
    $('#checkin').on('apply.daterangepicker', function (ev, picker) {
        $(this).val(picker.startDate.format('DD/MM/YYYY h:mm A'));
    });
    $('#checkin').on('cancel.daterangepicker', function (ev, picker) {
        $(this).val('');
    });
    
}

function checkoutDateTime() {
    $('#checkout').daterangepicker({
        autoUpdateInput: false,
        singleDatePicker: true,
        timePicker: true,
        timePickerIncrement: 30,
        locale: {
            //format: 'DD/MM/YYYY h:mm A',
            applyLabel: 'Aplicar',
            cancelLabel: 'Clear',
            daysOfWeek: [
                'Do',
                'Lu',
                'Ma',
                'Mi',
                'Ju',
                'Vi',
                'Sa'
            ],
            monthNames: [
                'Enero',
                'Febrero',
                'Marzo',
                'Abril',
                'Mayo',
                'Junio',
                'Julio',
                'Agusto',
                'Septiembre',
                'Octubre',
                'Noviembre',
                'Diciembre'
            ],
            firstDay: 1
        }
    });
    
    $('#checkout').on('apply.daterangepicker', function (ev, picker) {
        $(this).val(picker.startDate.format('DD/MM/YYYY h:mm A'));
    });
    $('#checkout').on('cancel.daterangepicker', function (ev, picker) {
        $(this).val('');
    });
    /*$('#checkout').daterangepicker({
     singleDatePicker: true,
     showDropdowns: true
     });*/
    //$('#checkout').daterangepicker();
}

function modalReserv() {
    if (reservSucess == 0) {
        $("#modalReserv").modal({
            backdrop: 'static',
            keyboard: false,
            show: true
        });
    }
}


/*function dateRangePickerLan(idDiv){
 $('#'+idDiv+'').daterangepicker({
 locale: {
 applyLabel: 'Aplicar',
 cancelLabel: 'Cancelar',
 daysOfWeek: [
 'Do',
 'Lu',
 'Ma',
 'Mi',
 'Ju',
 'Vi',
 'Sa'
 ],
 monthNames: [
 'Enero',
 'Febrero',
 'Marzo',
 'Abril',
 'Mayo',
 'Junio',
 'Julio',
 'Agusto',
 'Septiembre',
 'Octubre',
 'Noviembre',
 'Diciembre'
 ],
 firstDay: 1
 }
 });
 }*/