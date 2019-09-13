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
 -DarchetypeVersion=0.2.15
```

for SNAPSHOT version

```
mvn -U org.apache.maven.plugins:maven-archetype-plugin:2.2:generate \
 -DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots \
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.16-SNAPSHOT
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
 -DarchetypeVersion=0.2.15\
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
[INFO] Archetype repository not defined. Using the one from [am.ik.archetype:vanilla-spring-webflux-fn-blank-archetype:0.2.13] found in catalog remote
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.15/vanilla-spring-webflux-fn-blank-archetype-0.2.15.pom
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.15/vanilla-spring-webflux-fn-blank-archetype-0.2.15.pom (2.7 kB at 6.4 kB/s)
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.15/vanilla-spring-webflux-fn-blank-archetype-0.2.15.jar
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.2.15/vanilla-spring-webflux-fn-blank-archetype-0.2.15.jar (55 kB at 128 kB/s)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: vanilla-spring-webflux-fn-blank-archetype:0.2.15
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
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/native-image.properties
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/reflect-config.json
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/META-INF/native-image/com.example/demo-fluxfn/resource-config.json
[WARNING] CP Don't override file /private/tmp/demo-fluxfn/src/main/resources/logback.xml
[INFO] Project created from Archetype in dir: /private/tmp/demo-fluxfn
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.287 s
[INFO] Finished at: 2019-09-13T13:46:43+09:00
[INFO] Final Memory: 15M/222M
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
    │       │               ├── native-image.properties
    │       │               ├── reflect-config.json
    │       │               └── resource-config.json
    │       └── logback.xml
    └── test
        ├── java
        │   └── com
        │       └── example
        │           ├── HelloHandlerTest.java
        │           └── MessageHandlerTest.java
        └── resources
            └── junit-platform.properties

17 directories, 16 files
```



```
$ cd demo-fluxfn
$ chmod +x mvnw*
$ ./mvnw clean package
$ java -jar target/demo-fluxfn-1.0.0-SNAPSHOT.jar 
2019-09-13 13:48:44.989  INFO --- [           main] com.example.App                          : Started in 0.674 seconds
```

```
$ curl localhost:8080
Hello World!
```

Following libraries will be included:

```
$ mvn dependency:list | grep ':compile' | sort
[INFO]    am.ik.yavi:yavi:jar:0.2.3:compile
[INFO]    ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO]    ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO]    com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO]    com.fasterxml.jackson.core:jackson-core:jar:2.9.9:compile
[INFO]    com.fasterxml.jackson.core:jackson-databind:jar:2.9.9.3:compile
[INFO]    com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.9:compile
[INFO]    io.netty:netty-buffer:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-codec-http2:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-codec-http:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-codec-socks:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-codec:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-common:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-handler-proxy:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-handler:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-resolver:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-transport-native-epoll:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-transport-native-unix-common:jar:4.1.39.Final:compile
[INFO]    io.netty:netty-transport:jar:4.1.39.Final:compile
[INFO]    io.projectreactor.addons:reactor-pool:jar:0.1.0.RC1:compile
[INFO]    io.projectreactor.netty:reactor-netty:jar:0.9.0.RC1:compile
[INFO]    io.projectreactor:reactor-core:jar:3.3.0.RC1:compile
[INFO]    org.reactivestreams:reactive-streams:jar:1.0.3:compile
[INFO]    org.slf4j:slf4j-api:jar:1.7.28:compile
[INFO]    org.springframework:spring-aop:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-beans:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-context:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-core:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-expression:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-jcl:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-test:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-web:jar:5.2.0.RC2:compile
[INFO]    org.springframework:spring-webflux:jar:5.2.0.RC2:compile
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
$ ./mvnw clean package
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
 -DarchetypeVersion=0.2.15\
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
$ chmod +x mvnw*
$ ./mvnw clean package -DskipTests=true -Pgraal
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< com.example:demo-fluxfn >-----------------------
[INFO] Building demo-fluxfn 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ demo-fluxfn ---
[INFO] Deleting /private/tmp/demo-fluxfn/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ demo-fluxfn ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 4 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ demo-fluxfn ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 4 source files to /private/tmp/demo-fluxfn/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ demo-fluxfn ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ demo-fluxfn ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /private/tmp/demo-fluxfn/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.0:test (default-test) @ demo-fluxfn ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ demo-fluxfn ---
[INFO] Building jar: /private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- native-image-maven-plugin:19.2.0:native-image (default) @ demo-fluxfn ---
[INFO] ImageClasspath Entry: org.springframework:spring-context:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-context/5.2.0.RC2/spring-context-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-aop:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-aop/5.2.0.RC2/spring-aop-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-beans:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-beans/5.2.0.RC2/spring-beans-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-core:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-core/5.2.0.RC2/spring-core-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-jcl:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-jcl/5.2.0.RC2/spring-jcl-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-expression:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-expression/5.2.0.RC2/spring-expression-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-webflux:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-webflux/5.2.0.RC2/spring-webflux-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-web:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-web/5.2.0.RC2/spring-web-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: io.projectreactor:reactor-core:jar:3.3.0.RC1:compile (file:///Users/maki/.m2/repository/io/projectreactor/reactor-core/3.3.0.RC1/reactor-core-3.3.0.RC1.jar)
[INFO] ImageClasspath Entry: org.reactivestreams:reactive-streams:jar:1.0.3:compile (file:///Users/maki/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-classic:jar:1.2.3:compile (file:///Users/maki/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-core:jar:1.2.3:compile (file:///Users/maki/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.28:compile (file:///Users/maki/.m2/repository/org/slf4j/slf4j-api/1.7.28/slf4j-api-1.7.28.jar)
[INFO] ImageClasspath Entry: io.projectreactor.netty:reactor-netty:jar:0.9.0.RC1:compile (file:///Users/maki/.m2/repository/io/projectreactor/netty/reactor-netty/0.9.0.RC1/reactor-netty-0.9.0.RC1.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-http:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.39.Final/netty-codec-http-4.1.39.Final.jar)
[WARNING] jar:file:///Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.39.Final/netty-codec-http-4.1.39.Final.jar!/META-INF/native-image/io.netty/codec-http/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] ImageClasspath Entry: io.netty:netty-common:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-common/4.1.39.Final/netty-common-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-buffer:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-buffer/4.1.39.Final/netty-buffer-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-transport:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-transport/4.1.39.Final/netty-transport-4.1.39.Final.jar)
[WARNING] jar:file:///Users/maki/.m2/repository/io/netty/netty-transport/4.1.39.Final/netty-transport-4.1.39.Final.jar!/META-INF/native-image/io.netty/transport/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] ImageClasspath Entry: io.netty:netty-resolver:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-resolver/4.1.39.Final/netty-resolver-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec/4.1.39.Final/netty-codec-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-handler:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-handler/4.1.39.Final/netty-handler-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-handler-proxy:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-handler-proxy/4.1.39.Final/netty-handler-proxy-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-socks:jar:4.1.39.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-socks/4.1.39.Final/netty-codec-socks-4.1.39.Final.jar)
[INFO] ImageClasspath Entry: io.projectreactor.addons:reactor-pool:jar:0.1.0.RC1:compile (file:///Users/maki/.m2/repository/io/projectreactor/addons/reactor-pool/0.1.0.RC1/reactor-pool-0.1.0.RC1.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-databind:jar:2.9.9.3:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.9.3/jackson-databind-2.9.9.3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-core:jar:2.9.9:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.9/jackson-core-2.9.9.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.9:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.9/jackson-datatype-jsr310-2.9.9.jar)
[INFO] ImageClasspath Entry: am.ik.yavi:yavi:jar:0.2.3:compile (file:///Users/maki/.m2/repository/am/ik/yavi/yavi/0.2.3/yavi-0.2.3.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-test:jar:5.2.0.RC2:compile (file:///Users/maki/.m2/repository/org/springframework/spring-test/5.2.0.RC2/spring-test-5.2.0.RC2.jar)
[INFO] ImageClasspath Entry: com.github.spring-projects-experimental:spring-graal-feature:jar:0.5.0.RELEASE:compile (file:///Users/maki/.m2/repository/com/github/spring-projects-experimental/spring-graal-feature/0.5.0.RELEASE/spring-graal-feature-0.5.0.RELEASE.jar)
[INFO] ImageClasspath Entry: com.example:demo-fluxfn:jar:1.0.0-SNAPSHOT (file:///private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar)
[INFO] Executing: /Users/maki/.sdkman/candidates/java/19.2.0-grl/jre/bin/native-image -cp /Users/maki/.m2/repository/org/springframework/spring-context/5.2.0.RC2/spring-context-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-aop/5.2.0.RC2/spring-aop-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-beans/5.2.0.RC2/spring-beans-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-core/5.2.0.RC2/spring-core-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-jcl/5.2.0.RC2/spring-jcl-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-expression/5.2.0.RC2/spring-expression-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-webflux/5.2.0.RC2/spring-webflux-5.2.0.RC2.jar:/Users/maki/.m2/repository/org/springframework/spring-web/5.2.0.RC2/spring-web-5.2.0.RC2.jar:/Users/maki/.m2/repository/io/projectreactor/reactor-core/3.3.0.RC1/reactor-core-3.3.0.RC1.jar:/Users/maki/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/maki/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/maki/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/maki/.m2/repository/org/slf4j/slf4j-api/1.7.28/slf4j-api-1.7.28.jar:/Users/maki/.m2/repository/io/projectreactor/netty/reactor-netty/0.9.0.RC1/reactor-netty-0.9.0.RC1.jar:/Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.39.Final/netty-codec-http-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-common/4.1.39.Final/netty-common-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-buffer/4.1.39.Final/netty-buffer-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-transport/4.1.39.Final/netty-transport-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-resolver/4.1.39.Final/netty-resolver-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec/4.1.39.Final/netty-codec-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-handler/4.1.39.Final/netty-handler-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-handler-proxy/4.1.39.Final/netty-handler-proxy-4.1.39.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec-socks/4.1.39.Final/netty-codec-socks-4.1.39.Final.jar:/Users/maki/.m2/repository/io/projectreactor/addons/reactor-pool/0.1.0.RC1/reactor-pool-0.1.0.RC1.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.9.3/jackson-databind-2.9.9.3.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.9/jackson-core-2.9.9.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.9/jackson-datatype-jsr310-2.9.9.jar:/Users/maki/.m2/repository/am/ik/yavi/yavi/0.2.3/yavi-0.2.3.jar:/Users/maki/.m2/repository/org/springframework/spring-test/5.2.0.RC2/spring-test-5.2.0.RC2.jar:/Users/maki/.m2/repository/com/github/spring-projects-experimental/spring-graal-feature/0.5.0.RELEASE/spring-graal-feature-0.5.0.RELEASE.jar:/private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar -H:Class=com.example.App -H:Name=demo-fluxfn
Shutdown Server(pid: 43634, port: 54756)
Build on Server(pid: 68781, port: 56089)*
[demo-fluxfn:68781]    classlist:   4,504.25 ms
 ____             _               _____          _                  
/ ___| _ __  _ __(_)_ __   __ _  |  ___|__  __ _| |_ _   _ _ __ ___ 
\___ \| '_ \| '__| | '_ \ / _` | | |_ / _ \/ _` | __| | | | '__/ _ \
 ___) | |_) | |  | | | | | (_| | |  _|  __/ (_| | |_| |_| | | |  __/
|____/| .__/|_|  |_|_| |_|\__, | |_|  \___|\__,_|\__|\__,_|_|  \___|
      |_|                 |___/                                     

Remove unused config = true
[demo-fluxfn:68781]        (cap):   1,587.25 ms
DUPLICATE: com.sun.xml.internal.stream.events.XMLEventFactoryImpl
DUPLICATE: org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication$Type
DUPLICATE: org.springframework.context.annotation.Configuration
DUPLICATE: org.springframework.boot.autoconfigure.AutoConfigurationPackage
DUPLICATE: java.util.EventListener
DUPLICATE: java.lang.Class
SBG: reflection registering #321 entries
SBG: WARNING: /reflect.json included com.google.protobuf.ExtensionRegistry but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorBuilderImpl but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.annotations.common.Version but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.AutoFlushEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.condition.OnResourceCondition but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.ClearEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.DeleteEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.DirtyCheckEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.EvictEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.FlushEntityEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.FlushEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.InitializeCollectionEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.LoadEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.LockEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.MergeEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PersistEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostCollectionRecreateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostCollectionRemoveEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostCollectionUpdateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostDeleteEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostInsertEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostLoadEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PostUpdateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreCollectionRecreateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreCollectionRemoveEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreCollectionUpdateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreDeleteEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreInsertEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreLoadEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.PreUpdateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.RefreshEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.ReplicateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.ResolveNaturalIdEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.SaveOrUpdateEventListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.event.spi.EventType but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.dialect.H2Dialect but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.jboss.logging.BasicLogger but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.annotations.common.util.impl.Log_$logger but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.annotations.common.util.impl.Log but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included com.google.gson.GsonBuilder but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.aop.aspectj.AspectJAwareAdvisorAutoProxyCreator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.persistence.EntityManagerFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.jpa.HibernateEntityManagerFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.HibernateValidatorConfiguration but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.SpringBootVersion but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.validation.spi.ConfigurationState but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.validation.Configuration but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.validation.beanvalidation.LocalValidatorFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.web.reactive.ReactiveWebServerFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.web.client.RestTemplateBuilder but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationPropertiesBinder but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.condition.SearchStrategy but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.logging.java.JavaLoggingSystem but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationImportSelector but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication$Type but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication$Type but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigureOrder but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included com.fasterxml.jackson.dataformat.smile.SmileFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included com.google.protobuf.Message but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.condition.ConditionalOnResource but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.validation.Validator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationImportSelector$AutoConfigurationGroup but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationProperties but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.TypeExcludeFilter but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigureAfter but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.cache.CacheCondition but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.CommandLineRunner but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.SpringBootConfiguration but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.SpringBootApplication but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.EnableAutoConfiguration but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationPackage but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessorRegistrar but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.task.TaskExecutorBuilder but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.EnableConfigurationProperties but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.SpringApplication but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.admin.SpringApplicationAdminMXBeanRegistrar but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration$ConfigAvailableCondition but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.thymeleaf.spring5.view.reactive.ThymeleafReactiveView but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.thymeleaf.spring5.expression.Mvc$NonSpring41MvcUriComponentsBuilderDelegate but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.thymeleaf.standard.expression.AdditionExpression but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.jdbc.support.SQLErrorCodes but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.transaction.TransactionDefinition but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.transaction.annotation.Propagation but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.transaction.annotation.Transactional but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration$JCacheAvailableCondition but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.task.TaskSchedulerBuilder but it doesn't exist on the classpath, skipping...
SBG: ERROR: problem handling flag: allDeclaredMethods for org.springframework.validation.beanvalidation.MethodValidationPostProcessor because of missing javax/validation/Validator
SBG: WARNING: /reflect.json included org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationPackages$BasePackages but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.http.HttpMessageConverters but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.internal.util.logging.Messages but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.messageinterpolation.AbstractMessageInterpolator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.internal.util.logging.Log but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.condition.BeanTypeRegistry but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.h2.Driver but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.persister.entity.SingleTableEntityPersister but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.cache.spi.access.CollectionDataAccess but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.mapping.PersistentClass but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.persister.spi.PersisterCreationContext but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.cache.spi.access.NaturalIdDataAccess but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.cache.spi.access.EntityDataAccess but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.persister.entity.AbstractEntityPersister but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.persister.internal.PersisterClassResolverInitiator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.persister.spi.PersisterClassResolver but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.transaction.support.TransactionTemplate but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.UUIDGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.GUIDGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.UUIDHexGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.Assigned but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.IdentityGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.SelectGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.enhanced.SequenceStyleGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.SequenceHiLoGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.IncrementGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.ForeignGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.SequenceIdentityGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.id.enhanced.TableGenerator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included app.main.model.Foo but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.orm.jpa.DataSourceInitializedPublisher$Registrar but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.jdbc.DataSourceProperties but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.config.EnableJpaRepositories but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.orm.jpa.DataSourceInitializedPublisher but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.jpa.HibernateEntityManager but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.internal.SessionImpl but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.query.QueryLookupStrategy$Key but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.support.SimpleJpaRepository but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.core.support.TransactionalRepositoryFactoryBeanSupport but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.core.support.RepositoryFragmentsFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.core.support.PropertiesBasedNamedQueries but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationPropertiesScanRegistrar but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationPropertiesScan but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationPackages$Registrar but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationPackage but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurationPackages but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.persistence.Entity but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.persistence.GeneratedValue but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included javax.persistence.Id but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurePackages but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.AutoConfigurePackages$BasePackages but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.query.QueryByExampleExecutor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.PagingAndSortingRepository but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.CrudRepository but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.repository.Repository but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.JpaRepository but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included app.main.model.FooRepository but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.orm.jpa.SharedEntityManagerCreator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.util.JpaMetamodelCacheCleanup but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.config.JpaMetamodelMappingContextFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.orm.jpa.JpaVendorAdapter but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.internal.engine.resolver.JPATraversableResolver but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.internal.engine.resolver.TraversableResolvers but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.resourceloading.PlatformResourceBundleLocator but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.internal.xml.config.ValidationBootstrapParameters but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.validator.internal.engine.ConfigurationImpl but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer$SharedMetadataReaderFactoryBean but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.tuple.Tuplizer but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.tuple.entity.EntityTuplizer but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.tuple.entity.AbstractEntityTuplizer but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.tuple.entity.PojoEntityTuplizer but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.apache.logging.log4j.message.ReusableMessageFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.apache.logging.log4j.message.DefaultFlowMessageFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.h2.mvstore.db.MVTableEngine but it doesn't exist on the classpath, skipping...
ARRAY: java.sql.Statement
Array base type resolved as java.sql.Statement
Class of array is [Ljava.sql.Statement;
SBG: WARNING: /reflect.json included com.zaxxer.hikari.HikariDataSource but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included com.zaxxer.hikari.HikariConfig but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.internal.EntityManagerMessageLogger but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.internal.EntityManagerMessageLogger_$logger but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.internal.CoreMessageLogger but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.internal.CoreMessageLogger_$logger but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.service.jta.platform.internal.NoJtaPlatform but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.hibernate.Session but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.yaml.snakeyaml.Yaml but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.RabbitProperties but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.RabbitProperties$Cache but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.RabbitProperties$Listener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.RabbitProperties$Ssl but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.RabbitProperties$Template but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.core.Queue but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.rabbit.annotation.RabbitListener but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.rabbit.connection.ChannelProxy but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included com.rabbitmq.client.Channel but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included com.rabbitmq.client.ShutdownNotifier but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.rabbit.annotation.RabbitListenerAnnotationBeanPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.boot.autoconfigure.amqp.DirectRabbitListenerContainerFactoryConfigurer but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.rabbit.connection.CachingConnectionFactory but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.core.AnonymousQueue but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.amqp.core.AmqpAdmin but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.integration.config.IntegrationConfigurationBeanFactoryPostProcessor but it doesn't exist on the classpath, skipping...
SBG: WARNING: /reflect.json included org.springframework.integration.config.DefaultConfiguringBeanFactoryPostProcessor but it doesn't exist on the classpath, skipping...
SBG: INFO: Registering reflective access to ch.qos.logback.core.Appender
SBG: INFO: Registering reflective access to org.springframework.boot.logging.logback.LogbackLoggingSystem
SBG: ERROR: CANNOT RESOLVE org.springframework.boot.logging.logback.LogbackLoggingSystem ???
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.IdentityCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.ReplacingCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.DateConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.RelativeTimeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.LevelConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.ThreadConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.LoggerConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.MessageConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.ClassOfCallerConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.MethodOfCallerConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.LineOfCallerConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.FileOfCallerConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.MDCConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.ThrowableProxyConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.NopThrowableInformationConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.ContextNameConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.CallerDataConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.MarkerConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.PropertyConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.LineSeparatorConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BlackCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.RedCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.GreenCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.YellowCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BlueCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.MagentaCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.CyanCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.WhiteCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.GrayCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldRedCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldGreenCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldMagentaCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter
SBG: INFO: Registering reflective access to ch.qos.logback.classic.pattern.LocalSequenceNumberConverter
SBG: INFO: Registering reflective access to org.springframework.boot.logging.logback.ColorConverter
SBG: ERROR: CANNOT RESOLVE org.springframework.boot.logging.logback.ColorConverter ???
SBG: INFO: Registering reflective access to org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter
SBG: ERROR: CANNOT RESOLVE org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter ???
SBG: INFO: Registering reflective access to org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter
SBG: ERROR: CANNOT RESOLVE org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter ???
SBG: Proxy registration: #22 proxies
- [org.springframework.boot.context.properties.ConfigurationProperties, org.springframework.core.annotation.SynthesizedAnnotation]
Skipping dynamic proxy registration due to missing type: org.springframework.boot.context.properties.ConfigurationProperties
- [org.springframework.stereotype.Component]
- [org.springframework.beans.factory.annotation.Qualifier]
- [org.springframework.boot.context.properties.ConfigurationProperties]
Skipping dynamic proxy registration due to missing type: org.springframework.boot.context.properties.ConfigurationProperties
- [org.springframework.context.annotation.Lazy]
- [org.springframework.web.bind.annotation.RequestMapping]
- [org.springframework.web.bind.annotation.ResponseStatus]
- [org.springframework.web.bind.annotation.RequestBody]
- [org.springframework.web.bind.annotation.ResponseBody]
- [javax.validation.Validator, org.springframework.aop.SpringProxy, org.springframework.aop.framework.Advised, org.springframework.core.DecoratingProxy]
Skipping dynamic proxy registration due to missing type: javax.validation.Validator
- [org.hibernate.jpa.HibernateEntityManagerFactory, org.springframework.orm.jpa.EntityManagerFactoryInfo]
Skipping dynamic proxy registration due to missing type: org.hibernate.jpa.HibernateEntityManagerFactory
- [org.hibernate.jpa.HibernateEntityManagerFactory, org.springframework.orm.jpa.EntityManagerFactoryInfo, javax.persistence.EntityManagerFactory]
Skipping dynamic proxy registration due to missing type: org.hibernate.jpa.HibernateEntityManagerFactory
- [javax.persistence.Id]
Skipping dynamic proxy registration due to missing type: javax.persistence.Id
- [javax.persistence.GeneratedValue]
Skipping dynamic proxy registration due to missing type: javax.persistence.GeneratedValue
- [javax.persistence.Transient]
Skipping dynamic proxy registration due to missing type: javax.persistence.Transient
- [org.springframework.data.jpa.repository.support.CrudMethodMetadata, org.springframework.aop.SpringProxy, org.springframework.aop.framework.Advised, org.springframework.core.DecoratingProxy]
Skipping dynamic proxy registration due to missing type: org.springframework.data.jpa.repository.support.CrudMethodMetadata
- [org.hibernate.jpa.HibernateEntityManager, org.springframework.orm.jpa.EntityManagerProxy]
Skipping dynamic proxy registration due to missing type: org.hibernate.jpa.HibernateEntityManager
- [org.springframework.web.bind.annotation.RequestParam]
- [org.springframework.boot.CommandLineRunner, app.main.Finder, org.springframework.aop.SpringProxy, org.springframework.aop.framework.Advised, org.springframework.core.DecoratingProxy]
Skipping dynamic proxy registration due to missing type: org.springframework.boot.CommandLineRunner
- [app.main.model.FooRepository, org.springframework.aop.SpringProxy, org.springframework.aop.framework.Advised, org.springframework.core.DecoratingProxy]
Skipping dynamic proxy registration due to missing type: app.main.model.FooRepository
- [org.springframework.amqp.rabbit.annotation.RabbitListener]
Skipping dynamic proxy registration due to missing type: org.springframework.amqp.rabbit.annotation.RabbitListener
- [org.springframework.amqp.rabbit.connection.ChannelProxy]
Skipping dynamic proxy registration due to missing type: org.springframework.amqp.rabbit.connection.ChannelProxy
[demo-fluxfn:68781]        setup:   3,467.99 ms
SBG: adding resources - #50 patterns
Processing META-INF/spring.factories files...
SBG: INFO: Registering reflective access to org.springframework.test.context.web.socket.MockServerContainerContextCustomizerFactory
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.web.socket.MockServerContainerContextCustomizerFactory
SBG: INFO: Registering reflective access to org.springframework.test.context.web.ServletTestExecutionListener
SBG: ERROR: problem handling flag: allDeclaredConstructors for org.springframework.test.context.web.ServletTestExecutionListener because of missing javax/servlet/ServletContext
SBG: ERROR: problem handling flag: allDeclaredMethods for org.springframework.test.context.web.ServletTestExecutionListener because of missing javax/servlet/ServletContext
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.web.ServletTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.test.context.support.DependencyInjectionTestExecutionListener
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.support.DependencyInjectionTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.test.context.support.DirtiesContextTestExecutionListener
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.support.DirtiesContextTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.test.context.transaction.TransactionalTestExecutionListener
SBG: ERROR: problem handling flag: allDeclaredConstructors for org.springframework.test.context.transaction.TransactionalTestExecutionListener because of missing org/springframework/transaction/interceptor/TransactionAttributeSource
SBG: ERROR: problem handling flag: allDeclaredMethods for org.springframework.test.context.transaction.TransactionalTestExecutionListener because of missing org/springframework/transaction/interceptor/TransactionAttributeSource
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.transaction.TransactionalTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener
SBG: ERROR: problem handling flag: allDeclaredConstructors for org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener because of missing org/springframework/transaction/interceptor/TransactionAttribute
SBG: ERROR: problem handling flag: allDeclaredMethods for org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener because of missing org/springframework/transaction/interceptor/TransactionAttribute
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.test.context.event.EventPublishingTestExecutionListener
NEEDS ADDING TO RESOURCE LIST? org.springframework.test.context.event.EventPublishingTestExecutionListener
SBG: INFO: Registering reflective access to org.springframework.beans.ExtendedBeanInfoFactory
NEEDS ADDING TO RESOURCE LIST? org.springframework.beans.ExtendedBeanInfoFactory
Found no META-INF/spring.components -> generating one...
Computed spring.components is 
vvv
-- listing properties --
^^^
>>> {}
BAOS: #
#Fri Sep 13 13:52:05 JST 2019

SBG: forcing explicit class initialization at build or runtime:
InitializationDescriptor #124 buildtime-classes   #32 buildtime-packages   #5 runtime-classes    #1 runtime-packages

Registering these packages for buildtime initialization: 
[reactor.netty.resources, reactor.netty, reactor.netty.channel, reactor.netty.http, reactor.netty.http.client, reactor.netty.http.server, reactor.netty.http.websocket, reactor.netty.resources, reactor.netty.tcp, reactor.netty.udp, reactor.util, org.apache.logging.log4j, org.apache.logging.slf4j, org.jboss.logging, org.hibernate.validator.internal.metadata.provider, org.hibernate.validator.internal.metadata.aggregated, org.hibernate.validator.internal.metadata.raw, org.hibernate.validator.internal.engine, ch.qos.logback.classic.spi, javax.validation, org.hibernate.validator.constraints, org.hibernate.validator.internal.engine.groups, org.hibernate.validator.internal.engine.valueextraction, org.hibernate.validator.internal.util, org.hibernate.validator.internal.cfg.context, org.hibernate.validator.internal.metadata.core, org.hibernate.validator.internal.metadata.aggregated.rule, org.hibernate.validator.internal.engine.constraintvalidation, org.hibernate.validator.internal.util.logging.LoggerFactory, ch.qos.logback.core, ch.qos.logback.classic, ch.qos.logback.classic.util]
Registering these packages for runtime initialization: 
[io.netty.handler.codec.http2]
WARNING: Could not register reflection metadata for org.springframework.test.context.web.ServletTestExecutionListener. Reason: java.lang.NoClassDefFoundError: javax/servlet/ServletContext.
WARNING: Could not register reflection metadata for org.springframework.validation.beanvalidation.MethodValidationPostProcessor. Reason: java.lang.NoClassDefFoundError: Ljavax/validation/Validator;.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttribute.
WARNING: Could not register reflection metadata for org.springframework.test.context.transaction.TransactionalTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttributeSource.
Warning: class initialization of class io.netty.util.internal.logging.Log4JLogger failed with exception java.lang.NoClassDefFoundError: org/apache/log4j/Priority. This class will be initialized at run time because option --allow-incomplete-classpath is used for image building. Use the option --initialize-at-run-time=io.netty.util.internal.logging.Log4JLogger to explicitly request delayed initialization of this class.
Warning: class initialization of class reactor.netty.tcp.TcpMetricsHandler failed with exception java.lang.NoClassDefFoundError: io/micrometer/core/instrument/MeterRegistry. This class will be initialized at run time because option --allow-incomplete-classpath is used for image building. Use the option --initialize-at-run-time=reactor.netty.tcp.TcpMetricsHandler to explicitly request delayed initialization of this class.
WARNING: Could not register reflection metadata for org.springframework.test.context.web.ServletTestExecutionListener. Reason: java.lang.NoClassDefFoundError: javax/servlet/ServletContext.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/springframework/aop/aspectj/autoproxy/AspectJAwareAdvisorAutoProxyCreator$PartiallyComparableAdvisorHolder.
WARNING: Could not register reflection metadata for org.springframework.test.context.transaction.TransactionalTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttributeSource.
WARNING: Could not register reflection metadata for org.springframework.validation.beanvalidation.MethodValidationPostProcessor. Reason: java.lang.NoClassDefFoundError: Ljavax/validation/Validator;.
WARNING: Could not register reflection metadata for org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttribute.
WARNING: Could not register reflection metadata for org.springframework.test.context.web.ServletTestExecutionListener. Reason: java.lang.NoClassDefFoundError: javax/servlet/ServletContext.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/springframework/aop/aspectj/autoproxy/AspectJAwareAdvisorAutoProxyCreator$PartiallyComparableAdvisorHolder.
WARNING: Could not register reflection metadata for org.springframework.test.context.transaction.TransactionalTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttributeSource.
WARNING: Could not register reflection metadata for org.springframework.validation.beanvalidation.MethodValidationPostProcessor. Reason: java.lang.NoClassDefFoundError: Ljavax/validation/Validator;.
WARNING: Could not register reflection metadata for org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttribute.
WARNING: Could not register reflection metadata for org.springframework.test.context.web.ServletTestExecutionListener. Reason: java.lang.NoClassDefFoundError: javax/servlet/ServletContext.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/springframework/aop/aspectj/autoproxy/AspectJAwareAdvisorAutoProxyCreator$PartiallyComparableAdvisorHolder.
WARNING: Could not register reflection metadata for org.springframework.test.context.transaction.TransactionalTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttributeSource.
WARNING: Could not register reflection metadata for org.springframework.validation.beanvalidation.MethodValidationPostProcessor. Reason: java.lang.NoClassDefFoundError: Ljavax/validation/Validator;.
WARNING: Could not register reflection metadata for org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener. Reason: java.lang.NoClassDefFoundError: org/springframework/transaction/interceptor/TransactionAttribute.
[demo-fluxfn:68781]   (typeflow):  28,784.24 ms
[demo-fluxfn:68781]    (objects):  15,857.04 ms
[demo-fluxfn:68781]   (features):   2,668.03 ms
[demo-fluxfn:68781]     analysis:  49,723.57 ms
[demo-fluxfn:68781]     (clinit):   1,282.33 ms
[demo-fluxfn:68781]     universe:   3,306.61 ms
[demo-fluxfn:68781]      (parse):   3,878.81 ms
[demo-fluxfn:68781]     (inline):   5,140.56 ms
[demo-fluxfn:68781]    (compile):  32,443.05 ms
[demo-fluxfn:68781]      compile:  43,943.36 ms
[demo-fluxfn:68781]        image:   3,739.10 ms
[demo-fluxfn:68781]        write:   1,274.65 ms
[demo-fluxfn:68781]      [total]: 110,291.17 ms
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:56 min
[INFO] Finished at: 2019-09-13T13:53:48+09:00
[INFO] ------------------------------------------------------------------------

$ ./target/classes/demo-fluxfn 
Sep 13, 2019 1:54:54 PM com.fasterxml.jackson.databind.ext.Java7Support <clinit>
WARNING: Unable to load JDK7 types (annotations, java.nio.file.Path): no Java7 support added
2019-09-13 13:54:54.008  INFO --- [           main] com.example.App                          : Started in 0.005 seconds
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
           ./mvnw clean package -Pgraal
```

```
docker run -p 8080:8080 --rm \
   -v ${PWD}/target/classes:/work \
   cloudfoundry/cflinuxfs3 \
   /work/demo-fluxfn
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
