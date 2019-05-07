package com.nekoneko.ni;

public class NekoItem {
    private String mName;
    private int mLocationX;
    private int mLocationY;
    private int mFeedQuantity;
    private int mWaterQuantity;
    private boolean isCatChecked;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmLocationX() {
        return mLocationX;
    }

    public void setmLocationX(int mLocationX) {
        this.mLocationX = mLocationX;
    }

    public int getmLocationY() {
        return mLocationY;
    }

    public void setmLocationY(int mLocationY) {
        this.mLocationY = mLocationY;
    }

    public int getmFeedQuantity() {
        return mFeedQuantity;
    }

    public void setmFeedQuantity(int mFeedQuantity) {
        this.mFeedQuantity = mFeedQuantity;
    }

    public int getmWaterQuantity() {
        return mWaterQuantity;
    }

    public void setmWaterQuantity(int mWaterQuantity) {
        this.mWaterQuantity = mWaterQuantity;
    }

    public boolean isCatChecked() {
        return isCatChecked;
    }

    public void setCatChecked(boolean catChecked) {
        isCatChecked = catChecked;
    }
}
