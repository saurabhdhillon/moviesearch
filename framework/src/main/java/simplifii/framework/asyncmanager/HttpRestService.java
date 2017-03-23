package simplifii.framework.asyncmanager;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import simplifii.framework.Network.ClientURLConnection;
import simplifii.framework.exceptionhandler.RestException;
import simplifii.framework.utility.Logger;

public class HttpRestService extends GenericService {

    private static final String TAG = "RestService";

    public HttpRestService() {
    }

    ;

    @Override
    public Object getData(Object... params) throws JSONException, SQLException,
            NullPointerException, RestException, ClassCastException, IOException {
        if (params != null && params.length > 0) {
            HttpParamObject paramObject = (HttpParamObject) params[0];
            String url = paramObject.getUrl();
            HashMap<String, String> postParameters = paramObject.getPostParams();

            ClientURLConnection conn = new ClientURLConnection(url, "",
                    paramObject.getMethod());
            conn.setContentType(paramObject.getContentType());
            for (Map.Entry<String,String> pair : postParameters.entrySet()) {
                conn.addkeyValuePairToBeSend(pair.getKey(), pair.getValue());
                Logger.info(TAG, "params Key :" + pair.getKey() + ", value:" + pair.getValue());
            }

            for (Entry<String, String> entry : paramObject.getHeaders().entrySet()) {
                conn.addRequestHeader(entry.getKey(),
                        entry.getValue());
                Logger.info(TAG, "Header Key :" + entry.getKey() + ", value:" + entry.getValue());
            }
//            String authHeader = Preferences.getData(AppConstants.PREF_KEYS.ACCESS_CODE, "");
//            if (!TextUtils.isEmpty(authHeader)) {
//                authHeader = "bearer " + authHeader;
//                conn.addRequestHeader("authorization",
//                        authHeader);
//            }
            conn.addDataToSend(paramObject.getJson());


//            NetworkResponse<String> response = conn.getData();
//            if(response.getResponseCode() >=200 )
            String jsonString = conn.getData().getData();
            Logger.info(TAG, url + "..... json String" + jsonString);
            return parseJson(jsonString, paramObject);
        }
        return null;
    }

    protected Object parseJson(String jsonString, HttpParamObject postObject) {
        if (postObject.getClassType() == null) {
            return jsonString;
        }
        try {
            Class classType = postObject.getClassType();
            Method m = classType.getDeclaredMethod("parseJson", String.class);
            Object o = m.invoke(null, jsonString);

            return o;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Parse with Gson
        return new Gson().fromJson(jsonString, postObject.getClassType());

    }

}
