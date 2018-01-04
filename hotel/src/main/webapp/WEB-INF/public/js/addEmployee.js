/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initJobEmployee() {
    inJobDate();
    outJobDate();
    modalAddEmployee();
}

function inJobDate() {

    $('#inJob').daterangepicker({
        autoUpdateInput: false,
        singleDatePicker: true,
        locale: {
            //format: 'DD/MM/YYYY',
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

    $('#inJob').on('apply.daterangepicker', function (ev, picker) {
        $(this).val(picker.startDate.format('DD/MM/YYYY'));
    });
    $('#inJob').on('cancel.daterangepicker', function (ev, picker) {
        $(this).val('');
    });
}

function outJobDate() {
    $('#outJob').daterangepicker({
        autoUpdateInput: false,
        singleDatePicker: true,
        locale: {
            //format: 'DD/MM/YYYY',
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
    $('#outJob').on('apply.daterangepicker', function (ev, picker) {
        $(this).val(picker.startDate.format('DD/MM/YYYY'));
    });
    $('#outJob').on('cancel.daterangepicker', function (ev, picker) {
        $(this).val('');
    });
}

function modalAddEmployee() {
    if (addEmployeeSuccess == 0) {
        $("#modalEmployee").modal({
            backdrop: 'static',
            keyboard: false,
            show: true
        });
    }
}
