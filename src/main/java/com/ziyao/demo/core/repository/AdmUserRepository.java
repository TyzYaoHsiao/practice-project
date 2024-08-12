package com.ziyao.demo.core.repository;

import com.ziyao.demo.core.entity.AdmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmUserRepository extends JpaRepository<AdmUser, Long> {

    AdmUser findByUserId(String userId);
}
