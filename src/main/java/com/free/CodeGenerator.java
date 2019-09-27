package com.free;

import com.fanglin.tkmapper.generator.AutoGenerator;
import com.fanglin.tkmapper.generator.config.DataSourceConfig;
import com.fanglin.tkmapper.generator.config.GlobalConfig;
import com.fanglin.tkmapper.generator.config.PackageConfig;
import com.fanglin.tkmapper.generator.config.StrategyConfig;
import com.fanglin.tkmapper.generator.config.rules.DateType;

/**
 *  主函数
 * @author 彭方林
 * @date 2019/4/19 0:17
 * @version 1.0
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
            .setInclude("brand","brand_focus");
        generator.setStrategy(strategy);
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig()
            .setFileOverride(true)
            .setAuthor("彭方林")
            .setSwagger2(true)
            .setDateType(DateType.ONLY_DATE);
        generator.setGlobalConfig(globalConfig);
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.test");
        generator.setPackageConfig(packageConfig);
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
            .setUrl("jdbc:mysql://47.101.151.125:3306/free")
            .setDriverName("com.mysql.cj.jdbc.Driver")
            .setUsername("free")
            .setPassword("123456789");
        generator.setDataSource(dataSourceConfig);
        generator.execute();
    }
}
