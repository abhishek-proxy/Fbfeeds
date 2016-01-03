package com.example.linux.facebookfeeds;

/**
 * Created by Linux on 1/3/16.
 */
public class PagingFacebook {
    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    String previous;
    String next;
}
