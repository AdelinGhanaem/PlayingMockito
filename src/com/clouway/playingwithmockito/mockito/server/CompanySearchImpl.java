package com.clouway.playingwithmockito.mockito.server;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.clouway.playingwithmockito.mockito.client.CompanySearch;

import java.util.List;

/**
 * author webmaster1803@gmail.com
 */
public class CompanySearchImpl extends RemoteServiceServlet implements CompanySearch {
    @Override
    public List<CompanyCard> getCompanyBytType(String search) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}