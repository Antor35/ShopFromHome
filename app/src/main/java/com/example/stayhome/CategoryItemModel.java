package com.example.stayhome;

public class CategoryItemModel {
    private int shopLogo;
    private String shopName;
    private String shopAddress;

    public CategoryItemModel(int shopLogo, String shopName, String shopAddress) {
        this.shopLogo = shopLogo;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public int getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(int shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
