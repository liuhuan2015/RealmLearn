package com.liuh.realmlearn;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Date: 2018/3/13 14:15
 * Description:
 */

public class TimeInfo extends RealmObject {

    private String yMD;//年月日

    private String title;

    private String content;

    @PrimaryKey
    private String addTime;

    private String createTime;

    private boolean isNew = true;

    public String getyMD() {
        return yMD;
    }

    public void setyMD(String yMD) {
        this.yMD = yMD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
