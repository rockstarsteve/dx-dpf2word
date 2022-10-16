# dx-dpf2word
~~环境：jdk17 + javafx~~

切换回：**环境：jdk1.8 + javafx**,主要是打包的时候出了点问题，没法解决，先用回1.8吧

**pdf转word文档的工具**

**releases中有已经打好的安装包，点击exe可直接使用，不需要额外安装jre环境**


通过<properties>定义spring的版本号，通过${spring.version}调用spring的版本号。
$ {project.basedir}：表示当前项目的根目录，即当前pom.xml文件所在的位置，还可以简化的写法：${basedir}
${project.version}：表示当前项目的版本，可以简写为： ${version}
${project.build.sourceDirectory}：表示项目的主源码目录，默认为src/main/java/
${project.build.testSourceDirectory}：项目的测试源码目录，默认为/src/test/java/
${project.build.directory}：表示项目的构建目录，默认值为 ${basedir}/target
${project.build.outputDirectory}：表示项目主代码编译输出目录，默认为 ${basedir}/target/classes
${project.build.testOutputDirectory}：表示项目测试代码编译输出目录，默认为 ${basedir}/target/test-classes
${project.build.sourceDirectory}：表示默认情况下src/main/java文件夹。



## 用法

**解压dxPdf2word.zip文件后，直接双击里面的exe文件就能直接运行**

