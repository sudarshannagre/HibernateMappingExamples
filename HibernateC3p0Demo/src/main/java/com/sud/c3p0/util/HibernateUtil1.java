package com.sud.c3p0.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.sud.c3p0.entity.Person;

public class HibernateUtil1 {

   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
            StandardServiceRegistryBuilder registryBuilder =
                  new StandardServiceRegistryBuilder();

            Map<String, Object> settings = new HashMap();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hmbTest?autoReconnect=true&useSSL=false");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "password");
            settings.put(Environment.HBM2DDL_AUTO, "create");
            settings.put(Environment.SHOW_SQL, true);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

            // c3p0 configuration
            settings.put(Environment.C3P0_MIN_SIZE, 2);         //Minimum size of pool
            settings.put(Environment.C3P0_MAX_SIZE, 10);        //Maximum size of pool
            settings.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);//Number of connections acquired at a time when pool is exhausted 
            settings.put(Environment.C3P0_TIMEOUT, 1800);       //Connection idle time
            settings.put(Environment.C3P0_MAX_STATEMENTS, 50); //PreparedStatement cache size

            settings.put(Environment.C3P0_CONFIG_PREFIX+".initialPoolSize", 5);
            
            registryBuilder.applySettings(settings);
            
            registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry)
                  .addAnnotatedClass(Person.class);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }

   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
