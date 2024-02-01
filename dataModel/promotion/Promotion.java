
package dataModel.promotion;
import java.util.Date;

import constants.Constant;
import dataModel.order.Order;
import utilities.Validator;

public abstract class Promotion {

    private String name;
    protected Constant.promotionType promotionType;
    protected Validator validator; 

    public Promotion(String name, Constant.promotionType type) {
        this.name = name;
        this.promotionType = type;
    }

    public String getName() {
        return name;
    }

    public Constant.promotionType getType() {
        return promotionType;
    }

    public abstract boolean isValid(Date today);

    public abstract Order applyPromotion(Order o); 

}