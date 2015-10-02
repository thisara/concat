var controllersModule = angular.module('controllersModule', [ 'servicesModule',
		'ngQueue' ]);

controllersModule.controller('LoginController', function($scope, $location,
		localStorageService) {

	$scope.onLogin = function() {
		$location.path('System/Dashboard');
	}
});

controllersModule.controller('SystemMasterController', function($scope, $http,
		$location, $rootScope) {

	$scope.onClickLogOut = function() {
		authService.logOut();
		$location.path('/Login');
	}

});

controllersModule.controller('systemDashboardController', function($scope) {

});

controllersModule.controller('systemTypeInController', function($scope, $http) {

	$scope.summaryTextShow = false;
	$scope.summaryText = null;
	$scope.searchSummery = function(enteredText) {
		// alert($scope.enteredText);

		$http({
			method : 'POST',
			url : '/ConCat/summarize',
			data : $scope.enteredText
		}).

		success(function(data, status, headers, config) {
			// alert(data);
			$scope.summaryTextShow = true;
			$scope.summaryText = data;

		}).error(function(data, status, headers, config) {
			// alert("error");
		});

	}
});

controllersModule.controller('systemIntegrationController', function($scope) {

});

controllersModule.controller('systemUploadController', function($scope, upload, $http) {

			$scope.summaryUploadTextShow = false;
			$scope.summaryUploadText = null;

			$scope.searchUploadedSummery = function() {
				var file = $scope.selectedFile;

				alert(file);
			};
			/*
			 * $http({ method: 'POST', url: '/ConCat/summarize', data:
			 * $scope.enteredText}).
			 * 
			 * success(function (data, status, headers, config) { //alert(data);
			 * $scope.summaryUploadTextShow = true; $scope.summaryUploadText =
			 * data;
			 * 
			 * 
			 * }). error(function (data, status, headers, config) {
			 * //alert("error"); });
			 */

			$scope.uploadFileToUrl = function() {
				var fd = new FormData();

				fd.append('file', $scope.myFile);

				$http.post('/ConCat/summarizeFile', fd, {
					transformRequest : angular.identity,
					headers : {
						'Content-Type' : undefined
					}
				}).success(function() {
				}).error(function() {
				});
			}

		});

controllersModule.controller('systemReportsController', function ($scope, $http) {

    $http({ method: 'GET', url: '/ConCat/savedSummaries'}).

        success(function (data, status, headers, config) {

            $scope.summaryList = data;
            //alert(data);



        }).
        error(function (data, status, headers, config) {
            //alert("error");
        });

});

controllersModule.run(function ($rootScope, $state, $http, $window) {

});