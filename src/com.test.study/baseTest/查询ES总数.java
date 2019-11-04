package com.test.study.baseTest;

public class 查询ES总数 {

//    @Override
//    public List<TvDevice> getAllTvDevices(TvQuery tvQuery) {
//        SearchResponse searchResponse = null;
//        List<TvDevice> list = null;
//        try {
//            int pageSize = 10000;
//            SearchRequestBuilder searchRequestBuilder = createSearchRequestBuilder();
//            BoolQueryBuilder boolQueryBuilder = createQueryCondition(tvQuery,"");
//            searchRequestBuilder.setQuery(boolQueryBuilder)
//                    .addSort("mac.keyword", SortOrder.ASC)
//                    .setSize(pageSize).setScroll(TimeValue.timeValueSeconds(30));
//            logger.info("request:" + searchRequestBuilder.toString());
//            searchResponse = searchRequestBuilder.execute().actionGet();
//            logger.info("response:" + searchResponse.toString());
//            SearchHits searchHits = searchResponse.getHits();
//            long count = searchHits.getTotalHits();
//            list = new ArrayList<>();
//            for (SearchHit searchHit : searchHits) {
//                list.add(searchHit2TvService(searchHit));
//            }
//            if (count > pageSize) {
//                for (int sum = pageSize; sum < count; ) {
//                    searchResponse = elasticsearchTemplate.getClient().prepareSearchScroll(searchResponse.getScrollId())
//                            .setScroll(TimeValue.timeValueMinutes(1))
//                            .execute().actionGet();
//                    searchHits = searchResponse.getHits();
//                    sum += searchHits.hits().length;
//                    for (SearchHit searchHit : searchHits) {
//                        list.add(searchHit2TvService(searchHit));
//                    }
//                }
//            }
//        } catch (Exception e) {
//            String exInfo = "电视盒子激活数据查询列表错误";
//            logger.error(exInfo, e);
//            throw new TvServiceException(exInfo, e);
//        }
//        return list;
//    }
}