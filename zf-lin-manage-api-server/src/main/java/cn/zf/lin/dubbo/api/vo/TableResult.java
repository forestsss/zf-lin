package cn.zf.lin.dubbo.api.vo;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class TableResult<T> {

    private List<T> list;
    private Pagination pagination;

}