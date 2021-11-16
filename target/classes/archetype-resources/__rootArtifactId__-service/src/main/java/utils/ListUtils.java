#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Shirman
 * @date: 2020/4/20
 */
public class ListUtils {

    /**
     * 为list去除公共数据
     * @param newDataList
     * @param oldDataList
     */
    public static void reducePublicData(List newDataList, List oldDataList) {
        List tagC = new ArrayList<>(oldDataList.size());
        if (!CollectionUtils.isEmpty(oldDataList)) {
            tagC.addAll(oldDataList);
        }
        tagC.retainAll(newDataList);

        // 待删除
        oldDataList.removeAll(tagC);
        // 待新增
        newDataList.removeAll(tagC);
        tagC.clear();
    }
}
