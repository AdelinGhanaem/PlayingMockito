package com.clouway.playingwithmockito.mockito.client.search;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * author webmaster1803@gmail.com
 */
public class SearchViewImpl extends Composite implements SearchView {


    private SearchPresenter presenter;


    interface SearchViewImplUiBinder extends UiBinder<DecoratorPanel, SearchViewImpl> {
    }

    private static SearchViewImplUiBinder ourUiBinder = GWT.create(SearchViewImplUiBinder.class);

    @UiField
    TextBox searchText;
    @UiField
    Button search;
    @UiField
    FlexTable table;
    @UiField
    Label label;

    public SearchViewImpl() {

        DecoratorPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }

    public void setPresenter(SearchPresenter presenter) {
        this.presenter = presenter;
    }


    @UiHandler("search")
    public void onClick(ClickEvent event) {
        presenter.search(searchText.getText());
    }


    @Override
    public void showSearchResult(List<CompanyCard> searchResult) {
        int rowCount = 0;
        for (CompanyCard companyCard : searchResult) {
            rowCount++;
            table.setText(rowCount, 1, String.valueOf(companyCard.getId()));
        }
    }

    @Override
    public void notifyOfEmptySearch() {
        table.setText(1, 1, "No search results");
    }

    @Override
    public void notifyOfConnectionError() {
        label.setText("Error with the server ... !");
    }

    public Widget asWidget() {
        return this;
    }


}