'use strict';
(function () {

  var appWrapper;
  $('.app-sidebar-toggle').click(toggleSidebar);


  function toggleSidebar() {
    appWrapper = appWrapper || $('.app-wrapper');

    appWrapper.toggleClass('show-sidebar');
  }


})();

