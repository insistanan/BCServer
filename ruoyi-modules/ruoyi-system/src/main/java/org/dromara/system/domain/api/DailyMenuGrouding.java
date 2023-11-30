package org.dromara.system.domain.api;

import java.util.List;

public class DailyMenuGrouding {

    private String serverTimeName;
    private Integer serverLimit;
    private String servetimeRepotrendtime;

    private List<DailyMenuDetail> dailyMenuDetailList;

    public String getServerTimeName() {
        return serverTimeName;
    }

    public void setServerTimeName(String serverTimeName) {
        this.serverTimeName = serverTimeName;
    }

    public Integer getServerLimit() {
        return serverLimit;
    }

    public void setServerLimit(Integer serverLimit) {
        this.serverLimit = serverLimit;
    }

    public String getServetimeRepotrendtime() {
        return servetimeRepotrendtime;
    }

    public void setServetimeRepotrendtime(String servetimeRepotrendtime) {
        this.servetimeRepotrendtime = servetimeRepotrendtime;
    }

    public List<DailyMenuDetail> getDailyMenuDetailList() {
        return dailyMenuDetailList;
    }

    public void setDailyMenuDetailList(List<DailyMenuDetail> dailyMenuDetailList) {
        this.dailyMenuDetailList = dailyMenuDetailList;
    }
}
