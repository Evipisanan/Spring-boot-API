package com.example.springbootvipiapi.utils;

public class Response<T> {
    private String statusCode;
    private String statusDescription;
    private T content;

    public Response(T content) {
    }

    public Response(String statusCode, String statusDescription, T content) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.content = content;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Response{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", content=" + content +
                '}';
    }
}
