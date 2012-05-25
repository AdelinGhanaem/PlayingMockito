package com.clouway.playingwithmockito.mockito.server;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;

import java.util.List;

/**
* author webmaster1803@gmail.com
*/
interface CompanyRepository {
    List<CompanyCard> getCompaniesByType(String type);
}
