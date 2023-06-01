package com.example.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class Pagination {
//    현재 페이지
    private Integer page;
//    화면에 보이는 게시글의 개수
    private int rowCount;
//    화면상에 보이는 페이지 개수
    private int pageCount;
//      화면의 보이는 페이지들 중 시작 페이지
    private int startPage;
//    화면에 보이는 페이지들 중 끝 페이지
    private int endPage;
//    실직적 끝 페이지
    private int realEnd;
//    이전, 다음 버튼
    private boolean prev, next;
//    총 개수
    private int total;

//    페이징 처리 정보를 담아줄 메소드
    public void progress() {
        this.page = page == null ? 1 : page;
        this.rowCount = 5;
        this.pageCount = 5;
        this.total = total;
        this.endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil(total / (double)rowCount);
        if(realEnd < endPage) {
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
