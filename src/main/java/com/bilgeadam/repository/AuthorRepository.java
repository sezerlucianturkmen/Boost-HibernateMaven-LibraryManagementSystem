package com.bilgeadam.repository;

import java.util.Optional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bilgeadam.entity.Author;
import com.bilgeadam.utility.MyFactoryRepository;

public class AuthorRepository extends MyFactoryRepository<Author, Long> {

	public AuthorRepository() {
		super(new Author());

	}

	public Optional<Author> findbyFirstNameAndLastName(String fName, String lName) {
		Author tempAuthor = null;
		CriteriaQuery<Author> crteira = getCriteriaBuilder().createQuery(Author.class);
		Root<Author> root = crteira.from(Author.class);
		Predicate predicateFirstName = getCriteriaBuilder().equal(root.get("firstName"), fName);
		Predicate predicateLastName = getCriteriaBuilder().equal(root.get("lastName"), lName);
		crteira.select(root).where(getCriteriaBuilder().and(predicateFirstName, predicateLastName));

		try {
			tempAuthor = getEntityManager().createQuery(crteira).getSingleResult();
			return Optional.of(tempAuthor);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}

}