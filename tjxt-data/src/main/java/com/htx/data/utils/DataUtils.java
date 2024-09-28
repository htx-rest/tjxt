package com.htx.data.utils;

import com.htx.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataUtils {

    public static int getVersion(int totalVersion) {
        return DateUtils.now().getDayOfMonth() % totalVersion;
    }
}
