安装依赖
npm install
1
开发
根目录运行命令：
npm start
1
前后端联调：
为了方便前后端联调不跨域，开发环境下有请求代理，配置真实后台接口地址文件为：
server/middlewares/addDevMiddlewares.js
Lint
npm run lint
1
Test
npm run test
1
打包
npm run build
1
常见问题
npm install执行过程中报错：npm ERR! Unexpected end of JSON input while parsing near ‘xxx’

解决办法：

删除掉已经自动生成的node_module文件夹，然后再运行如下命令

npm cache clean --force
npm install    
1
2
npm install执行过程中报错：Error: Command failed: C:\WINDOWS\system32\cmd.exe /s /c，或者报错：Error: pngquant failed to build, make sure that libpng-dev is installed

解决办法：

换个网络环境重新执行npm install，确保网络能够访问到npm源和git源

npm start执行完后，可以正常访问登陆页面，但是控制台提示很多类似TS232的错误
在这里插入图片描述
解决办法：

这个可能是源码中的TypeScript语法不规范引起的，笔者将在后面尝试修复这些错误，这些错误不影响正常开发，可以忽略



#ERROR 
npm install -g npm bower gulp
npm install -g gifsicle