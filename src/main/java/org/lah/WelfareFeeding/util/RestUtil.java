package org.lah.WelfareFeeding.util;

import org.lah.WelfareFeeding.exception.NotFoundException;

public class RestUtil {
    public static <T> T CheckResult(T result){
        if(result == null){
            throw new NotFoundException();
        }
        return result;
    }
}
