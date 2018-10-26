package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.List;

public class CbStaticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbStaticsExample() {
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

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
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

        public Criteria andFundCostIsNull() {
            addCriterion("fund_cost is null");
            return (Criteria) this;
        }

        public Criteria andFundCostIsNotNull() {
            addCriterion("fund_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFundCostEqualTo(Integer value) {
            addCriterion("fund_cost =", value, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostNotEqualTo(Integer value) {
            addCriterion("fund_cost <>", value, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostGreaterThan(Integer value) {
            addCriterion("fund_cost >", value, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("fund_cost >=", value, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostLessThan(Integer value) {
            addCriterion("fund_cost <", value, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostLessThanOrEqualTo(Integer value) {
            addCriterion("fund_cost <=", value, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostIn(List<Integer> values) {
            addCriterion("fund_cost in", values, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostNotIn(List<Integer> values) {
            addCriterion("fund_cost not in", values, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostBetween(Integer value1, Integer value2) {
            addCriterion("fund_cost between", value1, value2, "fundCost");
            return (Criteria) this;
        }

        public Criteria andFundCostNotBetween(Integer value1, Integer value2) {
            addCriterion("fund_cost not between", value1, value2, "fundCost");
            return (Criteria) this;
        }

        public Criteria andPrjNumIsNull() {
            addCriterion("prj_num is null");
            return (Criteria) this;
        }

        public Criteria andPrjNumIsNotNull() {
            addCriterion("prj_num is not null");
            return (Criteria) this;
        }

        public Criteria andPrjNumEqualTo(Integer value) {
            addCriterion("prj_num =", value, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumNotEqualTo(Integer value) {
            addCriterion("prj_num <>", value, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumGreaterThan(Integer value) {
            addCriterion("prj_num >", value, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("prj_num >=", value, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumLessThan(Integer value) {
            addCriterion("prj_num <", value, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumLessThanOrEqualTo(Integer value) {
            addCriterion("prj_num <=", value, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumIn(List<Integer> values) {
            addCriterion("prj_num in", values, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumNotIn(List<Integer> values) {
            addCriterion("prj_num not in", values, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumBetween(Integer value1, Integer value2) {
            addCriterion("prj_num between", value1, value2, "prjNum");
            return (Criteria) this;
        }

        public Criteria andPrjNumNotBetween(Integer value1, Integer value2) {
            addCriterion("prj_num not between", value1, value2, "prjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumIsNull() {
            addCriterion("new_prj_num is null");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumIsNotNull() {
            addCriterion("new_prj_num is not null");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumEqualTo(Integer value) {
            addCriterion("new_prj_num =", value, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumNotEqualTo(Integer value) {
            addCriterion("new_prj_num <>", value, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumGreaterThan(Integer value) {
            addCriterion("new_prj_num >", value, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_prj_num >=", value, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumLessThan(Integer value) {
            addCriterion("new_prj_num <", value, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumLessThanOrEqualTo(Integer value) {
            addCriterion("new_prj_num <=", value, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumIn(List<Integer> values) {
            addCriterion("new_prj_num in", values, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumNotIn(List<Integer> values) {
            addCriterion("new_prj_num not in", values, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumBetween(Integer value1, Integer value2) {
            addCriterion("new_prj_num between", value1, value2, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andNewPrjNumNotBetween(Integer value1, Integer value2) {
            addCriterion("new_prj_num not between", value1, value2, "newPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumIsNull() {
            addCriterion("extend_prj_num is null");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumIsNotNull() {
            addCriterion("extend_prj_num is not null");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumEqualTo(Integer value) {
            addCriterion("extend_prj_num =", value, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumNotEqualTo(Integer value) {
            addCriterion("extend_prj_num <>", value, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumGreaterThan(Integer value) {
            addCriterion("extend_prj_num >", value, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_prj_num >=", value, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumLessThan(Integer value) {
            addCriterion("extend_prj_num <", value, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumLessThanOrEqualTo(Integer value) {
            addCriterion("extend_prj_num <=", value, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumIn(List<Integer> values) {
            addCriterion("extend_prj_num in", values, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumNotIn(List<Integer> values) {
            addCriterion("extend_prj_num not in", values, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumBetween(Integer value1, Integer value2) {
            addCriterion("extend_prj_num between", value1, value2, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andExtendPrjNumNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_prj_num not between", value1, value2, "extendPrjNum");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceIsNull() {
            addCriterion("source_city_finance is null");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceIsNotNull() {
            addCriterion("source_city_finance is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceEqualTo(Integer value) {
            addCriterion("source_city_finance =", value, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceNotEqualTo(Integer value) {
            addCriterion("source_city_finance <>", value, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceGreaterThan(Integer value) {
            addCriterion("source_city_finance >", value, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_city_finance >=", value, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceLessThan(Integer value) {
            addCriterion("source_city_finance <", value, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceLessThanOrEqualTo(Integer value) {
            addCriterion("source_city_finance <=", value, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceIn(List<Integer> values) {
            addCriterion("source_city_finance in", values, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceNotIn(List<Integer> values) {
            addCriterion("source_city_finance not in", values, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceBetween(Integer value1, Integer value2) {
            addCriterion("source_city_finance between", value1, value2, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceCityFinanceNotBetween(Integer value1, Integer value2) {
            addCriterion("source_city_finance not between", value1, value2, "sourceCityFinance");
            return (Criteria) this;
        }

        public Criteria andSourceSocialIsNull() {
            addCriterion("source_social is null");
            return (Criteria) this;
        }

        public Criteria andSourceSocialIsNotNull() {
            addCriterion("source_social is not null");
            return (Criteria) this;
        }

        public Criteria andSourceSocialEqualTo(Integer value) {
            addCriterion("source_social =", value, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialNotEqualTo(Integer value) {
            addCriterion("source_social <>", value, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialGreaterThan(Integer value) {
            addCriterion("source_social >", value, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_social >=", value, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialLessThan(Integer value) {
            addCriterion("source_social <", value, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialLessThanOrEqualTo(Integer value) {
            addCriterion("source_social <=", value, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialIn(List<Integer> values) {
            addCriterion("source_social in", values, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialNotIn(List<Integer> values) {
            addCriterion("source_social not in", values, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialBetween(Integer value1, Integer value2) {
            addCriterion("source_social between", value1, value2, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andSourceSocialNotBetween(Integer value1, Integer value2) {
            addCriterion("source_social not between", value1, value2, "sourceSocial");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoIsNull() {
            addCriterion("cb_type_no is null");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoIsNotNull() {
            addCriterion("cb_type_no is not null");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoEqualTo(Short value) {
            addCriterion("cb_type_no =", value, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoNotEqualTo(Short value) {
            addCriterion("cb_type_no <>", value, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoGreaterThan(Short value) {
            addCriterion("cb_type_no >", value, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoGreaterThanOrEqualTo(Short value) {
            addCriterion("cb_type_no >=", value, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoLessThan(Short value) {
            addCriterion("cb_type_no <", value, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoLessThanOrEqualTo(Short value) {
            addCriterion("cb_type_no <=", value, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoIn(List<Short> values) {
            addCriterion("cb_type_no in", values, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoNotIn(List<Short> values) {
            addCriterion("cb_type_no not in", values, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoBetween(Short value1, Short value2) {
            addCriterion("cb_type_no between", value1, value2, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbTypeNoNotBetween(Short value1, Short value2) {
            addCriterion("cb_type_no not between", value1, value2, "cbTypeNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoIsNull() {
            addCriterion("cb_label_no is null");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoIsNotNull() {
            addCriterion("cb_label_no is not null");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoEqualTo(Short value) {
            addCriterion("cb_label_no =", value, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoNotEqualTo(Short value) {
            addCriterion("cb_label_no <>", value, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoGreaterThan(Short value) {
            addCriterion("cb_label_no >", value, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoGreaterThanOrEqualTo(Short value) {
            addCriterion("cb_label_no >=", value, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoLessThan(Short value) {
            addCriterion("cb_label_no <", value, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoLessThanOrEqualTo(Short value) {
            addCriterion("cb_label_no <=", value, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoIn(List<Short> values) {
            addCriterion("cb_label_no in", values, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoNotIn(List<Short> values) {
            addCriterion("cb_label_no not in", values, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoBetween(Short value1, Short value2) {
            addCriterion("cb_label_no between", value1, value2, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andCbLabelNoNotBetween(Short value1, Short value2) {
            addCriterion("cb_label_no not between", value1, value2, "cbLabelNo");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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