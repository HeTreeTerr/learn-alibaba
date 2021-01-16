## dataID
CompositePropertySource 
{
    name='NACOS', 
    propertySources=
    [
        NacosPropertySource {
            name='nacos-config-client-load-dev.yml'
            }, 
        NacosPropertySource {
            name='nacos-config-client-load.yml'
            }
    ]
}

```
#  profiles:
#    active: dev
```

- 优先使用配置 applicationname-profile
- 不存在时读取 applicationname

## group
默认 DEFAULT_GROUP。

## namespace
命名空间（租户隔离）

## shared-dataids
shared-dataids 公共配置文件

```
# 共享配置文件只同步了命名空间，没有同步分组
#        shared-dataids: common.yml
        refreshable-dataids: common.yml
```

# ext-config
```
# 共享配置文件，同时支持命名空间和分组
ext-config:
          - data-id: common.yml
            group: PIGX
            refresh: true
```
        