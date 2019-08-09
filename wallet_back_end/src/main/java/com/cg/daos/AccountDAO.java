package com.cg.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {

}
