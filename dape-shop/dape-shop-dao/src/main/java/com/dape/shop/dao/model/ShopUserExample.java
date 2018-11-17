package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopUserExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public ShopUserExample() {
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameIsNull() {
            addCriterion("wei_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameIsNotNull() {
            addCriterion("wei_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameEqualTo(String value) {
            addCriterion("wei_nick_name =", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameNotEqualTo(String value) {
            addCriterion("wei_nick_name <>", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameGreaterThan(String value) {
            addCriterion("wei_nick_name >", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("wei_nick_name >=", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameLessThan(String value) {
            addCriterion("wei_nick_name <", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameLessThanOrEqualTo(String value) {
            addCriterion("wei_nick_name <=", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameLike(String value) {
            addCriterion("wei_nick_name like", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameNotLike(String value) {
            addCriterion("wei_nick_name not like", value, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameIn(List<String> values) {
            addCriterion("wei_nick_name in", values, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameNotIn(List<String> values) {
            addCriterion("wei_nick_name not in", values, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameBetween(String value1, String value2) {
            addCriterion("wei_nick_name between", value1, value2, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andWeiNickNameNotBetween(String value1, String value2) {
            addCriterion("wei_nick_name not between", value1, value2, "weiNickName");
            return (Criteria) this;
        }

        public Criteria andRCodeIsNull() {
            addCriterion("r_code is null");
            return (Criteria) this;
        }

        public Criteria andRCodeIsNotNull() {
            addCriterion("r_code is not null");
            return (Criteria) this;
        }

        public Criteria andRCodeEqualTo(String value) {
            addCriterion("r_code =", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeNotEqualTo(String value) {
            addCriterion("r_code <>", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeGreaterThan(String value) {
            addCriterion("r_code >", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeGreaterThanOrEqualTo(String value) {
            addCriterion("r_code >=", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeLessThan(String value) {
            addCriterion("r_code <", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeLessThanOrEqualTo(String value) {
            addCriterion("r_code <=", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeLike(String value) {
            addCriterion("r_code like", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeNotLike(String value) {
            addCriterion("r_code not like", value, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeIn(List<String> values) {
            addCriterion("r_code in", values, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeNotIn(List<String> values) {
            addCriterion("r_code not in", values, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeBetween(String value1, String value2) {
            addCriterion("r_code between", value1, value2, "rCode");
            return (Criteria) this;
        }

        public Criteria andRCodeNotBetween(String value1, String value2) {
            addCriterion("r_code not between", value1, value2, "rCode");
            return (Criteria) this;
        }

        public Criteria andSCodeIsNull() {
            addCriterion("s_code is null");
            return (Criteria) this;
        }

        public Criteria andSCodeIsNotNull() {
            addCriterion("s_code is not null");
            return (Criteria) this;
        }

        public Criteria andSCodeEqualTo(String value) {
            addCriterion("s_code =", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotEqualTo(String value) {
            addCriterion("s_code <>", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeGreaterThan(String value) {
            addCriterion("s_code >", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeGreaterThanOrEqualTo(String value) {
            addCriterion("s_code >=", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeLessThan(String value) {
            addCriterion("s_code <", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeLessThanOrEqualTo(String value) {
            addCriterion("s_code <=", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeLike(String value) {
            addCriterion("s_code like", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotLike(String value) {
            addCriterion("s_code not like", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeIn(List<String> values) {
            addCriterion("s_code in", values, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotIn(List<String> values) {
            addCriterion("s_code not in", values, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeBetween(String value1, String value2) {
            addCriterion("s_code between", value1, value2, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotBetween(String value1, String value2) {
            addCriterion("s_code not between", value1, value2, "sCode");
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