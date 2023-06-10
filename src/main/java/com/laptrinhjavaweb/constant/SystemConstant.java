package com.laptrinhjavaweb.constant;

public class SystemConstant {
    /*Spring security 4: ROLE_ADMIN, Spring security 3 not required*/
    public static final String MANAGER_ROLE = "ROLE_MANAGER";
    /*Spring security 4: ROLE_ADMIN, Spring security 3 not required*/
    public static final String STAFF_ROLE = "ROLE_STAFF";
    public static final String HOME = "/trang-chu";
    public static final String ADMIN_HOME = "/admin/home";
    public static final String MODEL = "model";
    public static final String INSERT_SUCCESS = "insert_success";
    public static final String UPDATE_SUCCESS = "update_success";
    public static final String DELETE_SUCCESS = "delete_success";
    public static final String ERROR_SYSTEM = "error_system";
    public static final String ALERT = "alert";
    public static final String MESSAGE_RESPONSE = "messageResponse";
    public static final String PASSWORD_DEFAULT = "123456";
    public static final String CHANGE_PASSWORD_FAIL = "change_password_fail";
    public static final String WHERE_ONE_EQUAL_ONE = "where 1 = 1";
    public static final String SELECT_FROM_BUILDING = "SELECT * FROM building b";
    public static final String SELECT_FROM_CUSTOMER = "SELECT * FROM customer c";
    public static final String GROUP_BY_BUILDING_ID = "GROUP BY b.id";
    public static final String SELECT_FROM_USER = "SELECT * FROM user u";
    public static final String GROUP_BY_USER_ID = "GROUP BY u.id";
    public static final String GROUP_BY_CUSTOMER_ID = "GROUP BY c.id";
    public static final String EMPTY_STRING = "";
    public static final String BUILDING_ALIAS = "b.";
    public static final String AND_STATEMENT = "\nAND ";

}
