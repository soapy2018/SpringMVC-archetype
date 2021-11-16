#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import ${groupId}.autoconfigure.configure.SpringContextHolder;
import ${groupId}.i18n.resource.EnumKeyTranslator;
import ${groupId}.i18n.resource.WebI18nMessageResourceAccessor;

/**
 * @description: 国际化工具
 * @author: Shirman
 * @date: 2020/4/7
 */
public class I18nUtils {
    private static WebI18nMessageResourceAccessor resourceAccessor;

    private static WebI18nMessageResourceAccessor getResourceAccessor() {
        if (resourceAccessor == null) {
            synchronized (I18nUtils.class) {
                if (resourceAccessor == null) {
                    resourceAccessor = SpringContextHolder.getBean(WebI18nMessageResourceAccessor.class);
                }
            }
        }
        return resourceAccessor;
    }

    public static String message(String key) {
        return getResourceAccessor().getMessage(key);
    }

    public static String messageByEnum(Object key) {
        return getResourceAccessor().getMessage(EnumKeyTranslator.enumValueToKey(key));
    }
}
