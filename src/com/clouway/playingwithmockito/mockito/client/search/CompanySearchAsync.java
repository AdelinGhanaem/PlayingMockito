package com.clouway.playingwithmockito.mockito.client.search;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

/**
 * author webmaster1803@gmail.com
 */
public interface CompanySearchAsync {

    void getCompaniesByType (String search, AsyncCallback<ArrayList<CompanyCard>> async);

}
