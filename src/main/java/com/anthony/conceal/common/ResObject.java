package com.anthony.conceal.common;

/**
 * Created by CHENDONG239 on 2016-12-29.
 */
public class ResObject {
    private String code;
    private String message;
    private Object content;

    private ResObject(ResObjectBuilder builder) {
        code = builder.code;
        message = builder.message;
        content = builder.content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResObject{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }

    public static class ResObjectBuilder {
        private String code = "00";
        private String message = "成功";
        private Object content = null;

        public ResObjectBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ResObjectBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResObjectBuilder content(Object content) {
            this.content = content;
            return this;
        }

        public ResObject build() {
            return new ResObject(this);
        }
    }
}
