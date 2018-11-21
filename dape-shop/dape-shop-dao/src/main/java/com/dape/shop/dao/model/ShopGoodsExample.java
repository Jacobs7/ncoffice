package com.dape.shop.dao.model;

import java.io.Serializable;
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

        public Criteria andNumIidIsNull() {
            addCriterion("num_iid is null");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNotNull() {
            addCriterion("num_iid is not null");
            return (Criteria) this;
        }

        public Criteria andNumIidEqualTo(String value) {
            addCriterion("num_iid =", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotEqualTo(String value) {
            addCriterion("num_iid <>", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThan(String value) {
            addCriterion("num_iid >", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(String value) {
            addCriterion("num_iid >=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThan(String value) {
            addCriterion("num_iid <", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThanOrEqualTo(String value) {
            addCriterion("num_iid <=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLike(String value) {
            addCriterion("num_iid like", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotLike(String value) {
            addCriterion("num_iid not like", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidIn(List<String> values) {
            addCriterion("num_iid in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotIn(List<String> values) {
            addCriterion("num_iid not in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidBetween(String value1, String value2) {
            addCriterion("num_iid between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotBetween(String value1, String value2) {
            addCriterion("num_iid not between", value1, value2, "numIid");
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

        public Criteria andReservePriceIsNull() {
            addCriterion("reserve_price is null");
            return (Criteria) this;
        }

        public Criteria andReservePriceIsNotNull() {
            addCriterion("reserve_price is not null");
            return (Criteria) this;
        }

        public Criteria andReservePriceEqualTo(String value) {
            addCriterion("reserve_price =", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotEqualTo(String value) {
            addCriterion("reserve_price <>", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThan(String value) {
            addCriterion("reserve_price >", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_price >=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThan(String value) {
            addCriterion("reserve_price <", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThanOrEqualTo(String value) {
            addCriterion("reserve_price <=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLike(String value) {
            addCriterion("reserve_price like", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotLike(String value) {
            addCriterion("reserve_price not like", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceIn(List<String> values) {
            addCriterion("reserve_price in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotIn(List<String> values) {
            addCriterion("reserve_price not in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceBetween(String value1, String value2) {
            addCriterion("reserve_price between", value1, value2, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotBetween(String value1, String value2) {
            addCriterion("reserve_price not between", value1, value2, "reservePrice");
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

        public Criteria andZkFinalPriceEqualTo(String value) {
            addCriterion("zk_final_price =", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotEqualTo(String value) {
            addCriterion("zk_final_price <>", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceGreaterThan(String value) {
            addCriterion("zk_final_price >", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("zk_final_price >=", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceLessThan(String value) {
            addCriterion("zk_final_price <", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceLessThanOrEqualTo(String value) {
            addCriterion("zk_final_price <=", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceLike(String value) {
            addCriterion("zk_final_price like", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotLike(String value) {
            addCriterion("zk_final_price not like", value, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceIn(List<String> values) {
            addCriterion("zk_final_price in", values, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotIn(List<String> values) {
            addCriterion("zk_final_price not in", values, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceBetween(String value1, String value2) {
            addCriterion("zk_final_price between", value1, value2, "zkFinalPrice");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceNotBetween(String value1, String value2) {
            addCriterion("zk_final_price not between", value1, value2, "zkFinalPrice");
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

        public Criteria andProvcityIsNull() {
            addCriterion("provcity is null");
            return (Criteria) this;
        }

        public Criteria andProvcityIsNotNull() {
            addCriterion("provcity is not null");
            return (Criteria) this;
        }

        public Criteria andProvcityEqualTo(String value) {
            addCriterion("provcity =", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityNotEqualTo(String value) {
            addCriterion("provcity <>", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityGreaterThan(String value) {
            addCriterion("provcity >", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityGreaterThanOrEqualTo(String value) {
            addCriterion("provcity >=", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityLessThan(String value) {
            addCriterion("provcity <", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityLessThanOrEqualTo(String value) {
            addCriterion("provcity <=", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityLike(String value) {
            addCriterion("provcity like", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityNotLike(String value) {
            addCriterion("provcity not like", value, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityIn(List<String> values) {
            addCriterion("provcity in", values, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityNotIn(List<String> values) {
            addCriterion("provcity not in", values, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityBetween(String value1, String value2) {
            addCriterion("provcity between", value1, value2, "provcity");
            return (Criteria) this;
        }

        public Criteria andProvcityNotBetween(String value1, String value2) {
            addCriterion("provcity not between", value1, value2, "provcity");
            return (Criteria) this;
        }

        public Criteria andItemUrlIsNull() {
            addCriterion("item_url is null");
            return (Criteria) this;
        }

        public Criteria andItemUrlIsNotNull() {
            addCriterion("item_url is not null");
            return (Criteria) this;
        }

        public Criteria andItemUrlEqualTo(String value) {
            addCriterion("item_url =", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotEqualTo(String value) {
            addCriterion("item_url <>", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlGreaterThan(String value) {
            addCriterion("item_url >", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlGreaterThanOrEqualTo(String value) {
            addCriterion("item_url >=", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlLessThan(String value) {
            addCriterion("item_url <", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlLessThanOrEqualTo(String value) {
            addCriterion("item_url <=", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlLike(String value) {
            addCriterion("item_url like", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotLike(String value) {
            addCriterion("item_url not like", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlIn(List<String> values) {
            addCriterion("item_url in", values, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotIn(List<String> values) {
            addCriterion("item_url not in", values, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlBetween(String value1, String value2) {
            addCriterion("item_url between", value1, value2, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotBetween(String value1, String value2) {
            addCriterion("item_url not between", value1, value2, "itemUrl");
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

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(Integer value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(Integer value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(Integer value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(Integer value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(Integer value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<Integer> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<Integer> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(Integer value1, Integer value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
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

        public Criteria andCatLeafNameIsNull() {
            addCriterion("cat_leaf_name is null");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameIsNotNull() {
            addCriterion("cat_leaf_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameEqualTo(String value) {
            addCriterion("cat_leaf_name =", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameNotEqualTo(String value) {
            addCriterion("cat_leaf_name <>", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameGreaterThan(String value) {
            addCriterion("cat_leaf_name >", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameGreaterThanOrEqualTo(String value) {
            addCriterion("cat_leaf_name >=", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameLessThan(String value) {
            addCriterion("cat_leaf_name <", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameLessThanOrEqualTo(String value) {
            addCriterion("cat_leaf_name <=", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameLike(String value) {
            addCriterion("cat_leaf_name like", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameNotLike(String value) {
            addCriterion("cat_leaf_name not like", value, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameIn(List<String> values) {
            addCriterion("cat_leaf_name in", values, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameNotIn(List<String> values) {
            addCriterion("cat_leaf_name not in", values, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameBetween(String value1, String value2) {
            addCriterion("cat_leaf_name between", value1, value2, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andCatLeafNameNotBetween(String value1, String value2) {
            addCriterion("cat_leaf_name not between", value1, value2, "catLeafName");
            return (Criteria) this;
        }

        public Criteria andIsPrepayIsNull() {
            addCriterion("is_prepay is null");
            return (Criteria) this;
        }

        public Criteria andIsPrepayIsNotNull() {
            addCriterion("is_prepay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrepayEqualTo(Boolean value) {
            addCriterion("is_prepay =", value, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayNotEqualTo(Boolean value) {
            addCriterion("is_prepay <>", value, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayGreaterThan(Boolean value) {
            addCriterion("is_prepay >", value, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_prepay >=", value, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayLessThan(Boolean value) {
            addCriterion("is_prepay <", value, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayLessThanOrEqualTo(Boolean value) {
            addCriterion("is_prepay <=", value, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayIn(List<Boolean> values) {
            addCriterion("is_prepay in", values, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayNotIn(List<Boolean> values) {
            addCriterion("is_prepay not in", values, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prepay between", value1, value2, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andIsPrepayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prepay not between", value1, value2, "isPrepay");
            return (Criteria) this;
        }

        public Criteria andShopDsrIsNull() {
            addCriterion("shop_dsr is null");
            return (Criteria) this;
        }

        public Criteria andShopDsrIsNotNull() {
            addCriterion("shop_dsr is not null");
            return (Criteria) this;
        }

        public Criteria andShopDsrEqualTo(Integer value) {
            addCriterion("shop_dsr =", value, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrNotEqualTo(Integer value) {
            addCriterion("shop_dsr <>", value, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrGreaterThan(Integer value) {
            addCriterion("shop_dsr >", value, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_dsr >=", value, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrLessThan(Integer value) {
            addCriterion("shop_dsr <", value, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrLessThanOrEqualTo(Integer value) {
            addCriterion("shop_dsr <=", value, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrIn(List<Integer> values) {
            addCriterion("shop_dsr in", values, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrNotIn(List<Integer> values) {
            addCriterion("shop_dsr not in", values, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrBetween(Integer value1, Integer value2) {
            addCriterion("shop_dsr between", value1, value2, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andShopDsrNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_dsr not between", value1, value2, "shopDsr");
            return (Criteria) this;
        }

        public Criteria andRatesumIsNull() {
            addCriterion("ratesum is null");
            return (Criteria) this;
        }

        public Criteria andRatesumIsNotNull() {
            addCriterion("ratesum is not null");
            return (Criteria) this;
        }

        public Criteria andRatesumEqualTo(Integer value) {
            addCriterion("ratesum =", value, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumNotEqualTo(Integer value) {
            addCriterion("ratesum <>", value, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumGreaterThan(Integer value) {
            addCriterion("ratesum >", value, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ratesum >=", value, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumLessThan(Integer value) {
            addCriterion("ratesum <", value, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumLessThanOrEqualTo(Integer value) {
            addCriterion("ratesum <=", value, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumIn(List<Integer> values) {
            addCriterion("ratesum in", values, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumNotIn(List<Integer> values) {
            addCriterion("ratesum not in", values, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumBetween(Integer value1, Integer value2) {
            addCriterion("ratesum between", value1, value2, "ratesum");
            return (Criteria) this;
        }

        public Criteria andRatesumNotBetween(Integer value1, Integer value2) {
            addCriterion("ratesum not between", value1, value2, "ratesum");
            return (Criteria) this;
        }

        public Criteria andIRfdRateIsNull() {
            addCriterion("i_rfd_rate is null");
            return (Criteria) this;
        }

        public Criteria andIRfdRateIsNotNull() {
            addCriterion("i_rfd_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIRfdRateEqualTo(Boolean value) {
            addCriterion("i_rfd_rate =", value, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateNotEqualTo(Boolean value) {
            addCriterion("i_rfd_rate <>", value, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateGreaterThan(Boolean value) {
            addCriterion("i_rfd_rate >", value, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("i_rfd_rate >=", value, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateLessThan(Boolean value) {
            addCriterion("i_rfd_rate <", value, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateLessThanOrEqualTo(Boolean value) {
            addCriterion("i_rfd_rate <=", value, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateIn(List<Boolean> values) {
            addCriterion("i_rfd_rate in", values, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateNotIn(List<Boolean> values) {
            addCriterion("i_rfd_rate not in", values, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateBetween(Boolean value1, Boolean value2) {
            addCriterion("i_rfd_rate between", value1, value2, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andIRfdRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("i_rfd_rate not between", value1, value2, "iRfdRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateIsNull() {
            addCriterion("h_good_rate is null");
            return (Criteria) this;
        }

        public Criteria andHGoodRateIsNotNull() {
            addCriterion("h_good_rate is not null");
            return (Criteria) this;
        }

        public Criteria andHGoodRateEqualTo(Boolean value) {
            addCriterion("h_good_rate =", value, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateNotEqualTo(Boolean value) {
            addCriterion("h_good_rate <>", value, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateGreaterThan(Boolean value) {
            addCriterion("h_good_rate >", value, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("h_good_rate >=", value, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateLessThan(Boolean value) {
            addCriterion("h_good_rate <", value, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateLessThanOrEqualTo(Boolean value) {
            addCriterion("h_good_rate <=", value, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateIn(List<Boolean> values) {
            addCriterion("h_good_rate in", values, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateNotIn(List<Boolean> values) {
            addCriterion("h_good_rate not in", values, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateBetween(Boolean value1, Boolean value2) {
            addCriterion("h_good_rate between", value1, value2, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHGoodRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("h_good_rate not between", value1, value2, "hGoodRate");
            return (Criteria) this;
        }

        public Criteria andHPayRate30IsNull() {
            addCriterion("h_pay_rate30 is null");
            return (Criteria) this;
        }

        public Criteria andHPayRate30IsNotNull() {
            addCriterion("h_pay_rate30 is not null");
            return (Criteria) this;
        }

        public Criteria andHPayRate30EqualTo(Boolean value) {
            addCriterion("h_pay_rate30 =", value, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30NotEqualTo(Boolean value) {
            addCriterion("h_pay_rate30 <>", value, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30GreaterThan(Boolean value) {
            addCriterion("h_pay_rate30 >", value, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30GreaterThanOrEqualTo(Boolean value) {
            addCriterion("h_pay_rate30 >=", value, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30LessThan(Boolean value) {
            addCriterion("h_pay_rate30 <", value, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30LessThanOrEqualTo(Boolean value) {
            addCriterion("h_pay_rate30 <=", value, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30In(List<Boolean> values) {
            addCriterion("h_pay_rate30 in", values, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30NotIn(List<Boolean> values) {
            addCriterion("h_pay_rate30 not in", values, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30Between(Boolean value1, Boolean value2) {
            addCriterion("h_pay_rate30 between", value1, value2, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andHPayRate30NotBetween(Boolean value1, Boolean value2) {
            addCriterion("h_pay_rate30 not between", value1, value2, "hPayRate30");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentIsNull() {
            addCriterion("free_shipment is null");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentIsNotNull() {
            addCriterion("free_shipment is not null");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentEqualTo(Boolean value) {
            addCriterion("free_shipment =", value, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentNotEqualTo(Boolean value) {
            addCriterion("free_shipment <>", value, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentGreaterThan(Boolean value) {
            addCriterion("free_shipment >", value, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("free_shipment >=", value, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentLessThan(Boolean value) {
            addCriterion("free_shipment <", value, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentLessThanOrEqualTo(Boolean value) {
            addCriterion("free_shipment <=", value, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentIn(List<Boolean> values) {
            addCriterion("free_shipment in", values, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentNotIn(List<Boolean> values) {
            addCriterion("free_shipment not in", values, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentBetween(Boolean value1, Boolean value2) {
            addCriterion("free_shipment between", value1, value2, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andFreeShipmentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("free_shipment not between", value1, value2, "freeShipment");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeIsNull() {
            addCriterion("material_lib_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeIsNotNull() {
            addCriterion("material_lib_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeEqualTo(String value) {
            addCriterion("material_lib_type =", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeNotEqualTo(String value) {
            addCriterion("material_lib_type <>", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeGreaterThan(String value) {
            addCriterion("material_lib_type >", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_lib_type >=", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeLessThan(String value) {
            addCriterion("material_lib_type <", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeLessThanOrEqualTo(String value) {
            addCriterion("material_lib_type <=", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeLike(String value) {
            addCriterion("material_lib_type like", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeNotLike(String value) {
            addCriterion("material_lib_type not like", value, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeIn(List<String> values) {
            addCriterion("material_lib_type in", values, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeNotIn(List<String> values) {
            addCriterion("material_lib_type not in", values, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeBetween(String value1, String value2) {
            addCriterion("material_lib_type between", value1, value2, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andMaterialLibTypeNotBetween(String value1, String value2) {
            addCriterion("material_lib_type not between", value1, value2, "materialLibType");
            return (Criteria) this;
        }

        public Criteria andTkRateIsNull() {
            addCriterion("tk_rate is null");
            return (Criteria) this;
        }

        public Criteria andTkRateIsNotNull() {
            addCriterion("tk_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTkRateEqualTo(String value) {
            addCriterion("tk_rate =", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateNotEqualTo(String value) {
            addCriterion("tk_rate <>", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateGreaterThan(String value) {
            addCriterion("tk_rate >", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateGreaterThanOrEqualTo(String value) {
            addCriterion("tk_rate >=", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateLessThan(String value) {
            addCriterion("tk_rate <", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateLessThanOrEqualTo(String value) {
            addCriterion("tk_rate <=", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateLike(String value) {
            addCriterion("tk_rate like", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateNotLike(String value) {
            addCriterion("tk_rate not like", value, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateIn(List<String> values) {
            addCriterion("tk_rate in", values, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateNotIn(List<String> values) {
            addCriterion("tk_rate not in", values, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateBetween(String value1, String value2) {
            addCriterion("tk_rate between", value1, value2, "tkRate");
            return (Criteria) this;
        }

        public Criteria andTkRateNotBetween(String value1, String value2) {
            addCriterion("tk_rate not between", value1, value2, "tkRate");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapIsNull() {
            addCriterion("zk_final_price_wap is null");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapIsNotNull() {
            addCriterion("zk_final_price_wap is not null");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapEqualTo(String value) {
            addCriterion("zk_final_price_wap =", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapNotEqualTo(String value) {
            addCriterion("zk_final_price_wap <>", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapGreaterThan(String value) {
            addCriterion("zk_final_price_wap >", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapGreaterThanOrEqualTo(String value) {
            addCriterion("zk_final_price_wap >=", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapLessThan(String value) {
            addCriterion("zk_final_price_wap <", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapLessThanOrEqualTo(String value) {
            addCriterion("zk_final_price_wap <=", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapLike(String value) {
            addCriterion("zk_final_price_wap like", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapNotLike(String value) {
            addCriterion("zk_final_price_wap not like", value, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapIn(List<String> values) {
            addCriterion("zk_final_price_wap in", values, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapNotIn(List<String> values) {
            addCriterion("zk_final_price_wap not in", values, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapBetween(String value1, String value2) {
            addCriterion("zk_final_price_wap between", value1, value2, "zkFinalPriceWap");
            return (Criteria) this;
        }

        public Criteria andZkFinalPriceWapNotBetween(String value1, String value2) {
            addCriterion("zk_final_price_wap not between", value1, value2, "zkFinalPriceWap");
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

        public Criteria andEventStartTimeIsNull() {
            addCriterion("event_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeIsNotNull() {
            addCriterion("event_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeEqualTo(Date value) {
            addCriterion("event_start_time =", value, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeNotEqualTo(Date value) {
            addCriterion("event_start_time <>", value, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeGreaterThan(Date value) {
            addCriterion("event_start_time >", value, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("event_start_time >=", value, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeLessThan(Date value) {
            addCriterion("event_start_time <", value, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("event_start_time <=", value, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeIn(List<Date> values) {
            addCriterion("event_start_time in", values, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeNotIn(List<Date> values) {
            addCriterion("event_start_time not in", values, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeBetween(Date value1, Date value2) {
            addCriterion("event_start_time between", value1, value2, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("event_start_time not between", value1, value2, "eventStartTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeIsNull() {
            addCriterion("event_end_time is null");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeIsNotNull() {
            addCriterion("event_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeEqualTo(Date value) {
            addCriterion("event_end_time =", value, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeNotEqualTo(Date value) {
            addCriterion("event_end_time <>", value, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeGreaterThan(Date value) {
            addCriterion("event_end_time >", value, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("event_end_time >=", value, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeLessThan(Date value) {
            addCriterion("event_end_time <", value, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("event_end_time <=", value, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeIn(List<Date> values) {
            addCriterion("event_end_time in", values, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeNotIn(List<Date> values) {
            addCriterion("event_end_time not in", values, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeBetween(Date value1, Date value2) {
            addCriterion("event_end_time between", value1, value2, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andEventEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("event_end_time not between", value1, value2, "eventEndTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(Integer value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("category not between", value1, value2, "category");
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