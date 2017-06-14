package com.huotu.common;

import com.huotu.common.ienum.ICommonEnum;

/**
 * Created by hxh on 2017-06-14.
 */
public interface ResultType {
    enum ApiResult implements ICommonEnum {
        SUCCESS(2000, "成功"),
        FAILED(5000, "处理失败");

        private int code;
        private String name;

        ApiResult(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
