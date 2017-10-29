package ccw.study;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class CommonsUtils {
    public static <T> T toBean(Map data, Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, data);
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
