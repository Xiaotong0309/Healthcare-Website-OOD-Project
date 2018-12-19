package com.test.health.vo;


public class SessionRequest {
    private Long start;

    private Long end;

    private String name;

    private Integer page;

    private Integer size;

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SessionRequest{" +
                "start=" + start +
                ", end=" + end +
                ", name='" + name + '\'' +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
