package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CityBuildPrjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityBuildPrjExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andPrjDbNoIsNull() {
            addCriterion("prj_db_no is null");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoIsNotNull() {
            addCriterion("prj_db_no is not null");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoEqualTo(String value) {
            addCriterion("prj_db_no =", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoNotEqualTo(String value) {
            addCriterion("prj_db_no <>", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoGreaterThan(String value) {
            addCriterion("prj_db_no >", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoGreaterThanOrEqualTo(String value) {
            addCriterion("prj_db_no >=", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoLessThan(String value) {
            addCriterion("prj_db_no <", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoLessThanOrEqualTo(String value) {
            addCriterion("prj_db_no <=", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoLike(String value) {
            addCriterion("prj_db_no like", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoNotLike(String value) {
            addCriterion("prj_db_no not like", value, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoIn(List<String> values) {
            addCriterion("prj_db_no in", values, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoNotIn(List<String> values) {
            addCriterion("prj_db_no not in", values, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoBetween(String value1, String value2) {
            addCriterion("prj_db_no between", value1, value2, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andPrjDbNoNotBetween(String value1, String value2) {
            addCriterion("prj_db_no not between", value1, value2, "prjDbNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoIsNull() {
            addCriterion("current_plan_no is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoIsNotNull() {
            addCriterion("current_plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoEqualTo(Integer value) {
            addCriterion("current_plan_no =", value, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoNotEqualTo(Integer value) {
            addCriterion("current_plan_no <>", value, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoGreaterThan(Integer value) {
            addCriterion("current_plan_no >", value, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_plan_no >=", value, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoLessThan(Integer value) {
            addCriterion("current_plan_no <", value, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoLessThanOrEqualTo(Integer value) {
            addCriterion("current_plan_no <=", value, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoIn(List<Integer> values) {
            addCriterion("current_plan_no in", values, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoNotIn(List<Integer> values) {
            addCriterion("current_plan_no not in", values, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoBetween(Integer value1, Integer value2) {
            addCriterion("current_plan_no between", value1, value2, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andCurrentPlanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("current_plan_no not between", value1, value2, "currentPlanNo");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearIsNull() {
            addCriterion("prj_start_year is null");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearIsNotNull() {
            addCriterion("prj_start_year is not null");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearEqualTo(Integer value) {
            addCriterion("prj_start_year =", value, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearNotEqualTo(Integer value) {
            addCriterion("prj_start_year <>", value, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearGreaterThan(Integer value) {
            addCriterion("prj_start_year >", value, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("prj_start_year >=", value, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearLessThan(Integer value) {
            addCriterion("prj_start_year <", value, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearLessThanOrEqualTo(Integer value) {
            addCriterion("prj_start_year <=", value, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearIn(List<Integer> values) {
            addCriterion("prj_start_year in", values, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearNotIn(List<Integer> values) {
            addCriterion("prj_start_year not in", values, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearBetween(Integer value1, Integer value2) {
            addCriterion("prj_start_year between", value1, value2, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjStartYearNotBetween(Integer value1, Integer value2) {
            addCriterion("prj_start_year not between", value1, value2, "prjStartYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearIsNull() {
            addCriterion("prj_end_year is null");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearIsNotNull() {
            addCriterion("prj_end_year is not null");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearEqualTo(Integer value) {
            addCriterion("prj_end_year =", value, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearNotEqualTo(Integer value) {
            addCriterion("prj_end_year <>", value, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearGreaterThan(Integer value) {
            addCriterion("prj_end_year >", value, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("prj_end_year >=", value, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearLessThan(Integer value) {
            addCriterion("prj_end_year <", value, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearLessThanOrEqualTo(Integer value) {
            addCriterion("prj_end_year <=", value, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearIn(List<Integer> values) {
            addCriterion("prj_end_year in", values, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearNotIn(List<Integer> values) {
            addCriterion("prj_end_year not in", values, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearBetween(Integer value1, Integer value2) {
            addCriterion("prj_end_year between", value1, value2, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andPrjEndYearNotBetween(Integer value1, Integer value2) {
            addCriterion("prj_end_year not between", value1, value2, "prjEndYear");
            return (Criteria) this;
        }

        public Criteria andActualEndDateIsNull() {
            addCriterion("actual_end_date is null");
            return (Criteria) this;
        }

        public Criteria andActualEndDateIsNotNull() {
            addCriterion("actual_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date =", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date <>", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("actual_end_date >", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date >=", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateLessThan(Date value) {
            addCriterionForJDBCDate("actual_end_date <", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_end_date <=", value, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("actual_end_date in", values, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("actual_end_date not in", values, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_end_date between", value1, value2, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andActualEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_end_date not between", value1, value2, "actualEndDate");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalIsNull() {
            addCriterion("prj_invest_total is null");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalIsNotNull() {
            addCriterion("prj_invest_total is not null");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalEqualTo(Integer value) {
            addCriterion("prj_invest_total =", value, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalNotEqualTo(Integer value) {
            addCriterion("prj_invest_total <>", value, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalGreaterThan(Integer value) {
            addCriterion("prj_invest_total >", value, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("prj_invest_total >=", value, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalLessThan(Integer value) {
            addCriterion("prj_invest_total <", value, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalLessThanOrEqualTo(Integer value) {
            addCriterion("prj_invest_total <=", value, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalIn(List<Integer> values) {
            addCriterion("prj_invest_total in", values, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalNotIn(List<Integer> values) {
            addCriterion("prj_invest_total not in", values, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalBetween(Integer value1, Integer value2) {
            addCriterion("prj_invest_total between", value1, value2, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPrjInvestTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("prj_invest_total not between", value1, value2, "prjInvestTotal");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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