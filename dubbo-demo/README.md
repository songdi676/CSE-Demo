# dubbo服务使用Mesher接入改造

## Mesher涉及的配置文件
### Provider Mesher
* auth.yaml

```yaml
cse.credentials.accessKey: AJADUZGY3IFKSQPEPB8Q
cse.credentials.secretKey: JUggo6jdtKqJ4fCaznLw043ideXRQV8Hoa5nsHTq
```

* mesher\conf\chassis.yaml

```yaml
cse:
  service:
    registry:
      address: @{SERVICE_CENTER} # uri of service center
     # address: https://cse.cn-north-1.myhwclouds.com:443 # uri of service center
      scope: full #set full to be able to discover other app's service
      watch: false # set if you want to watch instance change event
      autoIPIndex: true # set to true if u want to resolve source IP to microservice
  protocols:
    http:
      listenAddress: @{ADDR}:30101
      ## how to let other service discover this service, it is internalIP:serverPort
      #advertiseAddress: 127.0.0.1:30101
    dubbo:
      listenAddress: @{ADDR}:30201
    dubboSimpleRegistry:
      listenAddress: @{ADDR}:30202
```

* mesher\conf\monitoring.yaml

```yaml
cse:
  monitor: #Send monitoring data to CSE monitor Server
    client:
       serverUri: @{SERVICE_CENTER}
```

* AK
### Consumer Mesher
* auth.yaml

```yaml
cse.credentials.accessKey: AJADUZGY3IFKSQPEPB8Q
cse.credentials.secretKey: JUggo6jdtKqJ4fCaznLw043ideXRQV8Hoa5nsHTq
```
* mesher\conf\chassis.yaml

```yaml
cse:
  service:
    registry:
      address: @{SERVICE_CENTER} # uri of service center
     # address: https://cse.cn-north-1.myhwclouds.com:443 # uri of service center
      scope: full #set full to be able to discover other app's service
      watch: false # set if you want to watch instance change event
      autoIPIndex: true # set to true if u want to resolve source IP to microservice
  protocols:
    http:
      listenAddress: @{ADDR}:40101
      ## how to let other service discover this service, it is internalIP:serverPort
      #advertiseAddress: 127.0.0.1:30101
    dubbo:
      listenAddress: @{ADDR}:40201
    dubboSimpleRegistry:
      listenAddress: @{ADDR}:40202

```

### Dubbo Provider 
* dubbo.properties

```
dubbo.container=log4j,spring
dubbo.application.name=demo-provider
dubbo.application.owner=abc
#dubbo.registry.address=multicast://224.5.6.7:1234
#dubbo.registry.address=redis://127.0.0.1:6379
#dubbo.registry.address=dubbo://127.0.0.1:9090
#dubbo.registry.address=dubbo://10.57.75.87:30202
#dubbo.registry.address=zookeeper://10.21.215.103:2181
dubbo.registry.address=dubbo://@{ADDR}:30202
dubbo.monitor.protocol=registry
dubbo.protocol.name=dubbo
dubbo.protocol.port=3333
dubbo.protocol.host=@{ADDR}
dubbo.service.loadbalance=roundrobin
dubbo.log4j.file=logs/dubbo-demo-provider.log
dubbo.log4j.level=WARN
```

### Dubbo Consumer 
* dubbo.properties
* 
```
dubbo.container=log4j,spring
dubbo.application.name=demo-consumer
dubbo.application.owner=
#dubbo.registry.address=multicast://224.5.6.7:1234
#dubbo.registry.address=zookeeper://127.0.0.1:2181
#dubbo.registry.address=redis://127.0.0.1:6379
#dubbo.registry.address=dubbo://10.57.75.87:30202
#dubbo.registry.address=zookeeper://10.21.215.103:2181
dubbo.monitor.protocol=registry
dubbo.log4j.file=logs/dubbo-demo-consumer.log
dubbo.log4j.level=WARN
dubbo.reference.url=dubbo://@{ADDR}:40201
```
