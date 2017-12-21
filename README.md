# Vanilla Spring WebFlux.fn Blank

Maven archetype to create a pre-configured maven project for Vanilla Spring WebFlux.fn Application.

This app uses neither Spring Boot nor DI container (!!).

Only [Router Function](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/web-reactive.html#webflux-fn) is used.

## Create a blank project using maven archetype

### How to use

#### Use Release version

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.0.3
```


#### Use Snapshot version

```
mvn archetype:generate\
 -DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots \
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.0.4-SNAPSHOT
```

### Example

```
$ mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.0.3\
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
[INFO] >>> maven-archetype-plugin:2.4:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:2.4:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] --- maven-archetype-plugin:2.4:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[WARNING] Archetype not found in any catalog. Falling back to central repository (http://repo.maven.apache.org/maven2).
[WARNING] Use -DarchetypeRepository=<your repository> if archetype's repository is elsewhere.
[INFO] Downloading: http://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.0.3/vanilla-spring-webflux-fn-blank-archetype-0.0.3.jar
[INFO] Downloaded: http://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.0.3/vanilla-spring-webflux-fn-blank-archetype-0.0.3.jar (4 KB at 6.5 KB/sec)
[INFO] Downloading: http://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.0.3/vanilla-spring-webflux-fn-blank-archetype-0.0.3.pom
[INFO] Downloaded: http://repo.maven.apache.org/maven2/am/ik/archetype/vanilla-spring-webflux-fn-blank-archetype/0.0.3/vanilla-spring-webflux-fn-blank-archetype-0.0.3.pom (3 KB at 6.8 KB/sec)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: vanilla-spring-webflux-fn-blank-archetype:0.0.3
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
[INFO] project created from Archetype in dir: /private/tmp/demo-fluxfn
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 14.045 s
[INFO] Finished at: 2017-12-21T15:50:02+09:00
[INFO] Final Memory: 13M/180M
[INFO] ------------------------------------------------------------------------

$ tree demo-fluxfn
  demo-fluxfn
  ├── pom.xml
  └── src
      ├── main
      │   ├── java
      │   │   └── com
      │   │       └── example
      │   │           └── App.java
      │   └── resources
      │       └── logback.xml
      └── test
          └── java
              └── com
                  └── example
                      └── AppTest.java
  
  10 directories, 4 files
```



```
$ cd demo-fluxfn
$ mvn clean package
$ java -jar target/demo-fluxfn-1.0.0-SNAPSHOT.jar 
2017-12-21 02:51:08.503  INFO --- [ctor-http-nio-1] r.ipc.netty.tcp.BlockingNettyContext     : Started HttpServer on /0:0:0:0:0:0:0:0:8080
2017-12-21 02:51:08.507  INFO --- [           main] com.example.App                          : Started in 0.783 seconds
```

```
$ curl localhost:8080
Hello World!
```

Following libraries will be included:

```
$ mvn dependency:list | grep ':compile' | sort
[INFO]    ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO]    ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO]    com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO]    com.fasterxml.jackson.core:jackson-core:jar:2.9.2:compile
[INFO]    com.fasterxml.jackson.core:jackson-databind:jar:2.9.2:compile
[INFO]    io.netty:netty-buffer:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-codec-http:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-codec-socks:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-codec:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-common:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-handler-proxy:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-handler:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-resolver:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-transport-native-epoll:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-transport-native-unix-common:jar:4.1.17.Final:compile
[INFO]    io.netty:netty-transport:jar:4.1.17.Final:compile
[INFO]    io.projectreactor.ipc:reactor-netty:jar:0.7.2.RELEASE:compile
[INFO]    io.projectreactor:reactor-core:jar:3.1.2.RELEASE:compile
[INFO]    org.reactivestreams:reactive-streams:jar:1.0.1:compile
[INFO]    org.slf4j:slf4j-api:jar:1.7.25:compile
[INFO]    org.springframework:spring-aop:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-beans:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-context:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-core:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-expression:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-jcl:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-web:jar:5.0.2.RELEASE:compile
[INFO]    org.springframework:spring-webflux:jar:5.0.2.RELEASE:compile
```

Configure memory size as below:

```
JAVA_OPTS="-Xmx16M -Xss1M -XX:MaxMetaspaceSize=32M -XX:ReservedCodeCacheSize=32M -XX:CompressedClassSpaceSize=8M -XX:MaxDirectMemorySize=8M"
java $JAVA_OPTS -jar 
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

## License

Licensed under the Apache License, Version 2.0.