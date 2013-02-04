package com.zebia.loaders.params;

import android.net.Uri;
import android.os.Bundle;

import java.util.Map;

public class ItemsParamsMapper implements ParamsMapper {

    @Override
    public Bundle map(String ip, String port, String mountPoint, Map<String, String> params, boolean forceLoad) {
        StringBuilder sb = new StringBuilder("http://").append(ip).append(":").append(port);

        Uri.Builder uriBuilder = Uri.parse(sb.toString()).buildUpon();
        uriBuilder.appendPath(mountPoint);
        uriBuilder.appendPath("items");

        String pageToLoad = params.get(SearchParams.PAGE);
        if (pageToLoad == null) {
            pageToLoad = "0";
        }

        switch (Integer.parseInt(pageToLoad)) {
            case 1:
                uriBuilder.appendPath("items-page-1.json");
                break;
            case 2:
                uriBuilder.appendPath("items-page-2.json");
                break;
            case 3:
                uriBuilder.appendPath("items-page-3.json");
                break;

            default:
                uriBuilder.appendPath("items-page-1.json");
                break;
        }

        Bundle args = new Bundle();
        args.putParcelable(RestParamBuilder.ARGS_URI, uriBuilder.build());
        args.putParcelable(RestParamBuilder.ARGS_PARAMS, buildParams(params));
        args.putBoolean(RestParamBuilder.ARGS_RELOAD, forceLoad);
        return args;
    }

    private Bundle buildParams(Map<String, String> params) {
        Bundle bundle = new Bundle();
        String searchQuery = params.get(SearchParams.ARTIST_NAME);
        if (searchQuery != null && searchQuery.length() != 0) {
            bundle.putString("q", searchQuery);
        }

        String pageToLoad = params.get(SearchParams.PAGE);
        if (pageToLoad != null && pageToLoad.length() > 0) {
            bundle.putString("page", pageToLoad);
        }
        return bundle;
    }
}
