package simplifii.framework.asyncmanager;


import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;

import simplifii.framework.exceptionhandler.RestException;

public interface Service {

    public Object getData(Object... params) throws JSONException, SQLException, NullPointerException, RestException, ClassCastException, IOException;


}
