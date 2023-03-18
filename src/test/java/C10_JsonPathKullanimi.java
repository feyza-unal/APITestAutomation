import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {
    @Test
    public void method01() {

        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject adresJsonObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObj = new JSONObject();

        adresJsonObj.put("streetAddress", "Yenimahalle kurtulus cad");
        adresJsonObj.put("city","Ankara");
        adresJsonObj.put("postalCode","06100");

        cepTelJsonObj.put("type","Cep Telefonu");
        cepTelJsonObj.put("number", "555-123-4567");
        evTelJsonObj.put("type","Ev telefonu");
        evTelJsonObj.put("number","312-123-4567");
        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObj);

        kisiBilgileriJsonObj.put("firstName","Ahmet");
        kisiBilgileriJsonObj.put("lastName","Bulut");
        kisiBilgileriJsonObj.put("age",49);
        kisiBilgileriJsonObj.put("address",adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        //System.out.println(kisiBilgileriJsonObj);

        System.out.println("firstName:"+kisiBilgileriJsonObj.get("firstName"));

        System.out.println("cadde:"+kisiBilgileriJsonObj.getJSONObject("address").
                                                         get("streetAddress"));

        System.out.println("cep tel no:"+kisiBilgileriJsonObj.getJSONArray("phoneNumbers")
                                                             .getJSONObject(0)
                                                             .get("number"));
    }
}

/*  Bu sekilde ugrasmak yerine
jsonpath.com'da daha duzenli gorebiliriz

$ -> tum bilgileri verir
firstName -> direkta aradigimiza ulasmak icin
address.city -> adress'in icindeki city'i verir
phoneNumbers[1].number -> array ise indexini verip gideriz


  {
    "firstName": "Ahmet",
    "lastName": "Bulut",
    "address": {
      "streetAddress": "Yenimahalle kurtulus cad",
      "city": "Ankara",
      "postalCode": "06100"
    },
    "age": 49,
    "phoneNumbers": [
      {
        "number": "555-123-4567",
        "type": "Cep Telefonu"
      },
      {
        "number": "312-123-4567",
        "type": "Ev telefonu"
      }
    ]
  }

 */