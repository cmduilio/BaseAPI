package com.mainPackage.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.mainPackage.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//implementation of daydao interface using entityManager
@Repository
public class DayRepositoryImpl implements DayRepository {

	private static final Logger logger = LoggerFactory.getLogger(DayRepositoryImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void add(Day p) {
		entityManager.persist(p);
		logger.info("Day saved successfully, Day Details=" + p);
	}

    @Transactional
	public void update(Day p) {
		entityManager.merge(p);
		logger.info("Day updated successfully, Day Details=" + p);
	}

    @Transactional
	@SuppressWarnings("unchecked")
	public List<Day> getList() {
		List<Day> daysList = entityManager.createQuery("select d from Day d").getResultList();
		for (Day p : daysList) {
			logger.info("Day List::" + p.getDay() + "-" + p.getWeather());
		}
		return daysList;
	}

    @Transactional
	public Day getById(int id) {
		Day p = (Day) entityManager.find(Day.class, id);
		logger.info("Day loaded successfully, Day details=" + p);
		return p;
	}

    @Transactional
	public void remove(int id) {
		Day p = (Day) entityManager.find(Day.class, new Integer(id));
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Day deleted successfully, Day details=" + p);
	}
}
