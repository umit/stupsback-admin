var path = require('path');

var node_dir = __dirname + '/node_modules';

module.exports = {
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    entry: [
        './src/main/js/main.js',
        'webpack/hot/only-dev-server'
    ],
    output: {
        path: './src/main/resources/static/dist',
        filename: "bundle.js",
        publicPath: '/dist/'

    },
    resolve: {
        alias: {
            'stompjs': node_dir + '/stompjs/lib/stomp.js',
            'when': node_dir + '/when/when.js',
            components: path.resolve(__dirname, './src/main/js/components/'),
            constants: path.resolve(__dirname, './src/main/js/constants/')
        }
    },
    externals: [
        {
            "tether": {
                root: "Tether",
                commonjs2: "tether",
                commonjs: "tether",
                amd: "tether"
            }
        }
    ],
    devServer: {
        contentBase: 'src/main/js',
        noInfo: false, //  --no-info option
        quiet: false,
        historyApiFallback: true,
        proxy: {
            '/api*': 'http://localhost:8080',
            '/sse*': 'http://localhost:8080',
            '/feedback-stomp*': 'http://localhost:8080'
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
