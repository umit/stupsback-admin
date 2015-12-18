var path = require('path');

module.exports = {
    entry: './src/main/js/main.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: './src/main/resources/static',
        filename: "bundle.js"
    },
    resolve: {
        alias: {
            components: path.resolve(__dirname, './src/main/js/components/'),
            constants: path.resolve(__dirname, './src/main/js/constants/')
        }
    },
    devServer: {
      inline: true,
      contentBase: './src/main/resources/static'
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
