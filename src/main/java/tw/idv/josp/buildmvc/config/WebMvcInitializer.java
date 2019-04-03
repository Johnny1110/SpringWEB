package tw.idv.josp.buildmvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

/*
 * AbstractAnnotationConfigDispatcherServletInitializer 會同時創建 DispathcerServlet 與 ContextLoadListener。
 * 這兩個類別都屬於應用上下文(Bean 容器)。
 * DispathcerServlet 用於加載前端相關的 Bean(模板引擎)。
 * ContextLoadListener 用於加載後端相關的 Bean(持久層|交易管理)。
 */
public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
     * getRootConfigClasses() 會返回帶有 @Configuration 的 Bean 並交給 ContextLoadListener 載入。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /*
     * getServletConfigClasses() 會返回帶有 @Configuration 的 Bean 並交給 DispathcerServlet 載入。
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    /*
     * DispathcerServlet 映射點，攔截所有請求。
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
     * 配置 CharacterEncodingFilter
     * setForceRequestEncoding(true) 強行覆蓋所有請求回應中的編碼設定
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        return new Filter[]{encodingFilter};
    }

}
