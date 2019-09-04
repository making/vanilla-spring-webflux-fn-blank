# Vanilla Spring WebFlux.fn Blank

Maven archetype to create a pre-configured maven project for Vanilla Spring WebFlux.fn Application.

This app uses neither Spring Boot nor DI container (!!).

Only [Router Function](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/web-reactive.html#webflux-fn) is used.

## Create a blank project using maven archetype

### How to use

#### Use Spring 5.2.x

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.9
```

for SNAPSHOT version

```
mvn -U org.apache.maven.plugins:maven-archetype-plugin:2.2:generate \
 -DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots \
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.10-SNAPSHOT
```

#### Use Spring 5.1.x

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.1.4
```

### Example

```
$ mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.9\
 -DgroupId=com.example\
 -DartifactId=demo-fluxfn\
 -Dversion=1.0.0-SNAPSHOT\
 -B

[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] 
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[INFO] Archetype repository not defined. Using the one from [am.ik.archetype:vanilla-spring-webflux-fn-blank-archetype:0.2.8] found in catalog remote
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.9/vanilla-spring-webflux-fn-blank-archetype-0.2.9.pom
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.9/vanilla-spring-webflux-fn-blank-archetype-0.2.9.pom (2.7 kB at 6.6 kB/s)
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.9/vanilla-spring-webflux-fn-blank-archetype-0.2.9.jar
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.9/vanilla-spring-webflux-fn-blank-archetype-0.2.9.jar (56 kB at 135 kB/s)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: vanilla-spring-webflux-fn-blank-archetype:0.2.9
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.example
[INFO] Parameter: artifactId, Value: demo-fluxfn
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: package, Value: com.example
[INFO] Parameter: packageInPathFormat, Value: com/example
[INFO] Parameter: package, Value: com.example
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: groupId, Value: com.example
[INFO] Parameter: artifactId, Value: demo-fluxfn
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/yavi.json
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/app.json
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/native-image.properties
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/framework.json
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/netty.json
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/logback.xml
[INFO] Project created from Archetype in dir: /private/tmp/demo-fluxfn
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.250 s
[INFO] Finished at: 2019-09-04T15:49:11+09:00
[INFO] Final Memory: 15M/216M
[INFO] ------------------------------------------------------------------------

$ tree demo-fluxfn -a
demo-fluxfn
├── .mvn
│   └── wrapper
│       ├── maven-wrapper.jar
│       └── maven-wrapper.properties
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           ├── App.java
    │   │           ├── HelloHandler.java
    │   │           ├── Message.java
    │   │           └── MessageHandler.java
    │   └── resources
    │       ├── META-INF
    │       │   └── native-image
    │       │       └── com.example
    │       │           └── demo-fluxfn
    │       │               ├── app.json
    │       │               ├── framework.json
    │       │               ├── native-image.properties
    │       │               ├── netty.json
    │       │               └── yavi.json
    │       └── logback.xml
    └── test
        ├── java
        │   └── com
        │       └── example
        │           ├── HelloHandlerTest.java
        │           └── MessageHandlerTest.java
        └── resources
            └── junit-platform.properties

17 directories, 18 files
```



```
$ cd demo-fluxfn
$ mvn clean package
$ java -jar target/demo-fluxfn-1.0.0-SNAPSHOT.jar 
2019-05-27 08:49:42.073  INFO --- [           main] com.example.App                          : Started in 0.781 seconds
```

```
$ curl localhost:8080
Hello World!
```

Following libraries will be included:

```
$ mvn dependency:list | grep ':compile' | sort
[INFO]    am.ik.yavi:yavi:jar:0.2.2:compile
[INFO]    ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO]    ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO]    com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO]    com.fasterxml.jackson.core:jackson-core:jar:2.9.9:compile
[INFO]    com.fasterxml.jackson.core:jackson-databind:jar:2.9.9:compile
[INFO]    com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.9:compile
[INFO]    io.netty:netty-buffer:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-codec-http:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-codec-socks:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-codec:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-common:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-handler-proxy:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-handler:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-resolver:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-transport-native-epoll:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-transport-native-unix-common:jar:4.1.38.Final:compile
[INFO]    io.netty:netty-transport:jar:4.1.38.Final:compile
[INFO]    io.projectreactor.addons:reactor-pool:jar:0.0.1.M3:compile
[INFO]    io.projectreactor.netty:reactor-netty:jar:0.9.0.M3:compile
[INFO]    io.projectreactor:reactor-core:jar:3.3.0.M3:compile
[INFO]    org.reactivestreams:reactive-streams:jar:1.0.2:compile
[INFO]    org.slf4j:slf4j-api:jar:1.7.26:compile
[INFO]    org.springframework:spring-aop:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-beans:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-context:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-core:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-expression:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-jcl:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-web:jar:5.2.0.RC1:compile
[INFO]    org.springframework:spring-webflux:jar:5.2.0.RC1:compile
```

Configure memory size as below:

```
JAVA_OPTS="-Xmx16M -Xss1M -XX:MaxMetaspaceSize=32M -XX:ReservedCodeCacheSize=32M -XX:CompressedClassSpaceSize=8M -XX:MaxDirectMemorySize=8M"
java $JAVA_OPTS -jar target/demo-fluxfn-1.0.0-SNAPSHOT.jar
```

This will actually run.

### Deploy to Cloud Foundry

To make best use of small footprint, you can configure [Java Memory Calculator](https://github.com/cloudfoundry/java-buildpack-memory-calculator)

Here is a example of `manifest.yml` that uses only 112Mb memory:

``` yml
applications:
- name: fluxfn
  buildpack: java_buildpack
  memory: 112M
  path: target/demo-fluxfn-1.0.0-SNAPSHOT.jar 
  env:
    JAVA_OPTS: '-XX:MaxMetaspaceSize=32M -XX:ReservedCodeCacheSize=32M -XX:CompressedClassSpaceSize=8M -XX:MaxDirectMemorySize=8M'
    JBP_CONFIG_OPEN_JDK_JRE: '[memory_calculator: {stack_threads: 16}]'
```

Be careful that this configuration is well tuned for a tiny "Hello World" application.


```
$ mvn clean package
$ java -jar target/demo-fluxfn-1.0.0-SNAPSHOT.jar
$ cf push
  Using manifest file /private/tmp/demo-fluxfn/demo-fluxfn/manifest.yml
  
  Updating app fluxfn in org myorg / space development as maki@example.com...
  OK
  
  Uploading fluxfn...
  Uploading app files from: /var/folders/15/fww24j3d7pg9sz196cxv_6xm4nvlh8/T/unzipped-app921204986
  Uploading 214.5K, 78 files
  Done uploading               
  OK
  
  Starting app fluxfn in org myorg / space development as maki@example.com...
  Downloading java_buildpack...
  Downloaded java_buildpack
  Creating container
  Successfully created container
  Downloading app package...
  Downloaded app package (10.7M)
  -----> Java Buildpack v4.5 (offline) | https://github.com/cloudfoundry/java-buildpack.git#ffeefb9
  -----> Downloading Jvmkill Agent 1.10.0_RELEASE from https://java-buildpack.cloudfoundry.org/jvmkill/trusty/x86_64/jvmkill-1.10.0_RELEASE.so (found in cache)
  -----> Downloading Open Jdk JRE 1.8.0_141 from https://java-buildpack.cloudfoundry.org/openjdk/trusty/x86_64/openjdk-1.8.0_141.tar.gz (found in cache)
         Expanding Open Jdk JRE to .java-buildpack/open_jdk_jre (1.6s)
  -----> Downloading Open JDK Like Memory Calculator 3.9.0_RELEASE from https://java-buildpack.cloudfoundry.org/memory-calculator/trusty/x86_64/memory-calculator-3.9.0_RELEASE.tar.gz (found in cache)
         Loaded Classes: 12505, Threads: 16
  -----> Downloading Client Certificate Mapper 1.2.0_RELEASE from https://java-buildpack.cloudfoundry.org/client-certificate-mapper/client-certificate-mapper-1.2.0_RELEASE.jar (found in cache)
  -----> Downloading Container Security Provider 1.8.0_RELEASE from https://java-buildpack.cloudfoundry.org/container-security-provider/container-security-provider-1.8.0_RELEASE.jar (found in cache)
  -----> Downloading Spring Auto Reconfiguration 1.12.0_RELEASE from https://java-buildpack.cloudfoundry.org/auto-reconfiguration/auto-reconfiguration-1.12.0_RELEASE.jar (found in cache)
  Exit status 0
  Uploading droplet, build artifacts cache...
  Uploading build artifacts cache...
  Uploading droplet...
  Uploaded build artifacts cache (129B)
  Uploaded droplet (57.1M)
  Uploading complete
  Stopping instance bce0ba8a-c5e3-4554-b893-e545801da7a8
  Destroying container
  Successfully destroyed container
  
  1 of 1 instances running
  
  App started
  
  
  OK
  
  App fluxfn was started using this command `JAVA_OPTS="-agentpath:$PWD/.java-buildpack/open_jdk_jre/bin/jvmkill-1.10.0_RELEASE=printHeapHistogram=1 -Djava.io.tmpdir=$TMPDIR -Djava.ext.dirs=$PWD/.java-buildpack/container_security_provider:$PWD/.java-buildpack/open_jdk_jre/lib/ext -Djava.security.properties=$PWD/.java-buildpack/security_providers/java.security $JAVA_OPTS" && CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-3.9.0_RELEASE -totMemory=$MEMORY_LIMIT -stackThreads=16 -loadedClasses=13214 -poolType=metaspace -vmOptions="$JAVA_OPTS") && echo JVM Memory Configuration: $CALCULATED_MEMORY && JAVA_OPTS="$JAVA_OPTS $CALCULATED_MEMORY" && SERVER_PORT=$PORT eval exec $PWD/.java-buildpack/open_jdk_jre/bin/java $JAVA_OPTS -cp $PWD/. org.springframework.boot.loader.JarLauncher`
  
  Showing health and status for app fluxfn in org myorg / space development as maki@example.com...
  OK
  
  requested state: started
  instances: 1/1
  usage: 112M x 1 instances
  urls: fluxfn.cfapps.io
  last uploaded: Thu Dec 21 12:05:41 UTC 2017
  stack: cflinuxfs2
  buildpack: java_buildpack
  
       state     since                    cpu    memory          disk           details
  #0   running   2017-12-21 09:06:27 PM   0.3%   95.1M of 112M   135.7M of 1G
```


### How to use `ApplicationContext`

``` diff
diff --git a/src/main/java/com/example/App.java b/src/main/java/com/example/App.java
index 784b593..2f16b86 100644
--- a/src/main/java/com/example/App.java
+++ b/src/main/java/com/example/App.java
@@ -6,12 +6,14 @@ import java.util.Optional;
 import org.slf4j.LoggerFactory;
 import reactor.netty.http.server.HttpServer;
 
+import org.springframework.context.support.GenericApplicationContext;
 import org.springframework.http.server.reactive.HttpHandler;
 import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
-import org.springframework.web.reactive.function.server.HandlerStrategies;
 import org.springframework.web.reactive.function.server.RouterFunction;
 import org.springframework.web.reactive.function.server.RouterFunctions;
 import org.springframework.web.reactive.function.server.ServerResponse;
+import org.springframework.web.server.WebHandler;
+import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
 
 public class App {
 
@@ -21,8 +23,13 @@ public class App {
 				.map(Integer::parseInt) //
 				.orElse(8080);
 
-		HttpHandler httpHandler = RouterFunctions.toHttpHandler(App.routes(),
-				HandlerStrategies.builder().build());
+		GenericApplicationContext context = new GenericApplicationContext();
+		context.registerBean("webHandler", WebHandler.class,
+				() -> RouterFunctions.toWebHandler(App.routes()));
+		context.refresh();
+		context.registerShutdownHook();
+		HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(context)
+				.build();
 		HttpServer httpServer = HttpServer.create().host("0.0.0.0").port(port)
 				.handle(new ReactorHttpHandlerAdapter(httpHandler));
 		httpServer.bindUntilJavaShutdown(Duration.ofSeconds(3), disposableServer -> {
```

See also [Functional Spring Cookbook](https://github.com/making/functional-spring-cookbook)

### GraalVM support

0.2.x supports [GraalVM](https://www.graalvm.org) build.

Tested with 19.2.0.

```
$ mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.9\
 -DgroupId=com.example\
 -DartifactId=demo-fluxfn\
 -Dversion=1.0.0-SNAPSHOT\
 -B
```

Install [GraalVM](https://www.graalvm.org/downloads/) and configure

```
export JAVA_HOME=/path-to-graalvm
export PATH=$PATH:$JAVA_HOME/bin
```

If you are using SDKMAN, try 

```
sdk install java 19.2.0-grl
sdk use java 19.2.0-grl
```

```
$ cd demo-fluxfn
$ mvn clean package -DskipTests=true -Pgraal
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building demo-fluxfn 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ demo-fluxfn ---
[INFO] Deleting /private/tmp/demo-fluxfn/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ demo-fluxfn ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 6 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ demo-fluxfn ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 4 source files to /private/tmp/demo-fluxfn/target/classes
[WARNING] /private/tmp/demo-fluxfn/src/main/java/com/example/MessageHandler.java: /private/tmp/demo-fluxfn/src/main/java/com/example/MessageHandler.javaは非推奨のAPIを使用またはオーバーライドしています。
[WARNING] /private/tmp/demo-fluxfn/src/main/java/com/example/MessageHandler.java: 詳細は、-Xlint:deprecationオプションを指定して再コンパイルしてください。
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ demo-fluxfn ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ demo-fluxfn ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /private/tmp/demo-fluxfn/target/test-classes
[WARNING] /private/tmp/demo-fluxfn/src/test/java/com/example/MessageHandlerTest.java: /private/tmp/demo-fluxfn/src/test/java/com/example/MessageHandlerTest.javaは非推奨のAPIを使用またはオーバーライドしています。
[WARNING] /private/tmp/demo-fluxfn/src/test/java/com/example/MessageHandlerTest.java: 詳細は、-Xlint:deprecationオプションを指定して再コンパイルしてください。
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.0:test (default-test) @ demo-fluxfn ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ demo-fluxfn ---
[INFO] Building jar: /private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- native-image-maven-plugin:19.2.0:native-image (default) @ demo-fluxfn ---
[INFO] ImageClasspath Entry: org.springframework:spring-context:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-context/5.2.0.RC1/spring-context-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-aop:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-aop/5.2.0.RC1/spring-aop-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-beans:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-beans/5.2.0.RC1/spring-beans-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-core:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-core/5.2.0.RC1/spring-core-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-jcl:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-jcl/5.2.0.RC1/spring-jcl-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-expression:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-expression/5.2.0.RC1/spring-expression-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-webflux:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-webflux/5.2.0.RC1/spring-webflux-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: io.projectreactor:reactor-core:jar:3.3.0.M3:compile (file:///Users/maki/.m2/repository/io/projectreactor/reactor-core/3.3.0.M3/reactor-core-3.3.0.M3.jar)
[INFO] ImageClasspath Entry: org.reactivestreams:reactive-streams:jar:1.0.2:compile (file:///Users/maki/.m2/repository/org/reactivestreams/reactive-streams/1.0.2/reactive-streams-1.0.2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-web:jar:5.2.0.RC1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-web/5.2.0.RC1/spring-web-5.2.0.RC1.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-classic:jar:1.2.3:compile (file:///Users/maki/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-core:jar:1.2.3:compile (file:///Users/maki/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.26:compile (file:///Users/maki/.m2/repository/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar)
[INFO] ImageClasspath Entry: io.projectreactor.netty:reactor-netty:jar:0.9.0.M3:compile (file:///Users/maki/.m2/repository/io/projectreactor/netty/reactor-netty/0.9.0.M3/reactor-netty-0.9.0.M3.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-http:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.38.Final/netty-codec-http-4.1.38.Final.jar)
[WARNING] jar:file:///Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.38.Final/netty-codec-http-4.1.38.Final.jar!/META-INF/native-image/io.netty/codec-http/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] ImageClasspath Entry: io.netty:netty-common:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-common/4.1.38.Final/netty-common-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-buffer:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-buffer/4.1.38.Final/netty-buffer-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-transport:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-transport/4.1.38.Final/netty-transport-4.1.38.Final.jar)
[WARNING] jar:file:///Users/maki/.m2/repository/io/netty/netty-transport/4.1.38.Final/netty-transport-4.1.38.Final.jar!/META-INF/native-image/io.netty/transport/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] ImageClasspath Entry: io.netty:netty-resolver:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-resolver/4.1.38.Final/netty-resolver-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec/4.1.38.Final/netty-codec-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-handler:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-handler/4.1.38.Final/netty-handler-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-handler-proxy:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-handler-proxy/4.1.38.Final/netty-handler-proxy-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-socks:jar:4.1.38.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-socks/4.1.38.Final/netty-codec-socks-4.1.38.Final.jar)
[INFO] ImageClasspath Entry: io.projectreactor.addons:reactor-pool:jar:0.0.1.M3:compile (file:///Users/maki/.m2/repository/io/projectreactor/addons/reactor-pool/0.0.1.M3/reactor-pool-0.0.1.M3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-databind:jar:2.9.9:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.9/jackson-databind-2.9.9.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-core:jar:2.9.9:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.9/jackson-core-2.9.9.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.9:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.9/jackson-datatype-jsr310-2.9.9.jar)
[INFO] ImageClasspath Entry: am.ik.yavi:yavi:jar:0.2.2:compile (file:///Users/maki/.m2/repository/am/ik/yavi/yavi/0.2.2/yavi-0.2.2.jar)
[INFO] ImageClasspath Entry: com.example:demo-fluxfn:jar:1.0.0-SNAPSHOT (file:///private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar)
[INFO] Executing: /Users/maki/.sdkman/candidates/java/19.2.0-grl/jre/bin/native-image -cp /Users/maki/.m2/repository/org/springframework/spring-context/5.2.0.RC1/spring-context-5.2.0.RC1.jar:/Users/maki/.m2/repository/org/springframework/spring-aop/5.2.0.RC1/spring-aop-5.2.0.RC1.jar:/Users/maki/.m2/repository/org/springframework/spring-beans/5.2.0.RC1/spring-beans-5.2.0.RC1.jar:/Users/maki/.m2/repository/org/springframework/spring-core/5.2.0.RC1/spring-core-5.2.0.RC1.jar:/Users/maki/.m2/repository/org/springframework/spring-jcl/5.2.0.RC1/spring-jcl-5.2.0.RC1.jar:/Users/maki/.m2/repository/org/springframework/spring-expression/5.2.0.RC1/spring-expression-5.2.0.RC1.jar:/Users/maki/.m2/repository/org/springframework/spring-webflux/5.2.0.RC1/spring-webflux-5.2.0.RC1.jar:/Users/maki/.m2/repository/io/projectreactor/reactor-core/3.3.0.M3/reactor-core-3.3.0.M3.jar:/Users/maki/.m2/repository/org/reactivestreams/reactive-streams/1.0.2/reactive-streams-1.0.2.jar:/Users/maki/.m2/repository/org/springframework/spring-web/5.2.0.RC1/spring-web-5.2.0.RC1.jar:/Users/maki/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/maki/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/maki/.m2/repository/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar:/Users/maki/.m2/repository/io/projectreactor/netty/reactor-netty/0.9.0.M3/reactor-netty-0.9.0.M3.jar:/Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.38.Final/netty-codec-http-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-common/4.1.38.Final/netty-common-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-buffer/4.1.38.Final/netty-buffer-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-transport/4.1.38.Final/netty-transport-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-resolver/4.1.38.Final/netty-resolver-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec/4.1.38.Final/netty-codec-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-handler/4.1.38.Final/netty-handler-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-handler-proxy/4.1.38.Final/netty-handler-proxy-4.1.38.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec-socks/4.1.38.Final/netty-codec-socks-4.1.38.Final.jar:/Users/maki/.m2/repository/io/projectreactor/addons/reactor-pool/0.0.1.M3/reactor-pool-0.0.1.M3.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.9/jackson-databind-2.9.9.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.9/jackson-core-2.9.9.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.9/jackson-datatype-jsr310-2.9.9.jar:/Users/maki/.m2/repository/am/ik/yavi/yavi/0.2.2/yavi-0.2.2.jar:/private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar -H:Class=com.example.App -H:Name=demo-fluxfn
Build on Server(pid: 81439, port: 49961)
[demo-fluxfn:81439]    classlist:   4,522.45 ms
[demo-fluxfn:81439]        (cap):   1,229.01 ms
[demo-fluxfn:81439]        setup:   1,651.86 ms
[demo-fluxfn:81439]   (typeflow):  10,584.82 ms
[demo-fluxfn:81439]    (objects):   9,919.39 ms
[demo-fluxfn:81439]   (features):     599.15 ms
[demo-fluxfn:81439]     analysis:  21,764.91 ms
[demo-fluxfn:81439]     (clinit):     511.80 ms
[demo-fluxfn:81439]     universe:   1,024.54 ms
[demo-fluxfn:81439]      (parse):     854.77 ms
[demo-fluxfn:81439]     (inline):   2,444.39 ms
[demo-fluxfn:81439]    (compile):   9,334.19 ms
[demo-fluxfn:81439]      compile:  13,607.36 ms
[demo-fluxfn:81439]        image:   1,593.04 ms
[demo-fluxfn:81439]        write:     618.72 ms
[demo-fluxfn:81439]      [total]:  44,871.09 ms
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 49.578 s
[INFO] Finished at: 2019-09-04T16:11:07+09:00
[INFO] Final Memory: 33M/312M
[INFO] ------------------------------------------------------------------------

$ ./target/classes/demo-fluxfn 
2019-09-04 16:11:39.974  INFO --- [           main] com.example.App                          : Started in 0.004 seconds
```

```
$ curl localhost:8080 -w '\n'
Hello World!

$ curl localhost:8080/messages -d '{"text":"Hello"}' -H "Content-Type: application/json" -w "\n"
{"text":"Hello"}

$ curl localhost:8080/messages -w "\n"
[{"text":"Hello"}]
```

you can also build for Linux with docker as follows:

```
chmod +x mvnw
docker run --rm \
           -v "$PWD":/usr/src \
           -v "$HOME/.m2":/root/.m2 \
           -w /usr/src \
           oracle/graalvm-ce:19.2.0 \
           ./mvnw clean package -Pgraal
```

#### Deploy to Cloud Foundry

Build a image for Linux with Docker

```
chmod +x mvnw
docker run --rm \
           -v "$PWD":/usr/src \
           -v "$HOME/.m2":/root/.m2 \
           -w /usr/src \
           oracle/graalvm-ce:19.2.0 \
           ./mvnw package -Pgraal
```

and `cf push`

```
mkdir -p build
cp target/classes/demo-fluxfn ./build/
cf push demo-fluxfn --random-route -m 128m -b binary_buildpack -p ./build -c './demo-fluxfn'
```

```
Pushing app demo-fluxfn to org myorg / space development as maki@example.com...
Getting app info...
Creating app with these attributes...
+ name:         demo-fluxfn
  path:         /private/tmp/demo-fluxfn/build
  buildpacks:
+   binary_buildpack
+ command:      ./demo-fluxfn
+ memory:       128M
  routes:
+   demo-fluxfn-cheerful-chimpanzee.cfapps.io

Creating app demo-fluxfn...
Mapping routes...
Comparing local files to remote cache...
All files found in remote cache; nothing to upload.
Waiting for API to complete processing files...

Staging app and tracing logs...
   Downloading binary_buildpack...
   Downloaded binary_buildpack
   Cell 78d73e58-9a73-4317-bb61-c56223af688b creating container for instance 473b0faf-bdf8-4765-ac70-f31f8ab27db7
   Cell 78d73e58-9a73-4317-bb61-c56223af688b successfully created container for instance 473b0faf-bdf8-4765-ac70-f31f8ab27db7
   Downloading app package...
   Downloaded app package (7.7M)
   -----> Binary Buildpack version 1.0.33
   Exit status 0
   Uploading droplet, build artifacts cache...
   Uploading droplet...
   Uploading build artifacts cache...
   Uploaded build artifacts cache (215B)
   Uploaded droplet (7.7M)
   Uploading complete
   Cell 78d73e58-9a73-4317-bb61-c56223af688b stopping instance 473b0faf-bdf8-4765-ac70-f31f8ab27db7
   Cell 78d73e58-9a73-4317-bb61-c56223af688b destroying container for instance 473b0faf-bdf8-4765-ac70-f31f8ab27db7
   Cell 78d73e58-9a73-4317-bb61-c56223af688b successfully destroyed container for instance 473b0faf-bdf8-4765-ac70-f31f8ab27db7

Waiting for app to start...

name:              demo-fluxfn
requested state:   started
routes:            demo-fluxfn-cheerful-chimpanzee.cfapps.io
last uploaded:     Wed 04 Sep 16:31:12 JST 2019
stack:             cflinuxfs3
buildpacks:        binary

type:            web
instances:       1/1
memory usage:    128M
start command:   ./demo-fluxfn
     state     since                  cpu    memory      disk      details
#0   running   2019-09-04T07:31:26Z   0.0%   0 of 128M   0 of 1G   
```

## License

Licensed under the Apache License, Version 2.0.
