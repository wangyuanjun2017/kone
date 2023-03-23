package com.ava.kone.pricing.web.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Slf4j
public class ScannerUtils extends ClassPathBeanDefinitionScanner {
    private Class type;

    public ScannerUtils(BeanDefinitionRegistry registry, Class<RequestMapping> class1) {
        super(registry, false);
        this.type = class1;
    }

    public void registerTypeFilter() {
        addIncludeFilter(new AnnotationTypeFilter(type));
    }

    public List<Map<String, String>> doScan(String appName, String basePackage) {
        log.info("doScan start");
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackage);

        List<Map<String, String>> operationList = new ArrayList<Map<String, String>>();
        ScannerPermission controller = new ScannerPermission();

        try {
            for (BeanDefinitionHolder holder : beanDefinitionHolders) {
                controller.buildOperationObj(appName, Class.forName(holder.getBeanDefinition().getBeanClassName()),
                        operationList);
            }
        } catch (ClassNotFoundException e) {
            log.error("buildOperationObj error", e);
        }
        log.info("operationList :" + JSON.toJSONString(operationList));
        log.info("doScan end");
        return operationList;
    }

    public static List<Map<String, String>> scannerPackage(String appName, String packageName) {
        AnnotationConfigApplicationContext ac = new
                AnnotationConfigApplicationContext();
        ScannerUtils myClassPathDefinitonScanner = new ScannerUtils(ac, RequestMapping.class);
        myClassPathDefinitonScanner.registerTypeFilter();
        List<Map<String, String>> operationList = myClassPathDefinitonScanner.doScan(appName, packageName);
        return operationList;
    }
}
