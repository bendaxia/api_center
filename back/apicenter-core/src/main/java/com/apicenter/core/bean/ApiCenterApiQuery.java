package com.apicenter.core.bean;

import java.util.ArrayList;
import java.util.List;

public class ApiCenterApiQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ApiCenterApiQuery() {
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

        public Criteria andApiNameIsNull() {
            addCriterion("api_name is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("api_name is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("api_name =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("api_name <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("api_name >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("api_name >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("api_name <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("api_name <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("api_name like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("api_name not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("api_name in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("api_name not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("api_name between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("api_name not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiAgreementIsNull() {
            addCriterion("api_agreement is null");
            return (Criteria) this;
        }

        public Criteria andApiAgreementIsNotNull() {
            addCriterion("api_agreement is not null");
            return (Criteria) this;
        }

        public Criteria andApiAgreementEqualTo(String value) {
            addCriterion("api_agreement =", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementNotEqualTo(String value) {
            addCriterion("api_agreement <>", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementGreaterThan(String value) {
            addCriterion("api_agreement >", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementGreaterThanOrEqualTo(String value) {
            addCriterion("api_agreement >=", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementLessThan(String value) {
            addCriterion("api_agreement <", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementLessThanOrEqualTo(String value) {
            addCriterion("api_agreement <=", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementLike(String value) {
            addCriterion("api_agreement like", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementNotLike(String value) {
            addCriterion("api_agreement not like", value, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementIn(List<String> values) {
            addCriterion("api_agreement in", values, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementNotIn(List<String> values) {
            addCriterion("api_agreement not in", values, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementBetween(String value1, String value2) {
            addCriterion("api_agreement between", value1, value2, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiAgreementNotBetween(String value1, String value2) {
            addCriterion("api_agreement not between", value1, value2, "apiAgreement");
            return (Criteria) this;
        }

        public Criteria andApiModeIsNull() {
            addCriterion("api_mode is null");
            return (Criteria) this;
        }

        public Criteria andApiModeIsNotNull() {
            addCriterion("api_mode is not null");
            return (Criteria) this;
        }

        public Criteria andApiModeEqualTo(String value) {
            addCriterion("api_mode =", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotEqualTo(String value) {
            addCriterion("api_mode <>", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeGreaterThan(String value) {
            addCriterion("api_mode >", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeGreaterThanOrEqualTo(String value) {
            addCriterion("api_mode >=", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeLessThan(String value) {
            addCriterion("api_mode <", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeLessThanOrEqualTo(String value) {
            addCriterion("api_mode <=", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeLike(String value) {
            addCriterion("api_mode like", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotLike(String value) {
            addCriterion("api_mode not like", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeIn(List<String> values) {
            addCriterion("api_mode in", values, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotIn(List<String> values) {
            addCriterion("api_mode not in", values, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeBetween(String value1, String value2) {
            addCriterion("api_mode between", value1, value2, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotBetween(String value1, String value2) {
            addCriterion("api_mode not between", value1, value2, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiDomainIsNull() {
            addCriterion("api_domain is null");
            return (Criteria) this;
        }

        public Criteria andApiDomainIsNotNull() {
            addCriterion("api_domain is not null");
            return (Criteria) this;
        }

        public Criteria andApiDomainEqualTo(String value) {
            addCriterion("api_domain =", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainNotEqualTo(String value) {
            addCriterion("api_domain <>", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainGreaterThan(String value) {
            addCriterion("api_domain >", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainGreaterThanOrEqualTo(String value) {
            addCriterion("api_domain >=", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainLessThan(String value) {
            addCriterion("api_domain <", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainLessThanOrEqualTo(String value) {
            addCriterion("api_domain <=", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainLike(String value) {
            addCriterion("api_domain like", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainNotLike(String value) {
            addCriterion("api_domain not like", value, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainIn(List<String> values) {
            addCriterion("api_domain in", values, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainNotIn(List<String> values) {
            addCriterion("api_domain not in", values, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainBetween(String value1, String value2) {
            addCriterion("api_domain between", value1, value2, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiDomainNotBetween(String value1, String value2) {
            addCriterion("api_domain not between", value1, value2, "apiDomain");
            return (Criteria) this;
        }

        public Criteria andApiAddressIsNull() {
            addCriterion("api_address is null");
            return (Criteria) this;
        }

        public Criteria andApiAddressIsNotNull() {
            addCriterion("api_address is not null");
            return (Criteria) this;
        }

        public Criteria andApiAddressEqualTo(String value) {
            addCriterion("api_address =", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressNotEqualTo(String value) {
            addCriterion("api_address <>", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressGreaterThan(String value) {
            addCriterion("api_address >", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("api_address >=", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressLessThan(String value) {
            addCriterion("api_address <", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressLessThanOrEqualTo(String value) {
            addCriterion("api_address <=", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressLike(String value) {
            addCriterion("api_address like", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressNotLike(String value) {
            addCriterion("api_address not like", value, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressIn(List<String> values) {
            addCriterion("api_address in", values, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressNotIn(List<String> values) {
            addCriterion("api_address not in", values, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressBetween(String value1, String value2) {
            addCriterion("api_address between", value1, value2, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiAddressNotBetween(String value1, String value2) {
            addCriterion("api_address not between", value1, value2, "apiAddress");
            return (Criteria) this;
        }

        public Criteria andApiDescribeIsNull() {
            addCriterion("api_describe is null");
            return (Criteria) this;
        }

        public Criteria andApiDescribeIsNotNull() {
            addCriterion("api_describe is not null");
            return (Criteria) this;
        }

        public Criteria andApiDescribeEqualTo(String value) {
            addCriterion("api_describe =", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeNotEqualTo(String value) {
            addCriterion("api_describe <>", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeGreaterThan(String value) {
            addCriterion("api_describe >", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("api_describe >=", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeLessThan(String value) {
            addCriterion("api_describe <", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeLessThanOrEqualTo(String value) {
            addCriterion("api_describe <=", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeLike(String value) {
            addCriterion("api_describe like", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeNotLike(String value) {
            addCriterion("api_describe not like", value, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeIn(List<String> values) {
            addCriterion("api_describe in", values, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeNotIn(List<String> values) {
            addCriterion("api_describe not in", values, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeBetween(String value1, String value2) {
            addCriterion("api_describe between", value1, value2, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andApiDescribeNotBetween(String value1, String value2) {
            addCriterion("api_describe not between", value1, value2, "apiDescribe");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdIsNull() {
            addCriterion("founder_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdIsNotNull() {
            addCriterion("founder_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdEqualTo(int value) {
            addCriterion("founder_user_id =", value, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdNotEqualTo(int value) {
            addCriterion("founder_user_id <>", value, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdGreaterThan(int value) {
            addCriterion("founder_user_id >", value, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdGreaterThanOrEqualTo(int value) {
            addCriterion("founder_user_id >=", value, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdLessThan(int value) {
            addCriterion("founder_user_id <", value, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdLessThanOrEqualTo(int value) {
            addCriterion("founder_user_id <=", value, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdIn(List<Integer> values) {
            addCriterion("founder_user_id in", values, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdNotIn(List<Integer> values) {
            addCriterion("founder_user_id not in", values, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdBetween(int value1, int value2) {
            addCriterion("founder_user_id between", value1, value2, "founderUserId");
            return (Criteria) this;
        }

        public Criteria andFounderUserIdNotBetween(int value1, int value2) {
            addCriterion("founder_user_id not between", value1, value2, "founderUserId");
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

        public Criteria andCreateTimeEqualTo(long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(long value1, long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(long value1, long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdIsNull() {
            addCriterion("api_group_id is null");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdIsNotNull() {
            addCriterion("api_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdEqualTo(int value) {
            addCriterion("api_group_id =", value, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdNotEqualTo(int value) {
            addCriterion("api_group_id <>", value, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdGreaterThan(int value) {
            addCriterion("api_group_id >", value, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdGreaterThanOrEqualTo(int value) {
            addCriterion("api_group_id >=", value, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdLessThan(int value) {
            addCriterion("api_group_id <", value, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdLessThanOrEqualTo(int value) {
            addCriterion("api_group_id <=", value, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdIn(List<Integer> values) {
            addCriterion("api_group_id in", values, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdNotIn(List<Integer> values) {
            addCriterion("api_group_id not in", values, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdBetween(int value1, int value2) {
            addCriterion("api_group_id between", value1, value2, "apiGroupId");
            return (Criteria) this;
        }

        public Criteria andApiGroupIdNotBetween(int value1, int value2) {
            addCriterion("api_group_id not between", value1, value2, "apiGroupId");
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