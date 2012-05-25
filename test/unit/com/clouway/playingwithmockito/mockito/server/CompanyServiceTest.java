package com.clouway.playingwithmockito.mockito.server;

import com.clouway.playingwithmockito.mockito.shared.CompanyCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * author webmaster1803@gmail.com
 */
@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

    interface CompanyRepository {
        List<CompanyCard> getCompaniesByType(String type);
    }

    @Mock
    private CompanyRepository repository;

    private CompanyService companyService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        companyService = new CompanyService(repository);
    }

    @Test
    public void returnsAListOfCompaniesMatchingTheSearch() {
        String companiesType = "auto mobile";

        List<CompanyCard> companyCards = new ArrayList<CompanyCard>();

        companyCards.add(new CompanyCard(1l));


        stub(repository.getCompaniesByType(companiesType)).toReturn(companyCards);

        List<CompanyCard> returnedCards = companyService.getCompaniesByType(companiesType);

        verify(repository).getCompaniesByType(companiesType);

        assertThat(returnedCards, is(notNullValue()));
        assertThat(returnedCards.size(), is(1));
        assertThat(returnedCards.get(0).getId(), is(equalTo(1l)));
    }

    @Test
    public void anEmptyListIsReturnedWhenNoSearchResults() {
        String companyType = "computer programing ";
        List<CompanyCard> cards = new ArrayList<CompanyCard>();
        when(repository.getCompaniesByType(companyType)).thenReturn(cards);
        List<CompanyCard> returnedCards = companyService.getCompaniesByType(companyType);
        verify(repository).getCompaniesByType(companyType);
        assertThat(returnedCards, is(notNullValue()));
        assertThat(returnedCards.size(), is(0));
    }


    @Test
    public void anEmptyListIsReturnedWhenSearchParameterIsEmptyString() {
        String companyType = "";
        List<CompanyCard> cards = new ArrayList<CompanyCard>();
        when(repository.getCompaniesByType(companyType)).thenReturn(cards);
        List<CompanyCard> returnedCards = companyService.getCompaniesByType(companyType);
        verify(repository, never()).getCompaniesByType(companyType);
        assertThat(returnedCards, is(notNullValue()));
        assertThat(returnedCards.size(), is(0));
    }

    @Test
    public void whiteSpacesAreTrimmedIfPrefixTheSearchParameter() {
        String whitespacePrefixed = "    mobile companies";
        String whitespaceTrimmed = "mobile companies";
        when(repository.getCompaniesByType(whitespaceTrimmed)).thenReturn(new ArrayList<CompanyCard>());
        companyService.getCompaniesByType(whitespacePrefixed);
        verify(repository, never()).getCompaniesByType(whitespacePrefixed);
        verify(repository).getCompaniesByType(whitespaceTrimmed);
    }

    @Test
    public void tryWithAnotherWhitespacePrefixedParameter() {
        String whitespacePrefixed = "       farming";
        String trimmed = "farming";
        when(repository.getCompaniesByType(trimmed)).thenReturn(new ArrayList<CompanyCard>());
        companyService.getCompaniesByType(whitespacePrefixed);
        verify(repository, never()).getCompaniesByType(whitespacePrefixed);
        verify(repository).getCompaniesByType(trimmed);
    }




    private class CompanyService {

        private CompanyRepository companyRepository;

        private CompanyService(CompanyRepository companyRepository) {
            this.companyRepository = companyRepository;
        }

        public List<CompanyCard> getCompaniesByType(String companiesType) {
            String searchParameter = companiesType;
            if ("".equals(searchParameter)) {
                return new ArrayList<CompanyCard>();
            }
            searchParameter = trimWhiteSpace(searchParameter);
            List<CompanyCard> cards = companyRepository.getCompaniesByType(searchParameter);
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
}
