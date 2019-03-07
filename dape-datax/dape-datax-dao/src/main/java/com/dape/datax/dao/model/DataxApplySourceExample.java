package com.dape.datax.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataxApplySourceExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public DataxApplySourceExample() {
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

        public Criteria andLinkIpIsNull() {
            addCriterion("link_ip is null");
            return (Criteria) this;
        }

        public Criteria andLinkIpIsNotNull() {
            addCriterion("link_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIpEqualTo(String value) {
            addCriterion("link_ip =", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpNotEqualTo(String value) {
            addCriterion("link_ip <>", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpGreaterThan(String value) {
            addCriterion("link_ip >", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpGreaterThanOrEqualTo(String value) {
            addCriterion("link_ip >=", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpLessThan(String value) {
            addCriterion("link_ip <", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpLessThanOrEqualTo(String value) {
            addCriterion("link_ip <=", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpLike(String value) {
            addCriterion("link_ip like", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpNotLike(String value) {
            addCriterion("link_ip not like", value, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpIn(List<String> values) {
            addCriterion("link_ip in", values, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpNotIn(List<String> values) {
            addCriterion("link_ip not in", values, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpBetween(String value1, String value2) {
            addCriterion("link_ip between", value1, value2, "linkIp");
            return (Criteria) this;
        }

        public Criteria andLinkIpNotBetween(String value1, String value2) {
            addCriterion("link_ip not between", value1, value2, "linkIp");
            return (Criteria) this;
        }

        public Criteria andDbUserIsNull() {
            addCriterion("db_user is null");
            return (Criteria) this;
        }

        public Criteria andDbUserIsNotNull() {
            addCriterion("db_user is not null");
            return (Criteria) this;
        }

        public Criteria andDbUserEqualTo(String value) {
            addCriterion("db_user =", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserNotEqualTo(String value) {
            addCriterion("db_user <>", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserGreaterThan(String value) {
            addCriterion("db_user >", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserGreaterThanOrEqualTo(String value) {
            addCriterion("db_user >=", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserLessThan(String value) {
            addCriterion("db_user <", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserLessThanOrEqualTo(String value) {
            addCriterion("db_user <=", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserLike(String value) {
            addCriterion("db_user like", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserNotLike(String value) {
            addCriterion("db_user not like", value, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserIn(List<String> values) {
            addCriterion("db_user in", values, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserNotIn(List<String> values) {
            addCriterion("db_user not in", values, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserBetween(String value1, String value2) {
            addCriterion("db_user between", value1, value2, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbUserNotBetween(String value1, String value2) {
            addCriterion("db_user not between", value1, value2, "dbUser");
            return (Criteria) this;
        }

        public Criteria andDbPwdIsNull() {
            addCriterion("db_pwd is null");
            return (Criteria) this;
        }

        public Criteria andDbPwdIsNotNull() {
            addCriterion("db_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andDbPwdEqualTo(String value) {
            addCriterion("db_pwd =", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdNotEqualTo(String value) {
            addCriterion("db_pwd <>", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdGreaterThan(String value) {
            addCriterion("db_pwd >", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdGreaterThanOrEqualTo(String value) {
            addCriterion("db_pwd >=", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdLessThan(String value) {
            addCriterion("db_pwd <", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdLessThanOrEqualTo(String value) {
            addCriterion("db_pwd <=", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdLike(String value) {
            addCriterion("db_pwd like", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdNotLike(String value) {
            addCriterion("db_pwd not like", value, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdIn(List<String> values) {
            addCriterion("db_pwd in", values, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdNotIn(List<String> values) {
            addCriterion("db_pwd not in", values, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdBetween(String value1, String value2) {
            addCriterion("db_pwd between", value1, value2, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPwdNotBetween(String value1, String value2) {
            addCriterion("db_pwd not between", value1, value2, "dbPwd");
            return (Criteria) this;
        }

        public Criteria andDbPortIsNull() {
            addCriterion("db_port is null");
            return (Criteria) this;
        }

        public Criteria andDbPortIsNotNull() {
            addCriterion("db_port is not null");
            return (Criteria) this;
        }

        public Criteria andDbPortEqualTo(String value) {
            addCriterion("db_port =", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotEqualTo(String value) {
            addCriterion("db_port <>", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortGreaterThan(String value) {
            addCriterion("db_port >", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortGreaterThanOrEqualTo(String value) {
            addCriterion("db_port >=", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortLessThan(String value) {
            addCriterion("db_port <", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortLessThanOrEqualTo(String value) {
            addCriterion("db_port <=", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortLike(String value) {
            addCriterion("db_port like", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotLike(String value) {
            addCriterion("db_port not like", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortIn(List<String> values) {
            addCriterion("db_port in", values, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotIn(List<String> values) {
            addCriterion("db_port not in", values, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortBetween(String value1, String value2) {
            addCriterion("db_port between", value1, value2, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotBetween(String value1, String value2) {
            addCriterion("db_port not between", value1, value2, "dbPort");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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