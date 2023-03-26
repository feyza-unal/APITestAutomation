package testDatalari;

import org.json.JSONObject;

public class TestDataJsonPlaceholder {
    public static int basariliSorguStatusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String headerConnection = "keep-alive";
    public static JSONObject responseBodyOlustur22(){
        JSONObject exptectedData = new JSONObject();
        exptectedData.put("userId",3);
        exptectedData.put("id",22);
        exptectedData.put("title","dolor sint quo a velit explicabo quia nam");
        exptectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return exptectedData;
    }

    public static  JSONObject JsonBodyOlustur(int userId,int id,String title,String body){
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body",body);
        return expectedData;
    }
}

