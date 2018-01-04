/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var IMG_MARK = getURIComplete('/images/marker.png');
var map;
var marker = null;
var iconStyle;
function initMap() {
    drawMap();
}

function drawMap() {
    /*var longitud = $.dataJS("longitudHidden").val();
    var latitud = $.dataJS("latitudHidden").val();*/
    var coordLat = -12.0789262;
    var coordLong = -77.0362689;
    map = new ol.Map({
        view: new ol.View({
            center: ol.proj.transform([-75.019515, -10.023393], 'EPSG:4326', 'EPSG:3857'),
            zoom: 5,
            maxZoom: 22,
            minZoom: 15,
            extent: ol.proj.transformExtent([-68, -18.32, -82, 0.5], 'EPSG:4326', 'EPSG:3857')
        }),
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            }),
            new ol.layer.Vector({
                source: new ol.source.Vector()
            })],
        renderer: 'canvas',
        target: 'map'
    });

    //control de zoom
    map.addControl(new ol.control.ZoomSlider());

    iconStyle = new ol.style.Style({
        image: new ol.style.Icon(/**@type {olx.style.IconOptions} */({
            anchor: [0.5, 40],
            anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            opacity: 0.75,
            src: IMG_MARK
        }))
    });

    if (marker !== null) {
        map.removeLayer(marker);
        marker = null;
    }

    marker = new ol.Feature({
        geometry: new ol.geom.Point(ol.proj.transform([coordLong, coordLat], 'EPSG:4326', 'EPSG:3857'))
    })

    marker.setStyle(iconStyle);
    var vectorLayer = map.getLayers().a[1];
    var source = vectorLayer.getSource();
    source.clear();
    source.addFeature(marker);
    map.getView().setCenter(ol.proj.transform([coordLong, coordLat], 'EPSG:4326', 'EPSG:3857'));
    map.getView().setZoom(18);
}

    