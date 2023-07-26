let host = "http://localhost:8080/rest";
const app = angular.module("app", []); // Add ngRoute module dependency

app.controller("nameCtrl", function ($scope, $http) {
    $scope.form = {};
    $scope.items = [];
    $scope.key = null;

    $scope.reset = function () {
        $scope.form = { gender: true, country: 'VN' };
        $scope.key = null;
    }

    $scope.load_all = function () {
        var url = `${host}/students`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.update = function () {
        var key = $scope.key;
        var url = `${host}/students/${$scope.form.email}`;
        $http.put(url, $scope.form).then(resp => {
            var index = $scope.items.findIndex(item => item.email == $scope.form.email);
            $scope.items[index] = resp.data;
            $scope.reset();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.edit = function (email) {
        var url = `${host}/students/${email}`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.create = function () {
        var url = `${host}/students`;
        $http.post(url, $scope.form).then(resp => {
            $scope.reset();
            $scope.load_all();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.delete = function (email) {
        var url = `${host}/students/${email}`;
        $http.delete(url).then(resp => {
            var index = $scope.items.findIndex(item => item.email == email);
            $scope.items.splice(index, 1);
            $scope.reset();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    // Thực hiện tải toàn bộ students
    $scope.load_all();
    $scope.reset();
});



