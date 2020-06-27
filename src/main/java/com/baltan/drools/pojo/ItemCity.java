package com.baltan.drools.pojo;

import com.baltan.drools.constant.City;
import com.baltan.drools.constant.Type;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author Baltan
 * @date 2020-06-27 19:34
 */
@Data
public class ItemCity {
    private City purchaseCity;
    private BigDecimal sellPrice;
    private Type typeofItem;
    private BigDecimal localTax;
}
