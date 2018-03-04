//////Index one block height//////
function setHeiHeight() {
    "use strict";
  $('#promo_head').css({
    height: $(window).height() + 'px'
  });
}

$(document).ready(function () {
    "use strict";
  //////Add place//////
  $('#ad').on('click', function () {
      "use strict";
    $('#pl').removeClass("none");
  })
  $('#close').on('click', function () {
      "use strict";
    $('#pl').addClass("none");
  })

  //////Autorization//////
  $('.log_btn').on('click', function () {
      "use strict";
    $('#autorized').removeClass("none");
  })
  $('#closeau').on('click', function () {
      "use strict";
    $('#autorized').addClass("none");
  })

  //////Page load//////
  $("body").css("display", "none");
  $("body").fadeIn(900);
  $("a.transition").click(function(event){
      "use strict";
    event.preventDefault();
    linkLocation = this.href;
    $("body").fadeOut(900, redirectPage);
  });
  function redirectPage() {
      "use strict";
    window.location = linkLocation;
  }

  //////Mobile menu in map page (01.html)//////
  $('.mobile_menu').on('click', function () {
      "use strict";
    $('.container-fluid.menu').removeClass("mobile");
  })
  $('#close_menu').on('click', function () {
      "use strict";
    $('.container-fluid.menu').addClass("mobile");
  })
  $('.container-fluid.menu a').on('click', function () {
      "use strict";
    $('.container-fluid.menu').addClass("mobile");
  })
});




//////Side menu//////
$(function(){function a(){e.toggleClass(j),d.toggleClass(i),f.toggleClass(k),g.toggleClass(l)}function b(){e.addClass(j),d.animate({left:"0px"},n),f.animate({left:o},n),g.animate({left:o},n)}function c(){e.removeClass(j),d.animate({left:"-"+o},n),f.animate({left:"0px"},n),g.animate({left:"0px"},n)}var d=$(".pushy"),e=$("body"),f=$("#container"),g=$(".push"),h=$(".site-overlay"),i="pushy-left pushy-open",j="pushy-active",k="container-push",l="push-push",m=$(".menu-btn, .pushy a"),n=200,o=d.width()+"px";if(cssTransforms3d=function(){var a=document.createElement("p"),b=!1,c={webkitTransform:"-webkit-transform",OTransform:"-o-transform",msTransform:"-ms-transform",MozTransform:"-moz-transform",transform:"transform"};document.body.insertBefore(a,null);for(var d in c)void 0!==a.style[d]&&(a.style[d]="translate3d(1px,1px,1px)",b=window.getComputedStyle(a).getPropertyValue(c[d]));return document.body.removeChild(a),void 0!==b&&b.length>0&&"none"!==b}())m.click(function(){a()}),h.click(function(){a()});else{d.css({left:"-"+o}),f.css({"overflow-x":"hidden"});var p=!0;m.click(function(){p?(b(),p=!1):(c(),p=!0)}),h.click(function(){p?(b(),p=!1):(c(),p=!0)})}});