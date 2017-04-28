$(document).ajaxStart(function() {
	NProgress.start()
});
$(document).ajaxComplete(function() {
	NProgress.done()
});
$(document).ready(function() {
	$(".searcher").keyup(function() {
		console.log($(".searcher").val())
		$.get('list/productsTable', function(data) {
			$("table tbody").empty();
			var tbody = $(data).find("tbody tr")
			$("table tbody").append(tbody);
		})
	})

});

var phonecatApp = angular.module('cart', []);
phonecatApp.service('ProductsService', function($http) {
	var urlBase = 'api/products';

	this.getProducts = function() {
		return $http({
			url : urlBase,
			params : {
				query : 'qwe'
			},
			method : "GET",
		});
	};
});
phonecatApp.controller('CartController', function CartController($scope,
		ProductsService) {
	$scope.lines = []
	$scope.total = 0;

	ProductsService.getProducts().then(function(response) {
		$scope.products = response.data;

		$scope.$watch('lines', function(newV, old) {
			calculateCart($scope, newV, $scope.products);
		}, true);
	})

	$scope.addLine = function() {
		$scope.lines.push({
			"quantity" : 1
		})
	}

	$scope.remove = function(line) {
		var index = $scope.lines.indexOf(line);
		$scope.lines.splice(index, 1);
	}

});

function calculateCart(cart, lines, products) {
	var total = 0;
	lines
			.forEach(function(element) {
				var product = products.find(function(el) {
					return element.id == el.id;
				})
				if (product) {
					element.price = product.price;
					element.avaliable = product.quantity;
					element.sum = Number((element.quantity * element.price)
							.toFixed(2));
					total += element.sum;
				}
			});
	cart.total = total.toFixed(2);
}