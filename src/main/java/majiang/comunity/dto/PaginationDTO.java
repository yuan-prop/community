package majiang.comunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2020/3/10.
 */
@Data
public class PaginationDTO<T> {

    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    //分页功能实现 page是页码， size为每页的信息条数
    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;
        pages.add(page);
        for(int i=1; i<=3; i++){
            if(page-i > 0){
                pages.add(0, page-i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }

        //是否显示上，下翻页
        showPrevious = page == 1? false : true;
        showNext = page == totalPage? false : true;

        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }
}
