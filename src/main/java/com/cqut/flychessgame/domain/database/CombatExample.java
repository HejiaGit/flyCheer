package com.cqut.flychessgame.domain.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CombatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CombatExample() {
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

        public Criteria andSponsoridIsNull() {
            addCriterion("sponsorId is null");
            return (Criteria) this;
        }

        public Criteria andSponsoridIsNotNull() {
            addCriterion("sponsorId is not null");
            return (Criteria) this;
        }

        public Criteria andSponsoridEqualTo(Long value) {
            addCriterion("sponsorId =", value, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridNotEqualTo(Long value) {
            addCriterion("sponsorId <>", value, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridGreaterThan(Long value) {
            addCriterion("sponsorId >", value, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridGreaterThanOrEqualTo(Long value) {
            addCriterion("sponsorId >=", value, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridLessThan(Long value) {
            addCriterion("sponsorId <", value, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridLessThanOrEqualTo(Long value) {
            addCriterion("sponsorId <=", value, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridIn(List<Long> values) {
            addCriterion("sponsorId in", values, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridNotIn(List<Long> values) {
            addCriterion("sponsorId not in", values, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridBetween(Long value1, Long value2) {
            addCriterion("sponsorId between", value1, value2, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andSponsoridNotBetween(Long value1, Long value2) {
            addCriterion("sponsorId not between", value1, value2, "sponsorid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNull() {
            addCriterion("acceptId is null");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNotNull() {
            addCriterion("acceptId is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptidEqualTo(Long value) {
            addCriterion("acceptId =", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotEqualTo(Long value) {
            addCriterion("acceptId <>", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThan(Long value) {
            addCriterion("acceptId >", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThanOrEqualTo(Long value) {
            addCriterion("acceptId >=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThan(Long value) {
            addCriterion("acceptId <", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThanOrEqualTo(Long value) {
            addCriterion("acceptId <=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIn(List<Long> values) {
            addCriterion("acceptId in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotIn(List<Long> values) {
            addCriterion("acceptId not in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidBetween(Long value1, Long value2) {
            addCriterion("acceptId between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotBetween(Long value1, Long value2) {
            addCriterion("acceptId not between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andWinidIsNull() {
            addCriterion("winID is null");
            return (Criteria) this;
        }

        public Criteria andWinidIsNotNull() {
            addCriterion("winID is not null");
            return (Criteria) this;
        }

        public Criteria andWinidEqualTo(Long value) {
            addCriterion("winID =", value, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidNotEqualTo(Long value) {
            addCriterion("winID <>", value, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidGreaterThan(Long value) {
            addCriterion("winID >", value, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidGreaterThanOrEqualTo(Long value) {
            addCriterion("winID >=", value, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidLessThan(Long value) {
            addCriterion("winID <", value, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidLessThanOrEqualTo(Long value) {
            addCriterion("winID <=", value, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidIn(List<Long> values) {
            addCriterion("winID in", values, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidNotIn(List<Long> values) {
            addCriterion("winID not in", values, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidBetween(Long value1, Long value2) {
            addCriterion("winID between", value1, value2, "winid");
            return (Criteria) this;
        }

        public Criteria andWinidNotBetween(Long value1, Long value2) {
            addCriterion("winID not between", value1, value2, "winid");
            return (Criteria) this;
        }

        public Criteria andPlaydateIsNull() {
            addCriterion("playDate is null");
            return (Criteria) this;
        }

        public Criteria andPlaydateIsNotNull() {
            addCriterion("playDate is not null");
            return (Criteria) this;
        }

        public Criteria andPlaydateEqualTo(Date value) {
            addCriterionForJDBCDate("playDate =", value, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("playDate <>", value, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateGreaterThan(Date value) {
            addCriterionForJDBCDate("playDate >", value, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("playDate >=", value, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateLessThan(Date value) {
            addCriterionForJDBCDate("playDate <", value, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("playDate <=", value, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateIn(List<Date> values) {
            addCriterionForJDBCDate("playDate in", values, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("playDate not in", values, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("playDate between", value1, value2, "playdate");
            return (Criteria) this;
        }

        public Criteria andPlaydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("playDate not between", value1, value2, "playdate");
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