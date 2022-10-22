const { defineConfig } = require('@vue/cli-service')
const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')

module.exports = defineConfig({
  // devServer: {
  //   historyApiFallback: true,
  //   allowedHosts: 'all',
  //   proxy: {
  //     '/proxy': {
  //         target: 'https://sm.ms/',
  //         secure: false,
  //         ws: true,
  //         changeOrigin: true,
  //         pathRewrite: {
  //             '^/proxy': ''
  //         },
  //         // headers: {
  //         //     Referer: 'https://sm.ms/'
  //         // }
  //     },
      
  //   },
  // },
  transpileDependencies: true,
  configureWebpack: {
    plugins: [
      AutoImport({
        resolvers: [ElementPlusResolver()],
        }),
        Components({
          resolvers: [ElementPlusResolver()],
        }),
    ],
  },
  pwa: {
    iconPaths: {
        favicon32: 'favicon.ico',
        favicon16: 'favicon.ico',
        appleTouchIcon: 'favicon.ico',
        maskIcon: 'favicon.ico',
        msTileImage: 'favicon.ico'
    }
  },

})
