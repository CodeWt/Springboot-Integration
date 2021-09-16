what is maven 
```
POM(project object model)
在maven中每个项目 相当于一个对象，对象（项目）与对象（项目）之间是有关系的。关系包含了，继承，依赖，聚合，实现maven项目可以更加方便的引用jar包，拆分，合成项目等效果。
```
maven的坐标
```
maven中的project是基于坐标管理的，即groupId，artifactId，version来定位。
groupId:域名倒着写 eg：com.msb
artifactId：一般使用项目名字
version：版本
```
repository
```
1.默认为中央仓库 mvnrepository.com
2.本地仓库指的是本机的一份拷贝，用来缓存远程的下载，包含尚未发布的本地项目的临时构件。
3.仓库的优先级：
    先到本地仓库找，若本地仓库没有,分以下两种情况。
    <1>没有配置远程仓库镜像,直接到远程的中央仓库找。
    <2>配置了远程镜像，若配置的镜像中有目标jar，则download cache到local；
        若配置的远程镜像也没有目标镜像，则去central处找。
```
setting一般配置三项
```
1.本地仓库localRepository
2.远程仓库镜像mirror
3.编译器环境profile
```
用maven构建工程有三种类型
```
1.POM工程：该工程是逻辑工程，用在父级工程(子项目可以直接继承使用父类的jar包)
或聚合工程（聚合汇总多个子工程为一个项目）。用来做jar包的版本控制。
2.JAR工程：工程会被打包为jar，用作jar包使用。即常见的本地工程 --> Java Project
3.WAR工程：project会被打包成war，发布在服务器上的工程。
```
maven项目结构
```
|-ProjectName
    |--.idea
    |--src
        --main
            --java(存储java的源代码)
            --resources(存储配置文件)
        --test
            --java(测试类代码，eg:junit)
    |--target(执行mvn install 后会生成该文件夹并放置编译后的文件,包含了该项目的jar包，
                jar包的存放路径为localRepository.groupId.artifactId.version)
    |--ProjectName.iml
    |--pom.xml(maven的)
|-External Libraries
    |--Maven:com.msb:ProjectName:version
    |--Maven:org.mybatis:mybatis:version
    |--Maven:com.yjg:ProjectName:version
    ...

```
项目的依赖、依赖传递性
```
1.如果项目2依赖于项目1，而项目1依赖于mybatis，则项目2也依赖于mybatis，
在项目2中可以直接使用mybatis的API
2.最短路径优先原则：项目依赖关系树中最短路径的版本会被使用。
   eg：A->B—>C->D(2.0),A->E-D(1.0) ==> D(1.0)会被使用
3.最先声明原则
   eg:A->B->D(2.0),A->E->D(1.0),若是B在前,则使用D(2.0),相反则用D(1.0)
4.不用的依赖则排除包 ： exclusions标签，不用加版本号
```
依赖的范围<scope></scope>
```
依赖范围决定了依赖坐标在什么情况下有效什么情况下无效,
如果没有指定，默认为compile
1.compile表示依赖在编译和运行时都生效
2.provided已提供依赖范围。eg：servlet-api，编译和测试项目的时候需要该依赖范围，
    但在运行项目时，由于container已提供，就不需要Maven重新引入一遍。
3.runtime编译时不需要生效，而只有在运行时生效。eg：jdbc驱动的实现，项目主代码的编译
只需要jdk提供的jdbc的接口，只有在执行测试或者运行项目的时候才需要实现上述接口的具体jdbc驱动。
4.system系统范围与provided类似，不过必须显式的指定一个本地系统路径的jar，
此类依赖一直有效，Maven也不会去仓库中找他.但必须要通过systemPath元素显式的指定依赖文件的路径。
5.test只有在测试代码和运行测试的时候需要，应用的正常运行不需要此类依赖。
eg：Junit，只有在编译和运行测试代码时用，其jar包只在测试阶段用，但是打包到生产环境就没必要包含该jar。
6.import该范围只适用于pom文件中的<dependencyManagement>部分。
表明指定的pom必须使用<dependencyManagement>部分的依赖。
注意： import只能用在dependencyManagement的scope里。
      父工程声明<scope>import</scope>版本号，则子工程只能继承父工程的版本号不可重写。
```
Maven常见的插件
```aidl
1.编译配置插件
 pom.xml中配置jdk编译器插件覆盖setting.xml的配置
  <build>
     <plugins>
         ...
     </plugins>
  </build>
2.打包资源配置插件
 Maven在打包的时候默认将src/main/resources下的配置文件拷贝到项目中并做打包处理，
 而非resources目录下的配置文件是不会被打包添加到项目中的。如果需要将非resources中
 的配置文件打包到项目中，可以通过如下方式配置pom。
 <build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            //选定打包的文件
            <includes>
                <include>**/*.yaml</include>
                <include>**/*.xml</include>
            </includes>
            //排除打包的文件&ndash;&gt;
            <excludes>
                <exclude>other/mybatis-config.xml</exclude>
            </excludes>
        </resource>
    </resources>
 </build>
3.tomcat插件
 标准的webAPP项目结构
 |--src/main/webapp
    --|web-inf
        --|web.xml
    --|index.jsp
 日常创建war项目，必然要部署到服务器上面，方式：
    <1>部署到远程服务器上面
    <2>将Idea和外部的tomcat产生关联，然后将项目部署在外部的tomcat上
    <3>使用maven提供的tomcat插件，使用配置pom来使用。使用tomcat插件发布部署并执行war工程，
        启动命令为 tomcat7:run ,tomcat7为插件名，run为插件的具体功能命令。
    
```
Maven常见的命令
```
1.install 本地安装，包含编译，打包，安装到本地仓库
  相当于编译javac 打包 -jar 将java代码文件打包为jar文件，安装到本地仓库。
2.clean
  清除编译后的信息，删除工程中的target目录
3.compile
  javac
4.package
  打包，包含编译打包两个功能
5.install 和 package 区别
   package命令完成了项目的编译，单元测试，打包功能，但没有将可执行的jar包(war包或其他形式的包)部署到本地Maven仓库和远程仓库
   install命令完成了项目的编译，单元测试，打包功能，同时将可执行的jar包(war包或其他形式的包)部署到本地Maven仓库但是没有部署到远程仓库
6.deploy将打好的工程包部署到远程库。
   
```