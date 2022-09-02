package com.bilgeadam.repository;

import java.util.Optional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bilgeadam.entity.User;
import com.bilgeadam.utility.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User, Long> {

	public UserRepository() {
		super(new User());

	}

	public Optional<User> findbyUsernameAndPassword(String username, String password) {
		User user = null;
		CriteriaQuery<User> crteira = getCriteriaBuilder().createQuery(User.class);
		Root<User> root = crteira.from(User.class);
		Predicate predicateUsername = getCriteriaBuilder().equal(root.get("username"), username);
		Predicate predicatePassword = getCriteriaBuilder().equal(root.get("password"), password);
		crteira.select(root).where(getCriteriaBuilder().and(predicateUsername, predicatePassword));

		try {
			user = getEntityManager().createQuery(crteira).getSingleResult();
			return Optional.of(user);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}

}