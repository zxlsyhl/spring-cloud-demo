#命令规则/config/{application-name},{profile}={key}={value}

1、通过@Value不能自动刷新

2、需要通过@ConfigurationProperties(prefix = "org.zxl") 方式，能自动获取最新的配置。