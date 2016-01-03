package com.example.linux.facebookfeeds;

import java.util.List;

/**
 * Created by Linux on 1/3/16.
 */
public class FacebookFeeds {
    public List<Event> getData() {
        return data;
    }

    public void setData(List<Event> data) {
        this.data = data;
    }

    public PagingFacebook getPaging() {
        return paging;
    }

    public void setPaging(PagingFacebook paging) {
        this.paging = paging;
    }

    List<Event> data;
    PagingFacebook paging;
}
