package com.skillwise.cbtskillwisepayments;

import com.skillwise.cbtskillwisepayments.ProductOffer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class FullOffer extends ProductOffer
{
    Integer offerAmount;
    List<Product> productList;
}
