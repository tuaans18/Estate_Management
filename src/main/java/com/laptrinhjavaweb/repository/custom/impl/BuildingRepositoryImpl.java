package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.enums.SpecialSearchParamsEnum;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.CollectionUtils;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findBuildingByCondition(BuildingSearchBuilder buildingSearchBuilder) {
        List<BuildingEntity> results = new ArrayList<>();
        StringBuilder sql = new StringBuilder(SystemConstant.SELECT_FROM_BUILDING);
        buildingSqlJoining(buildingSearchBuilder, sql);
        sql.append(" " + SystemConstant.WHERE_ONE_EQUAL_ONE + " ");
        buildingSqlCommon(buildingSearchBuilder, sql);
        buildingSqlSpecial(buildingSearchBuilder, sql);
        sql.append(" " + SystemConstant.GROUP_BY_BUILDING_ID);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }


    private void buildingSqlJoining(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null && staffId != -1) {
            sql.append(" INNER JOIN assignmentbuilding a ON a.buildingid= b.id");
        }
        if (buildingSearchBuilder.getAreaFrom() != null || buildingSearchBuilder.getAreaTo() != null) {
            sql.append(" INNER JOIN rentarea ra ON ra.buildingid = b.id");
        }
    }

    private void buildingSqlCommon(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName().toLowerCase();
                if (!getSpecialSearchParams().contains(fieldName)) {
                    Object objectValue = field.get(buildingSearchBuilder);
                    if (objectValue != null) {
                        if (!objectValue.toString().isEmpty()) {
                            if (field.getType().getName().equals("java.lang.String")) {
                                sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                            } else if (field.getType().getName().equals("java.lang.Integer")) {
                                sql.append(" and b." + fieldName.toLowerCase() + " = " + objectValue + "");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildingSqlSpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Integer rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
        Integer rentPriceTo = buildingSearchBuilder.getRentPriceTo();
        Integer rentAreaFrom = buildingSearchBuilder.getAreaFrom();
        Integer rentAreaTo = buildingSearchBuilder.getAreaTo();
        if (rentPriceFrom != null) {
            sql.append(" AND b.rentprice >= " + rentPriceFrom);
        }
        if (rentPriceTo != null) {
            sql.append(" AND b.rentprice <=" + rentPriceTo);
        }
        if (rentAreaFrom != null) {
            sql.append(" AND ra.value >= " + rentAreaFrom);
        }
        if (rentAreaTo != null) {
            sql.append(" AND ra.value <= " + rentAreaTo);
        }

        List<String> types = buildingSearchBuilder.getTypes();
        if (!CollectionUtils.isEmpty(types)) {
            sql.append(" AND (");
            String sqlWhere = types.stream().map(item -> "b.type like '%" + item + "%' ").collect(Collectors.joining("  or "));
            sql.append(sqlWhere);
            sql.append(" ) ");
        }
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null && staffId != -1) {
            sql.append(" AND a.staffid = " + staffId);
        }
        String districtCode = buildingSearchBuilder.getDistrict();
        if (!StringUtils.isNullOrEmpty(districtCode)) {
            if (!districtCode.equals("-1")) {
                sql.append(" AND b.district = '" + districtCode + "'");
            }
        }
    }


    private List<String> getSpecialSearchParams() {
        List<String> params = new ArrayList<>();

        for (SpecialSearchParamsEnum item : SpecialSearchParamsEnum.values()) {
            params.add(item.getValue().toLowerCase());
        }

        return params;
    }
}
