package com.zebia.loaders.params;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.zebia.SettingsActivity;

import java.util.HashMap;
import java.util.Map;

public class RestParamBuilder {
    public static final String ARGS_URI = "com.zebia.fragments.ItemListFragment.ARGS_URI";
    public static final String ARGS_PARAMS = "com.zebia.fragments.ItemListFragment.ARGS_PARAMS";
    public static final String ARGS_RELOAD = "com.zebia.fragments.ItemListFragment.ARGS_RELOAD";

    public static final String DEF_PORT = "3000";
    public static final String DEF_MOUNT_POINT = "zebia";
    private final Context context;

    Map<String, String> params = new HashMap<String, String>();
    private boolean forceLoad = true;
    private final ParamsMapper paramsMapper;

    public RestParamBuilder(Context context) {
        this.context = context;
        this.paramsMapper = new BaseParamsMapper();
    }

    public RestParamBuilder(Context context, ParamsMapper paramsMapper) {
        this.context = context;
        this.paramsMapper = paramsMapper;
    }

    public Bundle build() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String ip = sharedPreferences.getString(SettingsActivity.PREF_IP, "");
        String port = sharedPreferences.getString(SettingsActivity.PREF_PORT, DEF_PORT);
        String mountPoint = sharedPreferences.getString(SettingsActivity.PREF_MPOINT, DEF_MOUNT_POINT);

        return paramsMapper.map(ip, port, mountPoint, params, forceLoad);
    }

    public RestParamBuilder putParam(String key, String value) {
        params.put(key, value);
        return this;
    }
    public RestParamBuilder putParam(String key, int value) {
        params.put(key, String.valueOf(value));
        return this;
    }

    public RestParamBuilder setForceLoad(boolean forceLoad) {
        this.forceLoad = forceLoad;
        return this;
    }

}
