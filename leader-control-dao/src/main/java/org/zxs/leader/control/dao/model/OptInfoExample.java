package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OptInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptInfoExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNull() {
            addCriterion("opt_type is null");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNotNull() {
            addCriterion("opt_type is not null");
            return (Criteria) this;
        }

        public Criteria andOptTypeEqualTo(Integer value) {
            addCriterion("opt_type =", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotEqualTo(Integer value) {
            addCriterion("opt_type <>", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThan(Integer value) {
            addCriterion("opt_type >", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_type >=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThan(Integer value) {
            addCriterion("opt_type <", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThanOrEqualTo(Integer value) {
            addCriterion("opt_type <=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeIn(List<Integer> values) {
            addCriterion("opt_type in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotIn(List<Integer> values) {
            addCriterion("opt_type not in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeBetween(Integer value1, Integer value2) {
            addCriterion("opt_type between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_type not between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andOptRetIsNull() {
            addCriterion("opt_ret is null");
            return (Criteria) this;
        }

        public Criteria andOptRetIsNotNull() {
            addCriterion("opt_ret is not null");
            return (Criteria) this;
        }

        public Criteria andOptRetEqualTo(Byte value) {
            addCriterion("opt_ret =", value, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetNotEqualTo(Byte value) {
            addCriterion("opt_ret <>", value, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetGreaterThan(Byte value) {
            addCriterion("opt_ret >", value, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetGreaterThanOrEqualTo(Byte value) {
            addCriterion("opt_ret >=", value, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetLessThan(Byte value) {
            addCriterion("opt_ret <", value, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetLessThanOrEqualTo(Byte value) {
            addCriterion("opt_ret <=", value, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetIn(List<Byte> values) {
            addCriterion("opt_ret in", values, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetNotIn(List<Byte> values) {
            addCriterion("opt_ret not in", values, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetBetween(Byte value1, Byte value2) {
            addCriterion("opt_ret between", value1, value2, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptRetNotBetween(Byte value1, Byte value2) {
            addCriterion("opt_ret not between", value1, value2, "optRet");
            return (Criteria) this;
        }

        public Criteria andOptMsgIsNull() {
            addCriterion("opt_msg is null");
            return (Criteria) this;
        }

        public Criteria andOptMsgIsNotNull() {
            addCriterion("opt_msg is not null");
            return (Criteria) this;
        }

        public Criteria andOptMsgEqualTo(String value) {
            addCriterion("opt_msg =", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgNotEqualTo(String value) {
            addCriterion("opt_msg <>", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgGreaterThan(String value) {
            addCriterion("opt_msg >", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgGreaterThanOrEqualTo(String value) {
            addCriterion("opt_msg >=", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgLessThan(String value) {
            addCriterion("opt_msg <", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgLessThanOrEqualTo(String value) {
            addCriterion("opt_msg <=", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgLike(String value) {
            addCriterion("opt_msg like", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgNotLike(String value) {
            addCriterion("opt_msg not like", value, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgIn(List<String> values) {
            addCriterion("opt_msg in", values, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgNotIn(List<String> values) {
            addCriterion("opt_msg not in", values, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgBetween(String value1, String value2) {
            addCriterion("opt_msg between", value1, value2, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptMsgNotBetween(String value1, String value2) {
            addCriterion("opt_msg not between", value1, value2, "optMsg");
            return (Criteria) this;
        }

        public Criteria andOptAtIsNull() {
            addCriterion("opt_at is null");
            return (Criteria) this;
        }

        public Criteria andOptAtIsNotNull() {
            addCriterion("opt_at is not null");
            return (Criteria) this;
        }

        public Criteria andOptAtEqualTo(Date value) {
            addCriterion("opt_at =", value, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtNotEqualTo(Date value) {
            addCriterion("opt_at <>", value, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtGreaterThan(Date value) {
            addCriterion("opt_at >", value, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtGreaterThanOrEqualTo(Date value) {
            addCriterion("opt_at >=", value, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtLessThan(Date value) {
            addCriterion("opt_at <", value, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtLessThanOrEqualTo(Date value) {
            addCriterion("opt_at <=", value, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtIn(List<Date> values) {
            addCriterion("opt_at in", values, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtNotIn(List<Date> values) {
            addCriterion("opt_at not in", values, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtBetween(Date value1, Date value2) {
            addCriterion("opt_at between", value1, value2, "optAt");
            return (Criteria) this;
        }

        public Criteria andOptAtNotBetween(Date value1, Date value2) {
            addCriterion("opt_at not between", value1, value2, "optAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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