FirstApp.controller('StudentController', ['$scope', 'Grade',
    function($scope, Grade) {
      $scope.grades = Grade.getGradesAsArray();

      $scope.name = 'Student controller';
      $scope.subjects = ['SP', 'OOP', 'WP', 'MPiP'];

      $scope.entity = {};

      $scope.addGrade = function() {
        Grade.setGrade($scope.grade.subject, $scope.grade.grade);
        $scope.grade = {};
        $scope.grades = Grade.getGradesAsArray();
      };
      
      $scope.removeGrade = function(g){
        Grade.removeGrade(g.subject);
        $scope.grades = Grade.getGradesAsArray();
      };
    }]);
