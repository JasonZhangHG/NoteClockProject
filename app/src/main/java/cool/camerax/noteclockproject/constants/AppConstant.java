package cool.camerax.noteclockproject.constants;


public final class AppConstant {

    public static final class ActivityRequestCode {
        public static final int ACCOUNT_KIT_LOGIN = 101;
        public static final int REQUEST_ALBUM_IMG = 105;
        public static final int REQUEST_CAMERA_IMG = 106;
        public static final int SETTING_PERMISSION = 109;
        public static final int LINK_INSTRAGRAM = 119;
        public static final int LINK_INSTRAGRAM_result = 120;
        public static final int GO_TO_SETTING_PERMISSION = 121;
        public static final int GO_TO_TEXT_CHAT_ACTIVITY = 122;
        public static final int TEXT_CHAT_ACTIVITY_RESULT_CODE = 98;
        public static final int INTENT_TO_STORY_PLAY_ACTIVITY_RESULT_CODE = 123;
        public static final int REQUEST_TO_MY_STORY_LIST_BROWSE = 124;
        public static final int REQUEST_SHOT_VIDEO_BROWSE = 125;
        public static final int REQUEST_CHOOSE_COVER_ACTIVITY = 126;
        public static final int REQUEST_OTHER_PROFILE_ACTIVITY = 127;
    }

    public static final class Common {
        public static final int TEXT_CHAT_INT_TO_MAIN_ACTIVITY = 1;
        public static final int LOGOUT_TINTEN_KEY = 2;
        public static final int INVITE_EXPIRE_TIME = 60000;
        public static final int TWOP_INVITE_INTENT_MAIN_KEY = 13;
        public static final int FRIEND_REQUEST_INTENT_MAIN_KEY = 14;
        public static final int VIDEO_CALL_INTENT_MAIN_KEY = 15;
        public static final int LAUNCH_NOTICE_INTENT_MAIN_KEY = 16;
        public static final int SHOW_FRIEND_FRAGMENT_INTENT_MAIN_KEY = 17;
        public static final int LAUNCH_NOTICE_TIME_KEY = 6 * 60 * 60 * 1000;
        public static final int FROM_NOTIFICATION_KEY = 1;
        public static final int UPLOAD_CONTACTS_TIME_KEY = 48 * 60 * 60 * 1000;
        public static final int SHOT_VIDEO_FROM_DISCOVER = 1;
        public static final int SHOT_VIDEO_FROM_PLAYER = 2;
        public static final int MOVE_LEFT = 6;
        public static final int MOVE_RIGHT = 7;

        public static final class BundkeKey {
            public static final String FCM_TYPE = "type";
            public static final String DIRECT_TYPE_AFTER_LOGIN = "DIRECT_TYPE_AFTER_LOGIN";
            public static final String TWOP_INVITE_INTENT_MAIN_KEY = "TWOP_INVITE_INTENT_MAIN_KEY";
            public static final String ACCEPT_TWOP_INVITE_EVENT_KEY = "ACCEPT_TWOP_INVITE_EVENT_KEY";
            public static final String TWOP_INVITE_UID_INTENT_MAIN_KEY = "TWOP_INVITE_UID_INTENT_MAIN_KEY";
            public static final String DASHBOARD_INTENT_INVITE_FRIEND_KEY = "DASHBOARD_INTENT_INVITE_FRIEND_KEY";
            public static final String ACCEPT_TWO_P_NOTIFICATION_VIDEO_CALL_KEY = "ACCEPT_TWO_P_NOTIFICATION_VIDEO_CALL_KEY";
        }

        public static final class IntentKey {
            public static final String FROM_NOTIFICATION = "FROM_NOTIFICATION";
            public static final String FROM_NOTIFICATION_CONTENT = "FROM_NOTIFICATION_CONTENT";
        }

        public static final class LinkValue {
            public static final String BANANA_COUNT_POPUP = "monkey://banana_recap_popup&action=show";
            public static final String TREE_LIST = "monkey://tree_list&action=show";
            public static final String EDIT_PROFILE = "monkey://edit_profile&action=show";
            public static final String SHOW_DASHBOARD = "monkey://display_2pdashboard";
            public static final String SHOW_FRIEND_LIST = "monkey://chatlist";
        }
    }

    public static final class TakeScreenshotType {
        public static final int REPORT = 1;
        public static final int MONITOR = 2;
        public static final int SHARE = 3;
        public static final int RATING = 4;
        public static final int REQUEST = 5;
        public static final int UNKNOWN = 0;
    }

    public static final class constantString {
        public static final String UNITED_STATES = "United States";
        public static final String MALE = "male";
        public static final String FEMALE = "female";
        public static final String IOS = "ios";
        public static final String ANDROID = "android";
        public static final String GOOGLE_PLAY_PATH = "https://play.google.com/store/apps/details?id=cool.monkey.android";
        public static final String SIGN_OUT_LOG_OUT = "logout";
        public static final String SIGN_OUT_TOKEN_MISSED = "token_missed";
        public static final String SIGN_OUT_ACCOUNT_DELETED = "account_deleted";
        public static final String SIGN_OUT_DATABASE_ERROR = "database_error";
        public static final String STRING_CAPTURE = "capture";
        public static final String STRING_UPLOAD_FROM_ALBUM = "upload from album";
    }


    public static final class PermissionRequestCode {
        private static final int BASE_VALUE_PERMISSION = 0X0001;
        public static final int RECORD_AUDIO = BASE_VALUE_PERMISSION + 1;
        public static final int CAMERA = BASE_VALUE_PERMISSION + 2;
        public static final int WRITE_EXTERNAL_STORAGE = BASE_VALUE_PERMISSION + 3;
        public static final int READ_CONTACTS = BASE_VALUE_PERMISSION + 4;
        public static final int READ_PHONE_STATE = BASE_VALUE_PERMISSION + 5;
        public static final int ACCESS_FINE_LOCATION = BASE_VALUE_PERMISSION + 6;
    }

    public static final class HttpResponseCode {
        public static final int SUCCESS = 200;
        public static final int INVALID_TOKEN = 3;
        public static final int NOT_ENOUGH_GEM = 7;
        public static final int ALREADY_FRIEND = 19;
        public static final int PAYMENT_REPEAT_CODE = 26;
        public static final int LOG_OUT = 401;
        public static final int TWO_P_LOG_OUT = 403;
        public static final int NAME_INVALID = 400;
        public static final int FIRST_NAME_LENGCH_INVALID = 105103;
        public static final int FIRST_NAME_SPECIAL_CHAREACTERS_INVALID = 105104;
        public static final int FIRST_NAME_HAVE_SAME_CHARACTER_INVALID = 105105;
        public static final int FIRST_NAME_HAVE_BAN_CHARACTER_INVALID = 105106;
        public static final int USER_NAME_LENGCH_INVALID = 105107;
        public static final int USER_NAME_SPECIAL_CHAREACTERS_INVALID = 105108;
        public static final int USER_NAME_HAVE_BAN_CHARACTER_INVALID = 105109;
        public static final int USER_NAME_SAME_INVALID = 105110;
    }

    public static final class SharedPreferenceKey {

        public static final String TEXTMODE = "text_mode";
        public static final String EVENTMODE = "event_mode";

        public static final String FRIST_ADD_TIME = "frist_add_time";
        public static final String FRIST_ADD_FRIEND = "frist_add_friend";
        public static final String FRIST_OPEN_SOUND = "frist_open_sound";

        public static final String HAS_SHOW_RATING = "hasShowRating";
        public static final String CURRENT_UID = "current_uid";
        public static final String CURRENT_USER = "current_user";
        public static final String ACCOUNTKIT_ACTION = "Accountkit_action";//这个是判断用户是老用户还是新注册用户

        public static final String CAMERA_PERMISSION_NEVER_ASK = "CAMERA_PERMISSION_NEVER_ASK";
        public static final String HAVE_REJECT_LOCATION_PERMISSION = "HAVE_REJECT_LOCATION_PERMISSION";
        public static final String START_USER_APP_TIME = "START_USER_APP_TIME";
        public static final String APP_USER_ALL_TIME = "APP_USER_ALL_TIME";
        public static final String APP_TREE_VERSION = "APP_TREE_VERSION";
        public static final String DEEP_LINK_SOURCE = "DEEP_LINK_SOURCE";
        public static final String GENDER_OPTION = "GENDER_OPTION";
        public static final String LINK = "LINK";
        public static final String SOURCE = "SOURCE";
        public static final String HAVE_SHOW_SAFETY_UPDATE_NOTICE_DIALOG = "HAVE_SHOW_SAFETY_UPDATE_NOTICE_DIALOG";
        public static final String LANDINGPAGE_SHOW_EVENT = "LANDINGPAGE_SHOW_EVENT";
        public static final String HAVE_AVATAR = "HAVE_AVATAR";
        public static final String HAS_UPLOAD_CONTACT_LIST = "HAS_UPLOAD_CONTACT_LIST";
        public static final String USE_TWOP_API = "USE_TWOP_API";
        public static final String DASH_2P_1ST_SHOW_AUTO_UNLOCK = "DASH_2P_1ST_SHOW_AUTO_UNLOCK";
        public static final String DASH_2P_1ST_SHOW_BTN = "DASH_2P_1ST_SHOW_BTN";
        public static final String DASH_2P_1ST_SHOW_PAIR_EXIT = "DDASH_2P_1ST_SHOW_PAIR_EXIT";
        public static final String DDASH_2P_1ST_SHOW_PAIR_FAILED = "DDASH_2P_1ST_SHOW_PAIR_FAILED";
        public static final String NOTIFICATION_1ST_PAIR_CLICK = "NOTIFICATION_1ST_PAIR_CLICK";
        public static final String LOGIN_STATUS = "LOGIN_STATUS";
        public static final String LAST_TIME_LAUNCH_NOTICE_SHOW_TIME = "LAST_TIME_LAUNCH_NOTICE_SHOW_TIME";
        public static final String VIDEO_UPLOADING = "VIDEO_UPLOADING";
        public static final String HAVE_UPLOAD_VIDEO = "HAVE_UPLOAD_VIDEO";

        public static final String LAST_TIME_UPLOAD_CONTACT_LIST_TIME = "LAST_TIME_UPLOAD_CONTACT_LIST_TIME";
        public static final String SP_CONTACT_KEY = "SP_CONTACT_KEY";
        public static final String SP_UNLOCK_BOARD_FIRST_ENTER_KEY = "SP_UNLOCK_BOARD_FIRST_ENTER_KEY";
        public static final String SP_HAVE_SIGN_IN_RIREBASE_TOKEN = "SP_HAVE_SIGN_IN_RIREBASE_TOKEN";

        public static final String BADGE_NUMBER = "BadgeNumber";
        public static final String DEVICE_ID = "DEVICE_ID";
        public static final String KEYCHAIN_ID = "KEYCHAIN_ID";


        public static final String STORY_SESSION_DATA = "story_session_data";
        public static final String SHOWN_STORY_GUIDE = "SHOWN_STORY_GUIDE";

        public static final String RECEIVE_MESSAGE_SHOW_VOICE = "RECEIVE_MESSAGE_SHOW_VOICE";
        public static final String RECEIVE_MESSAGE_SHOW_VIBRATION = "RECEIVE_MESSAGE_SHOW_VIBRATION";
    }

    public static final class IntentKey {
        public static final String EXTRA_ID = "id";
        public static final String EXTRA_DATA = "data";
        public static final String EXTRA_PHONE = "phone";
        public static final String EXTRA_USERNAME = "name";
        public static final String EXTRA_USER_AVATAR = "avatar";
        public static final String EXTRA_INDEX = "index";
        public static final String EXTRA_ACTION = "action";
        public static final String EXTRA_TIMESTAMP = "timeStamp";
        public static final String EXTRA_TYPE = "type";
        public static final String EXTRA_PAGE_NUMBER = "pageNum";
        public static final String EXTRA_BOOL = "bool";
        public static final String INTENT_KEY_VIDEO_INFO = "INTENT_KEY_VIDEO_INFO";
        public static final String INTENT_KEY_VIDEO_INFO_TO_UPLOAD_ACTIVITY = "INTENT_KEY_VIDEO_INFO_TO_UPLOAD_ACTIVITY";

        public static final String INTENT_TO_TEXT_CHAT_ACTIVITY_WITH_RELATION_USER = "INTENT_TO_TEXT_CHAT_ACTIVITY_WITH_RELATION_USER";
        public static final String INTENT_TO_VIDEO_CALL_ACTIVITY_WITH_VIDEO_CALL_MESSAGE = "INTENT_TO_VIDEOC_CALL_ACTIVITY_WITH_VIDEO_CALL_MESSAGE";
        public static final String INTENT_TO_VIDEO_CALL_ACTIVITY_WITH_SOCKET_MESSAGE = "INTENT_TO_VIDEO_CALL_ACTIVITY_WITH_SOCKET_MESSAGE";
        public static final String INTENT_TO_TEXT_CHAT_ACTIVITY_WITH_USER_ID = "INTENT_TO_TEXT_CHAT_ACTIVITY_WITH_USER_ID";
        public static final String INTENT_TO_TEXT_CHAT_ACTIVITY_WITH_FRIEND_SHIP_ID = "INTENT_TO_TEXT_CHAT_ACTIVITY_WITH_FRIEND_SHIP_ID";
        public static final String INTENT_TO_MAIN_ACTIVITY_WHEN_TEXT_CHAT_FINISH = "INTENT_TO_MAIN_ACTIVITY_WHEN_TEXT_CHAT_FINISH";
        public static final String INTENT_TO_PROFILE_ACTIVITY_WITH_CURRENT_USER_INFO = "INTENT_TO_PROFILE_ACTIVITY_WITH_CURRENT_USER_INFO";
        public static final String INTENT_TO_WEBVIEW_ACTIVITY_WITH_URL = "INTENT_TO_WEBVIEW_ACTIVITY_WITH_URL";
        public static final String INTENT_TO_INSTAGRAM_WEBVIEW_ACTIVITY_WITH_URL = "INTENT_TO_INSTAGRAM_WEBVIEW_ACTIVITY_WITH_URL";
        public static final String INTENT_TO_LOGIN_ACTIVITY_WITH_INTEN_KEY = "INTENT_TO_LOGIN_ACTIVITY_WITH_INTEN_KEY";

        public static final String INTENT_VIDEO_CHAT_ACTIVITY_WITH_RELATIONUSER = "INTENT_VIDEO_CHAT_ACTIVITY_WITH_RELATIONUSER";
        public static final String IINTENT_VIDEO_CHAT_ACTIVITY_WITH_CHAT_ID = "IINTENT_VIDEO_CHAT_ACTIVITY_WITH_CHAT_ID";
        public static final String IINTENT_VIDEO_CHAT_ACTIVITY_WITH_LINK = "IINTENT_VIDEO_CHAT_ACTIVITY_WITH_LINK";
        public static final String IINTENT_VIDEO_CHAT_ACTIVITY_WITH_OPEN_TO_TOKEN = "IINTENT_VIDEO_CHAT_ACTIVITY_WITH_OPEN_TO_TOKEN";
        public static final String IINTENT_VIDEO_CHAT_ACTIVITY_WITH_OPEN_TO_BIO = "IINTENT_VIDEO_CHAT_ACTIVITY_WITH_OPEN_TO_BIO";
        public static final String IINTENT_VIDEO_CHAT_ACTIVITY_WITH_OPEN_TO_SESSION = "IINTENT_VIDEO_CHAT_ACTIVITY_WITH_OPEN_TO_SESSION";
        public static final String IINTENT_DELETE_ACCOUNT_END_ACTIVITY = "IINTENT_DELETE_ACCOUNT_END_ACTIVITY";
        public static final String IINTENT_DELETE_ACCOUNT_END_ACTIVITY_RESAON = "IINTENT_DELETE_ACCOUNT_END_ACTIVITY_RESAON";
        public static final String IINTENT_APPEAR_DELETE_ACCOUNT_ACTIVITY = "IINTENT_APPEAR_DELETE_ACCOUNT_ACTIVITY";
        public static final String INTENT_SHOT_VIDEO_ACTIVITY = "INTENT_SHOT_VIDEO_ACTIVITY";
        public static final String INTENT_CHOOSE_COVER_ACTIVITY = "INTENT_CHOOSE_COVER_ACTIVITY";
        public static final String IUSER = "IUSER";
        public static final String USER_ID = "USER_ID";
        public static final String FROM = "FROM";
        public static final String FROM_LEFT_TO_RIGHT = "FROM_LEFT_TO_RIGHT";
    }

    public static final class ReceiveMessageType {
        public static final String CHAT = "chat";
        public static final String MATCHED_USER = "matched_user";
        public static final String JSON_API_DATA = "json_api_data";
        public static final String PAUSECAMERA = "pause_camera";
        public static final String RESUMEAMERA = "resume_camera";
        public static final String LOG_OUT_RESPONSE_MESSAGE = "Unauthorized";
        public static final String ADD_FRIEND_SUCCESS = "addFriendSuccess";
        public static final String SCREENSHOTSUCCESS = "screenShotSuccess";
        public static final String VIDEO_CALL = "videocall_call";
        public static final String VIDEO_CALL_CANCEL = "videocall_cancel";
        public static final String FRIEND_SHIP_DELETED = "friendship_deleted";
        public static final String FINISH_TEXT_CHAT_ACTIVITY = "finish_text_chat_activity";
        public static final String FRIENDVIDEOCANCEL = "friend_video_cancel";
        public static final String FRIENDVIDEOCACCEPTE = "friend_video_accepte";
        public static final String CLEAN_VIDEO_CALL = "clean_video_call";
        public static final String VIDEO_CALL_TIMEOUT = "video_call_timeout";
        public static final String RELATION_SHIP_NEW = "relationship_new";
        public static final String POST_MATCH_REQUEST = "pos_match_request";
        public static final String VIDEO_CALL_POST_REQUEST = "videocall_pos_request";
        public static final String AGORA_LEAVEL_CHANNEL = "agora_leavel_channel";
        public static final String REPORTED = "reported";
        public static final String FRIEND_VIDEO_CANCEL = "friend_video_cancel";
        public static final String FRIEND_VIDEOC_ACCEPTE = "friend_video_accepte";
        public static final String UNLOCK2P = "unlock2p";
        public static final String NEW_FRIEND = "newFriend";
        public static final String FRIEND_INVITE = "friendInvite";
        public static final String FRIEND_PAIR = "friendPair";
        public static final String ACCEPT_FRIEND_PAIR = "acceptFriendPair";
        public static final String DEFAULT = "default";
    }

    public static final class MatchRateEventType {
        public static final String POUTING = "bad";
        public static final String NEUTRAL = "neutral";
        public static final String SMILING = "good";
    }

    public static final class MatchRateType {
        public static final int POUTING = -1;
        public static final int NEUTRAL = 0;
        public static final int SMILING = 1;
    }

    public static final class ActivityBundle {
        public static final String LOAD_URL = "LOAD_URL";
        public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
        public static final String TITLE_TEXT = "TITLE_TEXT";
        public static final String CHAT_MESSAGE = "CHAT_MESSAGE";
        public static final String STORE_CHANNEL = "STORE_CHANNEL";
        public static final String NOTIFICATION_LAUNCH_TO_WELCOME = "NOTIFICATION_LAUNCH_TO_WELCOME";

    }

    public static final class FCMNotificationType {
        public static final int SEND_MESSAGE_LINK_NOTIFICATION = 0;
        public static final int TWOP_DEFAULT_NOTIFICATION_TYPE = 1;
        public static final int NOTIFICATION_INCLUDE_SOURCE_TYPE = 100;

        public static final int INVITE_ACCEPTED = 12;
        public static final int INVITE_SENT = 13;
        public static final int DISMISS_TWOP_INVITE = 21;

    }

    public static final class AnalyticEvent {
        public static final String MONKEY_GENDER = "Monkey_gender";
        public static final String MONKEY_AGE = "Monkey_age";
        public static final String MONKEY_BAN = "Monkey_ban";
        public static final String MONKEY_UID = "Monkey_uid";
        public static final String MONKEY_COUNTRY = "Monkey_country";
        public static final String MONKEY_SIGNUP_DATE = "Monkey_signup_date";
        public static final String LOGIN_COMPLETION = "Login_Completion ";
        public static final String FRIEND_INS_PROFILE = "friend_ins_profile";
        public static final String FRIEND_MONKEY_CLICK = "friend_monkeyking_click";
        public static final String SETTING_LINKINS_COMPLETE = "setting_linkIns_complete";

        public static final String MONKEY_GENDER_NEW = "Monkey_gender_new";
        public static final String MONKEY_AGE_NEW = "Monkey_age_new";
        public static final String MONKEY_BAN_NEW = "Monkey_ban_new";
        public static final String MONKEY_UID_NEW = "Monkey_uid_new";
        public static final String MONKEY_COUNTRY_NEW = "Monkey_country_new";
        public static final String MONKEY_SIGNUP_DATE_NEW = "Monkey_signup_date_new";


        public static final String ENTRANCE_2P_CLICK = "entrance_2p_click";
        public static final String INVITE_FRIENDS_UNLOCK_SETTING_POP_SHOW = "invite_friends_unlock_settingpop_show";
        public static final String INVITE_FRIENDS_UNLOCK_SETTING_CLICK = "invite_friends_unlock_setting_click";
        public static final String INVITE_FRIENDS_UNLOCK_SHOW = "invite_friends_unlock_show";
        public static final String INVITE_FRIENDS_UNLOCK_CLICK = "invite_friends_unlock_click";
        public static final String DASH_2P_1ST_SHOW = "dash_2p_1st_show";
        public static final String DASH_2P_SHOW = "dash_2p_show";
        public static final String FIRST_CLICK_DASHBOARD = "dash_2p_1st_click";
        public static final String CLICK_DASHBOARD = "dash_2p_click";
        public static final String SHOW_DASHBOARD_INVITE_PANEL = "invite_panel_show";
        public static final String CLICK_DASHBOARD_INVITE_PANEL = "invite_panel_click";
        public static final String NOTIFICATION_1ST_PAIR_CLICK = "notification_1st_pair_click";
        public static final String NOTIFICATION_PAIR_CLICK = "notification_pair_click";
        public static final String NOTIFICATION_PAIR_SHOW = "notification_pair_show";
        public static final String NOTIFICATION_INVITE_SHOW = "notification_invite_show";
        public static final String NOTIFICATION_INVITE_CLICK = "notification_invite_click";


        //  ----------   User properties Match lifetime start  ---------------

        public static final String USER_PROPERTY_MATCH_REQUEST = "match_request";
        public static final String USER_PROPERTY_MATCH_RECEIVE = "match_receive";
        public static final String USER_PROPERTY_MATCH_CONNECT = "match_connect";
        public static final String USER_PROPERTY_MATCH_SUCCESS = "match_success";
        public static final String USER_PROPERTY_MATCH_SUCCESS_F = "match_success_f";
        public static final String USER_PROPERTY_MATCH_SUCCESS_M = "match_success_m";
        public static final String USER_PROPERTY_MATCH_SUCCESS_ADD_TIME = "match_success_add_time";
        public static final String USER_PROPERTY_MATCH_SUCCESS_ADD_FRIEND = "match_success_add_friend";
        public static final String USER_PROPERTY_MATCH_SUCCESS_ADD_TIME_AND_FRIEND = "match_success_time&friend";
        public static final String USER_PROPERTY_MATCH_DURATION_TOTAL = "match_duration_total";
        public static final String USER_PROPERTY_MATCH_DURATION_TOTAL_VIDEO = "match_duration_total_video";
        public static final String USER_PROPERTY_MATCH_DURATION_TOTAL_TEXT = "match_duration_total_text";
        public static final String USER_PROPERTY_MATCH_DURATION_TOTAL_EVENT_MODE = "match_duration_total_eventmode";
        public static final String USER_PROPERTY_MATCH_SUCCESS_VIDEO = "match_success_video";
        public static final String USER_PROPERTY_MATCH_SUCCESS_TEXT = "match_success_text";
        public static final String USER_PROPERTY_MATCH_SUCCESS_EVENT_MODE = "match_success_eventmode";
        public static final String USER_PROPERTY_TOTAL_BANANA = "total_banana";
        public static final String USER_PROPERTY_CURRENT_BANABNA = "current_banana";

        //  ----------   User properties Match lifetime end  ---------------


        //  ----------   User properties Match 1st day start  ---------------

        public static final String USER_PROPERTY_DAY1_MATCH_REQUEST = "day1_match_request";
        public static final String USER_PROPERTY_DAY1_MATCH_RECEIVE = "day1_match_receive";
        public static final String USER_PROPERTY_DAY1_MATCH_CONNECT = "day1_match_connect";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS = "day1_match_success";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_F = "day1_match_success_f";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_M = "day1_match_success_m";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_ADD_TIME = "day1_match_success_add_time";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_ADD_FRIEND = "day1_match_success_add_friend";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_ADD_TIME_AND_FRIEND = "day1_match_success_time&friend";
        public static final String USER_PROPERTY_DAY1_MATCH_DURATION_TOTAL = "day1_match_duration_total";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_VIDEO = "day1_match_success_video";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_TEXT = "day1_match_success_text";
        public static final String USER_PROPERTY_DAY1_MATCH_SUCCESS_EVENT_MODE = "day1_match_success_eventmode";

        //  ----------   User properties Match 1st day end  ---------------

        public static final String APP_START = "APP_START";
        public static final String CODE_VERIFY = "CODE_VERIFY";
        public static final String SIGNUP_LOGIN = "SIGNUP_LOGIN";
        public static final String SIGNUP_FINISH = "SIGNUP_FINISH";
        public static final String PERMISSION_GRANTED = "PERMISSION_GRANTED";

        public static final String LANDING_PAGE = "LANDING_PAGE";
        public static final String SIGN_OUT = "SIGN_OUT";
        public static final String NOTIFICATION_MESSAGE = "NOTIFICATION_MESSAGE";
        public static final String NOTIFICATION_MESSAGE_BACKGROUND = "NOTIFICATION_MESSAGE_BACKGROUND";
        public static final String NOTIFICATION_MESSAGE_SHOW = "NOTIFICATION_MESSAGE_SHOW";
        public static final String NOTIFY_RECEIVE = "NOTIFY_RECEIVE";
        public static final String NOTIFICATION_CLICK = "NOTIFICATION_CLICK";
        public static final String NOTIFICATION_CLICK_SOURCE = "NOTIFICATION_CLICK_SOURCE";
        public static final String NOTIFY_CLICK = "NOTIFY_CLICK";

        public static final String UNLOCK_START = "UNLOCK_START";
        public static final String UNLOCK_BOARD = "UNLOCK_BOARD";
        public static final String UNLOCK_FINISH = "UNLOCK_FINISH";
        public static final String SESSION_START = "SESSION_START";
        public static final String SESSION_END = "SESSION_END";
        public static final String CODE_VERIFY_ATTEMPT = "CODE_VERIFY_ATTEMPT";
        public static final String CLIENT_ERROR = "CLIENT_ERROR";
        public static final String EDIT_PROFILE_ACTION = "EDIT_PROFILE_ACTION";
        public static final String ERROR_POPUP_SHOW = "ERROR_POPUP_SHOW";
        public static final String SEARCHUSER_ENTER = "SEARCHUSER_ENTER";
        public static final String SEARCHUSER_ERROR = "SEARCHUSER_ERROR";
        public static final String AGE13_POPUP_SHOW = "AGE13_POPUP_SHOW";

        public static final String STORY_CREATION_ENTER = "STORY_CREATION_ENTER";
        public static final String STORY_EDIT = "STORY_EDIT";
        public static final String STORY_SAVE = "STORY_SAVE";
        public static final String STORY_EDIT_COMPLETE = "STORY_EDIT_COMPLETE";
        public static final String STORY_POST_SUCCESS = "STORY_POST_SUCCESS";
        public static final String STORY_DM_ENTER = "STORY_DM_ENTER";
        public static final String CHAT_MSG_DELETE = "CHAT_MSG_DELETE";
        public static final String MERCH_STORE_ENTER = "MERCH_STORE_ENTER";
        public static final String MESSAGES_ENTER = "MESSAGES_ENTER";
        public static final String PROFILE_ENTER = "PROFILE_ENTER";

        public static final String STORY_COVER_SHOW = "STORY_COVER_SHOW";
        public static final String STORY_LIST_ENTER = "STORY_LIST_ENTER";
        public static final String STORY_LIST_SWITCH = "STORY_LIST_SWITCH";
        public static final String STORY_LIST_REFRESH = "STORY_LIST_REFRESH";
        public static final String STORY_LIST_FETCH = "STORY_LIST_FETCH";
        public static final String USER_PROPERTY = "UserProperty";


    }

    public static final class Config {
        public static final long TWOP_PAIR_EXPIRE = 30000;
        public static final long TWOP_INVITE_ENABLE_2P_EXPIRE = 72 * 60 * 60000;
    }

    public static final class DirectTypeAfterLogin {
        public static final int LINK_EVENT = 0;
        public static final int VIDEO_ANSWER = 1;
        public static final int VIDEO_CALL = 2;
        public static final int NOTIFICATION_INVITE_SENT = 3;
        public static final int NOTIFICATION_INVITE_ACCEPTED = 4;
        public static final int NOTIFICATION_DISMISS_TWOP_INVITE = 5;
        public static final int NOTIFICATION_TWOP_FRIEND_INVITION = 6;
        public static final int NOTIFICATION_TWOP_VIDEO_CALL = 7;
        public static final int NOTIFICATION_PUSH_MESSAGE = 16;
        public static final int NOTIFICATION_SOURCE = 100;
    }

    public static final class RemoteConfigKey {

        public static final String MATCH_ACCEPT = "match_accept";

        public static final String MATCH_WAITING = "match_waiting";

        public static final String ROOM_MAX_CONNECT_TIME = "room_max_connect_time";

        public static final String PEC_OUT_SHOW_TIME = "pce_out_show_time";

        public static final String UNLOCK_TWOP_EXPERIMENT = "unlock_2p_experiment";

        public static final String INVITE_MSG_SENT_METHOD = "invite_msg_sent_method";

        public static final String STORY_SWITCH_MODE = "story_play_method";

        public static final String MATCH_REQUEST_RE = "match_request_re";

        public static final String DM_SENT_AB_TEST = "dm_sent_ab_test";
    }

    public static final class RemoteConfigValue {

        public static final String PLANA = "A";

        public static final String PLANB = "B";

        public static final String NONE = "none";

        public static final String DM_GROUPA = "group_a";

        public static final String DM_GROUPB = "group_b";

        public static final String DM_GROUPC = "group_c";

    }

}
