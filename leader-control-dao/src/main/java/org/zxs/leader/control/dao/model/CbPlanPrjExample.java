package org.zxs.leader.control.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CbPlanPrjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbPlanPrjExample() {
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

        public Criteria andCbIdIsNull() {
            addCriterion("cb_id is null");
            return (Criteria) this;
        }

        public Criteria andCbIdIsNotNull() {
            addCriterion("cb_id is not null");
            return (Criteria) this;
        }

        public Criteria andCbIdEqualTo(Integer value) {
            addCriterion("cb_id =", value, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdNotEqualTo(Integer value) {
            addCriterion("cb_id <>", value, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdGreaterThan(Integer value) {
            addCriterion("cb_id >", value, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cb_id >=", value, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdLessThan(Integer value) {
            addCriterion("cb_id <", value, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdLessThanOrEqualTo(Integer value) {
            addCriterion("cb_id <=", value, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdIn(List<Integer> values) {
            addCriterion("cb_id in", values, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdNotIn(List<Integer> values) {
            addCriterion("cb_id not in", values, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdBetween(Integer value1, Integer value2) {
            addCriterion("cb_id between", value1, value2, "cbId");
            return (Criteria) this;
        }

        public Criteria andCbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cb_id not between", value1, value2, "cbId");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNull() {
            addCriterion("plan_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNotNull() {
            addCriterion("plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNoEqualTo(Integer value) {
            addCriterion("plan_no =", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotEqualTo(Integer value) {
            addCriterion("plan_no <>", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThan(Integer value) {
            addCriterion("plan_no >", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_no >=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThan(Integer value) {
            addCriterion("plan_no <", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThanOrEqualTo(Integer value) {
            addCriterion("plan_no <=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIn(List<Integer> values) {
            addCriterion("plan_no in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotIn(List<Integer> values) {
            addCriterion("plan_no not in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoBetween(Integer value1, Integer value2) {
            addCriterion("plan_no between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_no not between", value1, value2, "planNo");
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

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(BigDecimal value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(BigDecimal value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(BigDecimal value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(BigDecimal value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<BigDecimal> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<BigDecimal> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(BigDecimal value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(BigDecimal value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(BigDecimal value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(BigDecimal value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<BigDecimal> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<BigDecimal> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andStarNumIsNull() {
            addCriterion("star_num is null");
            return (Criteria) this;
        }

        public Criteria andStarNumIsNotNull() {
            addCriterion("star_num is not null");
            return (Criteria) this;
        }

        public Criteria andStarNumEqualTo(Byte value) {
            addCriterion("star_num =", value, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumNotEqualTo(Byte value) {
            addCriterion("star_num <>", value, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumGreaterThan(Byte value) {
            addCriterion("star_num >", value, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("star_num >=", value, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumLessThan(Byte value) {
            addCriterion("star_num <", value, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumLessThanOrEqualTo(Byte value) {
            addCriterion("star_num <=", value, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumIn(List<Byte> values) {
            addCriterion("star_num in", values, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumNotIn(List<Byte> values) {
            addCriterion("star_num not in", values, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumBetween(Byte value1, Byte value2) {
            addCriterion("star_num between", value1, value2, "starNum");
            return (Criteria) this;
        }

        public Criteria andStarNumNotBetween(Byte value1, Byte value2) {
            addCriterion("star_num not between", value1, value2, "starNum");
            return (Criteria) this;
        }

        public Criteria andCbTypeIsNull() {
            addCriterion("cb_type is null");
            return (Criteria) this;
        }

        public Criteria andCbTypeIsNotNull() {
            addCriterion("cb_type is not null");
            return (Criteria) this;
        }

        public Criteria andCbTypeEqualTo(Integer value) {
            addCriterion("cb_type =", value, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeNotEqualTo(Integer value) {
            addCriterion("cb_type <>", value, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeGreaterThan(Integer value) {
            addCriterion("cb_type >", value, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cb_type >=", value, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeLessThan(Integer value) {
            addCriterion("cb_type <", value, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cb_type <=", value, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeIn(List<Integer> values) {
            addCriterion("cb_type in", values, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeNotIn(List<Integer> values) {
            addCriterion("cb_type not in", values, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeBetween(Integer value1, Integer value2) {
            addCriterion("cb_type between", value1, value2, "cbType");
            return (Criteria) this;
        }

        public Criteria andCbTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cb_type not between", value1, value2, "cbType");
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

        public Criteria andRspLeaderIdIsNull() {
            addCriterion("rsp_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdIsNotNull() {
            addCriterion("rsp_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdEqualTo(Integer value) {
            addCriterion("rsp_leader_id =", value, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdNotEqualTo(Integer value) {
            addCriterion("rsp_leader_id <>", value, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdGreaterThan(Integer value) {
            addCriterion("rsp_leader_id >", value, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rsp_leader_id >=", value, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdLessThan(Integer value) {
            addCriterion("rsp_leader_id <", value, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("rsp_leader_id <=", value, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdIn(List<Integer> values) {
            addCriterion("rsp_leader_id in", values, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdNotIn(List<Integer> values) {
            addCriterion("rsp_leader_id not in", values, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdBetween(Integer value1, Integer value2) {
            addCriterion("rsp_leader_id between", value1, value2, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andRspLeaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rsp_leader_id not between", value1, value2, "rspLeaderId");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjIsNull() {
            addCriterion("is_fund_prj is null");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjIsNotNull() {
            addCriterion("is_fund_prj is not null");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjEqualTo(Byte value) {
            addCriterion("is_fund_prj =", value, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjNotEqualTo(Byte value) {
            addCriterion("is_fund_prj <>", value, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjGreaterThan(Byte value) {
            addCriterion("is_fund_prj >", value, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_fund_prj >=", value, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjLessThan(Byte value) {
            addCriterion("is_fund_prj <", value, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjLessThanOrEqualTo(Byte value) {
            addCriterion("is_fund_prj <=", value, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjIn(List<Byte> values) {
            addCriterion("is_fund_prj in", values, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjNotIn(List<Byte> values) {
            addCriterion("is_fund_prj not in", values, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjBetween(Byte value1, Byte value2) {
            addCriterion("is_fund_prj between", value1, value2, "isFundPrj");
            return (Criteria) this;
        }

        public Criteria andIsFundPrjNotBetween(Byte value1, Byte value2) {
            addCriterion("is_fund_prj not between", value1, value2, "isFundPrj");
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

        public Criteria andPlanEndMonthIsNull() {
            addCriterion("plan_end_month is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthIsNotNull() {
            addCriterion("plan_end_month is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthEqualTo(Byte value) {
            addCriterion("plan_end_month =", value, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthNotEqualTo(Byte value) {
            addCriterion("plan_end_month <>", value, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthGreaterThan(Byte value) {
            addCriterion("plan_end_month >", value, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthGreaterThanOrEqualTo(Byte value) {
            addCriterion("plan_end_month >=", value, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthLessThan(Byte value) {
            addCriterion("plan_end_month <", value, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthLessThanOrEqualTo(Byte value) {
            addCriterion("plan_end_month <=", value, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthIn(List<Byte> values) {
            addCriterion("plan_end_month in", values, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthNotIn(List<Byte> values) {
            addCriterion("plan_end_month not in", values, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthBetween(Byte value1, Byte value2) {
            addCriterion("plan_end_month between", value1, value2, "planEndMonth");
            return (Criteria) this;
        }

        public Criteria andPlanEndMonthNotBetween(Byte value1, Byte value2) {
            addCriterion("plan_end_month not between", value1, value2, "planEndMonth");
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

        public Criteria andCbFeatureIsNull() {
            addCriterion("cb_feature is null");
            return (Criteria) this;
        }

        public Criteria andCbFeatureIsNotNull() {
            addCriterion("cb_feature is not null");
            return (Criteria) this;
        }

        public Criteria andCbFeatureEqualTo(Integer value) {
            addCriterion("cb_feature =", value, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureNotEqualTo(Integer value) {
            addCriterion("cb_feature <>", value, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureGreaterThan(Integer value) {
            addCriterion("cb_feature >", value, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("cb_feature >=", value, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureLessThan(Integer value) {
            addCriterion("cb_feature <", value, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureLessThanOrEqualTo(Integer value) {
            addCriterion("cb_feature <=", value, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureIn(List<Integer> values) {
            addCriterion("cb_feature in", values, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureNotIn(List<Integer> values) {
            addCriterion("cb_feature not in", values, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureBetween(Integer value1, Integer value2) {
            addCriterion("cb_feature between", value1, value2, "cbFeature");
            return (Criteria) this;
        }

        public Criteria andCbFeatureNotBetween(Integer value1, Integer value2) {
            addCriterion("cb_feature not between", value1, value2, "cbFeature");
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