package com.datahan.server.irian.config;

/**
 * 读写分离配置
 */
//@Configuration
public class WriteToMasterReadFromReplicaConfiguration {

    /*@Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(SLAVE_PREFERRED)
                .build();

        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration("server", 6379);

        return new LettuceConnectionFactory(serverConfig, clientConfig);
    }*/
}
