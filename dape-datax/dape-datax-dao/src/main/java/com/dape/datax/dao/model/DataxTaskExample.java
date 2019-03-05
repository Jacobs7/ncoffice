package com.dape.datax.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataxTaskExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public DataxTaskExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlIsNull() {
            addCriterion("from_data_url is null");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlIsNotNull() {
            addCriterion("from_data_url is not null");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlEqualTo(String value) {
            addCriterion("from_data_url =", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlNotEqualTo(String value) {
            addCriterion("from_data_url <>", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlGreaterThan(String value) {
            addCriterion("from_data_url >", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("from_data_url >=", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlLessThan(String value) {
            addCriterion("from_data_url <", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlLessThanOrEqualTo(String value) {
            addCriterion("from_data_url <=", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlLike(String value) {
            addCriterion("from_data_url like", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlNotLike(String value) {
            addCriterion("from_data_url not like", value, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlIn(List<String> values) {
            addCriterion("from_data_url in", values, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlNotIn(List<String> values) {
            addCriterion("from_data_url not in", values, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlBetween(String value1, String value2) {
            addCriterion("from_data_url between", value1, value2, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromDataUrlNotBetween(String value1, String value2) {
            addCriterion("from_data_url not between", value1, value2, "fromDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlIsNull() {
            addCriterion("to_data_url is null");
            return (Criteria) this;
        }

        public Criteria andToDataUrlIsNotNull() {
            addCriterion("to_data_url is not null");
            return (Criteria) this;
        }

        public Criteria andToDataUrlEqualTo(String value) {
            addCriterion("to_data_url =", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlNotEqualTo(String value) {
            addCriterion("to_data_url <>", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlGreaterThan(String value) {
            addCriterion("to_data_url >", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("to_data_url >=", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlLessThan(String value) {
            addCriterion("to_data_url <", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlLessThanOrEqualTo(String value) {
            addCriterion("to_data_url <=", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlLike(String value) {
            addCriterion("to_data_url like", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlNotLike(String value) {
            addCriterion("to_data_url not like", value, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlIn(List<String> values) {
            addCriterion("to_data_url in", values, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlNotIn(List<String> values) {
            addCriterion("to_data_url not in", values, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlBetween(String value1, String value2) {
            addCriterion("to_data_url between", value1, value2, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andToDataUrlNotBetween(String value1, String value2) {
            addCriterion("to_data_url not between", value1, value2, "toDataUrl");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdIsNull() {
            addCriterion("from_type_id is null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdIsNotNull() {
            addCriterion("from_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdEqualTo(Integer value) {
            addCriterion("from_type_id =", value, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdNotEqualTo(Integer value) {
            addCriterion("from_type_id <>", value, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdGreaterThan(Integer value) {
            addCriterion("from_type_id >", value, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_type_id >=", value, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdLessThan(Integer value) {
            addCriterion("from_type_id <", value, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_type_id <=", value, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdIn(List<Integer> values) {
            addCriterion("from_type_id in", values, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdNotIn(List<Integer> values) {
            addCriterion("from_type_id not in", values, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("from_type_id between", value1, value2, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andFromTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_type_id not between", value1, value2, "fromTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdIsNull() {
            addCriterion("to_type_id is null");
            return (Criteria) this;
        }

        public Criteria andToTypeIdIsNotNull() {
            addCriterion("to_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andToTypeIdEqualTo(Integer value) {
            addCriterion("to_type_id =", value, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdNotEqualTo(Integer value) {
            addCriterion("to_type_id <>", value, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdGreaterThan(Integer value) {
            addCriterion("to_type_id >", value, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_type_id >=", value, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdLessThan(Integer value) {
            addCriterion("to_type_id <", value, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("to_type_id <=", value, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdIn(List<Integer> values) {
            addCriterion("to_type_id in", values, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdNotIn(List<Integer> values) {
            addCriterion("to_type_id not in", values, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("to_type_id between", value1, value2, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andToTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("to_type_id not between", value1, value2, "toTypeId");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIsNull() {
            addCriterion("from_username is null");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIsNotNull() {
            addCriterion("from_username is not null");
            return (Criteria) this;
        }

        public Criteria andFromUsernameEqualTo(String value) {
            addCriterion("from_username =", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotEqualTo(String value) {
            addCriterion("from_username <>", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameGreaterThan(String value) {
            addCriterion("from_username >", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("from_username >=", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLessThan(String value) {
            addCriterion("from_username <", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLessThanOrEqualTo(String value) {
            addCriterion("from_username <=", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLike(String value) {
            addCriterion("from_username like", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotLike(String value) {
            addCriterion("from_username not like", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIn(List<String> values) {
            addCriterion("from_username in", values, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotIn(List<String> values) {
            addCriterion("from_username not in", values, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameBetween(String value1, String value2) {
            addCriterion("from_username between", value1, value2, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotBetween(String value1, String value2) {
            addCriterion("from_username not between", value1, value2, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameIsNull() {
            addCriterion("to_username is null");
            return (Criteria) this;
        }

        public Criteria andToUsernameIsNotNull() {
            addCriterion("to_username is not null");
            return (Criteria) this;
        }

        public Criteria andToUsernameEqualTo(String value) {
            addCriterion("to_username =", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotEqualTo(String value) {
            addCriterion("to_username <>", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameGreaterThan(String value) {
            addCriterion("to_username >", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("to_username >=", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameLessThan(String value) {
            addCriterion("to_username <", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameLessThanOrEqualTo(String value) {
            addCriterion("to_username <=", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameLike(String value) {
            addCriterion("to_username like", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotLike(String value) {
            addCriterion("to_username not like", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameIn(List<String> values) {
            addCriterion("to_username in", values, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotIn(List<String> values) {
            addCriterion("to_username not in", values, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameBetween(String value1, String value2) {
            addCriterion("to_username between", value1, value2, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotBetween(String value1, String value2) {
            addCriterion("to_username not between", value1, value2, "toUsername");
            return (Criteria) this;
        }

        public Criteria andFromPwdIsNull() {
            addCriterion("from_pwd is null");
            return (Criteria) this;
        }

        public Criteria andFromPwdIsNotNull() {
            addCriterion("from_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andFromPwdEqualTo(String value) {
            addCriterion("from_pwd =", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdNotEqualTo(String value) {
            addCriterion("from_pwd <>", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdGreaterThan(String value) {
            addCriterion("from_pwd >", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdGreaterThanOrEqualTo(String value) {
            addCriterion("from_pwd >=", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdLessThan(String value) {
            addCriterion("from_pwd <", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdLessThanOrEqualTo(String value) {
            addCriterion("from_pwd <=", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdLike(String value) {
            addCriterion("from_pwd like", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdNotLike(String value) {
            addCriterion("from_pwd not like", value, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdIn(List<String> values) {
            addCriterion("from_pwd in", values, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdNotIn(List<String> values) {
            addCriterion("from_pwd not in", values, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdBetween(String value1, String value2) {
            addCriterion("from_pwd between", value1, value2, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andFromPwdNotBetween(String value1, String value2) {
            addCriterion("from_pwd not between", value1, value2, "fromPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdIsNull() {
            addCriterion("to_pwd is null");
            return (Criteria) this;
        }

        public Criteria andToPwdIsNotNull() {
            addCriterion("to_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andToPwdEqualTo(String value) {
            addCriterion("to_pwd =", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdNotEqualTo(String value) {
            addCriterion("to_pwd <>", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdGreaterThan(String value) {
            addCriterion("to_pwd >", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdGreaterThanOrEqualTo(String value) {
            addCriterion("to_pwd >=", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdLessThan(String value) {
            addCriterion("to_pwd <", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdLessThanOrEqualTo(String value) {
            addCriterion("to_pwd <=", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdLike(String value) {
            addCriterion("to_pwd like", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdNotLike(String value) {
            addCriterion("to_pwd not like", value, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdIn(List<String> values) {
            addCriterion("to_pwd in", values, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdNotIn(List<String> values) {
            addCriterion("to_pwd not in", values, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdBetween(String value1, String value2) {
            addCriterion("to_pwd between", value1, value2, "toPwd");
            return (Criteria) this;
        }

        public Criteria andToPwdNotBetween(String value1, String value2) {
            addCriterion("to_pwd not between", value1, value2, "toPwd");
            return (Criteria) this;
        }

        public Criteria andFromProtIsNull() {
            addCriterion("from_prot is null");
            return (Criteria) this;
        }

        public Criteria andFromProtIsNotNull() {
            addCriterion("from_prot is not null");
            return (Criteria) this;
        }

        public Criteria andFromProtEqualTo(String value) {
            addCriterion("from_prot =", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtNotEqualTo(String value) {
            addCriterion("from_prot <>", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtGreaterThan(String value) {
            addCriterion("from_prot >", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtGreaterThanOrEqualTo(String value) {
            addCriterion("from_prot >=", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtLessThan(String value) {
            addCriterion("from_prot <", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtLessThanOrEqualTo(String value) {
            addCriterion("from_prot <=", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtLike(String value) {
            addCriterion("from_prot like", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtNotLike(String value) {
            addCriterion("from_prot not like", value, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtIn(List<String> values) {
            addCriterion("from_prot in", values, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtNotIn(List<String> values) {
            addCriterion("from_prot not in", values, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtBetween(String value1, String value2) {
            addCriterion("from_prot between", value1, value2, "fromProt");
            return (Criteria) this;
        }

        public Criteria andFromProtNotBetween(String value1, String value2) {
            addCriterion("from_prot not between", value1, value2, "fromProt");
            return (Criteria) this;
        }

        public Criteria andToPortIsNull() {
            addCriterion("to_port is null");
            return (Criteria) this;
        }

        public Criteria andToPortIsNotNull() {
            addCriterion("to_port is not null");
            return (Criteria) this;
        }

        public Criteria andToPortEqualTo(String value) {
            addCriterion("to_port =", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortNotEqualTo(String value) {
            addCriterion("to_port <>", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortGreaterThan(String value) {
            addCriterion("to_port >", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortGreaterThanOrEqualTo(String value) {
            addCriterion("to_port >=", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortLessThan(String value) {
            addCriterion("to_port <", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortLessThanOrEqualTo(String value) {
            addCriterion("to_port <=", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortLike(String value) {
            addCriterion("to_port like", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortNotLike(String value) {
            addCriterion("to_port not like", value, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortIn(List<String> values) {
            addCriterion("to_port in", values, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortNotIn(List<String> values) {
            addCriterion("to_port not in", values, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortBetween(String value1, String value2) {
            addCriterion("to_port between", value1, value2, "toPort");
            return (Criteria) this;
        }

        public Criteria andToPortNotBetween(String value1, String value2) {
            addCriterion("to_port not between", value1, value2, "toPort");
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