package com.dape.shop.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopGoodsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public ShopGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andShortTitleIsNull() {
            addCriterion("short_title is null");
            return (Criteria) this;
        }

        public Criteria andShortTitleIsNotNull() {
            addCriterion("short_title is not null");
            return (Criteria) this;
        }

        public Criteria andShortTitleEqualTo(String value) {
            addCriterion("short_title =", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotEqualTo(String value) {
            addCriterion("short_title <>", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleGreaterThan(String value) {
            addCriterion("short_title >", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleGreaterThanOrEqualTo(String value) {
            addCriterion("short_title >=", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleLessThan(String value) {
            addCriterion("short_title <", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleLessThanOrEqualTo(String value) {
            addCriterion("short_title <=", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleLike(String value) {
            addCriterion("short_title like", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotLike(String value) {
            addCriterion("short_title not like", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleIn(List<String> values) {
            addCriterion("short_title in", values, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotIn(List<String> values) {
            addCriterion("short_title not in", values, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleBetween(String value1, String value2) {
            addCriterion("short_title between", value1, value2, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotBetween(String value1, String value2) {
            addCriterion("short_title not between", value1, value2, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andPictUrlIsNull() {
            addCriterion("pict_url is null");
            return (Criteria) this;
        }

        public Criteria andPictUrlIsNotNull() {
            addCriterion("pict_url is not null");
            return (Criteria) this;
        }

        public Criteria andPictUrlEqualTo(String value) {
            addCriterion("pict_url =", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlNotEqualTo(String value) {
            addCriterion("pict_url <>", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlGreaterThan(String value) {
            addCriterion("pict_url >", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pict_url >=", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlLessThan(String value) {
            addCriterion("pict_url <", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlLessThanOrEqualTo(String value) {
            addCriterion("pict_url <=", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlLike(String value) {
            addCriterion("pict_url like", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlNotLike(String value) {
            addCriterion("pict_url not like", value, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlIn(List<String> values) {
            addCriterion("pict_url in", values, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlNotIn(List<String> values) {
            addCriterion("pict_url not in", values, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlBetween(String value1, String value2) {
            addCriterion("pict_url between", value1, value2, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andPictUrlNotBetween(String value1, String value2) {
            addCriterion("pict_url not between", value1, value2, "pictUrl");
            return (Criteria) this;
        }

        public Criteria andSmallImagesIsNull() {
            addCriterion("small_images is null");
            return (Criteria) this;
        }

        public Criteria andSmallImagesIsNotNull() {
            addCriterion("small_images is not null");
            return (Criteria) this;
        }

        public Criteria andSmallImagesEqualTo(String value) {
            addCriterion("small_images =", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesNotEqualTo(String value) {
            addCriterion("small_images <>", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesGreaterThan(String value) {
            addCriterion("small_images >", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesGreaterThanOrEqualTo(String value) {
            addCriterion("small_images >=", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesLessThan(String value) {
            addCriterion("small_images <", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesLessThanOrEqualTo(String value) {
            addCriterion("small_images <=", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesLike(String value) {
            addCriterion("small_images like", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesNotLike(String value) {
            addCriterion("small_images not like", value, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesIn(List<String> values) {
            addCriterion("small_images in", values, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesNotIn(List<String> values) {
            addCriterion("small_images not in", values, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesBetween(String value1, String value2) {
            addCriterion("small_images between", value1, value2, "smallImages");
            return (Criteria) this;
        }

        public Criteria andSmallImagesNotBetween(String value1, String value2) {
            addCriterion("small_images not between", value1, value2, "smallImages");
            return (Criteria) this;
        }

        public Criteria andClickUrlIsNull() {
            addCriterion("click_url is null");
            return (Criteria) this;
        }

        public Criteria andClickUrlIsNotNull() {
            addCriterion("click_url is not null");
            return (Criteria) this;
        }

        public Criteria andClickUrlEqualTo(String value) {
            addCriterion("click_url =", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotEqualTo(String value) {
            addCriterion("click_url <>", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlGreaterThan(String value) {
            addCriterion("click_url >", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlGreaterThanOrEqualTo(String value) {
            addCriterion("click_url >=", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLessThan(String value) {
            addCriterion("click_url <", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLessThanOrEqualTo(String value) {
            addCriterion("click_url <=", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLike(String value) {
            addCriterion("click_url like", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotLike(String value) {
            addCriterion("click_url not like", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlIn(List<String> values) {
            addCriterion("click_url in", values, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotIn(List<String> values) {
            addCriterion("click_url not in", values, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlBetween(String value1, String value2) {
            addCriterion("click_url between", value1, value2, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotBetween(String value1, String value2) {
            addCriterion("click_url not between", value1, value2, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceIsNull() {
            addCriterion("zk_final_price is null");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceIsNotNull() {
            addCriterion("zk_final_price is not null");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceEqualTo(BigDecimal value) {
            addCriterion("zk_final_price =", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotEqualTo(BigDecimal value) {
            addCriterion("zk_final_price <>", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceGreaterThan(BigDecimal value) {
            addCriterion("zk_final_price >", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zk_final_price >=", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceLessThan(BigDecimal value) {
            addCriterion("zk_final_price <", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zk_final_price <=", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceIn(List<BigDecimal> values) {
            addCriterion("zk_final_price in", values, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotIn(List<BigDecimal> values) {
            addCriterion("zk_final_price not in", values, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zk_final_price between", value1, value2, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zk_final_price not between", value1, value2, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNull() {
            addCriterion("item_description is null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNotNull() {
            addCriterion("item_description is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionEqualTo(String value) {
            addCriterion("item_description =", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotEqualTo(String value) {
            addCriterion("item_description <>", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThan(String value) {
            addCriterion("item_description >", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("item_description >=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThan(String value) {
            addCriterion("item_description <", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThanOrEqualTo(String value) {
            addCriterion("item_description <=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLike(String value) {
            addCriterion("item_description like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotLike(String value) {
            addCriterion("item_description not like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIn(List<String> values) {
            addCriterion("item_description in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotIn(List<String> values) {
            addCriterion("item_description not in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionBetween(String value1, String value2) {
            addCriterion("item_description between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotBetween(String value1, String value2) {
            addCriterion("item_description not between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Integer value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Integer value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Integer value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Integer value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Integer> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Integer> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Integer value1, Integer value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlIsNull() {
            addCriterion("coupon_click_url is null");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlIsNotNull() {
            addCriterion("coupon_click_url is not null");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlEqualTo(String value) {
            addCriterion("coupon_click_url =", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlNotEqualTo(String value) {
            addCriterion("coupon_click_url <>", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlGreaterThan(String value) {
            addCriterion("coupon_click_url >", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_click_url >=", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlLessThan(String value) {
            addCriterion("coupon_click_url <", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlLessThanOrEqualTo(String value) {
            addCriterion("coupon_click_url <=", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlLike(String value) {
            addCriterion("coupon_click_url like", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlNotLike(String value) {
            addCriterion("coupon_click_url not like", value, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlIn(List<String> values) {
            addCriterion("coupon_click_url in", values, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlNotIn(List<String> values) {
            addCriterion("coupon_click_url not in", values, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlBetween(String value1, String value2) {
            addCriterion("coupon_click_url between", value1, value2, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponClickUrlNotBetween(String value1, String value2) {
            addCriterion("coupon_click_url not between", value1, value2, "couponClickUrl");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNull() {
            addCriterion("coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNotNull() {
            addCriterion("coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountEqualTo(BigDecimal value) {
            addCriterion("coupon_amount =", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <>", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThan(BigDecimal value) {
            addCriterion("coupon_amount >", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount >=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThan(BigDecimal value) {
            addCriterion("coupon_amount <", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIn(List<BigDecimal> values) {
            addCriterion("coupon_amount in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotIn(List<BigDecimal> values) {
            addCriterion("coupon_amount not in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount not between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountIsNull() {
            addCriterion("coupon_total_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountIsNotNull() {
            addCriterion("coupon_total_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountEqualTo(Integer value) {
            addCriterion("coupon_total_count =", value, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountNotEqualTo(Integer value) {
            addCriterion("coupon_total_count <>", value, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountGreaterThan(Integer value) {
            addCriterion("coupon_total_count >", value, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_total_count >=", value, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountLessThan(Integer value) {
            addCriterion("coupon_total_count <", value, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_total_count <=", value, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountIn(List<Integer> values) {
            addCriterion("coupon_total_count in", values, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountNotIn(List<Integer> values) {
            addCriterion("coupon_total_count not in", values, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total_count between", value1, value2, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponTotalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total_count not between", value1, value2, "couponTotalCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountIsNull() {
            addCriterion("coupon_remain_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountIsNotNull() {
            addCriterion("coupon_remain_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountEqualTo(Integer value) {
            addCriterion("coupon_remain_count =", value, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountNotEqualTo(Integer value) {
            addCriterion("coupon_remain_count <>", value, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountGreaterThan(Integer value) {
            addCriterion("coupon_remain_count >", value, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_remain_count >=", value, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountLessThan(Integer value) {
            addCriterion("coupon_remain_count <", value, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_remain_count <=", value, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountIn(List<Integer> values) {
            addCriterion("coupon_remain_count in", values, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountNotIn(List<Integer> values) {
            addCriterion("coupon_remain_count not in", values, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_remain_count between", value1, value2, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponRemainCountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_remain_count not between", value1, value2, "couponRemainCount");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeIsNull() {
            addCriterion("coupon_start_fee is null");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeIsNotNull() {
            addCriterion("coupon_start_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeEqualTo(String value) {
            addCriterion("coupon_start_fee =", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeNotEqualTo(String value) {
            addCriterion("coupon_start_fee <>", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeGreaterThan(String value) {
            addCriterion("coupon_start_fee >", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_start_fee >=", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeLessThan(String value) {
            addCriterion("coupon_start_fee <", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeLessThanOrEqualTo(String value) {
            addCriterion("coupon_start_fee <=", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeLike(String value) {
            addCriterion("coupon_start_fee like", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeNotLike(String value) {
            addCriterion("coupon_start_fee not like", value, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeIn(List<String> values) {
            addCriterion("coupon_start_fee in", values, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeNotIn(List<String> values) {
            addCriterion("coupon_start_fee not in", values, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeBetween(String value1, String value2) {
            addCriterion("coupon_start_fee between", value1, value2, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartFeeNotBetween(String value1, String value2) {
            addCriterion("coupon_start_fee not between", value1, value2, "couponStartFee");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNull() {
            addCriterion("coupon_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNotNull() {
            addCriterion("coupon_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeEqualTo(Date value) {
            addCriterion("coupon_start_time =", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotEqualTo(Date value) {
            addCriterion("coupon_start_time <>", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThan(Date value) {
            addCriterion("coupon_start_time >", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_start_time >=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThan(Date value) {
            addCriterion("coupon_start_time <", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_start_time <=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIn(List<Date> values) {
            addCriterion("coupon_start_time in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotIn(List<Date> values) {
            addCriterion("coupon_start_time not in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_start_time between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_start_time not between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeIsNull() {
            addCriterion("coupon_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeIsNotNull() {
            addCriterion("coupon_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeEqualTo(Date value) {
            addCriterion("coupon_end_time =", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeNotEqualTo(Date value) {
            addCriterion("coupon_end_time <>", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeGreaterThan(Date value) {
            addCriterion("coupon_end_time >", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_end_time >=", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeLessThan(Date value) {
            addCriterion("coupon_end_time <", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_end_time <=", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeIn(List<Date> values) {
            addCriterion("coupon_end_time in", values, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeNotIn(List<Date> values) {
            addCriterion("coupon_end_time not in", values, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_end_time between", value1, value2, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_end_time not between", value1, value2, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponInfoIsNull() {
            addCriterion("coupon_info is null");
            return (Criteria) this;
        }

        public Criteria andCouponInfoIsNotNull() {
            addCriterion("coupon_info is not null");
            return (Criteria) this;
        }

        public Criteria andCouponInfoEqualTo(String value) {
            addCriterion("coupon_info =", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoNotEqualTo(String value) {
            addCriterion("coupon_info <>", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoGreaterThan(String value) {
            addCriterion("coupon_info >", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_info >=", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoLessThan(String value) {
            addCriterion("coupon_info <", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoLessThanOrEqualTo(String value) {
            addCriterion("coupon_info <=", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoLike(String value) {
            addCriterion("coupon_info like", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoNotLike(String value) {
            addCriterion("coupon_info not like", value, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoIn(List<String> values) {
            addCriterion("coupon_info in", values, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoNotIn(List<String> values) {
            addCriterion("coupon_info not in", values, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoBetween(String value1, String value2) {
            addCriterion("coupon_info between", value1, value2, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponInfoNotBetween(String value1, String value2) {
            addCriterion("coupon_info not between", value1, value2, "couponInfo");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlIsNull() {
            addCriterion("coupon_share_url is null");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlIsNotNull() {
            addCriterion("coupon_share_url is not null");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlEqualTo(String value) {
            addCriterion("coupon_share_url =", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlNotEqualTo(String value) {
            addCriterion("coupon_share_url <>", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlGreaterThan(String value) {
            addCriterion("coupon_share_url >", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_share_url >=", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlLessThan(String value) {
            addCriterion("coupon_share_url <", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlLessThanOrEqualTo(String value) {
            addCriterion("coupon_share_url <=", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlLike(String value) {
            addCriterion("coupon_share_url like", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlNotLike(String value) {
            addCriterion("coupon_share_url not like", value, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlIn(List<String> values) {
            addCriterion("coupon_share_url in", values, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlNotIn(List<String> values) {
            addCriterion("coupon_share_url not in", values, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlBetween(String value1, String value2) {
            addCriterion("coupon_share_url between", value1, value2, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andCouponShareUrlNotBetween(String value1, String value2) {
            addCriterion("coupon_share_url not between", value1, value2, "couponShareUrl");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andShopTitleIsNull() {
            addCriterion("shop_title is null");
            return (Criteria) this;
        }

        public Criteria andShopTitleIsNotNull() {
            addCriterion("shop_title is not null");
            return (Criteria) this;
        }

        public Criteria andShopTitleEqualTo(String value) {
            addCriterion("shop_title =", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleNotEqualTo(String value) {
            addCriterion("shop_title <>", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleGreaterThan(String value) {
            addCriterion("shop_title >", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleGreaterThanOrEqualTo(String value) {
            addCriterion("shop_title >=", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleLessThan(String value) {
            addCriterion("shop_title <", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleLessThanOrEqualTo(String value) {
            addCriterion("shop_title <=", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleLike(String value) {
            addCriterion("shop_title like", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleNotLike(String value) {
            addCriterion("shop_title not like", value, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleIn(List<String> values) {
            addCriterion("shop_title in", values, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleNotIn(List<String> values) {
            addCriterion("shop_title not in", values, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleBetween(String value1, String value2) {
            addCriterion("shop_title between", value1, value2, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andShopTitleNotBetween(String value1, String value2) {
            addCriterion("shop_title not between", value1, value2, "shopTitle");
            return (Criteria) this;
        }

        public Criteria andNickIsNull() {
            addCriterion("nick is null");
            return (Criteria) this;
        }

        public Criteria andNickIsNotNull() {
            addCriterion("nick is not null");
            return (Criteria) this;
        }

        public Criteria andNickEqualTo(String value) {
            addCriterion("nick =", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotEqualTo(String value) {
            addCriterion("nick <>", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickGreaterThan(String value) {
            addCriterion("nick >", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickGreaterThanOrEqualTo(String value) {
            addCriterion("nick >=", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLessThan(String value) {
            addCriterion("nick <", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLessThanOrEqualTo(String value) {
            addCriterion("nick <=", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLike(String value) {
            addCriterion("nick like", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotLike(String value) {
            addCriterion("nick not like", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickIn(List<String> values) {
            addCriterion("nick in", values, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotIn(List<String> values) {
            addCriterion("nick not in", values, "nick");
            return (Criteria) this;
        }

        public Criteria andNickBetween(String value1, String value2) {
            addCriterion("nick between", value1, value2, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotBetween(String value1, String value2) {
            addCriterion("nick not between", value1, value2, "nick");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdIsNull() {
            addCriterion("level_one_category_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdIsNotNull() {
            addCriterion("level_one_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdEqualTo(String value) {
            addCriterion("level_one_category_id =", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdNotEqualTo(String value) {
            addCriterion("level_one_category_id <>", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdGreaterThan(String value) {
            addCriterion("level_one_category_id >", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("level_one_category_id >=", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdLessThan(String value) {
            addCriterion("level_one_category_id <", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("level_one_category_id <=", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdLike(String value) {
            addCriterion("level_one_category_id like", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdNotLike(String value) {
            addCriterion("level_one_category_id not like", value, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdIn(List<String> values) {
            addCriterion("level_one_category_id in", values, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdNotIn(List<String> values) {
            addCriterion("level_one_category_id not in", values, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdBetween(String value1, String value2) {
            addCriterion("level_one_category_id between", value1, value2, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryIdNotBetween(String value1, String value2) {
            addCriterion("level_one_category_id not between", value1, value2, "levelOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameIsNull() {
            addCriterion("level_one_category_name is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameIsNotNull() {
            addCriterion("level_one_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameEqualTo(String value) {
            addCriterion("level_one_category_name =", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameNotEqualTo(String value) {
            addCriterion("level_one_category_name <>", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameGreaterThan(String value) {
            addCriterion("level_one_category_name >", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("level_one_category_name >=", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameLessThan(String value) {
            addCriterion("level_one_category_name <", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("level_one_category_name <=", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameLike(String value) {
            addCriterion("level_one_category_name like", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameNotLike(String value) {
            addCriterion("level_one_category_name not like", value, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameIn(List<String> values) {
            addCriterion("level_one_category_name in", values, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameNotIn(List<String> values) {
            addCriterion("level_one_category_name not in", values, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameBetween(String value1, String value2) {
            addCriterion("level_one_category_name between", value1, value2, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andLevelOneCategoryNameNotBetween(String value1, String value2) {
            addCriterion("level_one_category_name not between", value1, value2, "levelOneCategoryName");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andSellNumIsNull() {
            addCriterion("sell_num is null");
            return (Criteria) this;
        }

        public Criteria andSellNumIsNotNull() {
            addCriterion("sell_num is not null");
            return (Criteria) this;
        }

        public Criteria andSellNumEqualTo(Integer value) {
            addCriterion("sell_num =", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotEqualTo(Integer value) {
            addCriterion("sell_num <>", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumGreaterThan(Integer value) {
            addCriterion("sell_num >", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_num >=", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumLessThan(Integer value) {
            addCriterion("sell_num <", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumLessThanOrEqualTo(Integer value) {
            addCriterion("sell_num <=", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumIn(List<Integer> values) {
            addCriterion("sell_num in", values, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotIn(List<Integer> values) {
            addCriterion("sell_num not in", values, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumBetween(Integer value1, Integer value2) {
            addCriterion("sell_num between", value1, value2, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_num not between", value1, value2, "sellNum");
            return (Criteria) this;
        }

        public Criteria andTotalStockIsNull() {
            addCriterion("total_stock is null");
            return (Criteria) this;
        }

        public Criteria andTotalStockIsNotNull() {
            addCriterion("total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStockEqualTo(Integer value) {
            addCriterion("total_stock =", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotEqualTo(Integer value) {
            addCriterion("total_stock <>", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockGreaterThan(Integer value) {
            addCriterion("total_stock >", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_stock >=", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockLessThan(Integer value) {
            addCriterion("total_stock <", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("total_stock <=", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockIn(List<Integer> values) {
            addCriterion("total_stock in", values, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotIn(List<Integer> values) {
            addCriterion("total_stock not in", values, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("total_stock between", value1, value2, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("total_stock not between", value1, value2, "totalStock");
            return (Criteria) this;
        }

        public Criteria andOstimeIsNull() {
            addCriterion("ostime is null");
            return (Criteria) this;
        }

        public Criteria andOstimeIsNotNull() {
            addCriterion("ostime is not null");
            return (Criteria) this;
        }

        public Criteria andOstimeEqualTo(String value) {
            addCriterion("ostime =", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeNotEqualTo(String value) {
            addCriterion("ostime <>", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeGreaterThan(String value) {
            addCriterion("ostime >", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeGreaterThanOrEqualTo(String value) {
            addCriterion("ostime >=", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeLessThan(String value) {
            addCriterion("ostime <", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeLessThanOrEqualTo(String value) {
            addCriterion("ostime <=", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeLike(String value) {
            addCriterion("ostime like", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeNotLike(String value) {
            addCriterion("ostime not like", value, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeIn(List<String> values) {
            addCriterion("ostime in", values, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeNotIn(List<String> values) {
            addCriterion("ostime not in", values, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeBetween(String value1, String value2) {
            addCriterion("ostime between", value1, value2, "ostime");
            return (Criteria) this;
        }

        public Criteria andOstimeNotBetween(String value1, String value2) {
            addCriterion("ostime not between", value1, value2, "ostime");
            return (Criteria) this;
        }

        public Criteria andOetimeIsNull() {
            addCriterion("oetime is null");
            return (Criteria) this;
        }

        public Criteria andOetimeIsNotNull() {
            addCriterion("oetime is not null");
            return (Criteria) this;
        }

        public Criteria andOetimeEqualTo(String value) {
            addCriterion("oetime =", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeNotEqualTo(String value) {
            addCriterion("oetime <>", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeGreaterThan(String value) {
            addCriterion("oetime >", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeGreaterThanOrEqualTo(String value) {
            addCriterion("oetime >=", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeLessThan(String value) {
            addCriterion("oetime <", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeLessThanOrEqualTo(String value) {
            addCriterion("oetime <=", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeLike(String value) {
            addCriterion("oetime like", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeNotLike(String value) {
            addCriterion("oetime not like", value, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeIn(List<String> values) {
            addCriterion("oetime in", values, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeNotIn(List<String> values) {
            addCriterion("oetime not in", values, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeBetween(String value1, String value2) {
            addCriterion("oetime between", value1, value2, "oetime");
            return (Criteria) this;
        }

        public Criteria andOetimeNotBetween(String value1, String value2) {
            addCriterion("oetime not between", value1, value2, "oetime");
            return (Criteria) this;
        }

        public Criteria andJddNumIsNull() {
            addCriterion("jdd_num is null");
            return (Criteria) this;
        }

        public Criteria andJddNumIsNotNull() {
            addCriterion("jdd_num is not null");
            return (Criteria) this;
        }

        public Criteria andJddNumEqualTo(Integer value) {
            addCriterion("jdd_num =", value, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumNotEqualTo(Integer value) {
            addCriterion("jdd_num <>", value, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumGreaterThan(Integer value) {
            addCriterion("jdd_num >", value, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("jdd_num >=", value, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumLessThan(Integer value) {
            addCriterion("jdd_num <", value, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumLessThanOrEqualTo(Integer value) {
            addCriterion("jdd_num <=", value, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumIn(List<Integer> values) {
            addCriterion("jdd_num in", values, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumNotIn(List<Integer> values) {
            addCriterion("jdd_num not in", values, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumBetween(Integer value1, Integer value2) {
            addCriterion("jdd_num between", value1, value2, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddNumNotBetween(Integer value1, Integer value2) {
            addCriterion("jdd_num not between", value1, value2, "jddNum");
            return (Criteria) this;
        }

        public Criteria andJddPriceIsNull() {
            addCriterion("jdd_price is null");
            return (Criteria) this;
        }

        public Criteria andJddPriceIsNotNull() {
            addCriterion("jdd_price is not null");
            return (Criteria) this;
        }

        public Criteria andJddPriceEqualTo(String value) {
            addCriterion("jdd_price =", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceNotEqualTo(String value) {
            addCriterion("jdd_price <>", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceGreaterThan(String value) {
            addCriterion("jdd_price >", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceGreaterThanOrEqualTo(String value) {
            addCriterion("jdd_price >=", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceLessThan(String value) {
            addCriterion("jdd_price <", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceLessThanOrEqualTo(String value) {
            addCriterion("jdd_price <=", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceLike(String value) {
            addCriterion("jdd_price like", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceNotLike(String value) {
            addCriterion("jdd_price not like", value, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceIn(List<String> values) {
            addCriterion("jdd_price in", values, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceNotIn(List<String> values) {
            addCriterion("jdd_price not in", values, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceBetween(String value1, String value2) {
            addCriterion("jdd_price between", value1, value2, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andJddPriceNotBetween(String value1, String value2) {
            addCriterion("jdd_price not between", value1, value2, "jddPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceIsNull() {
            addCriterion("orig_price is null");
            return (Criteria) this;
        }

        public Criteria andOrigPriceIsNotNull() {
            addCriterion("orig_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrigPriceEqualTo(String value) {
            addCriterion("orig_price =", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceNotEqualTo(String value) {
            addCriterion("orig_price <>", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceGreaterThan(String value) {
            addCriterion("orig_price >", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceGreaterThanOrEqualTo(String value) {
            addCriterion("orig_price >=", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceLessThan(String value) {
            addCriterion("orig_price <", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceLessThanOrEqualTo(String value) {
            addCriterion("orig_price <=", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceLike(String value) {
            addCriterion("orig_price like", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceNotLike(String value) {
            addCriterion("orig_price not like", value, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceIn(List<String> values) {
            addCriterion("orig_price in", values, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceNotIn(List<String> values) {
            addCriterion("orig_price not in", values, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceBetween(String value1, String value2) {
            addCriterion("orig_price between", value1, value2, "origPrice");
            return (Criteria) this;
        }

        public Criteria andOrigPriceNotBetween(String value1, String value2) {
            addCriterion("orig_price not between", value1, value2, "origPrice");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNull() {
            addCriterion("commission_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNotNull() {
            addCriterion("commission_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateEqualTo(String value) {
            addCriterion("commission_rate =", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotEqualTo(String value) {
            addCriterion("commission_rate <>", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThan(String value) {
            addCriterion("commission_rate >", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThanOrEqualTo(String value) {
            addCriterion("commission_rate >=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThan(String value) {
            addCriterion("commission_rate <", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThanOrEqualTo(String value) {
            addCriterion("commission_rate <=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLike(String value) {
            addCriterion("commission_rate like", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotLike(String value) {
            addCriterion("commission_rate not like", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIn(List<String> values) {
            addCriterion("commission_rate in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotIn(List<String> values) {
            addCriterion("commission_rate not in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateBetween(String value1, String value2) {
            addCriterion("commission_rate between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotBetween(String value1, String value2) {
            addCriterion("commission_rate not between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andWordUrlIsNull() {
            addCriterion("word_url is null");
            return (Criteria) this;
        }

        public Criteria andWordUrlIsNotNull() {
            addCriterion("word_url is not null");
            return (Criteria) this;
        }

        public Criteria andWordUrlEqualTo(String value) {
            addCriterion("word_url =", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlNotEqualTo(String value) {
            addCriterion("word_url <>", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlGreaterThan(String value) {
            addCriterion("word_url >", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlGreaterThanOrEqualTo(String value) {
            addCriterion("word_url >=", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlLessThan(String value) {
            addCriterion("word_url <", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlLessThanOrEqualTo(String value) {
            addCriterion("word_url <=", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlLike(String value) {
            addCriterion("word_url like", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlNotLike(String value) {
            addCriterion("word_url not like", value, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlIn(List<String> values) {
            addCriterion("word_url in", values, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlNotIn(List<String> values) {
            addCriterion("word_url not in", values, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlBetween(String value1, String value2) {
            addCriterion("word_url between", value1, value2, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordUrlNotBetween(String value1, String value2) {
            addCriterion("word_url not between", value1, value2, "wordUrl");
            return (Criteria) this;
        }

        public Criteria andWordIsNull() {
            addCriterion("word is null");
            return (Criteria) this;
        }

        public Criteria andWordIsNotNull() {
            addCriterion("word is not null");
            return (Criteria) this;
        }

        public Criteria andWordEqualTo(String value) {
            addCriterion("word =", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotEqualTo(String value) {
            addCriterion("word <>", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThan(String value) {
            addCriterion("word >", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThanOrEqualTo(String value) {
            addCriterion("word >=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThan(String value) {
            addCriterion("word <", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThanOrEqualTo(String value) {
            addCriterion("word <=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLike(String value) {
            addCriterion("word like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotLike(String value) {
            addCriterion("word not like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordIn(List<String> values) {
            addCriterion("word in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotIn(List<String> values) {
            addCriterion("word not in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordBetween(String value1, String value2) {
            addCriterion("word between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotBetween(String value1, String value2) {
            addCriterion("word not between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoIsNull() {
            addCriterion("tmall_play_activity_info is null");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoIsNotNull() {
            addCriterion("tmall_play_activity_info is not null");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoEqualTo(String value) {
            addCriterion("tmall_play_activity_info =", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoNotEqualTo(String value) {
            addCriterion("tmall_play_activity_info <>", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoGreaterThan(String value) {
            addCriterion("tmall_play_activity_info >", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_play_activity_info >=", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoLessThan(String value) {
            addCriterion("tmall_play_activity_info <", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoLessThanOrEqualTo(String value) {
            addCriterion("tmall_play_activity_info <=", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoLike(String value) {
            addCriterion("tmall_play_activity_info like", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoNotLike(String value) {
            addCriterion("tmall_play_activity_info not like", value, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoIn(List<String> values) {
            addCriterion("tmall_play_activity_info in", values, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoNotIn(List<String> values) {
            addCriterion("tmall_play_activity_info not in", values, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoBetween(String value1, String value2) {
            addCriterion("tmall_play_activity_info between", value1, value2, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andTmallPlayActivityInfoNotBetween(String value1, String value2) {
            addCriterion("tmall_play_activity_info not between", value1, value2, "tmallPlayActivityInfo");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleIsNull() {
            addCriterion("uv_sum_pre_sale is null");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleIsNotNull() {
            addCriterion("uv_sum_pre_sale is not null");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleEqualTo(Integer value) {
            addCriterion("uv_sum_pre_sale =", value, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleNotEqualTo(Integer value) {
            addCriterion("uv_sum_pre_sale <>", value, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleGreaterThan(Integer value) {
            addCriterion("uv_sum_pre_sale >", value, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("uv_sum_pre_sale >=", value, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleLessThan(Integer value) {
            addCriterion("uv_sum_pre_sale <", value, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleLessThanOrEqualTo(Integer value) {
            addCriterion("uv_sum_pre_sale <=", value, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleIn(List<Integer> values) {
            addCriterion("uv_sum_pre_sale in", values, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleNotIn(List<Integer> values) {
            addCriterion("uv_sum_pre_sale not in", values, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleBetween(Integer value1, Integer value2) {
            addCriterion("uv_sum_pre_sale between", value1, value2, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andUvSumPreSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("uv_sum_pre_sale not between", value1, value2, "uvSumPreSale");
            return (Criteria) this;
        }

        public Criteria andXIdIsNull() {
            addCriterion("x_id is null");
            return (Criteria) this;
        }

        public Criteria andXIdIsNotNull() {
            addCriterion("x_id is not null");
            return (Criteria) this;
        }

        public Criteria andXIdEqualTo(String value) {
            addCriterion("x_id =", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdNotEqualTo(String value) {
            addCriterion("x_id <>", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdGreaterThan(String value) {
            addCriterion("x_id >", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdGreaterThanOrEqualTo(String value) {
            addCriterion("x_id >=", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdLessThan(String value) {
            addCriterion("x_id <", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdLessThanOrEqualTo(String value) {
            addCriterion("x_id <=", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdLike(String value) {
            addCriterion("x_id like", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdNotLike(String value) {
            addCriterion("x_id not like", value, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdIn(List<String> values) {
            addCriterion("x_id in", values, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdNotIn(List<String> values) {
            addCriterion("x_id not in", values, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdBetween(String value1, String value2) {
            addCriterion("x_id between", value1, value2, "xId");
            return (Criteria) this;
        }

        public Criteria andXIdNotBetween(String value1, String value2) {
            addCriterion("x_id not between", value1, value2, "xId");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceIsNull() {
            addCriterion("new_user_price is null");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceIsNotNull() {
            addCriterion("new_user_price is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceEqualTo(String value) {
            addCriterion("new_user_price =", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceNotEqualTo(String value) {
            addCriterion("new_user_price <>", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceGreaterThan(String value) {
            addCriterion("new_user_price >", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceGreaterThanOrEqualTo(String value) {
            addCriterion("new_user_price >=", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceLessThan(String value) {
            addCriterion("new_user_price <", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceLessThanOrEqualTo(String value) {
            addCriterion("new_user_price <=", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceLike(String value) {
            addCriterion("new_user_price like", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceNotLike(String value) {
            addCriterion("new_user_price not like", value, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceIn(List<String> values) {
            addCriterion("new_user_price in", values, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceNotIn(List<String> values) {
            addCriterion("new_user_price not in", values, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceBetween(String value1, String value2) {
            addCriterion("new_user_price between", value1, value2, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andNewUserPriceNotBetween(String value1, String value2) {
            addCriterion("new_user_price not between", value1, value2, "newUserPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}