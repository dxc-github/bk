package com.dxc.blog.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.dxc.blog.pojo.AlipayProperties;
import org.glassfish.jersey.internal.guava.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class AlipayTestController {
    private static final String serverUrl = "https://openapi.alipaydev.com/gateway.do";
    private static final String appId = "2021000117616320";
    private static final String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDJtGPPbLJ9LQXpzo3dkixHKtmDYYZy9sb8+YPc4r2vKL9Y/1b+SuyxQ2aesUIGHHxD6qkz45nMYffjGnEIXkWCsYbakEYmbGA4RpoCbpee+fThF+Ak8Jc9ngSVdhwmCuZM9zFHtt668dU+TRhTsbsCxL7XgnRFRby6cI9gRHnXR9vaNc9zGo19KeA5FFRDgNi5viR481rGwIfkmkdiXxWjRj6uCfoDjjajVAw5BMkhY7/Dw0gTsvIzYy0UmrApmhwaTTp/g6LZt35udRWdvadatSugD/bNtnGfkfMVYlMBG7mo2BnEJ6nX/yA6Ls+xGqGmDSWxmGYPUtk+qJCIDQRBAgMBAAECggEAOhUwCLMMUu98HG/Wek91YKj+Kc8ToFdfxck0J49DgAUD1OTycBezQPhfvKLemFPrlMMmJkMMLsanU0Zx9i7vZUspwhZ5nObobkwmXTzrfGQOGCN/8CM36g5u03tHb80DtHYaQsRuLvckqOQadT9g0tNFAVoXkTsbtbRkFRyi2VLcQTZqkNk0aTvfWvIrF1+iMPczBS/UwkvFGvme/yJCI/gt9wmfDQxZFa3/JGONk2BR5lxMQINBduUd5nWmh6xf72B8xrYy62TQFcZZJgetnf6VyT1EdJPpNN2AFz9SiARQ82ERFYUlvZRwfMUqD52MGd4ySyFeusWPFBAtlwF2gQKBgQD/VqGlbNsoAqNfRsHC2xapJ3wEag/wCA3NMOrg50ErttYd8X0Sm8ypa4c+BlXqbpfYHlxghKtPCvReeZRaP4M3c4fbuE1hN6a0euBU00GUJzexAlSdzV0Yj/DqqYb2F60qZg4cIHt9CNbAbcNip/SHClK8fHiZCPRt099El/+b1QKBgQDKOi7BNBnG5aGgN23xGiJuuN9tDFqL0JjNDxOlhWjGkeZ/YIfUUt++5JPESk3TbUNsRrAe1sTDCKfS5dsTpQfsMm5jkF5jCSnrH6li+ETlp3EObGwM50aamNEKT261sMy+CZJCWh6euANlGYBHGOO/WbdsqYRfzAj9I2POt08YvQKBgQDcsL/d/wwctMsH2lw2Uq5vXZUvK4zC5fMn2pPn93i4k7rU/pgfsVFfTXUDAu7XROcxAGzPb1uxYcJ8tZCnwCVllBFksxMOZ89KRroGFuGjb5IPB/iiu5EvXZnY+NWRdj1RXAvt+5VAKJeUkkpBxvDultmT1/FUNA0vr+RVoRpoUQKBgG4oy5dLPk9uf2C7URRpXCBcbLkGZbyL4PCzKcyco7qnd5wjhVpP2rot4aCnqUVm27d7uizSaVSkvmbP90r4NxyfTCrIVeI097SxBqB3BXDkiV2GCkXtJjTI0fZ/1pr6uE09AYNLfCqRqqfEAHC6SjXONXDn1sgoaS0bvh65FEkxAoGBALoriKl+V4miMcj94f8fGaEgfqBBidymWmxvntqFoZUMuXNgrQsTGWQL70/K73e3fABzCyfPVeIjk85V3p9YiWrjZRy+Cz+sTkQejkI1MG6sX69i4vJs5D/wF3Uy1NN6A5H7FItr1G/oZsGQidp/3KosDZmxAZM9Cqk93oTkeKHD";
    private static final String format="json";
    private static final String charset="utf-8";
    private static final String alipayPulicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApFjyeMvMEveQGGxCcIEVHXpk38qS2CwqESYPrTk3DSK24BC0/04JSNXPh/jXLVJw9wTn4hSsxRN5xef4AZgElGjhgiWcbq9WZjHPkrRctrnRXgSbOar++CQkz6OrRBi1uA7l86oUj1OlNIsdXdxmCVOezbgejTxyUtzXT0XFSxQiZziMLwVGvExK2A+VAAUN9pCMHZQXhDZ3olAMdpBMgfFU9J/06b7ZEjZkK3s+1z3DbLsOJA5GgtkXxzVXlPLDyvNZOBUQrzY/f4A583MrocbsskH+kpDn7ukMedjkJwG7nhYoIn5WgM9rXmn0ZaotVDUkzMhK6WY35l4lReB8IwIDAQAB";
    private static final String signType="RSA2";
    Map map1 = new HashMap<String,String>();

    //请求支付宝返回一个二维码
    @RequestMapping("alipay")
    public String alipay() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl,appId,privateKey,format,charset,alipayPulicKey,signType);
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest (); //创建API对应的request类
        request.setNotifyUrl("http://2s2y467953.51vip.biz/api/order/gohome");
        String timed = String.valueOf(System.currentTimeMillis());
        request . setBizContent ("{"+
                "\"out_trade_no\":"+timed+","+ //商户订单号
                "\"total_amount\":\"88.88\","+
                "\"subject\":\"Iphone616G\","+
                "\"store_id\":\"NJ_001\","+
                "\"timeout_express\":\"90m\"}"); //订单允许的最晚付款时间
        AlipayTradePrecreateResponse response = alipayClient.execute (request);
        System.out.print( response.getBody ());

        map1.put("20150320010101002","false");
        return "订单创建成功";
    }

    @RequestMapping("gohome")
    public String gohome(HttpServletRequest request){
        Map<String,String> params = new HashMap<>();
        //getParameterMap()一般多用于接收前台表单多参数传输的数据
        //支付宝的回调都是把信息放到request里面
        Map requestParams = request.getParameterMap();
        //keyset()是获取所有的key值，iterator()是迭代遍历
        for(Iterator iter = requestParams.keySet().iterator(); iter.hasNext();){
            String name = (String)iter.next();
             //这里把key放到数组里面
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            //这个for循环的尊用就是把上面那个String中的值都遍历一遍
            for(int i = 0 ; i <values.length;i++){
                //这个是三元运算符
                valueStr = (i == values.length -1)?valueStr + values[i]:valueStr + values[i]+",";
                }
            //把数据全部加进map集合中   name就是key  valueStr就是value
            params.put(name,valueStr);
            }
        //sign就是签名    trade_status是交易的状态
        System.out.println(params.toString());
        //非常重要,验证回调的正确性,是不是支付宝发的.并且呢还要避免重复通知.
        //这个非常重要，但是不知道这个是什么意思
        //这个是签名类型 sign参数已经帮我们删除掉了，在这里我们要把签名类型删除掉
        params.remove("sign_type");
        try {
            //这里是RSA验证签名
            // Configs.getAlipayPublicKey() 其实就是支付宝的应用公钥（记住不是支付宝的公钥，是支付宝应用公钥）
            //Configs.getSignType()也就是支付宝文本类型里面的签名类型：RSA2
            boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, alipayPulicKey,"utf-8",signType);
            //如果验证上面的boolean为true的话，我们就应该更改下订单的状态，减少下库存这些操作
            if(!alipayRSACheckedV2){
                System.out.println("非法请求,验证不通过,再恶意请求我就报警找网警了");
                return "error";
                }
            System.out.println(alipayRSACheckedV2);
            map1.put("20150320010101002","true");
            } catch (AlipayApiException e) {
                e.printStackTrace();
                System.out.println("支付宝验证回调异常");
            }
        System.out.println("11111111111111111111111111111111111111111");
        map1.get("20150320010101002");
        return "SUCESS";
    }



}
