
$(window).on('popstate', function(e) {
  var lastEntry = customHistory.pop();
  history.pushState(lastEntry.data, lastEntry.title, lastEntry.location);
  // load the last entry
});