/*
 * Directive for generic combo (select)
 * 
 */

FirstApp.directive('combo', [
    'crudService',
    '$injector',
    function(crudService) {
      return {
        restrict: 'E',
        scope: {
          // The label for translating entity name
          comboLabel: '@',
          comboName: '@',
          // The url of the rest service and the form name
          comboType: '@',
          comboService: '@',
          comboServiceMethod: '@',
          comboServiceParams: '=',
          comboModel: '=',
          comboProperty: '@',
          comboGroupName: '@',
          comboGroupProperty: '@',
          comboRequired: '=',
          renderItem: '=',
          renderSelected: '=',
          onLoad: '=',
          autoSet: '=',
          onChange: '=',
          primitive: '=',
          multiple: '=',
          afterInit: '=', 
          allowClear: '='
        },
        compile: function(tElem, attrs) {

          if (attrs.comboRequired == "true") {
            tElem[0].children[0].children[1].setAttribute("required", true);
          }

          return function(scope, elem, attrs) {
            scope.form = elem.parent().controller('form');
            scope.fName = attrs.comboName;
            scope.validationParams = attrs;
          };
        },
        controller: function($scope, $element, crudService, $injector) {
          var service, method;

          // set the default combo property
          if ($scope.comboProperty == null) {
            $scope.comboProperty = 'name';
          }
          var property = $scope.comboProperty;
          var groupProp = $scope.comboGroupName;
          var groupNameProp = $scope.comboGroupProperty;

          var multiple = $scope.multiple || false;

          if ($scope.comboLabel) {
            $scope.showLabel = true;
          }

          if ($scope.comboType) {
            // Get reference to the service
            service = crudService($scope.comboType);
            method = 'query';
          } else if ($scope.comboService) {
            service = $injector.get($scope.comboService);
            method = $scope.comboServiceMethod;
          }

          // Function for highlighting the meching when
          // searching
          $scope.markMatch = function(text, query, escapeMarkup) {
            var markMatch = window.Select2.util.markMatch;
            var markup = [];
            if (query.term) {
              markMatch(text, query.term, markup, escapeMarkup);
              return markup.join("");
            } else {
              return text;
            }
          };

          // Function that returns the item display
          $scope.formatItem = function(item, container, query, escapeMarkup) {
            var val = item[property] || item;
            var markedText = $scope.markMatch(val, query, escapeMarkup);
            if (typeof $scope.renderItem === 'function') {
              return $scope.renderItem(val, markedText, item);
            } else {
              return markedText;
            }
          };

          // function for displaying the selected item
          $scope.formatResult = function(item) {
            var markedText = item[property] || item;
            var baseText = item[property] || item;
            if (groupProp && item[groupProp]) {
              var x = item[groupProp];
              markedText = item[property] + ' - <b>' + x[groupNameProp]
                      + '</b>';
            }
            if (typeof $scope.renderSelected === 'function') {
              return $scope.renderSelected(baseText, markedText, item);
            } else {
              return markedText;
            }
          };

          if ($scope.comboFormatResult
                  && typeof $scope.comboFormatResult === 'function') {
            $scope.foramtResult = $scope.comboFormatResult;
          }

          // Function that searches the term throught the items
          $scope.matcher = function(term, text, item) {
            if (groupProp && item[groupProp]) {
              return item[groupNameProp].toUpperCase().indexOf(
                      term.toUpperCase()) >= 0
                      || item[groupProp][groupNameProp].toUpperCase().indexOf(
                              term.toUpperCase()) >= 0;
            } else {
              var val = item[property] || item;
              return val.toUpperCase().indexOf(term.toUpperCase()) >= 0;
            }
          };

          // The config object for the select2
          $scope.options = {
            data: {
              results: [],
              text: property
            },
            allowClear: $scope.allowClear || true,
            triggerChange: true,
            multiple: multiple,
            formatSelection: $scope.formatResult,
            formatResult: $scope.formatItem,
            matcher: $scope.matcher
          };

          if ($scope.primitive) {
            $scope.options.id = function(item) {
              return item[property] || item;
            };
          }

          // Function for retrieving the combo items
          $scope.reload = function() {
            var populate = function(data) {
              var res = {};
              if (groupProp) {
                var arrayRes = [];
                angular.forEach(data, function(val) {
                  var id;
                  var g = val[groupProp];
                  if (!g) {
                    id = '--';
                  } else {
                    id = g[groupNameProp];
                  }
                  res[id] = res[id] || {
                    name: id,
                    group: g,
                    children: []
                  };
                  res[id].children.push(val);
                });

                angular.forEach(res, function(v, k) {
                  arrayRes.push(v);
                });
                $scope.options.data.results = arrayRes;
              } else {
                $scope.options.data.results = data;
              }
              if ($scope.options.data.results
                      && $scope.options.data.results.length == 1
                      && $scope.autoSet) {

                $scope.comboModel = $scope.options.data.results[0];
              }
              if ($scope.onLoad && typeof $scope.onLoad === 'function') {
                $scope.onLoad($scope, $scope.options.data.results);
              }
            };
            var params;
            if ($scope.comboServiceParams) {
              params = [$scope.comboServiceParams, populate];
            } else {
              params = [populate];
            }
            if (service) {
              service[method].apply(service, params);
            } else {
              var csrv = crudService($scope.comboType);
              method = 'query';
              csrv[method].apply(service, params);
            }
          };

          if (typeof $scope.afterInit === 'function') {
            $scope.afterInit($scope);
          } else {
            // fetch the combo items
            $scope.reload();
          }
        },
        templateUrl: 'directives/combo.html'
      };
    }]);

