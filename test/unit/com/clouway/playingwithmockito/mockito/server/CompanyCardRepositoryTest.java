package com.clouway.playingwithmockito.mockito.server;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * author webmaster1803@gmail.com
 */
public class CompanyCardRepositoryTest {


    CompanyCardRepository repository;

    @Before
    public void setUp() {
        Map<String, CompanyCard> cardMap = new HashMap<String, CompanyCard>();
        cardMap.put("abc", new CompanyCard(1l));
        cardMap.put("xyz", new CompanyCard(2l));
        repository = new CompanyCardRepository(cardMap);
    }

    @Test
    public void returnCompanyMatchingTheSearch() {
        CompanyCard card = repository.search("abc");
        assertThat(card, is(notNullValue()));
        assertThat(card.getId(), is(equalTo(1l)));
    }

    @Test
    public void tryWithAnotherSearch() {
        CompanyCard returnedCard = repository.search("xyz");
        assertThat(returnedCard, is(notNullValue()));
        assertThat(returnedCard.getId(), is(equalTo(2l)));
    }

    @Test
    public void returnsNullValueWhenSearchValueIsEmpty() {
        CompanyCardRepository repository = new CompanyCardRepository(new HashMap<String, CompanyCard>());
        CompanyCard companyCard = repository.search("");
        assertThat(companyCard, is(nullValue()));
    }

    @Test
    public void willReturnNullValueIfNoSearchResults() {
        CompanyCardRepository repository = new CompanyCardRepository(new HashMap<String, CompanyCard>());
        CompanyCard companyCard = repository.search("No Search result");
        assertThat(companyCard, is(nullValue()));
    }




}
