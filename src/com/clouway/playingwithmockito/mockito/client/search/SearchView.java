package com.clouway.playingwithmockito.mockito.client.search;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;

import java.util.List;

/**
* author webmaster1803@gmail.com
*/
public interface SearchView {

    void showSearchResult(List<CompanyCard> searchResult);

    void notifyOfEmptySearch();

    void notifyOfConnectionError();

    public void setPresenter(SearchPresenter presenter);
}
