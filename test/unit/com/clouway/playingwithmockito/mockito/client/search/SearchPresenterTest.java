package com.clouway.playingwithmockito.mockito.client.search;

import com.clouway.playingwithmockito.mockito.client.CompanySearchAsync;
import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubber;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


/**
 * author webmaster1803@gmail.com
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchPresenterTest {

    @Mock
    SearchView view;

    @Mock
    CompanySearchAsync async;

    private SearchPresenter searchPresenter;
    private ArrayList<CompanyCard> serverAnswer;

    @Before
    public void setUp() {
        initMocks(this);
        searchPresenter = new SearchPresenter(view, async);
        serverAnswer = new ArrayList<CompanyCard>();
        serverAnswer = new ArrayList<CompanyCard>();
        serverAnswer.add(new CompanyCard(1l));
        serverAnswer.add(new CompanyCard(2l));
    }


    @Test
    public void shouldShowSearchResultOnSearchSuccess() {
        String searchParameter = "search";
        doOnSuccess(serverAnswer).when(async).getCompanyBytType(eq(searchParameter), any(AsyncCallback.class));
        searchPresenter.search(searchParameter);
        verify(view).showSearchResult(serverAnswer);
        verify(async).getCompanyBytType(eq(searchParameter), any(AsyncCallback.class));
    }


    @Test
    public void userIsNotifiedWhenSearchResultIsEmpty() {
        String searchParam = "empty";
        ArrayList<CompanyCard> emptySearchResult = new ArrayList<CompanyCard>();
        doOnSuccess(emptySearchResult).when(async).getCompanyBytType(eq(searchParam), any(AsyncCallback.class));
        searchPresenter.search(searchParam);
        verify(view).notifyOfEmptySearch();

    }


    @Test
    public void notifiesUserOnCallbackFailure() {

        String searchParam = "will create connection failure !";
        doOnFailure(new RuntimeException()).when(async).getCompanyBytType(eq(searchParam), any(AsyncCallback.class));
        searchPresenter.search(searchParam);
        verify(view).notifyOfConnectionError();
    }


    // i don't like these at all ..... !!!!!!!
    private static Stubber doOnSuccess(final ArrayList<CompanyCard> returnedCards) {

        return doAnswer(new Answer<ArrayList<CompanyCard>>() {
            @Override
            public ArrayList<CompanyCard> answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                AsyncCallback<ArrayList<CompanyCard>> callback = (AsyncCallback<ArrayList<CompanyCard>>) args[args.length - 1];
                callback.onSuccess(returnedCards);
                return null;
            }
        });

    }

    private Stubber doOnFailure(final Throwable throwable) {
        return doAnswer(new Answer<Throwable>() {
            @Override
            public Throwable answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                AsyncCallback<ArrayList<CompanyCard>> callback = (AsyncCallback<ArrayList<CompanyCard>>) args[args.length - 1];
                callback.onFailure(throwable);
                return null;
            }
        });
    }


}
