package com.net.apps.powerplant.server.core.converter;

import com.net.apps.powerplant.server.utils.StreamUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter {
    /**
     * FIXME : no occured when types mismatch au property name differs
     * @param instance
     * @param clazz
     * @param <T>
     * @param <U>
     * @return
     */
    default <T, U> T convert(U instance, Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(instance, t);
        return t;
    }

    default <T, U> List<T> convertList(List<U> instances, Class<T> clazz) {
        return StreamUtils.stream(instances)
                .map(instance -> convert(instance, clazz))
                .collect(Collectors.toList());
    }
}
