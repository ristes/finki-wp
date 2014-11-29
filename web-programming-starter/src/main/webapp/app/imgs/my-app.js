// Initialize your app
var myApp = new Framework7({
    // Default title for modals
    modalTitle: 'Sport Leaf',

    // If it is webapp, we can enable hash navigation:
    pushState: true,
    swipePanel: 'left',
    //swipePanel: 'right',

    //swipeout: true,
    // Hide and show indicator during ajax requests
    onAjaxStart: function (xhr) {
        myApp.showIndicator();
    },
    onAjaxComplete: function (xhr) {
        myApp.hideIndicator();
    }
});
// Export selectors engine
var $$ = Dom7;

// Add views
var view1 = myApp.addView('#view-1');
var view2 = myApp.addView('#view-2', {
    // Because we use fixed-through navbar we can enable dynamic navbar
    dynamicNavbar: true
});
var view3 = myApp.addView('#view-3');
var view4 = myApp.addView('#view-4');
var view5 = myApp.addView('#view-5');

