package com.skillwise.cbtskillwisepayments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface ProductOfferRepository extends JpaRepository<ProductOffer, Integer> {
    @Transactional
    @Modifying
    @Query("update ProductOffer p set p.status = 'closed',p.acceptedorderid = ?2 where p.id = ?1")
    int updateStatusByIdEquals(@NonNull Integer offerid, Integer orderid);

}