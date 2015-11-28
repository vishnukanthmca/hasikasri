package com.aha.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aha.core.domain.Attribute;
import com.aha.core.domain.Category;
import com.aha.core.domain.Product;
import com.aha.web.dto.response.SearchDto;

@Repository
@Transactional
public class SearchRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private FullTextEntityManager em;

	public void startIndexing() {
		FullTextEntityManager em = Search
				.getFullTextEntityManager(entityManager);
		try {
			em.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			throw new RuntimeException("Error occurred during index rebuild - "
					+ e);
		}
	}

	@Transactional
	public List<SearchDto> query(String string) {

		em = Search.getFullTextEntityManager(entityManager);

		List<SearchDto> dtos = new ArrayList<SearchDto>();

		dtos.addAll(getProducts(string));

		dtos.addAll(getCategories(string));

		dtos.addAll(getAttributes(string));

		return dtos;
	}

	@Transactional
	private List<SearchDto> getAttributes(String string) {

		QueryBuilder qb = em.getSearchFactory().buildQueryBuilder()
				.forEntity(Attribute.class).get();

		org.apache.lucene.search.Query productQuery = qb.keyword().wildcard()
				.onField("value").matching(string + "*").createQuery();

		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(productQuery, BooleanClause.Occur.SHOULD);

		Query jpaQuery = em.createFullTextQuery(booleanQuery, Attribute.class);
		jpaQuery.setFirstResult(0);
		jpaQuery.setMaxResults(2);

		@SuppressWarnings("unchecked")
		List<Attribute> attributes = jpaQuery.getResultList();

		List<SearchDto> dtos = new ArrayList<SearchDto>();

		if (attributes != null && !attributes.isEmpty()) {

			for (Attribute p : attributes) {
				SearchDto dto = new SearchDto(p.getId(), p.getValue(),
						"Attribute");
				dtos.add(dto);
			}
		}

		return dtos;
	}

	@Transactional
	private List<SearchDto> getCategories(String string) {

		em = Search.getFullTextEntityManager(entityManager);

		QueryBuilder qb = em.getSearchFactory().buildQueryBuilder()
				.forEntity(Category.class).get();

		org.apache.lucene.search.Query productQuery = qb.keyword().wildcard()
				.onField("name").matching(string + "*").createQuery();

		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(productQuery, BooleanClause.Occur.SHOULD);

		Query jpaQuery = em.createFullTextQuery(booleanQuery, Category.class);
		jpaQuery.setFirstResult(0);
		jpaQuery.setMaxResults(2);

		@SuppressWarnings("unchecked")
		List<Category> categories = jpaQuery.getResultList();

		List<SearchDto> dtos = new ArrayList<SearchDto>();

		if (categories != null && !categories.isEmpty()) {

			for (Category p : categories) {
				SearchDto dto = new SearchDto(p.getId(), p.getName(),
						"Category");
				dtos.add(dto);
			}
		}

		return dtos;

	}

	private List<SearchDto> getProducts(String string) {

		em = Search.getFullTextEntityManager(entityManager);

		QueryBuilder qb = em.getSearchFactory().buildQueryBuilder()
				.forEntity(Product.class).get();

		org.apache.lucene.search.Query productQuery = qb.keyword().wildcard()
				.onField("name").matching(string + "*").createQuery();

		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(productQuery, BooleanClause.Occur.SHOULD);

		Query jpaQuery = em.createFullTextQuery(booleanQuery, Product.class);
		jpaQuery.setFirstResult(0);
		jpaQuery.setMaxResults(2);

		@SuppressWarnings("unchecked")
		List<Product> products = jpaQuery.getResultList();

		List<SearchDto> dtos = new ArrayList<SearchDto>();

		if (products != null && !products.isEmpty()) {

			for (Product p : products) {
				SearchDto dto = new SearchDto(p.getId(), p.getName(), "Product");
				dtos.add(dto);
			}
		}

		return dtos;
	}
}
