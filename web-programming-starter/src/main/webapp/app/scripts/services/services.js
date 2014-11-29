FirstApp
        .factory(
                "firstService",
                [function() {
                  var content = [
                      {
                        title: 'HTML5 Boilerplate',
                        content: 'HTML5 Boilerplate is a professional front-end template for building fast, robust, and adaptable web apps or sites.'
                      },
                      {
                        title: 'Angular',
                        content: 'AngularJS is a toolset for building the framework most suited to your application development.'
                      }];

                  return {
                    get: function() {
                      return content;
                    }
                  };
                }]);
