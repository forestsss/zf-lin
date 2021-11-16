package cn.zf.lin.dubbo.api.service;

import cn.zf.lin.dubbo.server.api.ApiAdService;
import cn.zf.lin.dubbo.server.pojo.Ad;
import cn.zf.lin.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
        return this.apiAdService.queryAdList(type, page, pageSize);
    }

}
