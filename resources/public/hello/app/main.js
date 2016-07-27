requirejs.config({
    baseUrl: '/hello/app',
    paths: {
        angular: "../node_modules/angular/angular",
        ngRoute : '../node_modules/angular-route/angular-route',
        jquery: "../node_modules/jquery/dist/jquery",
        text : "../node_modules/text/text"
    },
    shim:{
        angular : {
            exports : "angular"
        },
        ngRoute: {
            exports: 'angular',
            deps: ['angular']
        },
        jquery : {
            exports : "$"
        }
    }
});

require(["app"],function(app){
    app.init();
});
