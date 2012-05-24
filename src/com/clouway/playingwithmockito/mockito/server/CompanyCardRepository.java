package com.clouway.playingwithmockito.mockito.server;

import java.util.Map;

/**
* author webmaster1803@gmail.com
*/
 class CompanyCardRepository {

    private Map<String, CompanyCard> cardMap;

    CompanyCardRepository(Map<String, CompanyCard> cardMap) {
        this.cardMap = cardMap;
    }

    public CompanyCard search(String abc) {
        return cardMap.get(abc);
    }
}
