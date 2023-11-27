package org.subasadhikari.binaryTree;

public class SameKeyException extends Exception{
    String message;

    public SameKeyException(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "SameKeyException{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return message;
    }
}
