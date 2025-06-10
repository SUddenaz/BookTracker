package com.example.BookTracker.controller;

public class ResponseWrapper<T> {
    private T data;

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
