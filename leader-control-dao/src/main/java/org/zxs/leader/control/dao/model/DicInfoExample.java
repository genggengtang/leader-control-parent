package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.List;

public class DicInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DicInfoExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkIsNull() {
            addCriterion("type_remark is null");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkIsNotNull() {
            addCriterion("type_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkEqualTo(String value) {
            addCriterion("type_remark =", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkNotEqualTo(String value) {
            addCriterion("type_remark <>", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkGreaterThan(String value) {
            addCriterion("type_remark >", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("type_remark >=", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkLessThan(String value) {
            addCriterion("type_remark <", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkLessThanOrEqualTo(String value) {
            addCriterion("type_remark <=", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkLike(String value) {
            addCriterion("type_remark like", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkNotLike(String value) {
            addCriterion("type_remark not like", value, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkIn(List<String> values) {
            addCriterion("type_remark in", values, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkNotIn(List<String> values) {
            addCriterion("type_remark not in", values, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkBetween(String value1, String value2) {
            addCriterion("type_remark between", value1, value2, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andTypeRemarkNotBetween(String value1, String value2) {
            addCriterion("type_remark not between", value1, value2, "typeRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkIsNull() {
            addCriterion("value_remark is null");
            return (Criteria) this;
        }

        public Criteria andValueRemarkIsNotNull() {
            addCriterion("value_remark is not null");
            return (Criteria) this;
        }

        public Criteria andValueRemarkEqualTo(String value) {
            addCriterion("value_remark =", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkNotEqualTo(String value) {
            addCriterion("value_remark <>", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkGreaterThan(String value) {
            addCriterion("value_remark >", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("value_remark >=", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkLessThan(String value) {
            addCriterion("value_remark <", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkLessThanOrEqualTo(String value) {
            addCriterion("value_remark <=", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkLike(String value) {
            addCriterion("value_remark like", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkNotLike(String value) {
            addCriterion("value_remark not like", value, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkIn(List<String> values) {
            addCriterion("value_remark in", values, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkNotIn(List<String> values) {
            addCriterion("value_remark not in", values, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkBetween(String value1, String value2) {
            addCriterion("value_remark between", value1, value2, "valueRemark");
            return (Criteria) this;
        }

        public Criteria andValueRemarkNotBetween(String value1, String value2) {
            addCriterion("value_remark not between", value1, value2, "valueRemark");
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