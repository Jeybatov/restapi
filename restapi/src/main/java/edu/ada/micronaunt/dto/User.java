package edu.ada.micronaunt.dto;


import grails.gorm.annotation.Entity;

import org.grails.datastore.gorm.GormEntity;


@Entity
class User implements GormEntity<User>, UserState {
    private static String email;
    private static String username;
    private static String password;


    static constraints = {
        email nullable: false, blank: false;
        username nullable: false, blank: false, unique: true;
        password nullable: false, blank: false, password: true;
    }

    static mapping = {
        password column: 'password';
    }

