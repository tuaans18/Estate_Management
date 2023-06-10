package com.laptrinhjavaweb.builder;

public class CustomerSearchBuilder {
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;



    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Long getStaffId() {
        return staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public CustomerSearchBuilder(CustomerBuilder customerBuilder){
        this.fullName = customerBuilder.fullName;
        this.phone = customerBuilder.phone;
        this.email = customerBuilder.email;
        this.staffId = customerBuilder.staffId;

    }

    public static class CustomerBuilder
    {
        private String fullName;
        private String phone;
        private String email;
        private Long staffId;

        public CustomerBuilder setFullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public CustomerBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }
        public CustomerBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public CustomerBuilder setStaffId(Long staffId){
            this.staffId = staffId;
            return this;
        }

        public CustomerSearchBuilder build() {
            return new CustomerSearchBuilder(this);
        }

    }
}
