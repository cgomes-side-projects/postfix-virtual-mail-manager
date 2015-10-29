/*global module:false*/
'use strict';
module.exports = function(grunt) {

  require('load-grunt-tasks')(grunt);
  require('time-grunt')(grunt);

  // Project configuration.
  grunt.initConfig({
    // Metadata.
    pkg: grunt.file.readJSON('package.json'),


    watch: {
      gruntfile: {
        files: '<%= jshint.gruntfile.src %>',
        tasks: ['jshint:gruntfile']
      },
      jshint: {
        files: '<%= jshint.front.src %>',
        tasks: ['jshint:front']
      }
    },


    concat: {
      options: {
        stripBanners: true
      },
      dist: {
        src: ['lib/<%= pkg.name %>.js'],
        dest: 'dist/<%= pkg.name %>.js'
      }
    },


    uglify: {
      options: {
        banner: '<%= banner %>'
      },
      dist: {
        src: '<%= concat.dist.dest %>',
        dest: 'dist/<%= pkg.name %>.min.js'
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
};
