package com.abc.shopping.user.service.domain.entity;


import com.abc.shopping.domain.entity.AggregateRoot;
import com.abc.shopping.domain.valueobject.UserId;

import java.util.UUID;

public class User extends AggregateRoot<UserId> {

    private UserId id;

    private String userName;
    private String phoneNumber;
    private String address;

    public User() {
    }

    @Override
    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId id;
        private String userName;
        private String phoneNumber;
        private String address;


        public Builder id(UserId id) {
            this.id = id;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setPhoneNumber(phoneNumber);
            user.setAddress(address);
            return user;
        }
    }
}
