package cn.zf.lin.dubbo.api.controller;

import cn.zf.lin.dubbo.api.service.SearchService;
import cn.zf.lin.dubbo.api.vo.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("search")
@RestController
@CrossOrigin
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public SearchResult search(@RequestParam("keyWord") String keyWord,
                               @RequestParam(value = "page", defaultValue = "1")
                                       Integer page) {
        if (page > 100) { //防止爬虫抓取过多的数据
            page = 1;
        }
        String redisKey = "lin_SERCH_HOT_WORD";

        SearchResult search = this.searchService.search(keyWord, page);
        if(search.getTotalPage() <= 1){
            Set set = this.redisTemplate.opsForZSet().reverseRange(redisKey, 0, 4);
            search.setHotWord(set);
        }


        int count = ((Math.max(search.getTotalPage(), 1) - 1) * SearchService.ROWS) + search.getList().size();
        this.redisTemplate.opsForZSet().add(redisKey, keyWord, count);

        LOGGER.info("[Search]关键字为：" + keyWord + "，数量为：" + count);

        return search;
    }

}
