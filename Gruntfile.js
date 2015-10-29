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
      }
    },


    // Compiles Sass to CSS and generates necessary files if requested
    compass: {
      options: {
        sassDir: 'src/front/styles',
        cssDir: '<%= distPath %>/styles',
        generatedImagesDir: '<%= distPath %>/images/generated',
        imagesDir: 'src/front/images',
        javascriptsDir: 'src/front/scripts',
        fontsDir: 'src/front/styles/fonts',
        importPath: './bower_components',
        httpImagesPath: '/images',
        httpGeneratedImagesPath: '/images/generated',
        httpFontsPath: '/fonts',
        relativeAssets: true,
        assetCacheBuster: false,
        raw: 'Sass::Script::Number.precision = 10\n'
      },
      dist: {
        options: {
          debugInfo: true,
          generatedImagesDir: '<%= distPath %>/images/generated'
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
