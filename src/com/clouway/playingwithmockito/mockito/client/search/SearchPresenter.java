package com.clouway.playingwithmockito.mockito.client.search;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

/**
* author webmaster1803@gmail.com
*/
public class SearchPresenter {
    private SearchView view;
    private CompanySearchAsync searchAsync;

    public SearchPresenter(SearchView view, CompanySearchAsync searchAsync) {
        this.view = view;
        this.searchAsync = searchAsync;
    }


    public void search(String search) {
        searchAsync.getCompaniesByType(search, new AsyncCallback<ArrayList<CompanyCard>>() {
            @Override
            public void onFailure(Throwable caught) {
               view.notifyOfConnectionError();
            }

            @Override
            public void onSuccess(ArrayList<CompanyCard> result) {
                if (result.size() == 0) {

                    view.notifyOfEmptySearch();
                } else {
                    view.showSearchResult(result);
                }
            }
        });
    }
}
