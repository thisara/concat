var app = angular.module('app', [
    'controllersModule',
    'servicesModule',
    'ui.router',
    'cgBusy',
    'LocalStorageModule'
]);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider
        .when('', '/Login')
        .when('/', '/Login');

    $stateProvider
        .state('Login', {
            url: "/Login",
            templateUrl: "resources/app/view/account/Login.jsp",
            controller: 'LoginController',
            title: 'Login'
        }).state('System', {
            url: "/System",
            templateUrl: "resources/app/view/master-pages/system-master.jsp",
            controller: 'SystemMasterController',
            title: 'System Master Page'
        }).state('System.Dashboard', {
            url: "/Dashboard",
            templateUrl: "resources/app/view/system/dashboard.jsp",
            controller: 'systemDashboardController',
            title: 'Dashboard'
        }).state('System.TypeIn', {
            url: "/TypeIn",
            templateUrl: "resources/app/view/system/type-in.jsp",
            controller: 'systemTypeInController',
            title: 'Type In'
        }).state('System.Upload', {
            url: "/Upload",
            templateUrl: "resources/app/view/system/upload.jsp",
            controller: 'systemUploadController',
            title: 'Upload Content'
        });
});

app.config(function ($httpProvider) {
    
});