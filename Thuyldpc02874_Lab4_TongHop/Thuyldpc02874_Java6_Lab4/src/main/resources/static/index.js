let host="https://poly-java6-70fbd-default-rtdb.firebaseio.com";
const app = angular.module("app",[]);
app.controller("nameCtrl",function($scope,$http){
    $scope.form = {};
    $scope.items = {};
    $scope.key = null;

    $scope.reset = function(){
        $scope.form = {gender:true,country:'VN'};
        $scope.key = null;
    }
    $scope.load_all = function(){
        var url = `${host}/student.json`;
        $http.get(url).then(resp=>{
            $scope.items = resp.data;
            console.log("Success",resp)
        }).catch(error=>{
            console.log("Error",error)
        });
    }
    
    $scope.edit = function (key) {
        $scope.key = key;
        $scope.form = angular.copy($scope.items[key]);
    }

    $scope.create = function () {
        var url = `${host}/student.json`;
        $http.post(url, $scope.form).then(resp => {
            $scope.reset();
            $scope.load_all();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.delete = function (key) {
        var url = `${host}/student/${key}.json`;
        $http.delete(url).then(resp => {
            delete $scope.items[key];
            $scope.reset();
            // $scope.load_all();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.update = function () {
        var key = $scope.key;
        var url = `${host}/student/${key}.json`;
        $http.put(url, $scope.form).then(resp => {
            $scope.reset();
            $scope.load_all();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    //Thực hiện tải toàn bộ students
    $scope.load_all();
    $scope.reset();
})