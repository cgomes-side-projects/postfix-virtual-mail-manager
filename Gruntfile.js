/*global module:false*/
'use strict';
module.exports = function(grunt) {

  require('load-grunt-tasks')(grunt);
  require('time-grunt')(grunt);

  // Project configuration.
  grunt.initConfig({

    // Metadata.
    pkg: grunt.file.readJSON('package.json'),
    distPath: 'src/main/webapp/assets',
    sourcesPath: 'src/front',

    watch: {
      gruntfile: {
        files: '<%= jshint.gruntfile.src %>',
        tasks: ['jshint:gruntfile']
      },
      jshint: {
        files: '<%= jshint.front.src %>',
        tasks: ['jshint:front']
      },
      sass: {
        files: ['<%= sourcesPath %>/styles/**/*.scss', '!<%= sourcesPath %>/styles/main.scss'],
        tasks: ['sass:dev']
      }
    },


    sass: {
      options: {
        sourceMap: false,
        includePaths: ['bower_components/']
      },
      dev: {
        options: {
          outputStyle: 'expanded'
        },
        files: {
          '<%= distPath %>/styles/admin-template.css': '<%= sourcesPath %>/styles/admin-template.scss'
        }
      },
      dist: {
        files: {
          '<%= distPath %>/styles/main.css': '<%= sourcesPath %>/styles/main.scss',
          '<%= distPath %>/styles/admin-template.css': '<%= sourcesPath %>/styles/admin-template.scss'
        }
      }
    },


    uglify: {
      options: {
        mangle: false,
        quoteStyle: 3,//manter a atual
        //beautify: false,
        //compress: true
      },
      dist: {
        files: [
          {
            src: [
              'bower_components/jquery/dist/jquery.js',
              'bower_components/bootstrap-sass/assets/javascripts/bootstrap.js'
            ],
            dest: '<%= distPath %>/js/plugins.min.js'
          },
          {
            src: '<%= sourcesPath %>/js/**/*',
            dest: '<%= distPath %>/js/scripts.min.js'
          }
        ]
      }
    },


    copy: {
      dist: {
        files: [
          {
            expand: true,
            cwd: 'bower_components/bootstrap-sass/assets/',
            src: 'fonts/bootstrap/*',
            dest: '<%= distPath %>'
          }
        ]
      }
    },


    // Empties folders to start fresh
    clean: {
      dist: {
        files: [{
          dot: true,
          src: [
            '<%= distPath %>/fonts/**/*',
            '<%= distPath %>/styles/**/*'
          ]
        }]
      }
    },


    jshint: {
      options: {
        node: true,
        browser: true,
        esnext: true,
        bitwise: true,
        camelcase: true,
        curly: false,
        eqeqeq: false,
        immed: true,
        indent: 2,
        latedef: false,
        newcap: true,
        noarg: true,
        quotmark: 'single',
        undef: true,
        unused: true,
        strict: true,
        trailing: true,
        smarttabs: true,
        globals: {
          angular: false,
          $: false,
          APP_NAME: false,
          PRODUCTION: false,
          jQuery: true
        }
      },
      gruntfile: {
        src: 'Gruntfile.js'
      },
      front: {
        src: ['src/front/js/**/*.js']
      }
    }

  });

  // Default task.
  grunt.registerTask('default', []);


  grunt.registerTask('build', [
    'clean',
    'copy',
    'compass',
    'uglify'
  ]);

};
