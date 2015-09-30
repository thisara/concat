var controllersModule = angular.module('controllersModule', ['servicesModule', 'ngQueue']);

controllersModule.controller('LoginController', function ($scope, $location, localStorageService) {

    $scope.onLogin = function () {
        $location.path('System/Dashboard')
    }
});

controllersModule.controller('SystemMasterController', function ($scope, $http, $location, $rootScope) {

    $scope.onClickLogOut = function () {
        authService.logOut();
        $location.path('/Login');
    }


});

controllersModule.controller('systemDashboardController', function ($scope) {

});

controllersModule.controller('systemTypeInController', function ($scope) {

});

controllersModule.controller('systemTypeInController', function ($scope) {

});

controllersModule.run(function ($rootScope, $state, $http, $window) {

});