/**
 * 
 */
(function(){
	'use strict';
	
	angular.module('myApp').controller('orderController', function($scope, $http){
		
		
		
		// 1.0 INPUT FORMS - CHECKS IF EMPTY - INDEX.HTML
		$scope.ordrindex =1;
		$scope.addindx = function(mIndx) {
			$scope.ordrindex = mIndx + 1;
			console.log($scope.ordrindex);
			
			/*$scope.apply(function() {
				$scope.ordrindex = response.data;
			});*/
		}

		// 2.0 MENU DISPLAY - INDEX.HTML // 7.0 MENU DISPLAY - WAITER.HTML
		$scope.menu;
		$http.get("/menu").then(function(response){
			$scope.menu = response.data;
		});
		
		// 3.0 CUSTOMERS CURRENT ORDER - INDEX.HTML
		$scope.caseorder;
		$http.get("/caseorder").then(function(response){
			$scope.caseorder = response.data;
		});
		
		// 3.1 DELETE ITEM FROM ORDER - INDEX.HTML
		$scope.remove = function(id){
			var url = "/remove/" + id;
			$http.post(url).then(function(response){
				$scope.caseorder = response.data;
			});
		}
		
		// 3.2 CUSTOMER SUBMITS ORDER TO 'ITEMS IN CURRENT ORDER' - INDEX.HTML
		$scope.mkcaseordr = function(mItemId, mCustName, mCustTable, mOrdrName, mOrdrPrice) {
			if (mCustName == '' ){
				alert("Please enter your name before ordering!");
			
			} else if (mCustTable == '' ) {
				alert("Please select your Table before ordering!");
			
			} else {
			
				var caseorderObj = {
						index : $scope.ordrindex,  //$scope.ordrindex,
						itemId : mItemId,
						custName : mCustName,
						custTable : mCustTable,
						orderedName : mOrdrName,
						orderedPrice : mOrdrPrice,
				};
				$http.post("/makecaseorder/", caseorderObj).then(function(response) {
					$scope.caseorder = response.data;
				});
			}
		}
		
		// 4.0 SUBMIT AN ORDER TO WAITERS - INDEX.HTML
		$scope.mkordr = function(mName, mTable) {
			if (mName == '' ){
				alert("Please enter your name before submitting an order!");
			
			} else if (mTable == '' ) {
				alert("Please select your Table before submitting an order!");
			
			} else {
			
				$scope.mOrdrTime = new Date();
				$scope.mOrdrBool = new Boolean(0);
				
				var orderObj = {
						index : $scope.ordrindex,
						name : mName,
						table : mTable,
						ordrTime : $scope.mOrdrTime,
						confirmed : $scope.mOrdrBool,
						ready : $scope.mOrdrBool,
						waiter : $scope.mOrdrBool,
				};
				$http.post("/makeorder/", orderObj).then(function(response) {
					$scope.order = response.data;
				});
			}
		}
		
		// 5.0 CUSTOMERS SUBMITTED ORDERS 'YOUR ORDERS' - INDEX.HTML
		$scope.order;
		$http.get("/order").then(function(response){
			$scope.order = response.data;
		});
		
		// 5.1 A CUSTOMER CAN REMOVE THIER SUBMITTED ORDER - INDEX.HTML
		$scope.removeOrdr = function(id){
			var url = "/removeordr/" + id;
			$http.post(url).then(function(response){
				$scope.order = response.data;
			});
		}
		
		$scope.confirmOrdr = function(id){
			var url = "/confirmordr/" + id;
			$http.post(url).then(function(response){
				$scope.order = response.data;
			});
		}
		
		$scope.readyOrdr = function(id){
			var url = "/readyordr/" + id;
			$http.post(url).then(function(response){
				$scope.order = response.data;
			});
		}
		
		// 6.0 ADD ITEM TO MENU - WAITER.HTML
		$scope.add = function(mName, mDescription, mPrice, mIsVeg, mContainsNuts, mCalories) {
			if(mName.length === 0) {
				alert("Please give the menu item a name!");
			} else if(mDescription.length === 0) {
				alert("Please give the menu item a description!");
			} else if(mPrice.length === 0) {
				alert("Please give the menu item a price!");
			} else if (mCalories.length === 0) {
				alert("Please give the menu item calories count!");
			} else if (mIsVeg.length === 0) {
				alert("Please specify whether the menu item is vegetarian!");
			} else if (mContainsNuts.length === 0) {
				alert("Please specify whether the menu item contains nuts!");
			} else {
				var menuObj = {
					name : mName,
					price : mPrice,
					description : mDescription,
					containsNuts: mContainsNuts,
					isVeg: mIsVeg,
					calories: mCalories
				};
				$http.post("/create/", menuObj).then(function(response) {
					$scope.menu = response.data;
				});
			}
		}
		
		
		// 7.1 DELETE ITEM FROM MENU - WAITER.HTML
		$scope.del = function(id){
			var url = "/delete/" + id;
			$http.post(url).then(function(response){
				$scope.menu = response.data;
			});
		}
		
		// CALL WAITER	- INDEX.HTML
		$scope.call = function(mName, mTable) {
			if (mName == '' ){
				alert("Please enter your name before calling a waiter!");
			
			} else if (mTable == '' ) {
				alert("Please select your Table before calling a waiter!");
			} else {
				$scope.mOrdrTime = new Date();
				$scope.mOrdrBool = new Boolean(0);
				var orderObj = {
						name : mName,
						table : mTable,
						ordrTime : $scope.mOrdrTime,
						confirmed : $scope.mOrdrBool,
						ready : $scope.mOrdrBool,
						waiter : true,
				};
				$http.post("/call/", orderObj).then(function(response) {
					$scope.order = response.data;
					alert("A waiter will be with you shortly");
			});
			}
		}
	
	});
})();