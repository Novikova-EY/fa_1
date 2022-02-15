angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/api/v1/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get(contextPath + '/api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadCartList = function () {
        $http.get(contextPath + '/api/v1/order').then(function (response) {
            $scope.orderList = response.data[0].products;
        });
    }

    $scope.insertIntoOrder = function (productId) {
        $http.put(contextPath + '/api/v1/order/add/' + productId).then(function (response) {
            console.log(response)
            $scope.loadCartList();
        });
    }

    $scope.loadProducts();
    $scope.loadCartList();

});