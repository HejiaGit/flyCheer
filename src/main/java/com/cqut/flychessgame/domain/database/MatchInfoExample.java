package com.cqut.flychessgame.domain.database;

import java.util.ArrayList;
import java.util.List;

public class MatchInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MatchInfoExample() {
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

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(Integer value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(Integer value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(Integer value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(Integer value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(Integer value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<Integer> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<Integer> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(Integer value1, Integer value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(Integer value1, Integer value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andDicenumIsNull() {
            addCriterion("diceNum is null");
            return (Criteria) this;
        }

        public Criteria andDicenumIsNotNull() {
            addCriterion("diceNum is not null");
            return (Criteria) this;
        }

        public Criteria andDicenumEqualTo(Integer value) {
            addCriterion("diceNum =", value, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumNotEqualTo(Integer value) {
            addCriterion("diceNum <>", value, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumGreaterThan(Integer value) {
            addCriterion("diceNum >", value, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("diceNum >=", value, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumLessThan(Integer value) {
            addCriterion("diceNum <", value, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumLessThanOrEqualTo(Integer value) {
            addCriterion("diceNum <=", value, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumIn(List<Integer> values) {
            addCriterion("diceNum in", values, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumNotIn(List<Integer> values) {
            addCriterion("diceNum not in", values, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumBetween(Integer value1, Integer value2) {
            addCriterion("diceNum between", value1, value2, "dicenum");
            return (Criteria) this;
        }

        public Criteria andDicenumNotBetween(Integer value1, Integer value2) {
            addCriterion("diceNum not between", value1, value2, "dicenum");
            return (Criteria) this;
        }

        public Criteria andLocxIsNull() {
            addCriterion("locX is null");
            return (Criteria) this;
        }

        public Criteria andLocxIsNotNull() {
            addCriterion("locX is not null");
            return (Criteria) this;
        }

        public Criteria andLocxEqualTo(Double value) {
            addCriterion("locX =", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxNotEqualTo(Double value) {
            addCriterion("locX <>", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxGreaterThan(Double value) {
            addCriterion("locX >", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxGreaterThanOrEqualTo(Double value) {
            addCriterion("locX >=", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxLessThan(Double value) {
            addCriterion("locX <", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxLessThanOrEqualTo(Double value) {
            addCriterion("locX <=", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxIn(List<Double> values) {
            addCriterion("locX in", values, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxNotIn(List<Double> values) {
            addCriterion("locX not in", values, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxBetween(Double value1, Double value2) {
            addCriterion("locX between", value1, value2, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxNotBetween(Double value1, Double value2) {
            addCriterion("locX not between", value1, value2, "locx");
            return (Criteria) this;
        }

        public Criteria andLocyIsNull() {
            addCriterion("locY is null");
            return (Criteria) this;
        }

        public Criteria andLocyIsNotNull() {
            addCriterion("locY is not null");
            return (Criteria) this;
        }

        public Criteria andLocyEqualTo(Double value) {
            addCriterion("locY =", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyNotEqualTo(Double value) {
            addCriterion("locY <>", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyGreaterThan(Double value) {
            addCriterion("locY >", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyGreaterThanOrEqualTo(Double value) {
            addCriterion("locY >=", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyLessThan(Double value) {
            addCriterion("locY <", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyLessThanOrEqualTo(Double value) {
            addCriterion("locY <=", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyIn(List<Double> values) {
            addCriterion("locY in", values, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyNotIn(List<Double> values) {
            addCriterion("locY not in", values, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyBetween(Double value1, Double value2) {
            addCriterion("locY between", value1, value2, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyNotBetween(Double value1, Double value2) {
            addCriterion("locY not between", value1, value2, "locy");
            return (Criteria) this;
        }

        public Criteria andCellcolorIsNull() {
            addCriterion("cellColor is null");
            return (Criteria) this;
        }

        public Criteria andCellcolorIsNotNull() {
            addCriterion("cellColor is not null");
            return (Criteria) this;
        }

        public Criteria andCellcolorEqualTo(String value) {
            addCriterion("cellColor =", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorNotEqualTo(String value) {
            addCriterion("cellColor <>", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorGreaterThan(String value) {
            addCriterion("cellColor >", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorGreaterThanOrEqualTo(String value) {
            addCriterion("cellColor >=", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorLessThan(String value) {
            addCriterion("cellColor <", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorLessThanOrEqualTo(String value) {
            addCriterion("cellColor <=", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorLike(String value) {
            addCriterion("cellColor like", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorNotLike(String value) {
            addCriterion("cellColor not like", value, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorIn(List<String> values) {
            addCriterion("cellColor in", values, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorNotIn(List<String> values) {
            addCriterion("cellColor not in", values, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorBetween(String value1, String value2) {
            addCriterion("cellColor between", value1, value2, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andCellcolorNotBetween(String value1, String value2) {
            addCriterion("cellColor not between", value1, value2, "cellcolor");
            return (Criteria) this;
        }

        public Criteria andPlanenumIsNull() {
            addCriterion("planeNum is null");
            return (Criteria) this;
        }

        public Criteria andPlanenumIsNotNull() {
            addCriterion("planeNum is not null");
            return (Criteria) this;
        }

        public Criteria andPlanenumEqualTo(Integer value) {
            addCriterion("planeNum =", value, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumNotEqualTo(Integer value) {
            addCriterion("planeNum <>", value, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumGreaterThan(Integer value) {
            addCriterion("planeNum >", value, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("planeNum >=", value, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumLessThan(Integer value) {
            addCriterion("planeNum <", value, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumLessThanOrEqualTo(Integer value) {
            addCriterion("planeNum <=", value, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumIn(List<Integer> values) {
            addCriterion("planeNum in", values, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumNotIn(List<Integer> values) {
            addCriterion("planeNum not in", values, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumBetween(Integer value1, Integer value2) {
            addCriterion("planeNum between", value1, value2, "planenum");
            return (Criteria) this;
        }

        public Criteria andPlanenumNotBetween(Integer value1, Integer value2) {
            addCriterion("planeNum not between", value1, value2, "planenum");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Integer value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Integer value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Integer value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Integer value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Integer value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Integer> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Integer> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Integer value1, Integer value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Integer value1, Integer value2) {
            addCriterion("direction not between", value1, value2, "direction");
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