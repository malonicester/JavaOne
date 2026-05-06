package org.java.client;

import java.util.Map;

public class HttpRequest<T> {
    public String url;
    public String path;
    public Map<String, String> headers;
    public T body;

    private HttpRequest() {}

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private String url;
        private String path;
        private Map<String, String> headers;
        private T body;

        public Builder<T> url(String url) {
            this.url = url;
            return this;
        }

        public Builder<T> path(String path) {
            this.path = path;
            return this;
        }

        public Builder<T> headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder<T> body(T body) {
            this.body = body;
            return this;
        }

        public HttpRequest<T> build() {
            HttpRequest<T> request = new HttpRequest<>();
            request.url = this.url;
            request.path = this.path;
            request.headers = this.headers;
            request.body = this.body;
            return request;
        }
    }
}
