angular.module('httpApp', [])
    .controller('HttpController', function($http) {
        var httpExchange = this;
        httpExchange.response = [];

        httpExchange.method = "GET";
        httpExchange.path = "/api/v1/molecules"
        httpExchange.body = "";
        httpExchange.exchange = function() {
            $http({
                method: httpExchange.method,
                url: httpExchange.path,
                data : httpExchange.body ? angular.fromJson(httpExchange.body) : ""
            }).success(httpExchange.processResponse).error(httpExchange.processResponse);

        };
        httpExchange.processResponse  = function (data, status, headers) {
            httpExchange.response = data;
            httpExchange.status = status;
            var allHeaders = headers();
            httpExchange.headers =
                Object.keys(allHeaders).map(function(key) {return key + " = " + allHeaders[key]}).join("\n");
        }

    })
    .filter('prettyJSON', function () {
        function prettyPrintJson(json) {
            return JSON ? JSON.stringify(json, null, '  ') : 'your browser doesnt support JSON so cant pretty print';
        }
        return prettyPrintJson;
    });