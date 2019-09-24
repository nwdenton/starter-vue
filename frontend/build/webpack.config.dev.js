'use strict';
const webpack = require('webpack');
const {VueLoaderPlugin} = require('vue-loader');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const path = require('path');
const fs = require('fs');

function resolve (dir) {
    return path.join(__dirname, '..', dir)
}

module.exports = {
    mode: 'development',

    devServer: {
        hot: true,
        watchOptions: {
            poll: true
        },
        // https: {
        //     key: fs.readFileSync('./certs/server.key'),
        //     cert: fs.readFileSync('./certs/server.cert'),
        // },
        port: 3000,
        proxy: {
            '/api': 'http://localhost:8080'
        }
    },
    module: {
        rules: [
            {
                test: /\.vue$/,
                use: 'vue-loader'
            },
            {
                test: /\.scss$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    'sass-loader'
                ]
            },
            {
                test: /\.js$/,
                use: 'babel-loader'
            },
            {
                test: /\.ts$/,
                loader: 'ts-loader',
                exclude: /node_modules/,
                options: {
                    appendTsSuffixTo: [/\.vue$/]
                }
            }
        ]
    },
    resolve: {
        extensions: ['.ts','.js','.vue'],
        alias: {
            '@': resolve('src'),
            '@views': resolve('src/views'),
            '@components': resolve('src/components'),
            '@services': resolve('src/services'),
            '@assets': resolve('assets'),
        }
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new VueLoaderPlugin(),
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'index.html',
            inject: true
        }),
        new CopyWebpackPlugin([{
            from: resolve('assets'),
            to: resolve('dist/assets'),
            toType: 'dir'
        }])
    ]
};