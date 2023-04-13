package com.skillwise.cbtskillwisepayments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paymentrecords")
public class Paymentrecord {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "offerid")
    private Integer offerid;

    @Column(name = "sellername", length = 50)
    private String sellername;

    @Column(name = "buyername", length = 50)
    private String buyername;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "paymentid")
    private Integer paymentid;

}