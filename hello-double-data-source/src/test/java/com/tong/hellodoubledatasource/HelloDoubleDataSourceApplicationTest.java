package com.tong.hellodoubledatasource;

import com.tong.hellodoubledatasource.primary.dao.DutyDao;
import com.tong.hellodoubledatasource.primary.entity.Duty;
import com.tong.hellodoubledatasource.secondary.dao.FundDealDao;
import com.tong.hellodoubledatasource.secondary.entity.FundDeal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author matrix
 * @date
 */
@SpringBootTest
class HelloDoubleDataSourceApplicationTest {
    @Autowired
    private DutyDao dutyDao;
    @Autowired
    private FundDealDao fundDealDao;

    @Test
    void contextLoads() {
        Duty duty = dutyDao.findById("3").orElse(null);
        System.out.println(duty);

        FundDeal fundDeal = fundDealDao.findById("10").orElse(null);
        System.out.println(fundDeal);
    }

}
