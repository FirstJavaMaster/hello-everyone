package com.tong.hellodoubledatasource.secondary.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 权限信息
 * <p>
 * 对应数据库的TU_DUTY表
 *
 * @author tongpc32380
 * @date 2021/3/4 14:21
 */
@Data
@Entity
@Table(name = "to_funddeal")
public class FundDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fund_id")
    private String fundId;

    @Column(name = "islocked")
    private String isLocked;

    @Column(name = "lock_stamp")
    private String lockStamp;


}
