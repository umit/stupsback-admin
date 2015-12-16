var path = require('path');

module.exports = {
    entry: './src/main/js/main.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: './dist',
        filename: "bundle.js"
    },
    devServer: {
      inline: true,
      contentBase: './dist',
      // this does not work at the moment
      proxy: {
        "/api": "http://localhost:8080/api"
      }
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules|bower_components)/,
                loader: 'babel',
                query: {
                  presets: ['es2015', 'react']
                }
            }
        ]
    }
};
