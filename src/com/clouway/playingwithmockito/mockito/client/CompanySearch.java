package com.clouway.playingwithmockito.mockito.client;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * author webmaster1803@gmail.com
 */
@RemoteServiceRelativePath("CompanySearch")
public interface CompanySearch extends RemoteService {

    List<CompanyCard> getCompanyBytType(String search);

    /**
     * Utility/Convenience class.
     * Use CompanySearch.App.getInstance() to access static instance of CompanySearchAsync
     */
    public static class App {
        private static final CompanySearchAsync ourInstance = (CompanySearchAsync) GWT.create(CompanySearch.class);
        public static CompanySearchAsync getInstance() {
            return ourInstance;
        }
    }
}
