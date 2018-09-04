package com.github.framework.server.shared.domain.vo;

import com.github.framework.server.shared.domain.POJO;

/**
 * 基础视图对象
 */
public class BaseVO extends POJO {

    private Integer page = 1;
    private Integer start = 0;
    private Integer limit = 10;
    private Long totalCount;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
