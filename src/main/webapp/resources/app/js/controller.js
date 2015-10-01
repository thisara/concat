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

controllersModule.controller('systemIntegrationController', function ($scope) {

});

controllersModule.controller('systemUploadController', function ($scope, upload) {

    $scope.summaryUploadTextShow = false;
    $scope.summaryUploadText = null;

        $scope.searchUploadedSummery = function(){
            var file = $scope.selectedFile;
            
            alert(file);
        };
       /* $http({ method: 'POST', url: '/ConCat/summarize', data: $scope.enteredText}).

            success(function (data, status, headers, config) {
                //alert(data);
                $scope.summaryUploadTextShow = true;
                $scope.summaryUploadText = data;


            }).
            error(function (data, status, headers, config) {
                //alert("error");
            });*/
        
        $scope.doUpload = function () {
        	
        	console.log(selectedFile);
        	
            upload({
              url: '/upload',
              method: 'POST',
              data: {
                anint: 123,
                aBlob: new Blob([1,2,3]), // Only works in newer browsers
                aFile: $scope.myFile // a jqLite type="file" element, upload() will extract all the files from the input and put them into the FormData object before sending.
              }
            }).then(
              function (response) {
                console.log(response.data); // will output whatever you choose to return from the server on a successful upload
              },
              function (response) {
                  console.error(response); //  Will return if status code is above 200 and lower than 300, same as $http
              }
            );
          }

});

controllersModule.run(function ($rootScope, $state, $http, $window) {

});