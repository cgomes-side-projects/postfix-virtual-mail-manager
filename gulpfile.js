'use strict';

var distPath = 'src/main/webapp/assets';
var sourcesPath = 'src/front';


var gulp = require('gulp');


gulp.task('default', function() {
  // place code for your default task here
});


gulp.task('copy', function () {
  return gulp.src('bower_components/bootstrap-sass/assets/fonts/**/*')
    .pipe(gulp.dest(distPath + '/fonts/'));
});


gulp.task('compass', function() {
  var compass = require('gulp-compass');

  gulp.src( sourcesPath + '/styles/**/*.scss')
    .pipe(compass({
      sass: sourcesPath + '/styles',
      css: distPath + '/styles',
      fonts: distPath + '/fonts',
      import_path: './bower_components',
      relative: true
    }))
    .pipe(gulp.dest( distPath + '/styles/'));
});


gulp.task('uglify', function() {
  var uglify = require('gulp-uglify');
  var concat = require('gulp-concat');

  var options = {
    mangle: false,
    quoteStyle: 3,//manter a atual
    //beautify: false,
    //compress: true
  };

  gulp.src([
      'bower_components/jquery/dist/jquery.js',
      'bower_components/bootstrap-sass/assets/javascripts/bootstrap.js'
    ])
    .pipe(concat('plugins.min.js'))
    .pipe(uglify(options))
    .pipe(gulp.dest(distPath + '/js/'));

  return gulp.src([
      sourcesPath + '/js/**/*'
    ])
    .pipe(concat('scripts.min.js'))
    .pipe(uglify(options))
    .pipe(gulp.dest(distPath + '/js/'));
});


gulp.task('clean', function () {
  var clean = require('gulp-clean');
  var src = [
    distPath + '/fonts/**/*',
    distPath + '/styles/**/*',
    distPath + '/js/**/*'
  ];

  return gulp.src(src, {read: false})
    .pipe(clean());
});


gulp.task('build', ['clean', 'copy', 'compass', 'uglify']);
