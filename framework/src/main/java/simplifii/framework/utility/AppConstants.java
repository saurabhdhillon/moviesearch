
package simplifii.framework.utility;

import java.util.LinkedHashMap;

public interface AppConstants {

    String DEF_REGULAR_FONT = "OpenSans-Regular.ttf";
    String APP_LINK = "https://drive.google.com/file/d/0B8wKJnD6sONHeXlUbm5pOTk4dGM/view?usp=sharing";
    LinkedHashMap<Integer, String> storeCategory = new LinkedHashMap<Integer, String>();
    String REGISTRATION_COMPLETE = "registrationComplete";
    int REQUESTCODE_GOOGLE_SIGHN_IN = 101;

    interface ASSETS_RESOURCES {
        String JSON_FOLDER = "jsons";
        String TUTOR_PROFILE_STRUCTURE = JSON_FOLDER + "/tutor_profile_structure.json";
    }

    interface REQUEST_CODES {

        int GOOGLE_SIGHN_IN = 10;
        int REGISTER = 11;
        int UPDATE_PROFILE = 12;
        int CONFIRM_STATUS = 13;
        int STATUS_UPDATE = 14;
        int BALANCE_ADD = 15;
        int CHANGE_STATUS = 16;
        int REQ_PICK_IMAGE = 17;
        int ADD_MONEY = 18;
        int ADD_MONEY_FOR_LEAD = 19;
    }

    public static interface VALIDATIONS {
        String EMPTY = "empty";
        String EMAIL = "email";
        String MOBILE = "mobile";
    }

    public static interface PARAMS {
        String LAT = "latitude";
        String LNG = "longitude";
    }


    public static interface ERROR_CODES {

        public static final int UNKNOWN_ERROR = 0;
        public static final int NO_INTERNET_ERROR = 1;
        public static final int NETWORK_SLOW_ERROR = 2;
        public static final int URL_INVALID = 3;
        public static final int DEVELOPMENT_ERROR = 4;

    }

    public static interface PAGE_URL {
        String BASEURL = "http://chqbook.com/agent/api/v1/";
        String SIGNUP = BASEURL + "agent/signup";
        String LOGIN = BASEURL + "agent/login";
        String INITDATA = BASEURL + "init";
        String EDITPROFILE = BASEURL + "agent/profile/edit";
        String SENDOTP = BASEURL + "agent/password/otp";
        String CHANGEPASS = BASEURL + "agent/password/change";
        String UPLOAD_PAN_CARD = BASEURL + "agent/pancard/edit";
        String LOGOUT = BASEURL + "agent/logout";
        String GET_USER = BASEURL + "api/users/";
        String UPDATE_PROFILE_PIC = BASEURL + "agent/profilepicture/edit";
        String GET_AVAILABLE_LEADS = BASEURL + "agent/leads/available";
        String GET_CURRENT_LEADS = BASEURL + "agent/leads/current";
        String PURCHASE_LEAD = BASEURL + "agent/lead/purchase";
    }

    public static interface PREF_KEYS {

        String KEY_LOGIN = "IsUserLoggedIn";
        String KEY_USERNAME = "username";
        String KEY_EMAIL = "email";
        String KEY_PASSWORD = "password";
        String ACCESS_CODE = "access";
        String APP_LINK = "appLink";
        String USER_TOKEN = "user_token";
        String IS_LOGIN = "is_login";
        String IS_FIRST = "is_first";
        String PHONE_NO = "phoneno";
        String SOURCE = "source";
        String USER_TYPE = "userType";
        String USER_ID = "userId";
        String INITDATA = "initData";
        String USERPROFILE = "userProfile";
        String FCM_KEY = "fcm_key";
        String PUSH_NOTIFICATION = "pushNotification";
    }

    public static interface BUNDLE_KEYS {
        public static final String KEY_SERIALIZABLE_OBJECT = "KEY_SERIALIZABLE_OBJECT";
        public static final String FRAGMENT_TYPE = "FRAGMENT_TYPE";
        String EXTRA_BUNDLE = "bundle";
        String SOCIALSIGNUP = "isSocialSignUp";
        String FORGOTOBJECT = "forgotPass";
        String PHONE = "phone";
        String TITLE = "title";
        String LEAD_ID = "leadId";
        String LEAD = "lead";
        String STATUS = "status";
        String INSTITUTION = "institution";
        String KEY_URL = "keyUrl";
        String KEY_RESPONSE = "keyResponseUrl";
        String LEAD_PRICE = "leadPrice";
        String NOTIFICATION_BODY = "notificationBody";
        String NOTIFICATION_DATA = "notificationData";
        String NEXT_STAGE_TIME = "nextstagetime";
        String FROM_WALLET_FRAGMENT = "fromWalletFragment";
        String FROM_AVAILABLE_FRAGMENT = "fromAvailableFragment";
    }


    public static interface VIEW_TYPE {
        int CARD_MY_TEAM = 0;
        int GET_IMAGE = 1;
        int GET_AUDIO = 2;
        int GET_PDF = 3;
        int GET_VIDEO = 4;
        int GET_HEADER = 5;
    }

    public static interface MEDIA_TYPES {
        String IMAGE = "img";
        String AUDIO = "audio";
        String VIDEO = "video";
        String PDF = "pdf";
    }

    public interface TASKCODES {
        int SEARCH_MOVIE = 1;
    }

    interface ProfileStructureType {
        int PERSONAL_DETAILS = 1;
        int LOCATION = 2;
        int TUTION_DETAILS = 3;
        int QUALIFICATION = 4;
        int SOCIAL_PROFILES = 5;
        int CONTENT = 6;
        int REVIEWS = 7;
    }

    public interface IMAGE_CODE {
        int IMAGE = 21;
    }

    public interface FILE_TYPES {

        String IMAGE = "image";
        String AUDIO = "audio";
        String VIDEO = "video";
        String PDF = "pdf";
    }

    public interface FILE_REQUEST_CODE {
        int IMAGE = 13;
        int AUDIO = 14;
        int VIDEO = 15;
        int PDF = 16;
    }

    public interface CLICK_ID {
        int AVAILABLE = 1;
        int MYAPPS = 2;
        int COMPLETED = 3;
        int CALENDAR = 4;
        int WALLET = 5;
        int NOTIFICATION = 6;
        int PROFIL = 7;
        int CHANGEPASSWORD = 8;
        int TERMS = 9;
        int PRIVACY = 10;
        int LOGOUT = 11;
    }
}
