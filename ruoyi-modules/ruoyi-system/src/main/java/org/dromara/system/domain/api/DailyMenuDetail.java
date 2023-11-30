package org.dromara.system.domain.api;

public class DailyMenuDetail {
    private String foodName;
    private Integer residueNumber;
    private Integer stockLimit;
    private Float price;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getResidueNumber() {
        return residueNumber;
    }

    public void setResidueNumber(Integer residueNumber) {
        this.residueNumber = residueNumber;
    }

    public Integer getStockLimit() {
        return stockLimit;
    }

    public void setStockLimit(Integer stockLimit) {
        this.stockLimit = stockLimit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
