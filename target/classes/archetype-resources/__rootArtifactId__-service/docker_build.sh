#set ($rootArtifactId = "${rootArtifactId}")
#!/bin/sh
serviceName="${rootArtifactId}-service"
serviceVersion="1.0.0-SNAPSHOT-R1"
tarName="${rootArtifactId}-service-R1.tar"
path=$(pwd)
cd .. && mvn -Dmaven.test.skip=true -U clean install
cd $path
docker build -t docker.nb.bluetron.cn/bluetron/$serviceName:$serviceVersion .
docker save -o $tarName docker.nb.bluetron.cn/bluetron/$serviceName:$serviceVersion
echo "finish..."
read a