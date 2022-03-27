package com.zql.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/16 - 12 - 16 - 16:25
 * @Description: com.zql.pay.config
 * @version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "alipay")
@Data
public class AlipayAccountConfig {

    private String appId;

   private String privateKey;

   private String aliPayPublicKey;

   private String notifyUrl;

   private String returnUrl;
}
