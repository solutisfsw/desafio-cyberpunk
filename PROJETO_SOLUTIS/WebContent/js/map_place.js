
function initialize() {

    //Map parametrs
    var mapOptions_place = {
        zoom: 10,
        center: new google.maps.LatLng(-12.5480778, -38.7083469),
        mapTypeId: google.maps.MapTypeId.ROADMAP,

        mapTypeControl: false,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
            position: google.maps.ControlPosition.BOTTOM_CENTER
        },
        panControl: false,
        panControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        zoomControl: false,
        zoomControlOptions: {
            style: google.maps.ZoomControlStyle.LARGE,
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        scaleControl: false,
        scaleControlOptions: {
            position: google.maps.ControlPosition.TOP_LEFT
        },
        streetViewControl: false,
        streetViewControlOptions: {
            position: google.maps.ControlPosition.LEFT_TOP
        },
        scrollwheel: false
    }

    //map
    var map_place = new google.maps.Map(document.getElementById("map_place"), mapOptions_place);

    //category
  
    //positions
    var point_place = new google.maps.LatLng(-12.5480778, -38.7083469);

    //markers
    var marker_place = className = 'Cafe';
    var marker_place = new google.maps.Marker({
        position: point_place,
        map: map_place,
        category: Cafe_place,
        icon: Cafe_place,
        title: "point_place"
    });
};

    
    