package com.tong.hellodoubledatasource.secondary.dao;

import com.tong.hellodoubledatasource.secondary.entity.FundDeal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tongpc32380
 * @date 2021/4/14 17:23
 */
public interface FundDealDao extends JpaRepository<FundDeal, String> {
}
