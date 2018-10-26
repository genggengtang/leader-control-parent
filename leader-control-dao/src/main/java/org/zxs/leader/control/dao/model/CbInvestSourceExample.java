package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbInvestSourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbInvestSourceExample() {
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

        public Criteria andPrjPlanIdIsNull() {
            addCriterion("prj_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdIsNotNull() {
            addCriterion("prj_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdEqualTo(Integer value) {
            addCriterion("prj_plan_id =", value, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdNotEqualTo(Integer value) {
            addCriterion("prj_plan_id <>", value, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdGreaterThan(Integer value) {
            addCriterion("prj_plan_id >", value, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prj_plan_id >=", value, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdLessThan(Integer value) {
            addCriterion("prj_plan_id <", value, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("prj_plan_id <=", value, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdIn(List<Integer> values) {
            addCriterion("prj_plan_id in", values, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdNotIn(List<Integer> values) {
            addCriterion("prj_plan_id not in", values, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("prj_plan_id between", value1, value2, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andPrjPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prj_plan_id not between", value1, value2, "prjPlanId");
            return (Criteria) this;
        }

        public Criteria andSourceNoIsNull() {
            addCriterion("source_no is null");
            return (Criteria) this;
        }

        public Criteria andSourceNoIsNotNull() {
            addCriterion("source_no is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNoEqualTo(Integer value) {
            addCriterion("source_no =", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotEqualTo(Integer value) {
            addCriterion("source_no <>", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoGreaterThan(Integer value) {
            addCriterion("source_no >", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_no >=", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoLessThan(Integer value) {
            addCriterion("source_no <", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoLessThanOrEqualTo(Integer value) {
            addCriterion("source_no <=", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoIn(List<Integer> values) {
            addCriterion("source_no in", values, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotIn(List<Integer> values) {
            addCriterion("source_no not in", values, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoBetween(Integer value1, Integer value2) {
            addCriterion("source_no between", value1, value2, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("source_no not between", value1, value2, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoIsNull() {
            addCriterion("source_type_no is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoIsNotNull() {
            addCriterion("source_type_no is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoEqualTo(Integer value) {
            addCriterion("source_type_no =", value, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoNotEqualTo(Integer value) {
            addCriterion("source_type_no <>", value, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoGreaterThan(Integer value) {
            addCriterion("source_type_no >", value, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_type_no >=", value, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoLessThan(Integer value) {
            addCriterion("source_type_no <", value, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoLessThanOrEqualTo(Integer value) {
            addCriterion("source_type_no <=", value, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoIn(List<Integer> values) {
            addCriterion("source_type_no in", values, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoNotIn(List<Integer> values) {
            addCriterion("source_type_no not in", values, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoBetween(Integer value1, Integer value2) {
            addCriterion("source_type_no between", value1, value2, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("source_type_no not between", value1, value2, "sourceTypeNo");
            return (Criteria) this;
        }

        public Criteria andPlanInvestIsNull() {
            addCriterion("plan_invest is null");
            return (Criteria) this;
        }

        public Criteria andPlanInvestIsNotNull() {
            addCriterion("plan_invest is not null");
            return (Criteria) this;
        }

        public Criteria andPlanInvestEqualTo(Integer value) {
            addCriterion("plan_invest =", value, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestNotEqualTo(Integer value) {
            addCriterion("plan_invest <>", value, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestGreaterThan(Integer value) {
            addCriterion("plan_invest >", value, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_invest >=", value, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestLessThan(Integer value) {
            addCriterion("plan_invest <", value, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestLessThanOrEqualTo(Integer value) {
            addCriterion("plan_invest <=", value, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestIn(List<Integer> values) {
            addCriterion("plan_invest in", values, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestNotIn(List<Integer> values) {
            addCriterion("plan_invest not in", values, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestBetween(Integer value1, Integer value2) {
            addCriterion("plan_invest between", value1, value2, "planInvest");
            return (Criteria) this;
        }

        public Criteria andPlanInvestNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_invest not between", value1, value2, "planInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestIsNull() {
            addCriterion("actual_invest is null");
            return (Criteria) this;
        }

        public Criteria andActualInvestIsNotNull() {
            addCriterion("actual_invest is not null");
            return (Criteria) this;
        }

        public Criteria andActualInvestEqualTo(Integer value) {
            addCriterion("actual_invest =", value, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestNotEqualTo(Integer value) {
            addCriterion("actual_invest <>", value, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestGreaterThan(Integer value) {
            addCriterion("actual_invest >", value, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_invest >=", value, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestLessThan(Integer value) {
            addCriterion("actual_invest <", value, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestLessThanOrEqualTo(Integer value) {
            addCriterion("actual_invest <=", value, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestIn(List<Integer> values) {
            addCriterion("actual_invest in", values, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestNotIn(List<Integer> values) {
            addCriterion("actual_invest not in", values, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestBetween(Integer value1, Integer value2) {
            addCriterion("actual_invest between", value1, value2, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andActualInvestNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_invest not between", value1, value2, "actualInvest");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
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