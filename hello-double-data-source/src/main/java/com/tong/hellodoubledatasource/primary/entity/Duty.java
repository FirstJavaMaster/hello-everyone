package com.tong.hellodoubledatasource.primary.entity;

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
@Table(name = "tu_duty")
public class Duty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duty_id")
    private String dutyId;

    @Column(name = "duty_type")
    private String dutyCode;

    @Column(name = "duty_name")
    private String dutyName;


}
