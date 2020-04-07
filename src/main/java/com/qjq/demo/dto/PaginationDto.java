package com.qjq.demo.dto;

import com.qjq.demo.Model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDto {
    private List<QuestionDto> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        this.totalPage = (int) Math.ceil( (1.0 * totalCount) / size);

        if (page < 1) {
            page = 1;
        }

        if (page > this.totalPage) {
            page = this.totalPage;
        }

        this.page = page;

        pages.add(this.page);
        for (int i = 1; i <= 3; i++) {
            if (this.page - i > 0) {
                pages.add(0, this.page - i); // 头插
            }

            if (this.page + i <= totalPage) {
                pages.add(this.page + i); // 尾插
            }
        }

        // 是否显示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        // 是否显示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否显示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }




    }



}
