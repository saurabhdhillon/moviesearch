package simplifii.framework.asyncmanager;

import android.content.Context;

import simplifii.framework.utility.AppConstants;


public class ServiceFactory {

    public static Service getInstance(Context context, int taskCode) {
        Service service = null;
        switch (taskCode) {
            default:
                service = new OKHttpService();
                break;

        }
        return service;
    }

}
