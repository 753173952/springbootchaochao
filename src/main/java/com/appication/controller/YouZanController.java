package com.appication.controller;

import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanShopGet;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanShopGetParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanShopGetResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YouZanController {

    @RequestMapping("shop/get")
    @ResponseBody
    public YouzanShopGetResult shopGet() {
        YZClient client = new DefaultYZClient(new Token("token")); //new Sign(appKey, appSecret)
        YouzanShopGetParams youzanShopGetParams = new YouzanShopGetParams();


        YouzanShopGet youzanShopGet = new YouzanShopGet();
        youzanShopGet.setAPIParams(youzanShopGetParams);
        YouzanShopGetResult result = client.invoke(youzanShopGet);
        return result;
    }

}
