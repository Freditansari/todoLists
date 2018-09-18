//package com.fredy.projectbackend.Config;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.AbstractFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//
//@Configuration
////@EnableElasticsearchRepositories(basePackages = "com.fredy.projectbackend.Repositories.SearchRepo")
//////@EnableJpaRepositories(basePackages = "com.fredy.projectbackend.Repositories")
////@ComponentScan(basePackages = { "com.fredy.projectbackend.Services" })
//public class ElasticConfiguration {
////
//////    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/5.6.0}")
//////    private String elasticsearchHome;
////
////    @Value("${elasticsearch.cluster.name:elasticsearch}")
////    private String clusterName;
////
////    @Bean
////    public Client client() {
////        TransportClient client = null;
////        try {
////            final Settings elasticsearchSettings = Settings.builder()
////                    .put("client.transport.sniff", true)
////                    .put("cluster.name", clusterName).build();
////            client = new PreBuiltTransportClient(elasticsearchSettings);
////            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
////        } catch (UnknownHostException e) {
////            e.printStackTrace();
////        }
////        return client;
////    }
////
////    @Bean
////    public ElasticsearchOperations elasticsearchTemplate() {
////        return new ElasticsearchTemplate(client());
////    }
//
//
//
//
//
//}
//
//
//
//
//
//
