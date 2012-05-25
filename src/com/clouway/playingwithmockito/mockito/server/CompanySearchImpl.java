package com.clouway.playingwithmockito.mockito.server;

import com.clouway.playingwithmockito.mockito.client.search.CompanySearch;
import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;

/**
 * author webmaster1803@gmail.com
 */
public class CompanySearchImpl extends RemoteServiceServlet implements CompanySearch {

    private CompanyRepository companyRepository;

    public CompanySearchImpl(CompanyRepository repository) {
        companyRepository = repository;
    }

    public CompanySearchImpl() {
        companyRepository = new CompanyRepositoryImpl();
    }

    @Override
    public ArrayList<CompanyCard> getCompaniesByType(String companiesType) {
        String searchParameter = companiesType;
        if ("".equals(searchParameter)) {
            return new ArrayList<CompanyCard>();
        }
        searchParameter = trimWhiteSpace(searchParameter);
        ArrayList<CompanyCard> cards = (ArrayList<CompanyCard>) companyRepository.getCompaniesByType(searchParameter);
        return cards;
    }

    private String trimWhiteSpace(String searchParameter) {
        int whiteSpaceEndIndex = 0;
        for (int i = 0; i < searchParameter.length(); i++) {
            if (searchParameter.charAt(i) == ' ') {
                whiteSpaceEndIndex++;
            } else {
                break;
            }
        }
        return searchParameter.substring(whiteSpaceEndIndex, searchParameter.length());
    }


}
