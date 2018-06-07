package util;

import bean.UserBean;
import service.LinkupApplication;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class UserUtil {

    public final static String UNAME = "username";
    public final static String EMAIL = "email";
    public final static String PASSWORD = "password";

    public static void saveUserInfo(UserBean bean){
        if(bean!=null){
            LinkupApplication.setStringPref(UNAME,bean.getUsername());
            LinkupApplication.setStringPref(EMAIL,bean.getEmail());
            LinkupApplication.setStringPref(PASSWORD,bean.getPassword());
        }else{
            //Clear Cache
            LinkupApplication.setStringPref(UNAME,null);
            LinkupApplication.setStringPref(EMAIL,null);
            LinkupApplication.setStringPref(PASSWORD,null);
        }
    }
}
