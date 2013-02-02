package com.zebia.loaders.params;

import android.net.Uri;
import android.os.Bundle;

import java.util.Map;

public class BaseParamsMapper implements ParamsMapper {

    @Override
    public Bundle map(String ip, String port, String mountPoint, Map<String, String> params, boolean forceLoad) {
        StringBuilder sb = new StringBuilder("http://").append(ip).append(":").append(port).append("/").append(mountPoint).append("/");
        sb.append("items-page-1.json");

        Bundle args = new Bundle();
        args.putParcelable(RestParamBuilder.ARGS_URI, Uri.parse(sb.toString()));
        args.putParcelable(RestParamBuilder.ARGS_PARAMS, buildParams(params));
        args.putBoolean(RestParamBuilder.ARGS_RELOAD, forceLoad);
        return args;
    }

    private Bundle buildParams(Map<String, String> params) {
        Bundle bundle = new Bundle();
        for (String key : params.keySet()) {
            String value = params.get(key);
            bundle.putString(key, value);
        }
        return bundle;
    }
}
