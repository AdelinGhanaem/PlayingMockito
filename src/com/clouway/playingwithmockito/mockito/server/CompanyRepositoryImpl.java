package com.clouway.playingwithmockito.mockito.server;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;

import java.util.ArrayList;
import java.util.List;

/**
 * author webmaster1803@gmail.com
 */
class CompanyRepositoryImpl implements CompanyRepository {

    @Override
    public List<CompanyCard> getCompaniesByType(String type) {
        List<CompanyCard> companyRepositories = new ArrayList<CompanyCard>();
        companyRepositories.add(new CompanyCard(2l));
        companyRepositories.add(new CompanyCard(22l));
        companyRepositories.add(new CompanyCard(23123l));
        companyRepositories.add(new CompanyCard(23213l));
        return companyRepositories;
    }
}
