package com.github.codeqianxun.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
@Data
public class Index implements Serializable {
    private static final long serialVersionUID = 5897191343033380082L;

    @JSONField(name = "代码")
    String code;
    @JSONField(name = "名称")
    String name;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"")
                .append(code).append('\"');

        sb.append(",\"name\":\"")
                .append(name).append('\"');

        sb.append('}');
        return sb.toString();
    }
}