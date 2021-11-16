package cn.zf.lin.dubbo.server.service;

import cn.zf.lin.dubbo.server.pojo.Ad;
import cn.zf.lin.dubbo.server.vo.PageInfo;

public interface AdService {

    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}