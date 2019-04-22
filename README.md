# Vanilla Spring WebFlux.fn Blank

Maven archetype to create a pre-configured maven project for Vanilla Spring WebFlux.fn Application.

This app uses neither Spring Boot nor DI container (!!).

Only [Router Function](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/web-reactive.html#webflux-fn) is used.

## Create a blank project using maven archetype

### How to use

#### Use Spring 5.1.x

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.1.4
```

#### Use Spring 5.2.x

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.2
```

### Example

```
$ mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.1.4\
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
[INFO] Archetype repository not defined. Using the one from [am.ik.archetype:vanilla-spring-webflux-fn-blank-archetype:0.1.4] found in catalog remote
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.1.4/vanilla-spring-webflux-fn-blank-archetype-0.1.4.pom
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.1.4/vanilla-spring-webflux-fn-blank-archetype-0.1.4.pom (2.7 kB at 5.9 kB/s)
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.1.4/vanilla-spring-webflux-fn-blank-archetype-0.1.4.jar
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.1.4/vanilla-spring-webflux-fn-blank-archetype-0.1.4.jar (6.0 kB at 14 kB/s)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: vanilla-spring-webflux-fn-blank-archetype:0.1.4
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
[INFO] Project created from Archetype in dir: /private/tmp/demo-fluxfn
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.617 s
[INFO] Finished at: 2018-10-04T23:25:50+09:00
[INFO] Final Memory: 15M/218M
[INFO] ------------------------------------------------------------------------

$ tree demo-fluxfn
demo-fluxfn
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
    │       └── logback.xml
    └── test
        └── java
            └── com
                └── example
                    ├── HelloHandlerTest.java
                    └── MessageHandlerTest.java

10 directories, 8 files
```



```
$ cd demo-fluxfn
$ mvn clean package
$ java -jar target/demo-fluxfn-1.0.0-SNAPSHOT.jar 
2019-04-21 22:55:31.204  INFO --- [           main] com.example.App                          : Started in 0.732 seconds
```

```
$ curl localhost:8080
Hello World!
```

Following libraries will be included:

```
$ mvn dependency:list | grep ':compile' | sort
[INFO]    am.ik.yavi:yavi:jar:0.0.23:compile
[INFO]    ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO]    ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO]    com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO]    com.fasterxml.jackson.core:jackson-core:jar:2.9.8:compile
[INFO]    com.fasterxml.jackson.core:jackson-databind:jar:2.9.8:compile
[INFO]    io.netty:netty-buffer:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-codec-http2:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-codec-http:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-codec-socks:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-codec:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-common:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-handler-proxy:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-handler:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-resolver:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-transport-native-epoll:jar:linux-x86_64:4.1.34.Final:compile
[INFO]    io.netty:netty-transport-native-unix-common:jar:4.1.34.Final:compile
[INFO]    io.netty:netty-transport:jar:4.1.34.Final:compile
[INFO]    io.projectreactor.netty:reactor-netty:jar:0.8.6.RELEASE:compile
[INFO]    io.projectreactor:reactor-core:jar:3.2.8.RELEASE:compile
[INFO]    org.reactivestreams:reactive-streams:jar:1.0.2:compile
[INFO]    org.slf4j:slf4j-api:jar:1.7.26:compile
[INFO]    org.springframework:spring-aop:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-beans:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-context:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-core:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-expression:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-jcl:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-web:jar:5.1.6.RELEASE:compile
[INFO]    org.springframework:spring-webflux:jar:5.1.6.RELEASE:compile
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
--- src/main/java/com/example/App.java	(date 1513823988000)
+++ src/main/java/com/example/App.java	(revision )
@@ -1,11 +1,15 @@
 package com.example;
 
 import org.slf4j.LoggerFactory;
+import org.springframework.context.annotation.AnnotationConfigApplicationContext;
+import org.springframework.context.support.GenericApplicationContext;
 import org.springframework.http.server.reactive.HttpHandler;
 import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
 import org.springframework.web.reactive.function.server.RouterFunction;
 import org.springframework.web.reactive.function.server.RouterFunctions;
 import org.springframework.web.reactive.function.server.ServerResponse;
+import org.springframework.web.server.WebHandler;
+import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
 import reactor.core.publisher.Flux;
 import reactor.ipc.netty.http.server.HttpServer;
 
@@ -28,7 +32,11 @@
                 .orElse(8080);
         HttpServer httpServer = HttpServer.create("0.0.0.0", port);
         httpServer.startRouterAndAwait(routes -> {
-            HttpHandler httpHandler = RouterFunctions.toHttpHandler(App.routes());
+            GenericApplicationContext context = new AnnotationConfigApplicationContext();
+            context.registerBean(WebHandler.class, () -> RouterFunctions.toWebHandler(App.routes()));
+            context.refresh();
+            context.registerShutdownHook();
+            HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(context).build();
             routes.route(x -> true, new ReactorHttpHandlerAdapter(httpHandler));
         }, context -> {
             long elapsed = System.currentTimeMillis() - begin;
```


### GraalVM support

0.2.x supports [GraalVM](https://www.graalvm.org) build.

```
$ mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.2.2\
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
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ demo-fluxfn ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 5 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ demo-fluxfn ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 4 source files to /private/tmp/demo-fluxfn/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ demo-fluxfn ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /private/tmp/demo-fluxfn/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ demo-fluxfn ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /private/tmp/demo-fluxfn/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ demo-fluxfn ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ demo-fluxfn ---
[INFO] Building jar: /private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- native-image-maven-plugin:1.0.0-rc15:native-image (default) @ demo-fluxfn ---
[INFO] ImageClasspath Entry: org.springframework:spring-context:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-context/5.2.0.M1/spring-context-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-aop:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-aop/5.2.0.M1/spring-aop-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-beans:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-beans/5.2.0.M1/spring-beans-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-core:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-core/5.2.0.M1/spring-core-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-jcl:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-jcl/5.2.0.M1/spring-jcl-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-expression:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-expression/5.2.0.M1/spring-expression-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-webflux:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-webflux/5.2.0.M1/spring-webflux-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: io.projectreactor:reactor-core:jar:3.2.8.RELEASE:compile (file:///Users/maki/.m2/repository/io/projectreactor/reactor-core/3.2.8.RELEASE/reactor-core-3.2.8.RELEASE.jar)
[INFO] ImageClasspath Entry: org.reactivestreams:reactive-streams:jar:1.0.2:compile (file:///Users/maki/.m2/repository/org/reactivestreams/reactive-streams/1.0.2/reactive-streams-1.0.2.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-web:jar:5.2.0.M1:compile (file:///Users/maki/.m2/repository/org/springframework/spring-web/5.2.0.M1/spring-web-5.2.0.M1.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-classic:jar:1.2.3:compile (file:///Users/maki/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-core:jar:1.2.3:compile (file:///Users/maki/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.26:compile (file:///Users/maki/.m2/repository/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar)
[INFO] ImageClasspath Entry: io.projectreactor.netty:reactor-netty:jar:0.8.6.RELEASE:compile (file:///Users/maki/.m2/repository/io/projectreactor/netty/reactor-netty/0.8.6.RELEASE/reactor-netty-0.8.6.RELEASE.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-http:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.34.Final/netty-codec-http-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-common:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-common/4.1.34.Final/netty-common-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-buffer:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-buffer/4.1.34.Final/netty-buffer-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-transport:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-transport/4.1.34.Final/netty-transport-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-resolver:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-resolver/4.1.34.Final/netty-resolver-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec/4.1.34.Final/netty-codec-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-http2:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-http2/4.1.34.Final/netty-codec-http2-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-handler:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-handler/4.1.34.Final/netty-handler-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-handler-proxy:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-handler-proxy/4.1.34.Final/netty-handler-proxy-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: io.netty:netty-codec-socks:jar:4.1.34.Final:compile (file:///Users/maki/.m2/repository/io/netty/netty-codec-socks/4.1.34.Final/netty-codec-socks-4.1.34.Final.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-databind:jar:2.9.8:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.8/jackson-databind-2.9.8.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-core:jar:2.9.8:compile (file:///Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.8/jackson-core-2.9.8.jar)
[INFO] ImageClasspath Entry: am.ik.yavi:yavi:jar:0.0.23:compile (file:///Users/maki/.m2/repository/am/ik/yavi/yavi/0.0.23/yavi-0.0.23.jar)
[INFO] ImageClasspath Entry: com.example:demo-fluxfn:jar:1.0.0-SNAPSHOT (file:///private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar)
[INFO] Executing: /Library/Java/JavaVirtualMachines/graalvm-ce-1.0.0-rc15/Contents/Home/jre/bin/native-image -cp /Users/maki/.m2/repository/org/springframework/spring-context/5.2.0.M1/spring-context-5.2.0.M1.jar:/Users/maki/.m2/repository/org/springframework/spring-aop/5.2.0.M1/spring-aop-5.2.0.M1.jar:/Users/maki/.m2/repository/org/springframework/spring-beans/5.2.0.M1/spring-beans-5.2.0.M1.jar:/Users/maki/.m2/repository/org/springframework/spring-core/5.2.0.M1/spring-core-5.2.0.M1.jar:/Users/maki/.m2/repository/org/springframework/spring-jcl/5.2.0.M1/spring-jcl-5.2.0.M1.jar:/Users/maki/.m2/repository/org/springframework/spring-expression/5.2.0.M1/spring-expression-5.2.0.M1.jar:/Users/maki/.m2/repository/org/springframework/spring-webflux/5.2.0.M1/spring-webflux-5.2.0.M1.jar:/Users/maki/.m2/repository/io/projectreactor/reactor-core/3.2.8.RELEASE/reactor-core-3.2.8.RELEASE.jar:/Users/maki/.m2/repository/org/reactivestreams/reactive-streams/1.0.2/reactive-streams-1.0.2.jar:/Users/maki/.m2/repository/org/springframework/spring-web/5.2.0.M1/spring-web-5.2.0.M1.jar:/Users/maki/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/maki/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/maki/.m2/repository/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar:/Users/maki/.m2/repository/io/projectreactor/netty/reactor-netty/0.8.6.RELEASE/reactor-netty-0.8.6.RELEASE.jar:/Users/maki/.m2/repository/io/netty/netty-codec-http/4.1.34.Final/netty-codec-http-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-common/4.1.34.Final/netty-common-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-buffer/4.1.34.Final/netty-buffer-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-transport/4.1.34.Final/netty-transport-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-resolver/4.1.34.Final/netty-resolver-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec/4.1.34.Final/netty-codec-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec-http2/4.1.34.Final/netty-codec-http2-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-handler/4.1.34.Final/netty-handler-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-handler-proxy/4.1.34.Final/netty-handler-proxy-4.1.34.Final.jar:/Users/maki/.m2/repository/io/netty/netty-codec-socks/4.1.34.Final/netty-codec-socks-4.1.34.Final.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.8/jackson-databind-2.9.8.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar:/Users/maki/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.8/jackson-core-2.9.8.jar:/Users/maki/.m2/repository/am/ik/yavi/yavi/0.0.23/yavi-0.0.23.jar:/private/tmp/demo-fluxfn/target/demo-fluxfn-1.0.0-SNAPSHOT.jar -H:Class=com.example.App -H:Name=demo-fluxfn
Build on Server(pid: 73537, port: 53385)
[demo-fluxfn:73537]    classlist:   4,358.50 ms
[demo-fluxfn:73537]        (cap):   1,449.27 ms
[demo-fluxfn:73537]        setup:   1,977.40 ms
Warning: RecomputeFieldValue.ArrayIndexScale automatic substitution failed. The automatic substitution registration was attempted because a call to sun.misc.Unsafe.arrayIndexScale(Class) was detected in the static initializer of io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess. Detailed failure reason(s): Could not determine the field where the value produced by the call to sun.misc.Unsafe.arrayIndexScale(Class) for the array index scale computation is stored. The call is not directly followed by a field store or by a sign extend node followed directly by a field store. 
[demo-fluxfn:73537]   (typeflow):  13,486.05 ms
[demo-fluxfn:73537]    (objects):  12,280.38 ms
[demo-fluxfn:73537]   (features):     896.06 ms
[demo-fluxfn:73537]     analysis:  27,444.93 ms
[demo-fluxfn:73537]     universe:   1,307.39 ms
[demo-fluxfn:73537]      (parse):   1,066.48 ms
[demo-fluxfn:73537]     (inline):   3,913.27 ms
[demo-fluxfn:73537]    (compile):  19,510.88 ms
[demo-fluxfn:73537]      compile:  25,933.72 ms
[demo-fluxfn:73537]        image:   3,340.46 ms
[demo-fluxfn:73537]        write:   1,059.65 ms
[demo-fluxfn:73537]      [total]:  65,524.56 ms
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:11 min
[INFO] Finished at: 2019-04-22T04:26:31+09:00
[INFO] Final Memory: 31M/255M
[INFO] ------------------------------------------------------------------------

$ ./target/classes/demo-fluxfn 
2019-04-22 04:26:42.270  INFO --- [           main] com.example.App                          : Started in 0.003 seconds
```

```
$ curl localhost:8080 -w '\n'
Hello World!

$ curl localhost:8080/messages -d '{"text":"Hello"}' -H "Content-Type: application/json" -w "\n"
{"text":"Hello"}

$ curl localhost:8080/messages -w "\n"
[{"text":"Hello"}]
```

#### Deploy to Cloud Foundry

Build a image for Linux with Docker

```
mvn -N io.takari:maven:wrapper
docker run --rm \
           -v "$PWD":/usr/src \
           -v "$HOME/.m2":/root/.m2 \
           -w /usr/src \
           oracle/graalvm-ce:1.0.0-rc15 \
           ./mvnw package -Pgraal
```

and `cf push`

```
mkdir -p build
cp target/classes/demo-fluxfn ./build/
cf push demo-fluxfn --random-route -m 200m -b binary_buildpack -p ./build -c './demo-fluxfn'
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
+ memory:       200M
  routes:
+   demo-fluxfn-generous-meerkat.cfapps.io

Creating app demo-fluxfn...
Mapping routes...
Comparing local files to remote cache...
All files found in remote cache; nothing to upload.
Waiting for API to complete processing files...

Staging app and tracing logs...
   Downloading binary_buildpack...
   Downloaded binary_buildpack
   Cell dea4506e-e72c-4aec-bd88-5926d8e5217c creating container for instance df047713-152b-46f6-a146-cb5c163652eb
   Cell dea4506e-e72c-4aec-bd88-5926d8e5217c successfully created container for instance df047713-152b-46f6-a146-cb5c163652eb
   Downloading app package...
   Downloaded app package (8.5M)
   -----> Binary Buildpack version 1.0.31
   Exit status 0
   Uploading droplet, build artifacts cache...
   Uploading build artifacts cache...
   Uploading droplet...
   Uploaded build artifacts cache (213B)
   Uploaded droplet (8.5M)
   Uploading complete
   Cell dea4506e-e72c-4aec-bd88-5926d8e5217c stopping instance df047713-152b-46f6-a146-cb5c163652eb
   Cell dea4506e-e72c-4aec-bd88-5926d8e5217c destroying container for instance df047713-152b-46f6-a146-cb5c163652eb
   Cell dea4506e-e72c-4aec-bd88-5926d8e5217c successfully destroyed container for instance df047713-152b-46f6-a146-cb5c163652eb

Waiting for app to start...

name:              demo-fluxfn
requested state:   started
routes:            demo-fluxfn-generous-meerkat.cfapps.io
last uploaded:     Tue 23 Apr 03:06:19 JST 2019
stack:             cflinuxfs3
buildpacks:        binary

type:            web
instances:       1/1
memory usage:    200M
start command:   ./demo-fluxfn
     state     since                  cpu    memory      disk      details
#0   running   2019-04-22T18:06:29Z   0.0%   0 of 200M   0 of 1G   
```

## License

Licensed under the Apache License, Version 2.0.
