package com.tong.hellodoubledatasource.primary.dao;

import com.tong.hellodoubledatasource.primary.entity.Duty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tongpc32380
 * @date 2021/4/14 17:23
 */
public interface DutyDao extends JpaRepository<Duty, String> {
}
