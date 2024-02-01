package dataModel.promotion;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.validation.Validator;

import constants.Constant;
import dataModel.order.Order;

public class FlatDiscount extends Promotion {

    private double discount;

    public FlatDiscount(String name, Constant.promotionType type, double discount) {
        super(name, type);
        this.discount = discount;
    }

    @Override
    public boolean isValid(Date today) {
        if (this.promotionType == Constant.promotionType.ALWAYS) {
            return true; // ALWAYS valid
        } else if (this.promotionType == Constant.promotionType.PERIODIC) {
            return this.validator != null && this.validator.validate(today); // Use today as a Date argument
        } else {
            return false; // Invalid promotion type for FlatDiscount (should not be DAYOFWEEK)
        }
    }


    @Override
    public Order applyPromotion(Order o) {
     return o;
    }

}
