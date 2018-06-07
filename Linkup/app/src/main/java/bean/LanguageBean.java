package bean;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class LanguageBean {

    String language;
    String src;

    public LanguageBean(String language, String src){
        this.language = language;
        this.src = src;
    }

    public String getLanguage() {
        return language;
    }

    public String getSrc() {
        return src;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
