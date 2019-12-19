package Dog.shop.ben;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoIsNull() {
            addCriterion("receiveInfo is null");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoIsNotNull() {
            addCriterion("receiveInfo is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoEqualTo(String value) {
            addCriterion("receiveInfo =", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoNotEqualTo(String value) {
            addCriterion("receiveInfo <>", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoGreaterThan(String value) {
            addCriterion("receiveInfo >", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoGreaterThanOrEqualTo(String value) {
            addCriterion("receiveInfo >=", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoLessThan(String value) {
            addCriterion("receiveInfo <", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoLessThanOrEqualTo(String value) {
            addCriterion("receiveInfo <=", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoLike(String value) {
            addCriterion("receiveInfo like", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoNotLike(String value) {
            addCriterion("receiveInfo not like", value, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoIn(List<String> values) {
            addCriterion("receiveInfo in", values, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoNotIn(List<String> values) {
            addCriterion("receiveInfo not in", values, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoBetween(String value1, String value2) {
            addCriterion("receiveInfo between", value1, value2, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andReceiveinfoNotBetween(String value1, String value2) {
            addCriterion("receiveInfo not between", value1, value2, "receiveinfo");
            return (Criteria) this;
        }

        public Criteria andPhonumIsNull() {
            addCriterion("phoNum is null");
            return (Criteria) this;
        }

        public Criteria andPhonumIsNotNull() {
            addCriterion("phoNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonumEqualTo(String value) {
            addCriterion("phoNum =", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotEqualTo(String value) {
            addCriterion("phoNum <>", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumGreaterThan(String value) {
            addCriterion("phoNum >", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumGreaterThanOrEqualTo(String value) {
            addCriterion("phoNum >=", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumLessThan(String value) {
            addCriterion("phoNum <", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumLessThanOrEqualTo(String value) {
            addCriterion("phoNum <=", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumLike(String value) {
            addCriterion("phoNum like", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotLike(String value) {
            addCriterion("phoNum not like", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumIn(List<String> values) {
            addCriterion("phoNum in", values, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotIn(List<String> values) {
            addCriterion("phoNum not in", values, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumBetween(String value1, String value2) {
            addCriterion("phoNum between", value1, value2, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotBetween(String value1, String value2) {
            addCriterion("phoNum not between", value1, value2, "phonum");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAccepterIsNull() {
            addCriterion("accepter is null");
            return (Criteria) this;
        }

        public Criteria andAccepterIsNotNull() {
            addCriterion("accepter is not null");
            return (Criteria) this;
        }

        public Criteria andAccepterEqualTo(String value) {
            addCriterion("accepter =", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterNotEqualTo(String value) {
            addCriterion("accepter <>", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterGreaterThan(String value) {
            addCriterion("accepter >", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterGreaterThanOrEqualTo(String value) {
            addCriterion("accepter >=", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterLessThan(String value) {
            addCriterion("accepter <", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterLessThanOrEqualTo(String value) {
            addCriterion("accepter <=", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterLike(String value) {
            addCriterion("accepter like", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterNotLike(String value) {
            addCriterion("accepter not like", value, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterIn(List<String> values) {
            addCriterion("accepter in", values, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterNotIn(List<String> values) {
            addCriterion("accepter not in", values, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterBetween(String value1, String value2) {
            addCriterion("accepter between", value1, value2, "accepter");
            return (Criteria) this;
        }

        public Criteria andAccepterNotBetween(String value1, String value2) {
            addCriterion("accepter not between", value1, value2, "accepter");
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