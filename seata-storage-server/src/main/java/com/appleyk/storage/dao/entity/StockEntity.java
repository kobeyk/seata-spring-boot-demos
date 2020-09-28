package com.appleyk.storage.dao.entity;

import com.appleyk.common.dto.CommodityDTO;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p></p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:07 2020/9/28
 */
@Table(name = "t_storage")
public class StockEntity {
    @Id
    public Integer id;
    /**商品名称*/
    public String name;
    /**商品编号*/
    public String commodityCode;
    /**商品数量*/
    public int count;

    private StockEntity(CommodityDTO commodityDTO){
        this.name = commodityDTO.getName();
        this.commodityCode = commodityDTO.getCommodityCode();
        this.count = commodityDTO.getCount();
    }

    public static StockEntity createEntity(CommodityDTO commodityDTO){
        return new StockEntity(commodityDTO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
