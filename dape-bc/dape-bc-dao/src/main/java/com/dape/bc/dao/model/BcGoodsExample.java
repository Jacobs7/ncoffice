package com.dape.bc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BcGoodsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BcGoodsExample() {
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

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Boolean value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Boolean value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Boolean value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Boolean value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Boolean> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Boolean> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
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

        public Criteria andDescImgsIsNull() {
            addCriterion("desc_imgs is null");
            return (Criteria) this;
        }

        public Criteria andDescImgsIsNotNull() {
            addCriterion("desc_imgs is not null");
            return (Criteria) this;
        }

        public Criteria andDescImgsEqualTo(String value) {
            addCriterion("desc_imgs =", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsNotEqualTo(String value) {
            addCriterion("desc_imgs <>", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsGreaterThan(String value) {
            addCriterion("desc_imgs >", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsGreaterThanOrEqualTo(String value) {
            addCriterion("desc_imgs >=", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsLessThan(String value) {
            addCriterion("desc_imgs <", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsLessThanOrEqualTo(String value) {
            addCriterion("desc_imgs <=", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsLike(String value) {
            addCriterion("desc_imgs like", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsNotLike(String value) {
            addCriterion("desc_imgs not like", value, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsIn(List<String> values) {
            addCriterion("desc_imgs in", values, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsNotIn(List<String> values) {
            addCriterion("desc_imgs not in", values, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsBetween(String value1, String value2) {
            addCriterion("desc_imgs between", value1, value2, "descImgs");
            return (Criteria) this;
        }

        public Criteria andDescImgsNotBetween(String value1, String value2) {
            addCriterion("desc_imgs not between", value1, value2, "descImgs");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeIsNull() {
            addCriterion("hqzb_type is null");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeIsNotNull() {
            addCriterion("hqzb_type is not null");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeEqualTo(Integer value) {
            addCriterion("hqzb_type =", value, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeNotEqualTo(Integer value) {
            addCriterion("hqzb_type <>", value, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeGreaterThan(Integer value) {
            addCriterion("hqzb_type >", value, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hqzb_type >=", value, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeLessThan(Integer value) {
            addCriterion("hqzb_type <", value, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeLessThanOrEqualTo(Integer value) {
            addCriterion("hqzb_type <=", value, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeIn(List<Integer> values) {
            addCriterion("hqzb_type in", values, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeNotIn(List<Integer> values) {
            addCriterion("hqzb_type not in", values, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeBetween(Integer value1, Integer value2) {
            addCriterion("hqzb_type between", value1, value2, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andHqzbTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("hqzb_type not between", value1, value2, "hqzbType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeIsNull() {
            addCriterion("deq_type is null");
            return (Criteria) this;
        }

        public Criteria andDeqTypeIsNotNull() {
            addCriterion("deq_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeqTypeEqualTo(Integer value) {
            addCriterion("deq_type =", value, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeNotEqualTo(Integer value) {
            addCriterion("deq_type <>", value, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeGreaterThan(Integer value) {
            addCriterion("deq_type >", value, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deq_type >=", value, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeLessThan(Integer value) {
            addCriterion("deq_type <", value, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeLessThanOrEqualTo(Integer value) {
            addCriterion("deq_type <=", value, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeIn(List<Integer> values) {
            addCriterion("deq_type in", values, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeNotIn(List<Integer> values) {
            addCriterion("deq_type not in", values, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeBetween(Integer value1, Integer value2) {
            addCriterion("deq_type between", value1, value2, "deqType");
            return (Criteria) this;
        }

        public Criteria andDeqTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deq_type not between", value1, value2, "deqType");
            return (Criteria) this;
        }

        public Criteria andGybTypeIsNull() {
            addCriterion("gyb_type is null");
            return (Criteria) this;
        }

        public Criteria andGybTypeIsNotNull() {
            addCriterion("gyb_type is not null");
            return (Criteria) this;
        }

        public Criteria andGybTypeEqualTo(Integer value) {
            addCriterion("gyb_type =", value, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeNotEqualTo(Integer value) {
            addCriterion("gyb_type <>", value, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeGreaterThan(Integer value) {
            addCriterion("gyb_type >", value, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("gyb_type >=", value, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeLessThan(Integer value) {
            addCriterion("gyb_type <", value, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeLessThanOrEqualTo(Integer value) {
            addCriterion("gyb_type <=", value, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeIn(List<Integer> values) {
            addCriterion("gyb_type in", values, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeNotIn(List<Integer> values) {
            addCriterion("gyb_type not in", values, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeBetween(Integer value1, Integer value2) {
            addCriterion("gyb_type between", value1, value2, "gybType");
            return (Criteria) this;
        }

        public Criteria andGybTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("gyb_type not between", value1, value2, "gybType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeIsNull() {
            addCriterion("ppq_type is null");
            return (Criteria) this;
        }

        public Criteria andPpqTypeIsNotNull() {
            addCriterion("ppq_type is not null");
            return (Criteria) this;
        }

        public Criteria andPpqTypeEqualTo(Integer value) {
            addCriterion("ppq_type =", value, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeNotEqualTo(Integer value) {
            addCriterion("ppq_type <>", value, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeGreaterThan(Integer value) {
            addCriterion("ppq_type >", value, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ppq_type >=", value, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeLessThan(Integer value) {
            addCriterion("ppq_type <", value, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ppq_type <=", value, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeIn(List<Integer> values) {
            addCriterion("ppq_type in", values, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeNotIn(List<Integer> values) {
            addCriterion("ppq_type not in", values, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeBetween(Integer value1, Integer value2) {
            addCriterion("ppq_type between", value1, value2, "ppqType");
            return (Criteria) this;
        }

        public Criteria andPpqTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ppq_type not between", value1, value2, "ppqType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeIsNull() {
            addCriterion("myzt_type is null");
            return (Criteria) this;
        }

        public Criteria andMyztTypeIsNotNull() {
            addCriterion("myzt_type is not null");
            return (Criteria) this;
        }

        public Criteria andMyztTypeEqualTo(Integer value) {
            addCriterion("myzt_type =", value, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeNotEqualTo(Integer value) {
            addCriterion("myzt_type <>", value, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeGreaterThan(Integer value) {
            addCriterion("myzt_type >", value, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("myzt_type >=", value, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeLessThan(Integer value) {
            addCriterion("myzt_type <", value, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeLessThanOrEqualTo(Integer value) {
            addCriterion("myzt_type <=", value, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeIn(List<Integer> values) {
            addCriterion("myzt_type in", values, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeNotIn(List<Integer> values) {
            addCriterion("myzt_type not in", values, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeBetween(Integer value1, Integer value2) {
            addCriterion("myzt_type between", value1, value2, "myztType");
            return (Criteria) this;
        }

        public Criteria andMyztTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("myzt_type not between", value1, value2, "myztType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeIsNull() {
            addCriterion("jhs_type is null");
            return (Criteria) this;
        }

        public Criteria andJhsTypeIsNotNull() {
            addCriterion("jhs_type is not null");
            return (Criteria) this;
        }

        public Criteria andJhsTypeEqualTo(Integer value) {
            addCriterion("jhs_type =", value, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeNotEqualTo(Integer value) {
            addCriterion("jhs_type <>", value, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeGreaterThan(Integer value) {
            addCriterion("jhs_type >", value, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jhs_type >=", value, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeLessThan(Integer value) {
            addCriterion("jhs_type <", value, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("jhs_type <=", value, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeIn(List<Integer> values) {
            addCriterion("jhs_type in", values, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeNotIn(List<Integer> values) {
            addCriterion("jhs_type not in", values, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeBetween(Integer value1, Integer value2) {
            addCriterion("jhs_type between", value1, value2, "jhsType");
            return (Criteria) this;
        }

        public Criteria andJhsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("jhs_type not between", value1, value2, "jhsType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeIsNull() {
            addCriterion("yhh_type is null");
            return (Criteria) this;
        }

        public Criteria andYhhTypeIsNotNull() {
            addCriterion("yhh_type is not null");
            return (Criteria) this;
        }

        public Criteria andYhhTypeEqualTo(Integer value) {
            addCriterion("yhh_type =", value, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeNotEqualTo(Integer value) {
            addCriterion("yhh_type <>", value, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeGreaterThan(Integer value) {
            addCriterion("yhh_type >", value, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("yhh_type >=", value, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeLessThan(Integer value) {
            addCriterion("yhh_type <", value, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeLessThanOrEqualTo(Integer value) {
            addCriterion("yhh_type <=", value, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeIn(List<Integer> values) {
            addCriterion("yhh_type in", values, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeNotIn(List<Integer> values) {
            addCriterion("yhh_type not in", values, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeBetween(Integer value1, Integer value2) {
            addCriterion("yhh_type between", value1, value2, "yhhType");
            return (Criteria) this;
        }

        public Criteria andYhhTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("yhh_type not between", value1, value2, "yhhType");
            return (Criteria) this;
        }

        public Criteria andClfTypeIsNull() {
            addCriterion("clf_type is null");
            return (Criteria) this;
        }

        public Criteria andClfTypeIsNotNull() {
            addCriterion("clf_type is not null");
            return (Criteria) this;
        }

        public Criteria andClfTypeEqualTo(Integer value) {
            addCriterion("clf_type =", value, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeNotEqualTo(Integer value) {
            addCriterion("clf_type <>", value, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeGreaterThan(Integer value) {
            addCriterion("clf_type >", value, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("clf_type >=", value, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeLessThan(Integer value) {
            addCriterion("clf_type <", value, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeLessThanOrEqualTo(Integer value) {
            addCriterion("clf_type <=", value, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeIn(List<Integer> values) {
            addCriterion("clf_type in", values, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeNotIn(List<Integer> values) {
            addCriterion("clf_type not in", values, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeBetween(Integer value1, Integer value2) {
            addCriterion("clf_type between", value1, value2, "clfType");
            return (Criteria) this;
        }

        public Criteria andClfTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("clf_type not between", value1, value2, "clfType");
            return (Criteria) this;
        }

        public Criteria andThTypeIsNull() {
            addCriterion("th_type is null");
            return (Criteria) this;
        }

        public Criteria andThTypeIsNotNull() {
            addCriterion("th_type is not null");
            return (Criteria) this;
        }

        public Criteria andThTypeEqualTo(Integer value) {
            addCriterion("th_type =", value, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeNotEqualTo(Integer value) {
            addCriterion("th_type <>", value, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeGreaterThan(Integer value) {
            addCriterion("th_type >", value, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("th_type >=", value, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeLessThan(Integer value) {
            addCriterion("th_type <", value, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeLessThanOrEqualTo(Integer value) {
            addCriterion("th_type <=", value, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeIn(List<Integer> values) {
            addCriterion("th_type in", values, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeNotIn(List<Integer> values) {
            addCriterion("th_type not in", values, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeBetween(Integer value1, Integer value2) {
            addCriterion("th_type between", value1, value2, "thType");
            return (Criteria) this;
        }

        public Criteria andThTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("th_type not between", value1, value2, "thType");
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