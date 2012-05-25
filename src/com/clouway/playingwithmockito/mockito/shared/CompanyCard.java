package com.clouway.playingwithmockito.mockito.shared;

import java.io.Serializable;

/**
* author webmaster1803@gmail.com
*/
 public class CompanyCard implements Serializable {

    private long id;

    public CompanyCard(long cardId) {
        id = cardId;
    }

    public Long getId() {
        return id;
    }
}
