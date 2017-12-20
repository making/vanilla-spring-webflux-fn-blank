# Vanilla Spring WebFlux.fn Blank

Maven archetype to create a pre-configured maven project for Vanilla Spring WebFlux.fn Application.

This app uses neither Spring Boot nor DI container (!!).

Only Router Function is used.

## Create a blank project using maven archetype


### Use Release version

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.0.1 \
 -DgroupId=com.example \
 -DartifactId=demo-fluxfn \
 -Dversion=1.0.0-SNAPSHOT
```


```
mvn clean package
java -jar demo-fluxfn-1.0.0-SNAPSHOT.jar
```

### Use Snapshot version

```
mvn archetype:generate\
 -DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots \
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=vanilla-spring-webflux-fn-blank-archetype\
 -DarchetypeVersion=0.0.1-SNAPSHOT \
 -DgroupId=com.example \
 -DartifactId=demo-fluxfn \
 -Dversion=1.0.0-SNAPSHOT
```