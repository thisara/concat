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


controllersModule.controller('systemTypeInController', function ($scope, $http) {

    $scope.summaryTextShow = false;
    $scope.summaryText = null;
    $scope.searchSummery = function(enteredText){
        //alert($scope.enteredText);


        $http({ method: 'POST', url: '/ConCat/summarize', data: $scope.enteredText}).

            success(function (data, status, headers, config) {
                //alert(data);
                $scope.summaryTextShow = true;
                $scope.summaryText = data;


            }).
            error(function (data, status, headers, config) {
                //alert("error");
            });



    }
});

controllersModule.run(function ($rootScope, $state, $http, $window) {

});