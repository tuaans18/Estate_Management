package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import com.laptrinhjavaweb.repository.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findStaffByBuilding(Long buildingId) {
        StringBuilder sql = new StringBuilder(SystemConstant.SELECT_FROM_USER);
        sql.append(" INNER JOIN assignmentbuilding ab ON u.id = ab.staffid"
                + " INNER JOIN building b ON ab.buildingid = b.id"
                + " AND b.id = "+buildingId +" "+ SystemConstant.GROUP_BY_USER_ID);
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();

    }

    @Override
    public List<UserEntity> findStaffByCustomer(Long customerId) {
        StringBuilder sql = new StringBuilder(SystemConstant.SELECT_FROM_USER);
        sql.append(" INNER JOIN assignmentcustomer ac ON u.id = ac.staffid"
                + " INNER JOIN customer c ON ac.customerid = c.id"
                + " AND c.id = "+customerId +" "+ SystemConstant.GROUP_BY_USER_ID);
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }
}
