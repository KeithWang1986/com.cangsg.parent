process.env.BABEL_ENV = 'development';
process.env.NODE_ENV = 'development';

const webpack = require("webpack");
const config = require('./config/webpack.config.dev');

const compiler = webpack(config);

watchOptions = {
    ignored: /node_modules/
};

const watching = compiler.watch(watchOptions, (err, stats) => {
    if (err) {
        console.error(err);
        return;
    }

    console.log(stats.toString({
        chunks: false,  // Makes the build much quieter
        colors: true   // Shows colors in the console
    }));
    console.log('\u001b[1m\u001b[32m');
    console.log('===== [ 开发环境 监控开始... ] =====');
    console.log('\u001b[39m\u001b[22m');
});