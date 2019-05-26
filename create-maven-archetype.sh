#!/bin/bash

KEYWORD="DELETE THIS LINE"

rm -rf ./tmp
mkdir tmp
cp -a src pom.xml .mvn mvnw* .gitignore tmp
pushd tmp
TMP_DIR=`pwd`

sed -i.bk "s|am\.ik\.archetype|xxxxxx.yyyyyy.zzzzzz|g" pom.xml
sed -i.bk "s|vanilla-spring-webflux-fn-blank|projectName|g" pom.xml
sed -i.bk "s|github\.com/making/projectName|github.com/making/vanilla-spring-webflux-fn-blank|g" pom.xml
mv src/main/resources/META-INF/native-image/am.ik.archetype/vanilla-spring-webflux-fn-blank src/main/resources/META-INF/native-image/am.ik.archetype/projectName
mv src/main/resources/META-INF/native-image/am.ik.archetype src/main/resources/META-INF/native-image/xxxxxx.yyyyyy.zzzzzz

mvn org.apache.maven.plugins:maven-archetype-plugin:3.0.1:create-from-project

pushd target/generated-sources/archetype
sed -i.bk "/${KEYWORD}/d" target/classes/archetype-resources/pom.xml
sed -i.bk "s|xxxxxx\.yyyyyy\.zzzzzz|\${package}|g" target/classes/archetype-resources/pom.xml
sed -i.bk "s|xxxxxx\.yyyyyy\.zzzzzz|am.ik.archetype|g" pom.xml
sed -i.bk "s|projectName|vanilla-spring-webflux-fn-blank|g" pom.xml
sed -i.bk "s|<scm>|<distributionManagement><snapshotRepository><id>repo</id><url>https://oss.sonatype.org/content/repositories/snapshots</url></snapshotRepository><repository><id>repo</id><url>https://oss.sonatype.org/service/local/staging/deploy/maven2/</url></repository></distributionManagement><scm>|g" pom.xml
sed -i.bk "s|<build>|<build><plugins><plugin><groupId>org.sonatype.plugins</groupId><artifactId>nexus-staging-maven-plugin</artifactId><version>1.6.8</version><extensions>true</extensions><configuration><serverId>repo</serverId><nexusUrl>https://oss.sonatype.org/</nexusUrl><autoReleaseAfterClose>true</autoReleaseAfterClose></configuration></plugin><plugin><groupId>org.apache.maven.plugins</groupId><artifactId>maven-gpg-plugin</artifactId><version>1.6</version><executions><execution><id>sign-artifacts</id><phase>verify</phase><goals><goal>sign</goal></goals></execution></executions></plugin></plugins>|g" pom.xml
sed -i.bk '/<include>\*\*\/\*.json<\/include>/d' ./src/main/resources/META-INF/maven/archetype-metadata.xml
sed -i.bk "s|xxxxxx\.yyyyyy\.zzzzzz|\${package}|g" src/main/resources/archetype-resources/src/main/resources/META-INF/native-image/__package__/__artifactId__/app.json

sed -i.bk 's|<include>\*\*/\*.properties</include>|<include>**/*.properties</include><include>**/*.json</include>|' ./src/main/resources/META-INF/maven/archetype-metadata.xml
rm -f `find ${TMP_DIR} -name '*.bk'`
