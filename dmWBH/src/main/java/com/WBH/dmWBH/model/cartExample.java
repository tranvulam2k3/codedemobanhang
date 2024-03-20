package com.WBH.dmWBH.model;

import java.util.ArrayList;
import java.util.List;

public class cartExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public cartExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdcIsNull() {
            addCriterion("idc is null");
            return (Criteria) this;
        }

        public Criteria andIdcIsNotNull() {
            addCriterion("idc is not null");
            return (Criteria) this;
        }

        public Criteria andIdcEqualTo(Integer value) {
            addCriterion("idc =", value, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcNotEqualTo(Integer value) {
            addCriterion("idc <>", value, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcGreaterThan(Integer value) {
            addCriterion("idc >", value, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcGreaterThanOrEqualTo(Integer value) {
            addCriterion("idc >=", value, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcLessThan(Integer value) {
            addCriterion("idc <", value, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcLessThanOrEqualTo(Integer value) {
            addCriterion("idc <=", value, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcIn(List<Integer> values) {
            addCriterion("idc in", values, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcNotIn(List<Integer> values) {
            addCriterion("idc not in", values, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcBetween(Integer value1, Integer value2) {
            addCriterion("idc between", value1, value2, "idc");
            return (Criteria) this;
        }

        public Criteria andIdcNotBetween(Integer value1, Integer value2) {
            addCriterion("idc not between", value1, value2, "idc");
            return (Criteria) this;
        }

        public Criteria andTenIsNull() {
            addCriterion("ten is null");
            return (Criteria) this;
        }

        public Criteria andTenIsNotNull() {
            addCriterion("ten is not null");
            return (Criteria) this;
        }

        public Criteria andTenEqualTo(String value) {
            addCriterion("ten =", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotEqualTo(String value) {
            addCriterion("ten <>", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThan(String value) {
            addCriterion("ten >", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThanOrEqualTo(String value) {
            addCriterion("ten >=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThan(String value) {
            addCriterion("ten <", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThanOrEqualTo(String value) {
            addCriterion("ten <=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLike(String value) {
            addCriterion("ten like", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotLike(String value) {
            addCriterion("ten not like", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenIn(List<String> values) {
            addCriterion("ten in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotIn(List<String> values) {
            addCriterion("ten not in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenBetween(String value1, String value2) {
            addCriterion("ten between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotBetween(String value1, String value2) {
            addCriterion("ten not between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andGiaIsNull() {
            addCriterion("gia is null");
            return (Criteria) this;
        }

        public Criteria andGiaIsNotNull() {
            addCriterion("gia is not null");
            return (Criteria) this;
        }

        public Criteria andGiaEqualTo(Integer value) {
            addCriterion("gia =", value, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaNotEqualTo(Integer value) {
            addCriterion("gia <>", value, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaGreaterThan(Integer value) {
            addCriterion("gia >", value, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaGreaterThanOrEqualTo(Integer value) {
            addCriterion("gia >=", value, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaLessThan(Integer value) {
            addCriterion("gia <", value, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaLessThanOrEqualTo(Integer value) {
            addCriterion("gia <=", value, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaIn(List<Integer> values) {
            addCriterion("gia in", values, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaNotIn(List<Integer> values) {
            addCriterion("gia not in", values, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaBetween(Integer value1, Integer value2) {
            addCriterion("gia between", value1, value2, "gia");
            return (Criteria) this;
        }

        public Criteria andGiaNotBetween(Integer value1, Integer value2) {
            addCriterion("gia not between", value1, value2, "gia");
            return (Criteria) this;
        }

        public Criteria andSoluongIsNull() {
            addCriterion("soluong is null");
            return (Criteria) this;
        }

        public Criteria andSoluongIsNotNull() {
            addCriterion("soluong is not null");
            return (Criteria) this;
        }

        public Criteria andSoluongEqualTo(Integer value) {
            addCriterion("soluong =", value, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongNotEqualTo(Integer value) {
            addCriterion("soluong <>", value, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongGreaterThan(Integer value) {
            addCriterion("soluong >", value, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongGreaterThanOrEqualTo(Integer value) {
            addCriterion("soluong >=", value, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongLessThan(Integer value) {
            addCriterion("soluong <", value, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongLessThanOrEqualTo(Integer value) {
            addCriterion("soluong <=", value, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongIn(List<Integer> values) {
            addCriterion("soluong in", values, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongNotIn(List<Integer> values) {
            addCriterion("soluong not in", values, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongBetween(Integer value1, Integer value2) {
            addCriterion("soluong between", value1, value2, "soluong");
            return (Criteria) this;
        }

        public Criteria andSoluongNotBetween(Integer value1, Integer value2) {
            addCriterion("soluong not between", value1, value2, "soluong");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.cart
     *
     * @mbg.generated do_not_delete_during_merge Wed Jan 24 18:52:47 ICT 2024
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.cart
     *
     * @mbg.generated Wed Jan 24 18:52:47 ICT 2024
     */
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