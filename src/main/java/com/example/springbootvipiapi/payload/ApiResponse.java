package com.example.springbootvipiapi.payload;

public class ApiResponse<T> {
    private Boolean success;
    private  String message;
    private T content;

    public ApiResponse() {
    }

    public ApiResponse(T content) {
        this.success = true;
        this.message = "show some message";
        this.content = content;
    }

    public ApiResponse(Boolean success, String message, T content) {
        this.success = success;
        this.message = message;
        this.content = content;
    }

    public ApiResponse(Boolean success , String message) {
    this.message= message;
    this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
