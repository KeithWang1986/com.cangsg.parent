process.env.BABEL_ENV = 'production';
process.env.NODE_ENV = 'production';

const webpack = require("webpack");
const config = require('./config/webpack.config.prod');

const compiler = webpack(config);

compiler.run((err, stats) => {
    if (err) {
        console.error(err);
        return;
    }

    console.log(stats.toString({
        chunks: false,  // Makes the build much quieter
        colors: true    // Shows colors in the console
    }));
    console.log('\u001b[1m\u001b[32m');
    console.log('===== [ 生产环境 打包完成 ] =====');
    console.log('\u001b[39m\u001b[22m');
});