package com.clouway.playingwithmockito.mockito.client;

import com.clouway.playingwithmockito.mockito.client.search.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Mockito implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        SearchViewImpl view = new SearchViewImpl();
        CompanySearchAsync async = GWT.create(CompanySearch.class);
        SearchPresenter presenter = new SearchPresenter(view, async);
        view.setPresenter(presenter);
        RootPanel.get().add(view.asWidget());
    }
}
