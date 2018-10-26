package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CityPlanPrjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityPlanPrjExample() {
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

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearIsNull() {
            addCriterion("plan_start_year is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearIsNotNull() {
            addCriterion("plan_start_year is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearEqualTo(Integer value) {
            addCriterion("plan_start_year =", value, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearNotEqualTo(Integer value) {
            addCriterion("plan_start_year <>", value, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearGreaterThan(Integer value) {
            addCriterion("plan_start_year >", value, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_start_year >=", value, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearLessThan(Integer value) {
            addCriterion("plan_start_year <", value, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearLessThanOrEqualTo(Integer value) {
            addCriterion("plan_start_year <=", value, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearIn(List<Integer> values) {
            addCriterion("plan_start_year in", values, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearNotIn(List<Integer> values) {
            addCriterion("plan_start_year not in", values, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearBetween(Integer value1, Integer value2) {
            addCriterion("plan_start_year between", value1, value2, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartYearNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_start_year not between", value1, value2, "planStartYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearIsNull() {
            addCriterion("plan_end_year is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearIsNotNull() {
            addCriterion("plan_end_year is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearEqualTo(Integer value) {
            addCriterion("plan_end_year =", value, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearNotEqualTo(Integer value) {
            addCriterion("plan_end_year <>", value, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearGreaterThan(Integer value) {
            addCriterion("plan_end_year >", value, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_end_year >=", value, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearLessThan(Integer value) {
            addCriterion("plan_end_year <", value, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearLessThanOrEqualTo(Integer value) {
            addCriterion("plan_end_year <=", value, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearIn(List<Integer> values) {
            addCriterion("plan_end_year in", values, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearNotIn(List<Integer> values) {
            addCriterion("plan_end_year not in", values, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearBetween(Integer value1, Integer value2) {
            addCriterion("plan_end_year between", value1, value2, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanEndYearNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_end_year not between", value1, value2, "planEndYear");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthIsNull() {
            addCriterion("plan_start_month is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthIsNotNull() {
            addCriterion("plan_start_month is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthEqualTo(Byte value) {
            addCriterion("plan_start_month =", value, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthNotEqualTo(Byte value) {
            addCriterion("plan_start_month <>", value, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthGreaterThan(Byte value) {
            addCriterion("plan_start_month >", value, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthGreaterThanOrEqualTo(Byte value) {
            addCriterion("plan_start_month >=", value, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthLessThan(Byte value) {
            addCriterion("plan_start_month <", value, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthLessThanOrEqualTo(Byte value) {
            addCriterion("plan_start_month <=", value, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthIn(List<Byte> values) {
            addCriterion("plan_start_month in", values, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthNotIn(List<Byte> values) {
            addCriterion("plan_start_month not in", values, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthBetween(Byte value1, Byte value2) {
            addCriterion("plan_start_month between", value1, value2, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStartMonthNotBetween(Byte value1, Byte value2) {
            addCriterion("plan_start_month not between", value1, value2, "planStartMonth");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNull() {
            addCriterion("plan_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("plan_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(Integer value) {
            addCriterion("plan_status =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(Integer value) {
            addCriterion("plan_status <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(Integer value) {
            addCriterion("plan_status >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_status >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(Integer value) {
            addCriterion("plan_status <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("plan_status <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<Integer> values) {
            addCriterion("plan_status in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<Integer> values) {
            addCriterion("plan_status not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(Integer value1, Integer value2) {
            addCriterion("plan_status between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_status not between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andInvestSourceIsNull() {
            addCriterion("invest_source is null");
            return (Criteria) this;
        }

        public Criteria andInvestSourceIsNotNull() {
            addCriterion("invest_source is not null");
            return (Criteria) this;
        }

        public Criteria andInvestSourceEqualTo(String value) {
            addCriterion("invest_source =", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceNotEqualTo(String value) {
            addCriterion("invest_source <>", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceGreaterThan(String value) {
            addCriterion("invest_source >", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceGreaterThanOrEqualTo(String value) {
            addCriterion("invest_source >=", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceLessThan(String value) {
            addCriterion("invest_source <", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceLessThanOrEqualTo(String value) {
            addCriterion("invest_source <=", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceLike(String value) {
            addCriterion("invest_source like", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceNotLike(String value) {
            addCriterion("invest_source not like", value, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceIn(List<String> values) {
            addCriterion("invest_source in", values, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceNotIn(List<String> values) {
            addCriterion("invest_source not in", values, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceBetween(String value1, String value2) {
            addCriterion("invest_source between", value1, value2, "investSource");
            return (Criteria) this;
        }

        public Criteria andInvestSourceNotBetween(String value1, String value2) {
            addCriterion("invest_source not between", value1, value2, "investSource");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalIsNull() {
            addCriterion("plan_invest_total is null");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalIsNotNull() {
            addCriterion("plan_invest_total is not null");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalEqualTo(Integer value) {
            addCriterion("plan_invest_total =", value, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalNotEqualTo(Integer value) {
            addCriterion("plan_invest_total <>", value, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalGreaterThan(Integer value) {
            addCriterion("plan_invest_total >", value, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_invest_total >=", value, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalLessThan(Integer value) {
            addCriterion("plan_invest_total <", value, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalLessThanOrEqualTo(Integer value) {
            addCriterion("plan_invest_total <=", value, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalIn(List<Integer> values) {
            addCriterion("plan_invest_total in", values, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalNotIn(List<Integer> values) {
            addCriterion("plan_invest_total not in", values, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalBetween(Integer value1, Integer value2) {
            addCriterion("plan_invest_total between", value1, value2, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andPlanInvestTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_invest_total not between", value1, value2, "planInvestTotal");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaAdminIsNull() {
            addCriterion("area_admin is null");
            return (Criteria) this;
        }

        public Criteria andAreaAdminIsNotNull() {
            addCriterion("area_admin is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAdminEqualTo(Short value) {
            addCriterion("area_admin =", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotEqualTo(Short value) {
            addCriterion("area_admin <>", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminGreaterThan(Short value) {
            addCriterion("area_admin >", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminGreaterThanOrEqualTo(Short value) {
            addCriterion("area_admin >=", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminLessThan(Short value) {
            addCriterion("area_admin <", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminLessThanOrEqualTo(Short value) {
            addCriterion("area_admin <=", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminIn(List<Short> values) {
            addCriterion("area_admin in", values, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotIn(List<Short> values) {
            addCriterion("area_admin not in", values, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminBetween(Short value1, Short value2) {
            addCriterion("area_admin between", value1, value2, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotBetween(Short value1, Short value2) {
            addCriterion("area_admin not between", value1, value2, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdIsNull() {
            addCriterion("prj_db_id is null");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdIsNotNull() {
            addCriterion("prj_db_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdEqualTo(String value) {
            addCriterion("prj_db_id =", value, "prjDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdNotEqualTo(String value) {
            addCriterion("prj_db_id <>", value, "pjrDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdGreaterThan(String value) {
            addCriterion("prj_db_id >", value, "pjrDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdGreaterThanOrEqualTo(String value) {
            addCriterion("prj_db_id >=", value, "pjrDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdLessThan(String value) {
            addCriterion("prj_db_id <", value, "pjrDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdLessThanOrEqualTo(String value) {
            addCriterion("prj_db_id <=", value, "pjrDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdLike(String value) {
            addCriterion("prj_db_id like", value, "prjDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdNotLike(String value) {
            addCriterion("prj_db_id not like", value, "prjDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdIn(List<String> values) {
            addCriterion("prj_db_id in", values, "prjDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdNotIn(List<String> values) {
            addCriterion("prj_db_id not in", values, "prjDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdBetween(String value1, String value2) {
            addCriterion("prj_db_id between", value1, value2, "prjDbId");
            return (Criteria) this;
        }

        public Criteria andPrjDbIdNotBetween(String value1, String value2) {
            addCriterion("prj_db_id not between", value1, value2, "prjDbId");
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

        public Criteria andIsPrjDbIsNull() {
            addCriterion("is_prj_db is null");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbIsNotNull() {
            addCriterion("is_prj_db is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbEqualTo(Byte value) {
            addCriterion("is_prj_db =", value, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbNotEqualTo(Byte value) {
            addCriterion("is_prj_db <>", value, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbGreaterThan(Byte value) {
            addCriterion("is_prj_db >", value, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_prj_db >=", value, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbLessThan(Byte value) {
            addCriterion("is_prj_db <", value, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbLessThanOrEqualTo(Byte value) {
            addCriterion("is_prj_db <=", value, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbIn(List<Byte> values) {
            addCriterion("is_prj_db in", values, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbNotIn(List<Byte> values) {
            addCriterion("is_prj_db not in", values, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbBetween(Byte value1, Byte value2) {
            addCriterion("is_prj_db between", value1, value2, "isPrjDb");
            return (Criteria) this;
        }

        public Criteria andIsPrjDbNotBetween(Byte value1, Byte value2) {
            addCriterion("is_prj_db not between", value1, value2, "isPrjDb");
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