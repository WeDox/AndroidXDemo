package com.onedream.androidxdemo.framework.http.custome;

import com.onedream.androidxdemo.framework.utils.json_parse.OriginJsonParseUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class BodyOut {
    private int code;
    private String data;
    private String msg;

    public BodyOut(JSONObject object) {
        Set(object);
    }

    public void Set(JSONObject object) {
        try {
            code = OriginJsonParseUtils.getBoolean(object, "ret", false) ? ApiCode.SUCCESS : -1;
            data = OriginJsonParseUtils.getString(object, "info", "");
            msg = OriginJsonParseUtils.getString(object, "errMsg", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getApiMsg() {
        return msg == null ? "" : msg;
    }

    public void setApiMsg(String apiMsg) {
        this.msg = apiMsg;
    }


    //返回码判断
    public boolean isSuccess() {
        return code == ApiCode.SUCCESS;
    }

    public boolean isTokenError() {
        return code == ApiCode.TOKEN_ERROR;
    }

    public boolean isLuckDrawCoinNotEnough() {
        return code == ApiCode.LUCK_DRAW_MOENY_NotEnough;
    }
}
