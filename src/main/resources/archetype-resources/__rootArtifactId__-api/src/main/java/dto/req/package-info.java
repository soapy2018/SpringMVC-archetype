#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * @description:
 *  快速获取验证信息code,使用方式，在当前目录下执行下列脚本：
 *  grep  '{.*}' ./* -o -h | sort | uniq | sed -e 's/[{}]//g'
 * @author: Shirman
 * @date: 2020/7/15
 */
package ${package}.dto.req;