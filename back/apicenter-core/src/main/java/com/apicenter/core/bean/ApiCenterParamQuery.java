package com.apicenter.core.bean;

import java.util.ArrayList;
import java.util.List;

public class ApiCenterParamQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ApiCenterParamQuery() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andIdEqualTo(int value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(int value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(int value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(int value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(int value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(int value) {
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

        public Criteria andIdBetween(int value1, int value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(int value1, int value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNull() {
            addCriterion("api_id is null");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNotNull() {
            addCriterion("api_id is not null");
            return (Criteria) this;
        }

        public Criteria andApiIdEqualTo(int value) {
            addCriterion("api_id =", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotEqualTo(int value) {
            addCriterion("api_id <>", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThan(int value) {
            addCriterion("api_id >", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThanOrEqualTo(int value) {
            addCriterion("api_id >=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThan(int value) {
            addCriterion("api_id <", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThanOrEqualTo(int value) {
            addCriterion("api_id <=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdIn(List<Integer> values) {
            addCriterion("api_id in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotIn(List<Integer> values) {
            addCriterion("api_id not in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdBetween(int value1, int value2) {
            addCriterion("api_id between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotBetween(int value1, int value2) {
            addCriterion("api_id not between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("param_name is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("param_name is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("param_name =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("param_name <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("param_name >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("param_name >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("param_name <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("param_name <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("param_name like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("param_name not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("param_name in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("param_name not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("param_name between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("param_name not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamDescribeIsNull() {
            addCriterion("param_describe is null");
            return (Criteria) this;
        }

        public Criteria andParamDescribeIsNotNull() {
            addCriterion("param_describe is not null");
            return (Criteria) this;
        }

        public Criteria andParamDescribeEqualTo(String value) {
            addCriterion("param_describe =", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeNotEqualTo(String value) {
            addCriterion("param_describe <>", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeGreaterThan(String value) {
            addCriterion("param_describe >", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("param_describe >=", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeLessThan(String value) {
            addCriterion("param_describe <", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeLessThanOrEqualTo(String value) {
            addCriterion("param_describe <=", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeLike(String value) {
            addCriterion("param_describe like", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeNotLike(String value) {
            addCriterion("param_describe not like", value, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeIn(List<String> values) {
            addCriterion("param_describe in", values, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeNotIn(List<String> values) {
            addCriterion("param_describe not in", values, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeBetween(String value1, String value2) {
            addCriterion("param_describe between", value1, value2, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamDescribeNotBetween(String value1, String value2) {
            addCriterion("param_describe not between", value1, value2, "paramDescribe");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNull() {
            addCriterion("param_type is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNotNull() {
            addCriterion("param_type is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeEqualTo(String value) {
            addCriterion("param_type =", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotEqualTo(String value) {
            addCriterion("param_type <>", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThan(String value) {
            addCriterion("param_type >", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("param_type >=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThan(String value) {
            addCriterion("param_type <", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThanOrEqualTo(String value) {
            addCriterion("param_type <=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLike(String value) {
            addCriterion("param_type like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotLike(String value) {
            addCriterion("param_type not like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeIn(List<String> values) {
            addCriterion("param_type in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotIn(List<String> values) {
            addCriterion("param_type not in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeBetween(String value1, String value2) {
            addCriterion("param_type between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotBetween(String value1, String value2) {
            addCriterion("param_type not between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andTestValueIsNull() {
            addCriterion("test_value is null");
            return (Criteria) this;
        }

        public Criteria andTestValueIsNotNull() {
            addCriterion("test_value is not null");
            return (Criteria) this;
        }

        public Criteria andTestValueEqualTo(String value) {
            addCriterion("test_value =", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueNotEqualTo(String value) {
            addCriterion("test_value <>", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueGreaterThan(String value) {
            addCriterion("test_value >", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueGreaterThanOrEqualTo(String value) {
            addCriterion("test_value >=", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueLessThan(String value) {
            addCriterion("test_value <", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueLessThanOrEqualTo(String value) {
            addCriterion("test_value <=", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueLike(String value) {
            addCriterion("test_value like", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueNotLike(String value) {
            addCriterion("test_value not like", value, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueIn(List<String> values) {
            addCriterion("test_value in", values, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueNotIn(List<String> values) {
            addCriterion("test_value not in", values, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueBetween(String value1, String value2) {
            addCriterion("test_value between", value1, value2, "testValue");
            return (Criteria) this;
        }

        public Criteria andTestValueNotBetween(String value1, String value2) {
            addCriterion("test_value not between", value1, value2, "testValue");
            return (Criteria) this;
        }

        public Criteria andIsoptionalIsNull() {
            addCriterion("isoptional is null");
            return (Criteria) this;
        }

        public Criteria andIsoptionalIsNotNull() {
            addCriterion("isoptional is not null");
            return (Criteria) this;
        }

        public Criteria andIsoptionalEqualTo(int value) {
            addCriterion("isoptional =", value, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalNotEqualTo(int value) {
            addCriterion("isoptional <>", value, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalGreaterThan(int value) {
            addCriterion("isoptional >", value, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalGreaterThanOrEqualTo(int value) {
            addCriterion("isoptional >=", value, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalLessThan(int value) {
            addCriterion("isoptional <", value, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalLessThanOrEqualTo(int value) {
            addCriterion("isoptional <=", value, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalIn(List<Integer> values) {
            addCriterion("isoptional in", values, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalNotIn(List<Integer> values) {
            addCriterion("isoptional not in", values, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalBetween(int value1, int value2) {
            addCriterion("isoptional between", value1, value2, "isoptional");
            return (Criteria) this;
        }

        public Criteria andIsoptionalNotBetween(int value1, int value2) {
            addCriterion("isoptional not between", value1, value2, "isoptional");
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