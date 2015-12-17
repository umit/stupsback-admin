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
            {test: path.join(__dirname, '.'),
                exclude: /(node_modules|bower_components)/,
                loader: 'babel-loader',
                query: {
                  presets: ['es2015', 'react']
                }
            },
            {test: /\.(otf|eot|svg|ttf|woff|woff2)(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=8192&mimetype=application/font-woff'},
            {test: /\.(png|jpg|jpeg|gif)$/, loaders: ['url?limit=8192', 'img']},
            {test: /\.less$/, exclude: /node_modules/, loaders: ['style-loader', 'css-loader', 'autoprefixer', 'less-loader']},
            {test: /\.css$/, loaders: ['style-loader', 'css-loader']}
        ]
    }
};
