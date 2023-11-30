package org.dromara.system.domain.api;

import java.util.List;

public class DailyMenu {
    private List<DailyMenuGrouding> dailyMenuGroudings;

    public List<DailyMenuGrouding> getDailyMenuGroudings() {
        return dailyMenuGroudings;
    }

    public void setDailyMenuGroudings(List<DailyMenuGrouding> dailyMenuGroudings) {
        this.dailyMenuGroudings = dailyMenuGroudings;
    }
}
