package com.dream.jie.huang.appbackground.entity;

import java.util.List;

/**
 * 分页的实体类
 */
public class Page<T> {
    private List<T> list;//结果集
    private int pageSize;//每页多少条数据
    private int pageNumber;//第几页
    private int totalRow;//总记录数
    private int totalPage;//总页数
    private int startSize;//开始条数
    private int endSize;//结束条数


    public Page<T> initPage(Page<T> page){
        if(page.getPageNumber() == 0){
            page.setPageSize(10);
            page.setPageNumber(1);
            page.setStartSize(0);
            page.setEndSize(10);
        }else {
            page.setStartSize((pageNumber-1)*pageSize);
            page.setEndSize(pageNumber*pageSize);
        }
        return page;
    }

    /**

     * 总页数
     * @return
     */
    public int getTotalPages(){
        return (totalRow+pageSize - 1) / pageSize;
    }

    /**
     * 获取首页
     * @return
     */
    public int getTopPageNo(){
        return 1;
    }

    /**
     * 下一页
     * @return
     */
    public int getNextPageNo(){
        if(pageNumber >= getBottomPageNo()){
            return getBottomPageNo();
        }
        return pageNumber + 1;
    }

    /**
     * 获取尾页
     * @return
     */
    public int getBottomPageNo(){
        return getTotalPages();
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getStartSize() {
        return startSize;
    }

    public void setStartSize(int startSize) {
        this.startSize = startSize;
    }

    public int getEndSize() {
        return endSize;
    }

    public void setEndSize(int endSize) {
        this.endSize = endSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }



    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
