/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Repository.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tavo
 */
@Repository
public class RepositoryConnection {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getHibernateSession() {
        return sessionFactory.getCurrentSession();
    }
}
