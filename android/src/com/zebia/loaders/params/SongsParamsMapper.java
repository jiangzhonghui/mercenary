package com.zebia.loaders.params;

import android.os.Bundle;

import java.util.Map;

public class SongsParamsMapper extends BaseParamsMapper implements ParamsMapper {

    @Override
    public Bundle map(String ip, String port, String mountPoint, Map<String, String> params, boolean forceLoad) {
        return super.map(ip, port, mountPoint, params, forceLoad);
    }

    protected Bundle buildParams(Map<String, String> params) {
        if (params.get(SearchParams.PAGE) == null) {
            params.put(SearchParams.PAGE, "0");
        }

        Bundle bundle = super.buildParams(params);
        bundle.putString(SearchParams.RESULTS_PER_PAGE, "15");
        return bundle;
    }
}
