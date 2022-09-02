package com.bilgeadam.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class MyFactoryRepository<T, ID> implements ICrud<T, ID> {

	Session session;
	EntityManager entityManager;
	CriteriaBuilder criteriaBuilder;
	org.hibernate.Transaction transaction;
	private T t;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}

	public org.hibernate.Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(org.hibernate.Transaction transaction) {
		this.transaction = transaction;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public MyFactoryRepository(T t) {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		criteriaBuilder = entityManager.getCriteriaBuilder();
		this.t = t;
	}

	public void openSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();

	}

	public void closeSuccessSession() {

		transaction.commit();
		session.close();

	}

	public void closeErrorSession() {
		transaction.rollback();
		session.close();

	}

	@Override
	public <S extends T> S save(S entity) {
		try {
			openSession();
			session.save(entity);
			closeSuccessSession();
			System.out.println("It is successfully built");
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			closeErrorSession();
			System.out.println("Something went wrong");
		}
		return null;
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		try {
			openSession();
			entities.forEach(entity -> {

				session.save(entity);

			});
			closeSuccessSession();

			return entities;
		} catch (Exception e) {
			e.printStackTrace();
			closeErrorSession();
		}
		return null;
	}

	@Override
	public void deleteById(ID id) {
		Optional<T> deleteEntitiy = null;

		try {

			deleteEntitiy = findById(id);

			if (deleteEntitiy.isPresent()) {
				openSession();
				session.remove(deleteEntitiy.get());
				closeSuccessSession();
			} else {

				System.out.println("This data related to the ID is not found");
			}

		} catch (Exception e) {
			closeErrorSession();
		}

	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<T> findById(ID id) {
		CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
		Root<T> root = (Root<T>) criteria.from(t.getClass());
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("id"), id));

		try {
			T result = entityManager.createQuery(criteria).getSingleResult();
			return Optional.of(result);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}

	@Override
	public boolean existById(ID id) {

		try {
			CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
			Root<T> root = (Root<T>) criteria.from(t.getClass());
			criteria.select(root);
			criteria.where(criteriaBuilder.equal(root.get("id"), id));
			Optional<T> result = (Optional<T>) entityManager.createQuery(criteria).getSingleResult();

			return result.isPresent();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
		Root<T> root = (Root<T>) criteria.from(t.getClass());
		criteria.select(root);
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<T> finByCollumnAndValue(String collumn, Object value) {
		CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
		Root<T> root = (Root<T>) criteria.from(t.getClass());
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get(collumn), value));
		return entityManager.createQuery(criteria).getResultList();

	}

	@Override
	public List<T> findByEntity(T entity) {
		List<T> result = new ArrayList<T>();
		Class cl = entity.getClass();

		Field[] fl = cl.getDeclaredFields();

		try {
			CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
			Root<T> root = (Root<T>) criteria.from(t.getClass());
			List<Predicate> list = new ArrayList<Predicate>();
			for (int i = 0; i < fl.length; i++) {
				// reflaction ile eriþtiðimiz alanlar eriþebilir olamalý

				fl[i].setAccessible(true);
				if (fl[i].get(t) != null && !fl[i].getName().equals("id")) {
					if (fl[i].getType().isAssignableFrom(String.class)) {// String kontrolu

						list.add(criteriaBuilder.like(root.get(fl[i].getName()), "%" + fl[i].get(t) + "%"));

					} else {
						list.add(criteriaBuilder.equal(root.get(fl[i].getName()), fl[i].get(t)));
					}

				}
			}
			criteria.where(list.toArray(new Predicate[] {}));

			result = entityManager.createQuery(criteria).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
