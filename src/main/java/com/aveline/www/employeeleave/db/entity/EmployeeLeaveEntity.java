package com.aveline.www.employeeleave.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@JsonDeserialize(builder = EmployeeLeaveEntity.EmployeeLeaveEntityBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class EmployeeLeaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;
    private String employeeId;
    private Number yearMonth;
    private Number count;

    public EmployeeLeaveEntity() {
    }

    public EmployeeLeaveEntity(EmployeeLeaveEntityBuilder builder) {
        this.employeeId = builder.employeeId;
        this.yearMonth = builder.yearMonth;
        this.count = builder.count;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    public Number getCount() {
        return count;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class EmployeeLeaveEntityBuilder {

        protected String id;
        protected String employeeId;
        protected Number yearMonth;
        protected Number count;

        public EmployeeLeaveEntityBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeLeaveEntityBuilder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeLeaveEntityBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public EmployeeLeaveEntityBuilder setCount(Number count) {
            this.count = count;
            return this;
        }


        public EmployeeLeaveEntity build() {
            return new EmployeeLeaveEntity(this);
        }
    }
}
