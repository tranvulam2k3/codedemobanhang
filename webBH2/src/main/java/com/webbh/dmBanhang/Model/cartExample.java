package com.webbh.dmBanhang.Model;

import java.util.ArrayList;
import java.util.List;

public class cartExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public cartExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
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
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
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
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.cart
     *
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
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
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
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

        public Criteria andIdspIsNull() {
            addCriterion("idsp is null");
            return (Criteria) this;
        }

        public Criteria andIdspIsNotNull() {
            addCriterion("idsp is not null");
            return (Criteria) this;
        }

        public Criteria andIdspEqualTo(Integer value) {
            addCriterion("idsp =", value, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspNotEqualTo(Integer value) {
            addCriterion("idsp <>", value, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspGreaterThan(Integer value) {
            addCriterion("idsp >", value, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspGreaterThanOrEqualTo(Integer value) {
            addCriterion("idsp >=", value, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspLessThan(Integer value) {
            addCriterion("idsp <", value, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspLessThanOrEqualTo(Integer value) {
            addCriterion("idsp <=", value, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspIn(List<Integer> values) {
            addCriterion("idsp in", values, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspNotIn(List<Integer> values) {
            addCriterion("idsp not in", values, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspBetween(Integer value1, Integer value2) {
            addCriterion("idsp between", value1, value2, "idsp");
            return (Criteria) this;
        }

        public Criteria andIdspNotBetween(Integer value1, Integer value2) {
            addCriterion("idsp not between", value1, value2, "idsp");
            return (Criteria) this;
        }

        public Criteria andHinhanhIsNull() {
            addCriterion("hinhanh is null");
            return (Criteria) this;
        }

        public Criteria andHinhanhIsNotNull() {
            addCriterion("hinhanh is not null");
            return (Criteria) this;
        }

        public Criteria andHinhanhEqualTo(String value) {
            addCriterion("hinhanh =", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhNotEqualTo(String value) {
            addCriterion("hinhanh <>", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhGreaterThan(String value) {
            addCriterion("hinhanh >", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhGreaterThanOrEqualTo(String value) {
            addCriterion("hinhanh >=", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhLessThan(String value) {
            addCriterion("hinhanh <", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhLessThanOrEqualTo(String value) {
            addCriterion("hinhanh <=", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhLike(String value) {
            addCriterion("hinhanh like", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhNotLike(String value) {
            addCriterion("hinhanh not like", value, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhIn(List<String> values) {
            addCriterion("hinhanh in", values, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhNotIn(List<String> values) {
            addCriterion("hinhanh not in", values, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhBetween(String value1, String value2) {
            addCriterion("hinhanh between", value1, value2, "hinhanh");
            return (Criteria) this;
        }

        public Criteria andHinhanhNotBetween(String value1, String value2) {
            addCriterion("hinhanh not between", value1, value2, "hinhanh");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.cart
     *
     * @mbg.generated do_not_delete_during_merge Sun Apr 07 00:25:17 ICT 2024
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
     * @mbg.generated Sun Apr 07 00:25:17 ICT 2024
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