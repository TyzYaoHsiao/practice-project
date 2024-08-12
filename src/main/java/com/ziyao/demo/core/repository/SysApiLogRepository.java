package com.ziyao.demo.core.repository;

import com.ziyao.demo.core.entity.SysApiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysApiLogRepository extends JpaRepository<SysApiLog, Long> {

    List<SysApiLog> findAllByOrderByIdDesc();
}
