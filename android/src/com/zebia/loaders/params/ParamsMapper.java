package com.zebia.loaders.params;

import android.os.Bundle;

import java.util.Map;

public interface ParamsMapper {
    Bundle map(String ip, String port, String mountPoint, Map<String, String> params, boolean forceLoad);
}
