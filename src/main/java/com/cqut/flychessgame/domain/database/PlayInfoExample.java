package com.cqut.flychessgame.domain.database;

import java.util.ArrayList;
import java.util.List;

public class PlayInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayInfoExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andPlaycountIsNull() {
            addCriterion("playCount is null");
            return (Criteria) this;
        }

        public Criteria andPlaycountIsNotNull() {
            addCriterion("playCount is not null");
            return (Criteria) this;
        }

        public Criteria andPlaycountEqualTo(Integer value) {
            addCriterion("playCount =", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountNotEqualTo(Integer value) {
            addCriterion("playCount <>", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountGreaterThan(Integer value) {
            addCriterion("playCount >", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("playCount >=", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountLessThan(Integer value) {
            addCriterion("playCount <", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountLessThanOrEqualTo(Integer value) {
            addCriterion("playCount <=", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountIn(List<Integer> values) {
            addCriterion("playCount in", values, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountNotIn(List<Integer> values) {
            addCriterion("playCount not in", values, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountBetween(Integer value1, Integer value2) {
            addCriterion("playCount between", value1, value2, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountNotBetween(Integer value1, Integer value2) {
            addCriterion("playCount not between", value1, value2, "playcount");
            return (Criteria) this;
        }

        public Criteria andWincountIsNull() {
            addCriterion("winCount is null");
            return (Criteria) this;
        }

        public Criteria andWincountIsNotNull() {
            addCriterion("winCount is not null");
            return (Criteria) this;
        }

        public Criteria andWincountEqualTo(Integer value) {
            addCriterion("winCount =", value, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountNotEqualTo(Integer value) {
            addCriterion("winCount <>", value, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountGreaterThan(Integer value) {
            addCriterion("winCount >", value, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountGreaterThanOrEqualTo(Integer value) {
            addCriterion("winCount >=", value, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountLessThan(Integer value) {
            addCriterion("winCount <", value, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountLessThanOrEqualTo(Integer value) {
            addCriterion("winCount <=", value, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountIn(List<Integer> values) {
            addCriterion("winCount in", values, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountNotIn(List<Integer> values) {
            addCriterion("winCount not in", values, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountBetween(Integer value1, Integer value2) {
            addCriterion("winCount between", value1, value2, "wincount");
            return (Criteria) this;
        }

        public Criteria andWincountNotBetween(Integer value1, Integer value2) {
            addCriterion("winCount not between", value1, value2, "wincount");
            return (Criteria) this;
        }

        public Criteria andPlaytorIsNull() {
            addCriterion("playToR is null");
            return (Criteria) this;
        }

        public Criteria andPlaytorIsNotNull() {
            addCriterion("playToR is not null");
            return (Criteria) this;
        }

        public Criteria andPlaytorEqualTo(Integer value) {
            addCriterion("playToR =", value, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorNotEqualTo(Integer value) {
            addCriterion("playToR <>", value, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorGreaterThan(Integer value) {
            addCriterion("playToR >", value, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorGreaterThanOrEqualTo(Integer value) {
            addCriterion("playToR >=", value, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorLessThan(Integer value) {
            addCriterion("playToR <", value, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorLessThanOrEqualTo(Integer value) {
            addCriterion("playToR <=", value, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorIn(List<Integer> values) {
            addCriterion("playToR in", values, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorNotIn(List<Integer> values) {
            addCriterion("playToR not in", values, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorBetween(Integer value1, Integer value2) {
            addCriterion("playToR between", value1, value2, "playtor");
            return (Criteria) this;
        }

        public Criteria andPlaytorNotBetween(Integer value1, Integer value2) {
            addCriterion("playToR not between", value1, value2, "playtor");
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