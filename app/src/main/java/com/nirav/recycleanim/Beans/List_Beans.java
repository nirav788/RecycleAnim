package com.nirav.recycleanim.Beans;

/**
 * Created by Developers on 25-07-2017.
 */

public class List_Beans {

    public List_Beans() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getIsHosted() {
        return isHosted;
    }

    public void setIsHosted(String isHosted) {
        this.isHosted = isHosted;
    }

    String type, sectionId, sectionName, webTitle, isHosted;

    public List_Beans(String type, String sectionId, String sectionName, String webTitle, String isHosted) {
        this.type = type;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.isHosted = isHosted;
    }
}
