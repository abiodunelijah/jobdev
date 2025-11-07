package com.coder2client.exception;

public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException() {
    }
    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
