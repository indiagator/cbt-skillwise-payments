package com.skillwise.cbtskillwisepayments;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FullOrder extends Order{

    Userdetail sellerDetails;
    FullOffer fullOffer;
}
