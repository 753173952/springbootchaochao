package com.appication.controller;

import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.client.oauth.model.OAuthToken;
import com.youzan.open.sdk.exception.KDTException;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanLogisticsOnlineConfirm;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanLogisticsOnlineConfirmParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanLogisticsOnlineConfirmResult;
import com.youzan.open.sdk.util.http.DefaultHttpClient;
import com.youzan.open.sdk.util.http.HttpClient;
import com.youzan.open.sdk.util.json.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youzan")
public class YouZanController {

    //8839ff80f9373bedb20389ffea81267d
    @RequestMapping("/trans")
    public YouzanLogisticsOnlineConfirmResult testTrans() {
        YZClient client = new DefaultYZClient(new Token("8839ff80f9373bedb20389ffea81267d")); //new Sign(appKey, appSecret)
        YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams = new YouzanLogisticsOnlineConfirmParams();

        youzanLogisticsOnlineConfirmParams.setTid("E20181206172055079200001");
        youzanLogisticsOnlineConfirmParams.setIsNoExpress(1L);

        YouzanLogisticsOnlineConfirm youzanLogisticsOnlineConfirm = new YouzanLogisticsOnlineConfirm();
        youzanLogisticsOnlineConfirm.setAPIParams(youzanLogisticsOnlineConfirmParams);
        YouzanLogisticsOnlineConfirmResult result = client.invoke(youzanLogisticsOnlineConfirm);
        return result;
    }

    @RequestMapping("/access")
    public OAuthToken getAccessToken() {
        HttpClient httpClient = new DefaultHttpClient();
        HttpClient.Params params = HttpClient.Params.custom()

                .add("client_id", "cd5250409c60e63b76")
                .add("client_secret", "f077ecbfb500512004212a808483043f")
                .add("grant_type", "silent")
                .add("kdt_id", "42196622")
                .setContentType(ContentType.APPLICATION_FORM_URLENCODED).build();
        String resp = httpClient.post("https://open.youzan.com/oauth/token", params);
        if (StringUtils.isBlank(resp) || !resp.contains("access_token")) {
            throw new RuntimeException(resp);
        }
        return JsonUtils.toBean(resp, OAuthToken.class);
    }

    @RequestMapping("/sendGoods")
    public YouzanLogisticsOnlineConfirmResult sendGoods() throws KDTException {
        YZClient client = new DefaultYZClient(new Token("b8ce91f2de493167b2588e74142b085d")); //new Sign(appKey, appSecret)
        YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams = new YouzanLogisticsOnlineConfirmParams();
        youzanLogisticsOnlineConfirmParams.setTid("E20181211111059097000045");
        youzanLogisticsOnlineConfirmParams.setIsNoExpress(0L);
        //设置快递单号
        youzanLogisticsOnlineConfirmParams.setOutSid("123123");
        youzanLogisticsOnlineConfirmParams.setOutStype("1");
        //设置物流公司编号
        YouzanLogisticsOnlineConfirm youzanLogisticsOnlineConfirm = new YouzanLogisticsOnlineConfirm();
        youzanLogisticsOnlineConfirm.setAPIParams(youzanLogisticsOnlineConfirmParams);
        YouzanLogisticsOnlineConfirmResult result = new YouzanLogisticsOnlineConfirmResult();
        try {
            result = client.invoke(youzanLogisticsOnlineConfirm);
        } catch (Exception e) {
            return result;
        }
        System.out.println("我是catch后面的");

        return result;
    }
}
