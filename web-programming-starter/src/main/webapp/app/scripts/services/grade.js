FirstApp.factory("Grade", ['$resource', function($resource) {
  var grades = {};

  return {
    /**
     * set grade for a subject. If a grade for the subject exists, it will be
     * overridden
     */
    setGrade: function(subject, grade) {
      grades[subject] = grade;
    },
    /**
     * removes the grade for the subject, if it exists
     */
    removeGrade: function(subject) {
      delete grades[subject];
    },
    /**
     * retrieves all the grades as an array of objects.
     */
    getGradesAsArray: function() {
      var res = new $resource('/web-programming/data/grades.json', {}, {});
      res.save({
        "subject": "MP",
        grade: '10'
      });
      res.remove({id: 1});
      return res.query();
    }
  };
}]);