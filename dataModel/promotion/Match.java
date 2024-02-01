package dataModel.promotion;

import java.util.Date;

import constants.Constant;
import dataModel.order.Order;

public class Match extends Promotion {

    private int qtyItemsOrder;
    private int qtyItemsPaid;

    public Match(String name, Constant.promotionType type, int qtyItemsOrder, int qtyItemsPaid) {
        super(name, type);
        this.qtyItemsOrder = qtyItemsOrder;
        this.qtyItemsPaid = qtyItemsPaid;
    }

    @Override
    public boolean isValid(Date today) {
        if (this.promotionType == Constant.promotionType.ALWAYS) {
            return true; // ALWAYS valid
        } else if (this.promotionType == Constant.promotionType.DAYOFWEEK) {
            return this.validator != null && this.validator.validate(today);
        } else {
            return false; // Other promotion types not applicable for Match
        }
    }



    @Override
    public Order applyPromotion(Order o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyPromotion'");
    }
}