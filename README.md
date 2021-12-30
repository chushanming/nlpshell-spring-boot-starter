# nlpshell-spring-boot-starter
## 项目说明

NLP-Shell是一个更易于调用现有的自然语言处理服务的接口组件，让自然语言处理的研究和应用过程摆脱复杂的配置和请求响应的数据编码与解析工作，对处理过程和编码进行了深度封装，使调用过程简捷而明确。


## 示例

### 如何使用


0. 构建自然语言处理服务，将已有的自然语言处理模型或框架以服务形式运行，每种自然语言处理模型的实现形式不尽相同，以 CoreNLP 为例。
      
   参照[CoreNLP](https://stanfordnlp.github.io/CoreNLP)官网，构建并运行CoreNLP Server，假定服务运行地址和端口为`127.0.0.1:9000`。
      
1. 下载完整源代码包，解压到任意本地目录，以Ubuntu为例，在源代码包的 `pom.xml` 所在目录下执行

    > `mvn clean install`
    
    显示`BUILD SUCCESS`即为编译打包成功并安装nlp-shell到本地maven库中。

2. 构建 Spring Boot 应用，在 `pom.xml` 中添加nlp-shell的依赖
    ```
    <dependency>
       <groupId>io.shannon</groupId>
       <artifactId>nlpshell-spring-boot-starter</artifactId>
       <version>${version}</version>
    </dependency>
    ```
    根据实际填写或定义版本`${version}`

3. 在应用的 /src/main/resources/application.properties 配置文件中配置 CoreNLP Server 地址
	
    `nlpshell.corenlp.remote-host=127.0.0.1`
    
    `nlpshell.corenlp.remote-port=9000`（缺省值即为`9000`，端口配置可省略）
    
    若使用application.yml配置文件同理
    ```
    nlpshell:
      corenlp:
        remote-host: 127.0.0.1
        remote-port: 9000
    ```
4. 使用自动注入方式，将 `NLPShellService` 注入到 `Controller` 中
   
    ```
     @Autowired
     private NLPShellService nlpShellService;
    ```
   
5. 在需要的位置调用处理方法
    
    ```
      //输入内容为 input
      String input = “Starting Application using Java 1.8.0_241 on ubuntu with PID 1769926.”;
      //输出结果集为 result
      NLPResult result = nlpShellService.nlpProcess(input);
    ```
    
6. 输出结果集中包含了词性标注(pos)、命名实体识别(NER)等结果，从中进一步提取

    ```
      //获取结果集中所有的名词
      ArrayList<String> nnList = result.getListOfNN();
      //获取结果集中所有的命名实体
      ArrayList<String> nerList = result.getListOfNER();
    ```

### 更多

如果您对 NLP-Shell 有任何建议或想法，欢迎在 issue 中或者通过其他社区渠道提出。
