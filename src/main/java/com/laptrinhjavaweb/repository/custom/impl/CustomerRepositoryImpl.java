package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.repository.entity.CustomerEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> finCustomerByCondition(CustomerSearchBuilder customerSearchBuilder) {
        List<CustomerEntity> results = new ArrayList<>();
        StringBuilder sql = new StringBuilder(SystemConstant.SELECT_FROM_CUSTOMER);
        customerSqlJoining(customerSearchBuilder, sql);
        sql.append(" " + SystemConstant.WHERE_ONE_EQUAL_ONE + " ");
        customerSqlCommon(customerSearchBuilder, sql);
        customerSqlSpecial(customerSearchBuilder, sql);
        sql.append(" " + SystemConstant.GROUP_BY_CUSTOMER_ID);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    private void customerSqlSpecial(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
        Long staffId = customerSearchBuilder.getStaffId();
        if (staffId != null && staffId != -1) {
            sql.append(" AND a.staffid = " + staffId);
        }
    }

    private void customerSqlCommon(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
        try {
            Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName().toLowerCase();
                if (!fieldName.equals("staffId")) {
                    Object objectValue = field.get(customerSearchBuilder);
                    if (objectValue != null) {
                        if (!objectValue.toString().isEmpty()) {
                            if (field.getType().getName().equals("java.lang.String")) {
                                sql.append(" and c." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                            } else if (field.getType().getName().equals("java.lang.Integer")) {
                                sql.append(" and c." + fieldName.toLowerCase() + " = " + objectValue + "");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void customerSqlJoining(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
        Long staffId = customerSearchBuilder.getStaffId();
        if (staffId != null && staffId != -1) {
            sql.append(" INNER JOIN assignmentcustomer a ON a.customerid= c.id");
        }
    }
}
