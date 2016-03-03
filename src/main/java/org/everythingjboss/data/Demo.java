package org.everythingjboss.data;

import org.everythingjboss.jdv.model.Customer;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.persistence.jpa.configuration.JpaStoreConfigurationBuilder;
import org.infinispan.transaction.TransactionMode;

import static org.junit.Assert.*;

public class Demo {
	
    public static void main(String[] args) {
    	String FAIL_MESSAGE = "The cache is not warmed with right no. of records";
        Configuration cacheConfig = new ConfigurationBuilder()
                .transaction().transactionMode(TransactionMode.NON_TRANSACTIONAL)
                .persistence()
                    .addStore(JpaStoreConfigurationBuilder.class)
                    .storeMetadata(false)
                    .persistenceUnitName("jdg-jpa-jdv-cachestore-app")
                    .entityClass(Customer.class)
                    .preload(true)
                .eviction().maxEntries(100)
                .build();
        EmbeddedCacheManager cm = new DefaultCacheManager(cacheConfig);
        Cache<String,Customer> customerCache = cm.getCache();
        assertTrue(FAIL_MESSAGE,customerCache.size() == 35);
    }
    
}
