package com.zebia.loaders.params;

import android.net.Uri;
import android.os.Bundle;

import java.util.Map;

public class BaseParamsMapper implements ParamsMapper {

    @Override
    public Bundle map(String ip, String port, String mountPoint, Map<String, String> params, boolean forceLoad) {
        Uri.Builder uriBuilder = buildInitialUrl(ip, port, mountPoint);

        Bundle args = new Bundle();
        args.putParcelable(RestParamBuilder.ARGS_URI, uriBuilder.build());
        args.putParcelable(RestParamBuilder.ARGS_PARAMS, buildParams(params));
        args.putBoolean(RestParamBuilder.ARGS_RELOAD, forceLoad);
        return args;
    }

    private Uri.Builder buildInitialUrl(String ip, String port, String mountPoint) {
        StringBuilder sb = new StringBuilder("http://").append(ip).append(":").append(port);

        Uri.Builder uriBuilder = Uri.parse(sb.toString()).buildUpon();

        if (mountPoint.length() > 0) {
            uriBuilder.appendPath(mountPoint);
        }
        uriBuilder.appendPath("song");
        return uriBuilder;
    }

    protected Bundle buildParams(Map<String, String> params) {
        Bundle bundle = new Bundle();
        for (String key : params.keySet()) {
            String value = params.get(key);
            bundle.putString(key, value);
        }
        return bundle;
    }
}
